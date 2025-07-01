package com.workoutapp.workoutbackend.exception;

public class WorkoutNotFoundException extends RuntimeException {
    public WorkoutNotFoundException(Long id) {
        super("Workout not found with id: " + id);
    }
}
