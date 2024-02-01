package com.gdtc.Employee.management.system.controller;

import com.gdtc.Employee.management.system.Service.AccountDetailsService;
import com.gdtc.Employee.management.system.Service.ExpensesService;
import com.gdtc.Employee.management.system.model.AccountDetails;
import com.gdtc.Employee.management.system.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("account")
@CrossOrigin("*")
public class AccountDetailsController {
    @Autowired
    AccountDetailsService accountDetailsService;
    @GetMapping("{id}")
    AccountDetails getAccountDetailsByUserId(@PathVariable Integer id){
        return accountDetailsService.getAllAccountDetails(id);
    }
    @PostMapping()
    String createAccountDetails(@RequestBody AccountDetails accountDetails){
        return accountDetailsService.createAccountDetails(accountDetails);
    }

    @PutMapping()
    String updateStatus(@RequestBody AccountDetails accountDetails){
        return accountDetailsService.updateStatus(accountDetails);
    }
}
