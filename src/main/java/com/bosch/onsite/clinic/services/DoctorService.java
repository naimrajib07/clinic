package com.bosch.onsite.clinic.services;

import com.bosch.onsite.clinic.entities.Appointment;
import com.bosch.onsite.clinic.entities.Doctor;
import com.bosch.onsite.clinic.exceptions.AppointmentConflictException;
import com.bosch.onsite.clinic.utils.AppointmentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DoctorService {
    private InMemoryDbService inMemoryDbService;
    private static int DOCTOR_ID = 5; // seeded for 5 doctor

    @Autowired
    public DoctorService(InMemoryDbService inMemoryDbService) {
        this.inMemoryDbService = inMemoryDbService;
    }

    public Set<Doctor> getAllDoctor() {
        return inMemoryDbService.getAllDoctor();
    }

    public Doctor createDoctor(Doctor doctor) {
        doctor.setId(++DOCTOR_ID);
        inMemoryDbService.saveDoctor(doctor);
        return doctor;
    }

    public void validateDoctorAvailability(int doctorId, String appointmentDateTime) {
        // retrieve current appointment for the doctor
        List<Appointment> currentHourAppointment = inMemoryDbService.getAllAppointment().stream()
                .filter(appointment -> appointment.getDoctor().getId() == doctorId && AppointmentUtils.isTodaysAppointment(appointment))
                .filter(appointment -> AppointmentUtils.hasAlreadyBookedAppointment(appointment, appointmentDateTime))
                .collect(Collectors.toList());

        if (!currentHourAppointment.isEmpty()) {
            throw AppointmentConflictException.builder()
                    .message(String.format("Doctor already has an booked appointment for the schedule  %s with patient email %s",
                            appointmentDateTime, currentHourAppointment.get(0).getDoctor().getEmail()))
                    .build();
        }
    }
}
