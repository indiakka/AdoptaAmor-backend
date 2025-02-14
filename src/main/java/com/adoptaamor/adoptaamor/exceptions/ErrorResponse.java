package com.adoptaamor.adoptaamor.exceptions;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;

@Getter
public class ErrorResponse {
    private final int statusCode;
    private final String message;
    private final List<String> details;
    private final LocalDateTime timestamp;

    public ErrorResponse(int statusCode, String message, List<String> details, LocalDateTime timestamp) {
        this.statusCode = statusCode;
        this.message = message;
        this.details = details;
        this.timestamp = timestamp;
    }
}