package com.lcb.service;

import com.lcb.domain.Doctor;
import com.lcb.domain.Patient;
import com.lcb.dto.DoctorDTO;
import com.lcb.exception.ResourceNotFoundException;
import com.lcb.repository.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientService {private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient updatePatient(String id, Patient patientToUpdate) {
        Patient existingPatient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient", "id", id));

        // güncelleme işlemi
        existingPatient.setName(patientToUpdate.getName());
        existingPatient.setGender(patientToUpdate.getGender());
        existingPatient.setDateOfBirth(patientToUpdate.getDateOfBirth());
        existingPatient.setCity(patientToUpdate.getCity());
        existingPatient.setAddress(patientToUpdate.getAddress());
        existingPatient.setHealthInsurance(patientToUpdate.isHealthInsurance());

        return patientRepository.save(existingPatient);
    }
}


