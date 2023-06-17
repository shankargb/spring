package com.realtech.employeeservice.controller;

import com.realtech.employeeservice.dto.EmployeeDto;
import com.realtech.employeeservice.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{employeeId}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long employeeId) {
        EmployeeDto employee = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }
}
