package com.workoutapp.workoutbackend.dto;

import com.workoutapp.workoutbackend.model.Exercise;

public class WorkoutExerciseDto {

    private Long id;
    private ExerciseDto exercise;
    // add annotation for int values
    private int sets;
    private int reps;
    // round to one decimal in service
    private float kilos;

    public WorkoutExerciseDto(Long id, ExerciseDto exercise, int sets, int reps, float kilos) {
        this.id = id;
        this.exercise = exercise;
        this.sets = sets;
        this.reps = reps;
        this.kilos = kilos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ExerciseDto getExercise() {
        return exercise;
    }

    public void setExercise(ExerciseDto exercise) {
        this.exercise = exercise;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public float getKilos() {
        return kilos;
    }

    public void setKilos(float kilos) {
        this.kilos = kilos;
    }
}
