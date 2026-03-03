package com.luizhmigueis.employeeRegistration.services;

import com.luizhmigueis.employeeRegistration.entities.Department;
import com.luizhmigueis.employeeRegistration.entities.Employee;
import com.luizhmigueis.employeeRegistration.enums.DepartmentNameEnum;
import com.luizhmigueis.employeeRegistration.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional(readOnly = true)
    public List<Department> findAll(){
        return departmentRepository.findAll();
    }


}


