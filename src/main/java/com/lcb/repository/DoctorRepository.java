package com.lcb.repository;

import com.lcb.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
//    boolean existsByName(String name);


    boolean existByName(String name);
}
