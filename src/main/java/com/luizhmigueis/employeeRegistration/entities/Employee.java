package com.luizhmigueis.employeeRegistration.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table
@Builder

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(unique = true)
    private String driversLicenseNumber;

    private Double baseSalary;

    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonBackReference
    private Department department;





}
