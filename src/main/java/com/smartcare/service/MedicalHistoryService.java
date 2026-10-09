package com.smartcare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smartcare.entity.MedicalHistory;
import com.smartcare.repository.MedicalHistoryRepository;

@Service
public class MedicalHistoryService {

	
    private final MedicalHistoryRepository medicalHistoryRepository;

    public MedicalHistoryService(MedicalHistoryRepository medicalHistoryRepository) {
        this.medicalHistoryRepository = medicalHistoryRepository;
    }

    public MedicalHistory saveHistory(MedicalHistory history) {
        return medicalHistoryRepository.save(history);
    }

    public List<MedicalHistory> getAllHistory() {
        return medicalHistoryRepository.findAll();
    }

    public MedicalHistory getHistoryById(Long id) {
        return medicalHistoryRepository.findById(id).orElse(null);
    }

    public void deleteHistory(Long id) {
        medicalHistoryRepository.deleteById(id);
    }
    public List<MedicalHistory> getHistoryByPatientId(Long patientId) {
        return medicalHistoryRepository.findByPatientId(patientId);
    }
}