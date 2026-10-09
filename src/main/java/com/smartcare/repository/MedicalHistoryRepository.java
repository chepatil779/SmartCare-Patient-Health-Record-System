package com.smartcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.smartcare.entity.MedicalHistory;

public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Long> {
	List<MedicalHistory> findByPatientId(Long patientId);

}
