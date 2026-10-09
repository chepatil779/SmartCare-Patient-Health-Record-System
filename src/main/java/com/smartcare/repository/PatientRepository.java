package com.smartcare.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.smartcare.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    // Name ya ID se search karne ke liye custom query
    @Query("SELECT p FROM Patient p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR CAST(p.id AS string) LIKE CONCAT('%', :keyword, '%')")
    List<Patient> searchPatients(@Param("keyword") String keyword);
}