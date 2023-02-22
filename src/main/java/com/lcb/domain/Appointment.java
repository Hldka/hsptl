package com.lcb.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;


    @NotNull(message = "doctor id can not be null")
    @NotBlank(message = "first character can not be with white space ")
    @Column(unique = true)
    private String doctorId;


    @NotNull(message = "patient id can not be null")
    @NotBlank(message = "first character can not be with white space ")
    @Column(unique = true)
    private String patientId;

    private String data;

    private  Integer hour;


    private Integer minute;

    private String notes;




}