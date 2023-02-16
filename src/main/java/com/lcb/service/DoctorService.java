package com.lcb.service;

import com.lcb.domain.Doctor;
import com.lcb.exception.ResourceNotFoundException;
import com.lcb.repository.DoctorRepository;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public void deleteDoctor(Long id) {
        Doctor doctor=doctorRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Doctor not found"));
        doctorRepository.delete(doctor);


    }
}
