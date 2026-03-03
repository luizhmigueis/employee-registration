package com.luizhmigueis.employeeRegistration.controllers;

import com.luizhmigueis.employeeRegistration.entities.Department;
import com.luizhmigueis.employeeRegistration.repositories.DepartmentRepository;
import com.luizhmigueis.employeeRegistration.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;
    private final DepartmentRepository departmentRepository;

    @GetMapping("/all-departments")
    public ResponseEntity<List<Department>> findAll(){
        departmentService.findAll();
        return ResponseEntity.ok().build();
    }
    @GetMapping("/all-employeeswithdepartments")
    public ResponseEntity<List<Department>> findAllWithEmployees(){
        List<Department> departmentList = departmentService.findAll();
        return ResponseEntity.ok(departmentList);
    }
}
