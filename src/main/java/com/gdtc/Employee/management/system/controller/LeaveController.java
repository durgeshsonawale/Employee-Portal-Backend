package com.gdtc.Employee.management.system.controller;

import com.gdtc.Employee.management.system.Service.LeaveService;
import com.gdtc.Employee.management.system.model.Leave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("leave")
@CrossOrigin("*")
public class LeaveController {

    @Autowired
    LeaveService leaveService;
    @GetMapping()
    List<Leave> getAllLeaves(){
        return leaveService.getAllLeaves();
    }
    @PostMapping()
    String createLeave(@RequestBody Leave leave){
        return leaveService.createLeave(leave);
    }

    @PutMapping()
    String updateStatus(@RequestBody Leave leave){
        return leaveService.updateStatus(leave);
    }

    @GetMapping("{id}")
    List<Leave> getAllById(@PathVariable Integer id){
        return this.leaveService.getAllById(id);
    }

    @GetMapping("monthly/{id}")
    public Map<String,Integer> calculateMonthlyLeaveStats(@PathVariable Integer id){
        return leaveService.calculateMonthlyLeaveStats(id);
    }
}
