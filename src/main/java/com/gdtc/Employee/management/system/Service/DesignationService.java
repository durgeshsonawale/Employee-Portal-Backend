package com.gdtc.Employee.management.system.Service;

import com.gdtc.Employee.management.system.model.Designation;
import com.gdtc.Employee.management.system.repository.DesignationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DesignationService {

    @Autowired
    private DesignationRepo designationRepo;

    public String addDesignation(Designation designation) {
        designationRepo.save(designation);
        return "Designation Added.";
    }

    public Designation getById(Integer id) {
        return designationRepo.findById(id).get();
    }
}
