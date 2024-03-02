package com.example.redis.configuration;

import com.example.redis.exception.HttpResponse;
import com.example.redis.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<?> handleException(StudentNotFoundException exception) {
        return new ResponseEntity<>(new HttpResponse(exception.getMessage()), HttpStatus.NOT_FOUND );
    }
}
