package com.bosch.onsite.clinic.services;

import com.bosch.onsite.clinic.entities.Appointment;
import com.bosch.onsite.clinic.entities.Doctor;
import com.bosch.onsite.clinic.entities.Patient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AppointmentService {
    private InMemoryDbService inMemoryDbService;
    private DoctorService doctorService;
    private PatientService patientService;

    private static int APPOINTMENT_NUMBER = 5;

    @Autowired
    public AppointmentService(InMemoryDbService inMemoryDbService,
                              DoctorService doctorService, PatientService patientService) {
        this.inMemoryDbService = inMemoryDbService;
        this.doctorService = doctorService;
        this.patientService = patientService;
    }

    public List<Appointment> getAllAppointment() {
        return inMemoryDbService.getAllAppointment();
    }

    public List<Appointment> getAllAppointmentForDoctor(int doctorId) {
        return getAllAppointment().stream()
                .filter(appointment -> appointment.getDoctor().getId() == doctorId)
                .collect(Collectors.toList());
    }

    public List<Appointment> getAllAppointmentForPatient(int patientId) {
        return getAllAppointment().stream()
                .filter(appointment -> appointment.getPatient().getId() == patientId)
                .collect(Collectors.toList());
    }

    public Appointment createAppointment(Appointment requestedAppointment) {
        Appointment appointment = null;

        if (Objects.isNull(requestedAppointment)) {
            log.error("Not a valid requestedAppointment [requestedAppointment = {}]", requestedAppointment);
        }

        Doctor doctor = requestedAppointment.getDoctor();
        Patient patient = requestedAppointment.getPatient();

        if (Objects.isNull(doctor) || Objects.isNull(patient)) {
            log.error("Requires valid doctor and patient [doctor = {}, patient = {}]", doctor, patient);
        }

        // check appointment from request
        String appointmentDateTime = LocalDateTime.now().toString();
        if (!Objects.isNull(requestedAppointment.getDateOfAppointment())) {
            appointmentDateTime = requestedAppointment.getDateOfAppointment();
        }

        appointment = Appointment.builder()
                .id(++APPOINTMENT_NUMBER)
                .dateOfAppointment(appointmentDateTime)
                .dateOfBooking(LocalDateTime.now().toString())
                .doctor(requestedAppointment.getDoctor())
                .patient(requestedAppointment.getPatient())
                .build();

        doctorService.validateDoctorAvailability(doctor.getId(), appointmentDateTime);
        patientService.validatePatientAvailability(patient.getId(), appointmentDateTime);

        inMemoryDbService.saveAppointment(appointment);


        return appointment;
    }
}
