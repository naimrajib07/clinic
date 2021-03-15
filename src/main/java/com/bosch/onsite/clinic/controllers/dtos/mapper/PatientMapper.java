package com.bosch.onsite.clinic.controllers.dtos.mapper;

import com.bosch.onsite.clinic.controllers.dtos.PatientDto;
import com.bosch.onsite.clinic.entities.Patient;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class PatientMapper {
    public Patient toEntity(PatientDto patientDto) {
        return Patient.builder()
                .firstName(patientDto.getFirstName())
                .lastName(patientDto.getLastName())
                .email(patientDto.getEmail())
                .build();
    }

    public PatientDto toDto(Patient patient) {
        return PatientDto.builder()
                .firstName(patient.getFirstName())
                .lastName(patient.getLastName())
                .email(patient.getEmail())
                .build();
    }

    public Set<PatientDto> toDto(Set<Patient> patients) {
        Set<PatientDto> patientDtos = new HashSet<>();

        for (Patient patient : patients) {
            patientDtos.add(toDto(patient));
        }

        return patientDtos;
    }
}
