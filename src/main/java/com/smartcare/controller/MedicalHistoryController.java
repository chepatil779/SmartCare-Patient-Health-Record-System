package com.smartcare.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.smartcare.entity.Patient;
import com.smartcare.service.PatientService;

import com.smartcare.entity.MedicalHistory;
import com.smartcare.service.MedicalHistoryService;

@RestController
@RequestMapping("/medical-history")
public class MedicalHistoryController {

    private final MedicalHistoryService medicalHistoryService;
    private final PatientService patientService;

    public MedicalHistoryController(
            MedicalHistoryService medicalHistoryService,
            PatientService patientService) {

        this.medicalHistoryService = medicalHistoryService;
        this.patientService = patientService;
    }

    @PostMapping("/patient/{patientId}")
    public MedicalHistory addHistory(
            @PathVariable Long patientId,
            @RequestBody MedicalHistory history) {

        Patient patient = patientService.getPatientById(patientId);

        history.setPatient(patient);

        return medicalHistoryService.saveHistory(history);
    }

    @GetMapping
    public List<MedicalHistory> getAllHistory() {
        return medicalHistoryService.getAllHistory();
    }

    @GetMapping("/{id}")
    public MedicalHistory getHistoryById(@PathVariable Long id) {
        return medicalHistoryService.getHistoryById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteHistory(@PathVariable Long id) {
        medicalHistoryService.deleteHistory(id);
        return "Medical history deleted successfully";
    }
    
    @GetMapping("/patient/{patientId}")
    public List<MedicalHistory> getHistoryByPatientId(
            @PathVariable Long patientId) {

        return medicalHistoryService.getHistoryByPatientId(patientId);
    }
}