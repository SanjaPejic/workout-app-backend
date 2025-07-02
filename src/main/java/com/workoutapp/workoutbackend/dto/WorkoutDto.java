package com.workoutapp.workoutbackend.dto;

import java.time.LocalDate;
import java.util.List;

public class WorkoutDto {

    private Long id;
    private String name;
    private LocalDate date;
    private List<WorkoutExerciseDto> workoutExercises;
    private UserDto user;

    public WorkoutDto(Long id, String name, LocalDate date, List<WorkoutExerciseDto> workoutExercises, UserDto user) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.workoutExercises = workoutExercises;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<WorkoutExerciseDto> getWorkoutExercises() {
        return workoutExercises;
    }

    public void setWorkoutExercises(List<WorkoutExerciseDto> workoutExercises) {
        this.workoutExercises = workoutExercises;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}
