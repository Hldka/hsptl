package com.lcb.service;

import com.lcb.domain.Patient;
import com.lcb.dto.PatientDTO;
import com.lcb.exception.ResourceNotFoundException;
import com.lcb.repository.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient addPatient(PatientDTO patientDto) {
        Patient patient = new Patient();
        patient.setPatientNo(patientDto.getPatientNo());
        patient.setName(patientDto.getName());
        patient.setGender(patientDto.getGender());
        patient.setDateOfBirth(patientDto.getDateOfBirth());
        patient.setCity(patientDto.getCity());
        patient.setAddress(patientDto.getAddress());
        patient.setHealthInsurance(patientDto.isHealthInsurance());

        return patientRepository.save(patient);
    }
}
