package com.lcb.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String name;
    private NamePrefix namePrefix;//(Dr,Prof,Uzm enum)
    private Department department; //enum      PEDIATRICIAN,DERMATOGIST,CARDIOLOGISTS

    private Integer dateOfGraduate;
    private Integer dateOfStart;

}
