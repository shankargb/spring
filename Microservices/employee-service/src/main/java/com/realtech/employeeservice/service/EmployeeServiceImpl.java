package com.realtech.employeeservice.service;

import com.netflix.discovery.converters.Auto;
import com.realtech.employeeservice.dto.ApiResponseDto;
import com.realtech.employeeservice.dto.DepartmentDto;
import com.realtech.employeeservice.dto.EmployeeDto;
import com.realtech.employeeservice.dto.OrganizationDto;
import com.realtech.employeeservice.entity.Employee;
import com.realtech.employeeservice.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import static com.realtech.employeeservice.mapper.EmployeeMapper.MAPPER;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    private WebClient webClient;

    @Autowired
    private ApiClient apiClient;

   // private RestTemplate restTemplate;

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
    public ApiResponseDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();
        EmployeeDto employeeDto = MAPPER.mapToEmployeeDto(employee);
        //EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);

        /*ResponseEntity<DepartmentDto> responseDept =restTemplate.getForEntity("http://localhost:8083/api/departments/"+employee.getDepartmentCode(), DepartmentDto.class);
        DepartmentDto departmentDto = responseDept.getBody();

        ResponseEntity<OrganizationDto> responseOrg=restTemplate.getForEntity("http://localhost:8084/api/organizations/"+employee.getOrganizationCode(), OrganizationDto.class);
        OrganizationDto organizationDto = responseOrg.getBody();*/

       /* DepartmentDto departmentDto=webClient.get().uri("http://localhost:8083/api/departments/"+employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();*/

        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

        OrganizationDto organizationDto = webClient.get().uri("http://localhost:8084/api/organizations/"+employee.getOrganizationCode())
                .retrieve()
                .bodyToMono(OrganizationDto.class)
                .block();

        ApiResponseDto apiResponseDto = new ApiResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        apiResponseDto.setOrganizationDto(organizationDto);
        return apiResponseDto;
    }
}
