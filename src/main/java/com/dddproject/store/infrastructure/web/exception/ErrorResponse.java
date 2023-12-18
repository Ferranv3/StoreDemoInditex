package com.dddproject.store.infrastructure.web.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class ErrorResponse {
    private Date timestamp;
    private String message;
    private String details;
    private String extraDetails;

    public ErrorResponse(String message, String details, String extraDetails) {
        this.timestamp = new Date();
        this.message = message;
        this.details = details;
        this.extraDetails = extraDetails;
    }
}
