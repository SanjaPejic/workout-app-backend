package com.workoutapp.workoutbackend.exception;

public class AppException extends RuntimeException {

    private int statusCode;
    public AppException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {return this.statusCode;}

}


// "Exercise not found with id: " + id