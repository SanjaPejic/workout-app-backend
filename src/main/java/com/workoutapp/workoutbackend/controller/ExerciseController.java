package com.workoutapp.workoutbackend.controller;

import com.workoutapp.workoutbackend.model.Exercise;
import com.workoutapp.workoutbackend.service.ExerciseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercises")
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping
    public ResponseEntity<List<Exercise>> getAllExercises(){
        List<Exercise> allExercises = this.exerciseService.getAllExercises();
        return ResponseEntity.status(200).body(allExercises);
    }

    @GetMapping("/{exerciseId}")
    public ResponseEntity<Exercise> getExercise(@PathVariable Long exerciseId){
        Exercise exercise = this.exerciseService.getExerciseById(exerciseId);
        return ResponseEntity.status(200).body(exercise);
    }

    @PostMapping
    public ResponseEntity<Exercise> addExercise(@RequestBody Exercise exercise){
        Exercise savedExercise = this.exerciseService.addExercise(exercise);
        return ResponseEntity.status(201).body(savedExercise);
    }

    @DeleteMapping("/{exerciseId}")
    public ResponseEntity<Exercise> deleteExercise(@PathVariable Long exerciseId){
        this.exerciseService.deleteById(exerciseId);
        return ResponseEntity.noContent().build();
    }

}
