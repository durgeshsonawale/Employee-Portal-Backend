package com.gdtc.Employee.management.system.Service;

import com.gdtc.Employee.management.system.model.AccountDetails;
import com.gdtc.Employee.management.system.model.Employee;
import com.gdtc.Employee.management.system.repository.AccountDetailsRepo;
import com.gdtc.Employee.management.system.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountDetailsService {
    @Autowired
    AccountDetailsRepo accountDetailsRepo;
    @Autowired
    EmployeeRepo employeeRepo;
    public AccountDetails getAllAccountDetails(Integer id) {
        Employee employee=employeeRepo.findById(id).orElseThrow();
        return accountDetailsRepo.findByEmployeeId(employee);

    }

    public String createAccountDetails(AccountDetails accountDetails) {
        accountDetailsRepo.save(accountDetails);
        return "Account details added";
    }

    public String updateStatus(AccountDetails accountDetails) {
        accountDetailsRepo.save(accountDetails);
        return "Account details updated";
    }
}
