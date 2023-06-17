package com.realtech.employeeservice.service;

import com.realtech.employeeservice.dto.EmployeeDto;
import com.realtech.employeeservice.entity.Employee;
import com.realtech.employeeservice.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import static com.realtech.employeeservice.mapper.EmployeeMapper.MAPPER;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

   // private ModelMapper modelMapper;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
      //  Employee employee = modelMapper.map(employeeDto, Employee.class);
        Employee employee = MAPPER.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDto savedDto = MAPPER.mapToEmployeeDto(savedEmployee);
        return savedDto;
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();
        EmployeeDto employeeDto = MAPPER.mapToEmployeeDto(employee);
        //EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
        return employeeDto;
    }
}
