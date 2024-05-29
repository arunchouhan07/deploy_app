package com.employee.ems.services;

import com.employee.ems.dto.EmployeeDto;
import com.employee.ems.entity.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getAllEmployeeById(Long id);

    List<EmployeeDto> getAllEmployeeData();

    EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto);

    boolean deleteEmployee(Long id);
}
