package com.gdtc.Employee.management.system.controller;

import com.gdtc.Employee.management.system.Service.ExpensesService;
import com.gdtc.Employee.management.system.model.Expense;
import com.gdtc.Employee.management.system.model.Leave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("expenses")
@CrossOrigin("*")
public class ExpensesControlller {
    @Autowired
    ExpensesService expenseService;
    @GetMapping()
    List<Expense> getAllExpenses(){
        return expenseService.getAllExpenses();
    }
    @PostMapping()
    String createExpenses(@RequestBody Expense expense){
        return expenseService.createExpenses(expense);
    }

    @PutMapping()
    String updateStatus(@RequestBody Expense expense){
        return expenseService.updateStatus(expense);
    }

    @GetMapping("{id}")
    public List<List<Expense>> getById(@PathVariable Integer id){
        return expenseService.getById(id);
    }
}
