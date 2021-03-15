package com.bosch.onsite.clinic.controllers.dtos;

import com.bosch.onsite.clinic.entities.Doctor;
import com.bosch.onsite.clinic.entities.Patient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDto {
    private String dateOfAppointment;
    private Doctor doctor;
    private Patient patient;
}
