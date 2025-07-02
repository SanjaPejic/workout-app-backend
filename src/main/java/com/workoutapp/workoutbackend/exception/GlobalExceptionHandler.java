package com.workoutapp.workoutbackend.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(AppException.class)
  public ResponseEntity<String> handleAppException(AppException ex) {
    return ResponseEntity.status(ex.getStatusCode()).body(ex.getMessage());
  }

}
