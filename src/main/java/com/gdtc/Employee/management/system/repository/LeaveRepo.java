package com.gdtc.Employee.management.system.repository;

import com.gdtc.Employee.management.system.model.Employee;
import com.gdtc.Employee.management.system.model.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveRepo  extends JpaRepository<Leave,Integer> {
    List<Leave> findByEmployeeId(Employee employee);
}
