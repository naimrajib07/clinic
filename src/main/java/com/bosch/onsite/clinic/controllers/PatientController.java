package com.bosch.onsite.clinic.controllers;

import com.bosch.onsite.clinic.controllers.dtos.mapper.PatientMapper;
import com.bosch.onsite.clinic.controllers.dtos.PatientDto;
import com.bosch.onsite.clinic.entities.Patient;
import com.bosch.onsite.clinic.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class PatientController {
    private PatientService patientService;
    private PatientMapper patientMapper;

    @Autowired
    public PatientController(PatientService patientService, PatientMapper patientMapper) {
        this.patientService = patientService;
        this.patientMapper = patientMapper;
    }

    @GetMapping(path = "/patients")
    public Set<PatientDto> index() {
        Set<Patient> patients = patientService.getAllPatient();

        return patientMapper.toDto(patients);
    }

    @PostMapping(path = "/patients")
    public PatientDto create(@RequestBody PatientDto patientDto) {
        Patient patient = patientMapper.toEntity(patientDto);
        Patient savedPatient = patientService.createPatient(patient);

        return patientMapper.toDto(savedPatient);
    }
}
