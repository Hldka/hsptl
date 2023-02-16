package com.lcb.repository;

import com.lcb.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {


    boolean existsByPersonalNo(String personalNo);
}
