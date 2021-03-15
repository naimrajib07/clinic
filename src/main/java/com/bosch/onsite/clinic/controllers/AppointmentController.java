package com.bosch.onsite.clinic.controllers;

import com.bosch.onsite.clinic.controllers.dtos.AppointmentDto;
import com.bosch.onsite.clinic.controllers.dtos.mapper.AppointmentMapper;
import com.bosch.onsite.clinic.entities.Appointment;
import com.bosch.onsite.clinic.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Assumption:
 * Just handling AppointmentConflictException only as we are using in memory storage. Other exception will
 * need to handle based on implementation and scenario. This hold true for each REST endpoint has been exporsed.
 */
@RestController
public class AppointmentController {
    private AppointmentService appointmentService;
    private AppointmentMapper appointmentMapper;

    @Autowired
    public AppointmentController(AppointmentService appointmentService, AppointmentMapper appointmentMapper) {
        this.appointmentService = appointmentService;
        this.appointmentMapper = appointmentMapper;
    }

    @GetMapping(path = "/appointments")
    public List<AppointmentDto> index() {
        List<Appointment> appointments = appointmentService.getAllAppointment();

        return appointmentMapper.toDto(appointments);
    }

    @PostMapping(path = "/appointments")
    public AppointmentDto create(@RequestBody AppointmentDto appointmentDto) {
        Appointment appointment = appointmentMapper.toEntity(appointmentDto);
        Appointment savedAppointment = appointmentService.createAppointment(appointment);

        return appointmentMapper.toDto(savedAppointment);
    }

    @GetMapping(path = "/appointments/doctors/{doctorId}")
    public List<AppointmentDto> getDoctorAllAppointment(@PathVariable int doctorId) {
        List<Appointment> appointmentForDoctor = appointmentService.getAllAppointmentForDoctor(doctorId);

        return appointmentMapper.toDto(appointmentForDoctor);
    }

    @GetMapping(path = "/appointments/patients/{patientId}")
    public List<AppointmentDto> getPatientAllAppointment(@PathVariable int patientId) {
        List<Appointment> appointmentForPatient = appointmentService.getAllAppointmentForPatient(patientId);

        return appointmentMapper.toDto(appointmentForPatient);
    }
}
