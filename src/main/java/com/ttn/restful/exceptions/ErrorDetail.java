package com.ttn.restful.exceptions;

import java.time.LocalDateTime;

public class ErrorDetail {
    private LocalDateTime timestamp;
    private String message;
    private String detail;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetail() {
        return detail;
    }

    public ErrorDetail(LocalDateTime timestamp, String message, String detail) {
        this.timestamp = timestamp;
        this.message = message;
        this.detail = detail;
    }
}
