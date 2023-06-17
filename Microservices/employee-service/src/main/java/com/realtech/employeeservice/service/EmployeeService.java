package com.realtech.employeeservice.service;

import com.realtech.employeeservice.dto.EmployeeDto;
import com.realtech.employeeservice.entity.Employee;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeId);
}
