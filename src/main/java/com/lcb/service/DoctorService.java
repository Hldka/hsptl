package com.lcb.service;

import com.lcb.domain.Doctor;


import com.lcb.dto.DoctorDTO;
import com.lcb.exception.ConflictException;
import com.lcb.exception.ResourceNotFoundException;
import com.lcb.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;
    public void deleteDoctor(Long id) {
        Doctor doctor=doctorRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Doctor not found"));
        doctorRepository.delete(doctor);


    }


    public void saveDoctor(Doctor doctor) {
        if (doctorRepository.existsByPersonalNo(doctor.getPersonalNo())){
            throw new ConflictException("Doctor already exist");

        }
        doctorRepository.save(doctor);
    }


    public List<Doctor> getAllList() {
        return doctorRepository.findAll();
    }

    public Doctor findDoctor(Long id) {
        return doctorRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Doctor is not found"+id));
    }

    public void updateDoctor(Long id, DoctorDTO doctorDTO) {
        boolean existPersonalNo=doctorRepository.existsByPersonalNo(doctorDTO.getPersonalNo());
        Doctor doctor=findDoctor(id);
        if (existPersonalNo&&!doctorDTO.getPersonalNo().equals(doctor.getPersonalNo())){
            throw new ConflictException("PersonalNo is already exist");
        }
        doctor.setName(doctorDTO.getName());
        doctor.setNamePrefix(doctorDTO.getNamePrefix());
        doctor.setDepartment(doctorDTO.getDepartment());
        doctor.setDateOfGraduate(doctorDTO.getDateOfGraduate());
        doctor.setDateOfStart(doctorDTO.getDateOfStart());
        doctorRepository.save(doctor);
    }
}