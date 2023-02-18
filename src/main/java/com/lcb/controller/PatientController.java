package com.lcb.controller;

import com.lcb.domain.Doctor;
import com.lcb.dto.DoctorDTO;
import com.lcb.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDto> updatePatient(
            @PathVariable String id,
            @RequestBody PatientDto patientDto) {
        PatientDto updatedPatient = patientService.updatePatient(id, patientDto);
        return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
    }
}
