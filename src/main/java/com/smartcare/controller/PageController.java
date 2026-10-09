package com.smartcare.controller;

import java.util.List;

import com.smartcare.entity.MedicalHistory;
import com.smartcare.service.MedicalHistoryService;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.smartcare.entity.Patient;
import com.smartcare.service.PatientService;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController {

    private final PatientService patientService;
    private final MedicalHistoryService medicalHistoryService;

    public PageController(
            PatientService patientService,
            MedicalHistoryService medicalHistoryService) {
        this.patientService = patientService;
        this.medicalHistoryService = medicalHistoryService;
    }

    @GetMapping("/")
    public String home(Model model) {
        // Total Patients aur Medical History counts fetch kar rahe hain
        long totalPatients = patientService.getAllPatients().size();
        long totalHistory = medicalHistoryService.getAllHistory().size();

        model.addAttribute("totalPatients", totalPatients);
        model.addAttribute("totalHistory", totalHistory);

        return "index";
    }

    @PostMapping("/patients/form")
    public String addPatientFromForm(Patient patient) {

        patientService.savePatient(patient);

        return "redirect:/";
    }
    
    @GetMapping("/patients-page")
    public String patientList(
            @RequestParam(name = "keyword", required = false) String keyword,
            Model model) {

        List<Patient> patients = patientService.searchPatients(keyword);

        model.addAttribute("patients", patients);
        model.addAttribute("keyword", keyword);

        return "patients";
    }
    
    @PostMapping("/patients/delete/{id}")
    public String deletePatient(@PathVariable Long id) {

        patientService.deletePatient(id);

        return "redirect:/patients-page";
    }
    
    @PostMapping("/patients/update/{id}")
    public String updatePatient(@PathVariable Long id, Patient patient) {

        patient.setId(id);

        patientService.savePatient(patient);

        return "redirect:/patients-page";
    }
    
    @GetMapping("/patients/edit/{id}")
    public String editPatient(@PathVariable Long id, Model model) {

        Patient patient = patientService.getPatientById(id);

        model.addAttribute("patient", patient);

        return "edit-patient";
    }
    
    @GetMapping("/medical-history-page/{patientId}")
    public String viewMedicalHistory(
            @PathVariable Long patientId,
            @RequestParam(name = "success", required = false) String success,
            @RequestParam(name = "deleted", required = false) String deleted,
            Model model) {

        Patient patient = patientService.getPatientById(patientId);
        List<MedicalHistory> historyList = medicalHistoryService.getHistoryByPatientId(patientId);

        model.addAttribute("patient", patient);
        model.addAttribute("historyList", historyList);
        
        // Front-end ke liye success aur deleted status add kar rahe hain
        model.addAttribute("success", success);
        model.addAttribute("deleted", deleted);

        return "medical-history";
    }
    
    @PostMapping("/save-medical-history/{patientId}")
    public String saveMedicalHistory(
            @PathVariable Long patientId,
            MedicalHistory history) {

        Patient patient = patientService.getPatientById(patientId);
        history.setPatient(patient);
        medicalHistoryService.saveHistory(history);

        // URL ke saath ?success=true bhej rahe hain
        return "redirect:/medical-history-page/" + patientId + "?success=true";
    }

    @PostMapping("/medical-history/delete/{historyId}/{patientId}")
    public String deleteMedicalHistory(
            @PathVariable Long historyId,
            @PathVariable Long patientId) {

        medicalHistoryService.deleteHistory(historyId);

        // URL ke saath ?deleted=true bhej rahe hain
        return "redirect:/medical-history-page/" + patientId + "?deleted=true";
    }
}