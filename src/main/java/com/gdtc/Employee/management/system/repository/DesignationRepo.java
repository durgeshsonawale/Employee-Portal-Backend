package com.gdtc.Employee.management.system.repository;

import com.gdtc.Employee.management.system.model.Designation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesignationRepo extends JpaRepository<Designation,Integer> {
    Designation findFirstByDesignationTitle(String designation);
}
