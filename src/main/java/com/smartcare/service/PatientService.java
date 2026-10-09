package com.smartcare.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.smartcare.entity.Patient;
import com.smartcare.repository.PatientRepository;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    // Search Method
    public List<Patient> searchPatients(String keyword) {
        if (keyword != null && !keyword.trim().isEmpty()) {
            return patientRepository.searchPatients(keyword);
        }
        return patientRepository.findAll();
    }
}