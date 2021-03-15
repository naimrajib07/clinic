package com.bosch.onsite.clinic.utils;

import com.bosch.onsite.clinic.entities.Doctor;
import com.bosch.onsite.clinic.entities.Patient;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class SeedDataUtils {
    //TODO: use generic?
    public static List<Doctor> generateDoctor(int size) {
        List<Doctor> doctors = new ArrayList<>();
        for (int index = 1; index <= size; index++) {
            Doctor doctor = Doctor.builder()
                    .id(index)
                    .firstName(String.format("doctor-%s", index))
                    .lastName("lastname")
                    .email(String.format("doctor-%s.lastname@email.com", index))
                    .specialities("General Practitioner")
                    .build();

            log.info("Inserting doctor in memoryDb [doctorId = {}]", doctor.getId());
            doctors.add(doctor);
        }
        return doctors;
    }

    public static List<Patient> generatePatient(int size) {
        List<Patient> patients = new ArrayList<>();
        for (int index = 1; index <= size; index++) {
            Patient patient = Patient.builder()
                    .id(index)
                    .firstName(String.format("patient-%s", index))
                    .lastName("lastname")
                    .email(String.format("patient-%s.lastname@email.com", index))
                    .build();
            log.info("Inserting patient in memoryDb [patientId = {}]", patient.getId());
            patients.add(patient);
        }
        return patients;
    }
}
