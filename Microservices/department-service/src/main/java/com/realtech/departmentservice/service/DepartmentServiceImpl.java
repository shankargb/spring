package com.realtech.departmentservice.service;

import com.realtech.departmentservice.dto.DepartmentDto;
import com.realtech.departmentservice.entity.Department;
import com.realtech.departmentservice.respository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.realtech.departmentservice.mapper.DepartmentMapper.MAPPER;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = MAPPER.mapToDepartment(departmentDto);
        Department savedDepartment =departmentRepository.save(department);
        DepartmentDto savedDepartmentDto = MAPPER.mapToDepartmentDto(savedDepartment);
        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        Department department = departmentRepository.findByDepartmentCode(code);
        DepartmentDto departmentDto = MAPPER.mapToDepartmentDto(department);
        return departmentDto;
    }
}
