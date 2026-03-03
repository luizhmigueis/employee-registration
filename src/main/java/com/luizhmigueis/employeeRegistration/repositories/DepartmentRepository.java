package com.luizhmigueis.employeeRegistration.repositories;


import com.luizhmigueis.employeeRegistration.entities.Department;
import com.luizhmigueis.employeeRegistration.entities.Employee;
import com.luizhmigueis.employeeRegistration.enums.DepartmentNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Optional<Department> findByName(String name);

    List<Employee> findByDepartmentName(DepartmentNameEnum departmentNameEnum);

}
