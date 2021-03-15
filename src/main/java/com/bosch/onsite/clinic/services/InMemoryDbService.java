package com.bosch.onsite.clinic.services;

import com.bosch.onsite.clinic.entities.Appointment;
import com.bosch.onsite.clinic.entities.Doctor;
import com.bosch.onsite.clinic.entities.Patient;
import com.bosch.onsite.clinic.utils.SeedDataUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Component
public class InMemoryDbService {
    public static List<Appointment> inMemoryAppointments = new ArrayList<>();
    public static Set<Doctor> inMemoryDoctors = new HashSet<>();
    public static Set<Patient> inMemoryPatients = new HashSet<>();

    static {
        seedData();
    }

    public List<Appointment> getAllAppointment() {
        return inMemoryAppointments;
    }

    public Set<Doctor> getAllDoctor() {
        return inMemoryDoctors;
    }

    public Set<Patient> getAllPatient() {
        return inMemoryPatients;
    }

    public void saveAppointment(Appointment appointmentToSave) {
        log.info("Saving appointment [appointmentId = {}, patientId = {}, doctorId = {}]",
                appointmentToSave.getId(), appointmentToSave.getPatient().getId(), appointmentToSave.getDoctor().getId());
        inMemoryAppointments.add(appointmentToSave);
    }

    public Doctor saveDoctor(Doctor doctorToSave) {
        log.info("Saving doctor [doctorId = {}, doctorEmail = {}]",
                doctorToSave.getId(), doctorToSave.getEmail());
        inMemoryDoctors.add(doctorToSave);

        return doctorToSave;
    }

    public Patient savePatient(Patient patientToSave) {
        log.info("Saving patient [patientId = {}, patientEmail = {}]",
                patientToSave.getId(), patientToSave.getEmail());
        inMemoryPatients.add(patientToSave);

        return patientToSave;
    }

    public static void seedData() {
        int numberOfAppointment = 5;
        List<Doctor> doctors = SeedDataUtils.generateDoctor(5);
        List<Patient> patients = SeedDataUtils.generatePatient(5);

        // store each entity to respective container like a table
        inMemoryDoctors.addAll(doctors);
        inMemoryPatients.addAll(patients);

        for (int index = 1; index <= numberOfAppointment; index++) {
            // Assume visiting hour starts at 9 AM
            LocalDateTime visitStartTime = LocalDateTime.now().withHour(9);
            Appointment appointment = Appointment.builder()
                    .doctor(doctors.get(index - 1))
                    .patient(patients.get(index - 1))
                    .dateOfBooking(LocalDateTime.now().toString())
                    .dateOfAppointment(visitStartTime.plusHours(index).toString())
                    .id(index)
                    .build();
            log.info("Inserting appointment in memoryDb [appointmentId = {}]", appointment.getId());
            inMemoryAppointments.add(appointment);
        }
    }
}
