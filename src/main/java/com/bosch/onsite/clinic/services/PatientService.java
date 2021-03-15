package com.bosch.onsite.clinic.services;

import com.bosch.onsite.clinic.entities.Appointment;
import com.bosch.onsite.clinic.entities.Patient;
import com.bosch.onsite.clinic.exceptions.AppointmentConflictException;
import com.bosch.onsite.clinic.utils.AppointmentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PatientService {
    private InMemoryDbService inMemoryDbService;

    @Autowired
    public PatientService(InMemoryDbService inMemoryDbService) {
        this.inMemoryDbService = inMemoryDbService;
    }

    public Set<Patient> getAllPatient() {
        return inMemoryDbService.getAllPatient();
    }

    public Patient createPatient(Patient patient) {
        return inMemoryDbService.savePatient(patient);
    }

    public void validatePatientAvailability(int patientId, String appointmentDateTime) {
        List<Appointment> currentHourAppointment = inMemoryDbService.getAllAppointment().stream()
                .filter(appointment -> appointment.getPatient().getId() == patientId && AppointmentUtils.isTodaysAppointment(appointment))
                .filter(appointment -> AppointmentUtils.hasAlreadyBookedAppointment(appointment, appointmentDateTime))
                .collect(Collectors.toList());

        if (!currentHourAppointment.isEmpty()) {
            throw AppointmentConflictException.builder()
                    .message(String.format("Patient already has an booked appointment for the schedule  %s with doctor email %s",
                            appointmentDateTime, currentHourAppointment.get(0).getPatient().getEmail()))
                    .build();
        }
    }
}
