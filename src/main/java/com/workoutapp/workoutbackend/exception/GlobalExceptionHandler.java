package com.workoutapp.workoutbackend.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ExerciseNotFoundException.class)
  public ResponseEntity<String> handleExerciseNotFoundException(ExerciseNotFoundException ex) {
    return ResponseEntity.status(404).body(ex.getMessage());
  }

}
