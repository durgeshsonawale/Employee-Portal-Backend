package com.gdtc.Employee.management.system.Service;

import com.gdtc.Employee.management.system.model.Employee;
import com.gdtc.Employee.management.system.model.Leave;
import com.gdtc.Employee.management.system.repository.EmployeeRepo;
import com.gdtc.Employee.management.system.repository.LeaveRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class LeaveService {
    @Autowired
    LeaveRepo leaveRepo;
    @Autowired
    EmployeeRepo employeeRepo;
    public List<Leave> getAllLeaves() {
        return leaveRepo.findAll();

    }

    public String createLeave(Leave leave) {
        System.out.println(leave.getLeaveTypeId());
        Employee emp = employeeRepo.findById(leave.getEmployeeId().getId()).get();


        long daysBetween = ChronoUnit.DAYS.between(leave.getFromDate(), leave.getToDate());

        if(emp.getAvailableLeaves()>=daysBetween){
            emp.setAvailableLeaves((int) (emp.getAvailableLeaves()-daysBetween-1));
            employeeRepo.save((emp));
        leaveRepo.save(leave);
        return "leave has been submitted successfully";}
        else throw new RuntimeException("no sufficient leaves" + daysBetween+" "+leave.getEmployeeId().getAvailableLeaves());
    }

    public String updateStatus(Leave leave) {
        leaveRepo.save(leave);
                return "status updated";
    }

    public List<Leave> getAllById(Integer id) {

        return this.leaveRepo.findByEmployeeId(this.employeeRepo.findById(id).get());
    }


    public  Map<String,Integer> calculateMonthlyLeaveStats(Integer id) {
        List<Leave> leaveRequests=getAllById(id);

        Map<String, Integer> monthlyStatsMap = new HashMap<>();
        monthlyStatsMap.put("JANUARY",0);
        monthlyStatsMap.put("FEBRUARY",0);
        monthlyStatsMap.put("MARCH",0);
        monthlyStatsMap.put("APRIL",0);
        monthlyStatsMap.put("MAY",0);
        monthlyStatsMap.put("JUNE",0);
        monthlyStatsMap.put("JULY",0);
        monthlyStatsMap.put("AUGUST",0);
        monthlyStatsMap.put("SEPTEMBER",0);
        monthlyStatsMap.put("OCTOBER",0);
        monthlyStatsMap.put("NOVEMBER",0);
        monthlyStatsMap.put("DECEMBER",0);







        for (Leave leaveRequest : leaveRequests) {
            LocalDate fromDate = leaveRequest.getFromDate();
            LocalDate toDate = leaveRequest.getToDate();


            while (!fromDate.isAfter(toDate)) {
                String monthKey = getMonthKey(fromDate);


                monthlyStatsMap.put(monthKey, monthlyStatsMap.getOrDefault(monthKey, 0) + 1);

                fromDate = fromDate.plusDays(1);
            }
        }


        return monthlyStatsMap;
    }

    private static String getMonthKey(LocalDate date) {
        Month month = date.getMonth();


         return month.getDisplayName(TextStyle.FULL, Locale.ENGLISH).toUpperCase();

    }


}
