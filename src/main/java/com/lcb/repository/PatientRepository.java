package com.lcb.repository;

import com.lcb.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {

    boolean existsByPatientNo(String patientNo);
}
