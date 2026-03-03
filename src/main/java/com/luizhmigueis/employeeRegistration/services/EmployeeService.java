package com.luizhmigueis.employeeRegistration.services;


import com.luizhmigueis.employeeRegistration.entities.Department;
import com.luizhmigueis.employeeRegistration.entities.Employee;
import com.luizhmigueis.employeeRegistration.enums.DepartmentNameEnum;
import com.luizhmigueis.employeeRegistration.repositories.DepartmentRepository;
import com.luizhmigueis.employeeRegistration.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public void saveEmployee(Employee employee) {
        employeeRepository.saveAndFlush(employee);
        }

    public void deleteEmployeeByDriversLicense(String driversLicenseNumber){
        employeeRepository.deleteByDriversLicenseNumber(driversLicenseNumber);
    }
    public Employee findByDriversLicenseNumber(String driversLicenseNumber){
        return employeeRepository.findByDriversLicenseNumber(driversLicenseNumber).orElseThrow(
                () -> new RuntimeException("Employee not found")
        );
    }
    public Employee findById(Long id){
        return employeeRepository.findById(id).orElseThrow(
                () -> new RuntimeException("ID not found")
        );
    }
    public void updateEmployeeByDriversLicenseNumber(String driversLicenseNumber, Employee employee){
        Employee employeeEntity = employeeRepository.findByDriversLicenseNumber(driversLicenseNumber).orElseThrow(() -> new RuntimeException("Drivers License Number not found"));
        Employee employeeUpdated = Employee.builder()
                .id(employeeEntity.getId())
                .name(employee.getName() != null ? employee.getName() : employeeEntity.getName())
                .driversLicenseNumber(employee.getDriversLicenseNumber() != null ? employee.getDriversLicenseNumber() : employeeEntity.getDriversLicenseNumber())
                .baseSalary(employee.getBaseSalary() != null ? employee.getBaseSalary() : employeeEntity.getBaseSalary())
                .birthDate(employee.getBirthDate() != null ? employee.getBirthDate() : employeeEntity.getBirthDate())
                .department(employee.getDepartment() != null ? employee.getDepartment() : employeeEntity.getDepartment())
                .build();
        employeeRepository.saveAndFlush(employeeUpdated);

    }



}
