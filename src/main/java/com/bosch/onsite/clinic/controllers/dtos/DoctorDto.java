package com.bosch.onsite.clinic.controllers.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {
    private String firstName;
    private String lastName;
    private String email;
    private String specialities;
    private String availableFrom;
    private String availableTill;
}
