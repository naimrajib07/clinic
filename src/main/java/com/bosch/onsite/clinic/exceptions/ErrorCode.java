package com.bosch.onsite.clinic.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    APPOINTMENT_CONFLICT("Appointment conflict");

    String codeValue;


    @Override
    public String toString() {
        return getCodeValue();
    }
}
