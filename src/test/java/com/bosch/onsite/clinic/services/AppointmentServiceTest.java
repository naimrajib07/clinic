package com.bosch.onsite.clinic.services;

import com.bosch.onsite.clinic.entities.Appointment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

/**
 * Skipping because of time constraint
 */
@RunWith(MockitoJUnitRunner.class)
public class AppointmentServiceTest {
    @Spy
    private InMemoryDbService inMemoryDbService;

    @InjectMocks
    private AppointmentService appointmentService;

    @Test
    public void test_getAllAppointment_ok() {
        List<Appointment> allAppointment = appointmentService.getAllAppointment();

        // seed data creating 5 appointment initially
        assertThat(allAppointment, hasSize(5));
    }
}
