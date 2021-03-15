package com.bosch.onsite.clinic.controllers.dtos.mapper;

import com.bosch.onsite.clinic.controllers.dtos.DoctorDto;
import com.bosch.onsite.clinic.entities.Doctor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DoctorMapper {
    public Doctor toEntity(DoctorDto doctorDto) {
        return Doctor.builder()
                .firstName(doctorDto.getFirstName())
                .lastName(doctorDto.getLastName())
                .availableFrom(doctorDto.getAvailableFrom())
                .availableTill(doctorDto.getAvailableTill())
                .email(doctorDto.getEmail())
                .specialities(doctorDto.getSpecialities())
                .build();
    }

    public DoctorDto toDto(Doctor doctor) {
        return DoctorDto.builder()
                .firstName(doctor.getFirstName())
                .lastName(doctor.getLastName())
                .availableFrom(doctor.getAvailableFrom())
                .availableTill(doctor.getAvailableTill())
                .email(doctor.getEmail())
                .specialities(doctor.getSpecialities())
                .build();
    }

    public Set<DoctorDto> toDto(Set<Doctor> doctors) {
        Set<DoctorDto> doctorDtos = new HashSet<>();

        for (Doctor doctor : doctors) {
            doctorDtos.add(toDto(doctor));
        }

        return doctorDtos;
    }
}
