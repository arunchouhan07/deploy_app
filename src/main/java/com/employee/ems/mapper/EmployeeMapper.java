package com.employee.ems.mapper;

import com.employee.ems.dto.EmployeeDto;
import com.employee.ems.entity.Employee;

public class EmployeeMapper {
        public static EmployeeDto mapToEmployeeDto(Employee employee){
                return new EmployeeDto(
                        employee.getId(),
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getEmail()
                );
        }
        public static Employee mapToEmployee(EmployeeDto employeeDto){
                return new Employee(
                        employeeDto.getId(),
                        employeeDto.getFirst_name(),
                        employeeDto.getLast_name(),
                        employeeDto.getEmail()
                );
        }
}
