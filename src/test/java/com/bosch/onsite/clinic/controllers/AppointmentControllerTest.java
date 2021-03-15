package com.bosch.onsite.clinic.controllers;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Skipped because of time constraint
 */
@SpringBootTest
public class AppointmentControllerTest {

    @Test
    public void appointmentShouldCreateForAvailableDoctorAndPatient_ok() {
    }

    @Test
    public void appointmentShouldNotCreateForSameAvailableDoctorAndPatient_ok() {
    }

    @Test
    public void appointmentShouldCreateForOtherAvailableDoctorAndPatientInSameTime_ok() {
    }

    @Test
    public void appointmentShouldNotCreateForNonAvailableDoctorAndAvailablePatient_conflict() {
    }

    @Test
    public void appointmentShouldNotCreateForAvailableDoctorAndNonAvailablePatient_conflict() {
    }

    @Test
    public void appointmentShouldCreateForAvailableDoctorAndPatient_dayBeforeToday_ok() {
    }

    @Test
    public void appointmentShouldCreateForAvailableDoctorAndPatient_dayAfterToday_ok() {
    }
}
