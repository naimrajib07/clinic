package com.bosch.onsite.clinic.controllers.dtos.mapper;

import com.bosch.onsite.clinic.controllers.dtos.AppointmentDto;
import com.bosch.onsite.clinic.entities.Appointment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppointmentMapper {
    public Appointment toEntity(AppointmentDto appointmentDto) {
        return Appointment.builder()
                .dateOfAppointment(appointmentDto.getDateOfAppointment())
                .patient(appointmentDto.getPatient())
                .doctor(appointmentDto.getDoctor())
                .build();
    }

    public AppointmentDto toDto(Appointment appointment) {
        return AppointmentDto.builder()
                .dateOfAppointment(appointment.getDateOfAppointment())
                .patient(appointment.getPatient())
                .doctor(appointment.getDoctor())
                .build();
    }

    public List<AppointmentDto> toDto(List<Appointment> appointments) {
        List<AppointmentDto> appointmentDtos = new ArrayList<>();

        for (Appointment appointment : appointments) {
            appointmentDtos.add(toDto(appointment));
        }

        return appointmentDtos;
    }
}
