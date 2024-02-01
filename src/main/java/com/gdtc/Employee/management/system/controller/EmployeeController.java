package com.gdtc.Employee.management.system.controller;

import com.gdtc.Employee.management.system.Service.EmployeeService;
import com.gdtc.Employee.management.system.model.Designation;
import com.gdtc.Employee.management.system.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("employee")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("register")
    public String registerEmployee(@RequestBody Employee employee){
        return  employeeService.addEmployee(employee);
    }

    @GetMapping("LogIn/{name}/{password}")
    public Integer logIn(@PathVariable String name, @PathVariable String password){
        return employeeService.logIn(name, password);
    }
    @GetMapping("{id}")
    public Employee getEmpById(@PathVariable Integer id){
        return  employeeService.getEmpById(id);
    }
    @PutMapping()
    public String updateEmp(@RequestBody Employee employee){
        return employeeService.updateEmp(employee);
    }

//    @GetMapping("designation")
//    public Designation getDesgnation
//

}
