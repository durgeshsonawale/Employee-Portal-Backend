package com.gdtc.Employee.management.system.Service;

import com.gdtc.Employee.management.system.model.Employee;
import com.gdtc.Employee.management.system.model.Expense;
import com.gdtc.Employee.management.system.model.ExpenseStatus;
import com.gdtc.Employee.management.system.model.Leave;
import com.gdtc.Employee.management.system.repository.EmployeeRepo;
import com.gdtc.Employee.management.system.repository.ExpensesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpensesService {
    @Autowired
    ExpensesRepo expensesRepo;
    @Autowired
    EmployeeRepo employeeRepo;
    public List<Expense> getAllExpenses() {
        return expensesRepo.findAll();
    }

    public String createExpenses(Expense expense) {
//        expense.setStatus();
        expensesRepo.save(expense);
        return "expense request raised successfully";
    }

    public String updateStatus(Expense expense) {
        expensesRepo.save(expense);
        return "status updated successfully";
    }



    public List<List<Expense>> getById(Integer id) {
        List<Expense> pendingList=new ArrayList<>();
        List<Expense> disbursedList=new ArrayList<>();
        List<Expense> approvedList=new ArrayList<>();
        Employee employee=employeeRepo.findById(id).get();
        List<Expense> list= expensesRepo.findByEmployeeId(employee);
        for(Expense e:list){
            if(e.getStatus().toString().equals("PENDING"))pendingList.add(e);
            else if (e.getStatus().toString().equals("APPROVED"))approvedList.add(e);
            else    disbursedList.add(e);
        }
        List<List<Expense>> res=new ArrayList<>();
        res.add(pendingList);
        res.add(disbursedList);
        res.add(approvedList);
        return  res;
    }
}
