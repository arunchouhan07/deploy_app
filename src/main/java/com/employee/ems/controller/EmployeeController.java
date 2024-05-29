package com.employee.ems.controller;

import com.employee.ems.dto.EmployeeDto;
import com.employee.ems.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@AllArgsConstructor
public class EmployeeController {
    EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployeeData = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployeeData, HttpStatus.CREATED);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long ids) {
        EmployeeDto employeeDto = employeeService.getAllEmployeeById(ids);
        return ResponseEntity.ok(employeeDto);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployee() {
        List<EmployeeDto> employeeDtoList = employeeService.getAllEmployeeData();
        return ResponseEntity.ok(employeeDtoList);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeDto employeeDto) {
        EmployeeDto employeeDto1 = employeeService.updateEmployee(id, employeeDto);
        return ResponseEntity.ok(employeeDto1);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id")Long id){
        if(employeeService.deleteEmployee(id)){
            return ResponseEntity.ok("Employee Delete Permanently");
        }
        else {
            return ResponseEntity.ok("Employee Not Found");
        }
    }
}
