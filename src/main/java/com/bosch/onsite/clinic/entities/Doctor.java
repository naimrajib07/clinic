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
public class Doctor {
    private String firstName;
    private String lastName;
    private String email;
    private String specialities;
    private String availableFrom ;
    private String availableTill;
    private int id;
}
