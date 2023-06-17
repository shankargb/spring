package com.realtech.employeeservice.mapper;

import com.realtech.employeeservice.dto.EmployeeDto;
import com.realtech.employeeservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper MAPPER = Mappers.getMapper(EmployeeMapper.class);

    Employee mapToEmployee(EmployeeDto employeeDto);

    EmployeeDto mapToEmployeeDto(Employee employee);
}
