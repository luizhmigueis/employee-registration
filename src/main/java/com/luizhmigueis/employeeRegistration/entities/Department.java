package com.luizhmigueis.employeeRegistration.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.luizhmigueis.employeeRegistration.enums.DepartmentNameEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DepartmentNameEnum name;

    @OneToMany
    @JsonManagedReference
    private List<Employee> employeeList;
}
