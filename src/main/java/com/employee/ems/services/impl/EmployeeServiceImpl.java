package com.employee.ems.services.impl;

import com.employee.ems.dto.EmployeeDto;
import com.employee.ems.entity.Employee;
import com.employee.ems.exception.CustomException;
import com.employee.ems.mapper.EmployeeMapper;
import com.employee.ems.repository.EmployeeRepository;
import com.employee.ems.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployeeData = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployeeData);
    }

    @Override
    public EmployeeDto getAllEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() ->
                new CustomException("Employee Not Found By Given Id :" + id));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployeeData() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList.stream().map((employee) ->
                EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {

        Employee employee = employeeRepository.findById(id).orElseThrow(() ->
                new CustomException("Employee Not Found By Given Id : " + id)
        );
        employee.setFirstName(employeeDto.getFirst_name());
        employee.setLastName(employeeDto.getLast_name());
        employee.setEmail(employeeDto.getEmail());
        Employee employee1 = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(employee1);
    }

    @Override
    public boolean deleteEmployee(Long id) {

        if(employeeRepository.existsById(id)){
            employeeRepository.findById(id).orElseThrow(() ->
                    new CustomException("Employee Not Found with Given Id: "+id)
            );
            employeeRepository.deleteById(id);
            return true;
        }
        else{
            return false;
        }
    }
}
