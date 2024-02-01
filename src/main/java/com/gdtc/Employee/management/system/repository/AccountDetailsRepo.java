package com.gdtc.Employee.management.system.repository;

import com.gdtc.Employee.management.system.model.AccountDetails;
import com.gdtc.Employee.management.system.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDetailsRepo extends JpaRepository<AccountDetails,Integer>{
    AccountDetails findByEmployeeId(Employee employee);
}
