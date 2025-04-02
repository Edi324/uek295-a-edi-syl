package ch.noseryoung.uek295_account.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
public class ApiErrorResponse {
    private final LocalDateTime timestamp;
    private final int status;
    private final String error;
    private final String message;
    private final String path;

    public ApiErrorResponse(HttpStatus status, String error, String message, String path) {
        this.timestamp = LocalDateTime.now();
        this.status = status.value();
        this.error = error;
        this.message = message;
        this.path = path;
    }
}