package com.luizhmigueis.employeeRegistration.controllers;


import com.luizhmigueis.employeeRegistration.entities.Employee;
import com.luizhmigueis.employeeRegistration.repositories.EmployeeRepository;
import com.luizhmigueis.employeeRegistration.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;

    @PostMapping
    public ResponseEntity<Void> saveEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/all-employees")
    public Page<Employee> findAllEmployees (Pageable pageable){
        List<Employee> employeeList = employeeService.findAllEmployees();
        return employeeRepository.findAll(pageable);
    }
    @GetMapping
    public ResponseEntity<Employee> findByDriversLicenseNumber(@RequestParam String driversLicenseNumber){
        return ResponseEntity.ok(employeeService.findByDriversLicenseNumber(driversLicenseNumber));
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteByDriversLicenseNumber(@RequestParam String driversLicenseNumber){
        employeeService.deleteEmployeeByDriversLicense(driversLicenseNumber);
        return ResponseEntity.ok().build();
    }
    @PutMapping
    public ResponseEntity<Void> updateEmployeeByDriversLicenseNumber(@RequestParam String driversLicenseNumber, @RequestBody Employee employee){
        employeeService.updateEmployeeByDriversLicenseNumber(driversLicenseNumber, employee);
        return ResponseEntity.ok().build();
    }



}
