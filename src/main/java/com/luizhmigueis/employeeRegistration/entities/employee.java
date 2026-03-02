package com.luizhmigueis.employeeRegistration.entities;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.web.format.DateTimeFormatters;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table
@Builder

public class employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(unique = true)
    private String driversLicenseNumber;

    private Double baseSalary;

    private LocalDate birthDate;

    



}
