package com.lcb.domain;

import com.lcb.domain.City;
import com.lcb.domain.Gender;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(unique = true)
    private String patientNo;
    @NotNull(message= "Please provide your name")
    @Column(length = 50, nullable = false)
    private String name;
    @NotNull(message= "Please provide your gender MALE or FEMALE")
    @Column(length =10, nullable = false)
    private Gender gender;
    private Integer dateOfBirth;
    @NotNull(message= "Please provide your city")
    private City city;
    @NotNull(message= "Please provide your address")
    @Column(length = 50, nullable = false)
    private String  address;

    private boolean healthInsurance;

}