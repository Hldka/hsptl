package com.lcb.dto;

import com.lcb.domain.Department;
import com.lcb.domain.Doctor;
import com.lcb.domain.NamePrefix;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO {
    private String name;
    private NamePrefix namePrefix;//(Dr,Prof,Uzm enum)
    private Department department; //enum      PEDIATRICIAN,DERMATOGIST,CARDIOLOGISTS

    private Integer dateOfGraduate;
    private Integer dateOfStart;

    private String personalNo;


}
