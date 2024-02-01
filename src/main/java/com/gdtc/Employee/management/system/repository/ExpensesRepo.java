package com.gdtc.Employee.management.system.repository;

import com.gdtc.Employee.management.system.model.Employee;
import com.gdtc.Employee.management.system.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpensesRepo extends JpaRepository<Expense,Integer> {
    List<Expense> findByEmployeeId(Employee employee);
}
