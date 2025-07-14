package com.workoutapp.workoutbackend.dto;

import java.time.LocalDate;
import java.util.List;

public class WorkoutDto {

    private Long id;
    private String name;
    private LocalDate date;
    private List<WorkoutExerciseDto> workoutExercises;
    private Long userId;

    public WorkoutDto(Long id, String name, LocalDate date, List<WorkoutExerciseDto> workoutExercises, Long userId) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.workoutExercises = workoutExercises;
        this.userId = userId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUser(Long userId) {
        this.userId = userId;
    }
}
