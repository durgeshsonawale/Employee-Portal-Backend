package com.gdtc.Employee.management.system.controller;

import com.gdtc.Employee.management.system.Service.DesignationService;
import com.gdtc.Employee.management.system.model.Designation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("designation")
@CrossOrigin("*")
public class DesignationController {

    @Autowired
    private DesignationService designationService;

    @PostMapping()
    public String addDesignation(@RequestBody Designation designation){
        return designationService.addDesignation(designation);
    }

    @GetMapping("{id}")
    public Designation getById(@PathVariable Integer id){
        return designationService.getById(id);
    }
}
