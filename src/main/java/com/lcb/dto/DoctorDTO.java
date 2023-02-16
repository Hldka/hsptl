package com.lcb.dto;

import com.lcb.domain.Department;
import com.lcb.domain.Doctor;
import com.lcb.domain.NamePrefix;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    public DoctorDTO(Doctor doctor) {
        this.name = doctor.getName();
        this.namePrefix = doctor.getNamePrefix();
        this.department = doctor.getDepartment();
        this.dateOfGraduate = doctor.getDateOfGraduate();
        this.dateOfStart = doctor.getDateOfStart();
    }
}
