package com.bosch.onsite.clinic.controllers.dtos;

import com.bosch.onsite.clinic.exceptions.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponseDto {
    private ErrorCode errorCode;
    private String errorMessage;
}
