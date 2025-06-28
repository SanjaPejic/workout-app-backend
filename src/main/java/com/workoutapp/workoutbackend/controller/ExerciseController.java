package com.workoutapp.workoutbackend.controller;

import com.workoutapp.workoutbackend.model.Exercise;
import com.workoutapp.workoutbackend.service.ExerciseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/exercise")
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Exercise>> getAllExercises(){
        List<Exercise> allExercises = this.exerciseService.getAllExercises();
        return ResponseEntity.status(200).body(allExercises);
    }

}
