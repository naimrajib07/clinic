package com.bosch.onsite.clinic.controllers;

import com.bosch.onsite.clinic.controllers.dtos.mapper.DoctorMapper;
import com.bosch.onsite.clinic.controllers.dtos.DoctorDto;
import com.bosch.onsite.clinic.entities.Doctor;
import com.bosch.onsite.clinic.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class DoctorController {
    private DoctorService doctorService;
    private DoctorMapper doctorMapper;

    @Autowired
    public DoctorController(DoctorService doctorService, DoctorMapper doctorMapper) {
        this.doctorService = doctorService;
        this.doctorMapper = doctorMapper;
    }

    @GetMapping(path = "/doctors")
    public Set<DoctorDto> index() {
        Set<Doctor> doctors = doctorService.getAllDoctor();

        return doctorMapper.toDto(doctors);
    }

    @PostMapping(path = "/doctors")
    public DoctorDto create(@RequestBody DoctorDto doctorRequestDto) {
        Doctor doctor = doctorService.createDoctor(doctorMapper.toEntity(doctorRequestDto));

        return doctorMapper.toDto(doctor);
    }
}
