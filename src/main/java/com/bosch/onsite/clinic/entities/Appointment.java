package com.bosch.onsite.clinic.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    private int id;
    private String dateOfBooking;
    private String dateOfAppointment;
    @Builder.Default
    private int durationInHours = 1;
    private Doctor doctor;
    private Patient patient;
}
