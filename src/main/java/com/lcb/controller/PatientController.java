package com.lcb.controller;

import com.lcb.domain.Patient;
import com.lcb.dto.PatientDTO;
import com.lcb.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {

    final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<Patient> addPatient(@RequestBody PatientDTO patientDto) {
        Patient newPatient = patientService.addPatient(patientDto);
        return ResponseEntity.ok(newPatient);
    }
}
