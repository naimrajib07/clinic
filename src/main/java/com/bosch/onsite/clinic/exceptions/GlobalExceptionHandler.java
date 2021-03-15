package com.bosch.onsite.clinic.exceptions;

import com.bosch.onsite.clinic.controllers.dtos.ErrorResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AppointmentConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ErrorResponseDto process(AppointmentConflictException ex, WebRequest request) {
        log.error("Appointment conflict", ex);

        return ErrorResponseDto.builder()
                .errorCode(ErrorCode.APPOINTMENT_CONFLICT)
                .errorMessage(ex.getMessage())
                .build();
    }
}
