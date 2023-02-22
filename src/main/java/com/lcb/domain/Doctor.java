package com.lcb.domain;

import lombok.*;

import javax.persistence.*;

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
    @Enumerated(EnumType.STRING)
    private NamePrefix namePrefix;//(Dr,Prof,Uzm enum)
    @Enumerated(EnumType.STRING)
    private Department department; //enum      PEDIATRICIAN,DERMATOGIST,CARDIOLOGISTS

    private Integer dateOfGraduate;
    private Integer dateOfStart;


    public String getPersonalNo() {
        return getPersonalNo();
    }
}



