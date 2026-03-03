package com.luizhmigueis.employeeRegistration.repositories;

import com.luizhmigueis.employeeRegistration.entities.Employee;
import com.luizhmigueis.employeeRegistration.enums.DepartmentNameEnum;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByDriversLicenseNumber(String driversLicenseNumber);

    List<Employee> findByDepartmentName(DepartmentNameEnum name);

    @Transactional
    void deleteByDriversLicenseNumber(String driversLicenseNumber);
}

