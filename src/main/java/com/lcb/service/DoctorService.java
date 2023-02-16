package com.lcb.service;
import com.lcb.domain.Doctor;
import com.lcb.dto.DoctorDTO;
import com.lcb.exception.ConflictException;
import com.lcb.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;
    public void saveDoctor(Doctor doctor)  {

        boolean isExistDoctor = doctorRepository.existByName(doctor.getName());
        if (isExistDoctor) {
            throw new ConflictException("Doctor is already exists by personal number!" + doctor.getName());
        }
        doctorRepository.save(doctor);
    }

/*
    public void updateDoctor(Long id, DoctorDTO doctorDTO) throws ConflictException {
        boolean existName=doctorRepository.existsByName(doctorDTO.getName());
   Doctor doctor=findDoctor(id);
   if (existName&& !doctorDTO.getName().equals(doctor.getName())){
       throw new ConflictException("Doctor name already exist");
   }
doctor.setDepartment(doctorDTO.getDepartment());
   doctor.setDateOfStart(doctorDTO.getDateOfStart());
   doctor.setNamePrefix(doctorDTO.getNamePrefix());
   doctor.setDateOfGraduate(doctorDTO.getDateOfGraduate());
    }


    //!!!DeLETE
     public void deleteDoctor(Long id) {

        Doctor doctor = findDoctor(id);// kendimizi tekrar etmemek icin yukardakini kullandik
        doctorRepository.delete(doctor);
    }


*/
}