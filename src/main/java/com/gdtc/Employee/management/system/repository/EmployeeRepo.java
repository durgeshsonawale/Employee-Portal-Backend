package com.gdtc.Employee.management.system.repository;

import com.gdtc.Employee.management.system.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    Employee findByFirstNameAndPassword(String name, String password);
}
