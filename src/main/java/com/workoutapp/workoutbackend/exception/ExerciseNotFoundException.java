package com.workoutapp.workoutbackend.exception;

public class ExerciseNotFoundException extends RuntimeException {
    public ExerciseNotFoundException(Long id) {
        super("Exercise not found with id: " + id);
    }
}
