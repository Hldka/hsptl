package com.lcb.dto;

import com.lcb.domain.City;
import com.lcb.domain.Gender;
import com.lcb.domain.Patient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {

    @Column(unique = true)
    private String patientNo;
    private String name;
    private Gender gender;
    private Integer dateOfBirth;
    private City city;
    private String  address;
    private boolean healthInsurance;

    public PatientDTO(Patient patient) {
        this.patientNo = patient.getPatientNo();
        this.name = patient.getName();
        this.gender = patient.getGender();
        this.dateOfBirth = patient.getDateOfBirth();
        this.city = patient.getCity();
        this.address = patient.getAddress();
        this.healthInsurance = patient.isHealthInsurance();
    }
}
