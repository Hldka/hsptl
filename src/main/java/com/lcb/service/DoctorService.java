package com.lcb.service;

import com.lcb.domain.Doctor;
import com.lcb.dto.DoctorDTO;
import com.lcb.exception.ResourceNotFoundException;
import com.lcb.repository.DoctorRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
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
    public Doctor updateDoctor(Long id, DoctorDTO doctorDto) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id " + id));
        doctor.setName(doctorDto.getName());
        doctor.setNamePrefix(doctorDto.getNamePrefix());
        doctor.setDepartment(doctorDto.getDepartment());
        doctor.setPersonalNo(doctorDto.getPersonalNo());
        doctor.setDateOfGraduate(doctorDto.getDateOfGraduate());
        doctor.setDateOfStart(doctorDto.getDateOfStart());

        return doctorRepository.save(doctor);
    }


    }

