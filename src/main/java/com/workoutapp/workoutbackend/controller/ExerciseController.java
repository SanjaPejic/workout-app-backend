package com.workoutapp.workoutbackend.controller;

import com.workoutapp.workoutbackend.dto.ExerciseDto;
import com.workoutapp.workoutbackend.mappers.ExerciseMapper;
import com.workoutapp.workoutbackend.model.Exercise;
import com.workoutapp.workoutbackend.service.ExerciseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/exercises")
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping
    public ResponseEntity<Page<ExerciseDto>> getAllExercises(Pageable pageable, @RequestParam("searchTerm") Optional<String> searchTerm, @RequestParam(name = "targetMuscles", required = false) List<String> targetMuscNames) {
        Page<Exercise> allExercises = this.exerciseService.getAllExercises(pageable, searchTerm.orElse(""), targetMuscNames != null ? targetMuscNames : new ArrayList<>());
        return ResponseEntity.status(200).body(ExerciseMapper.toExerciseDtoPage(allExercises));
    }

    @GetMapping("/{exerciseId}")
    public ResponseEntity<ExerciseDto> getExercise(@PathVariable Long exerciseId){
        Exercise exercise = this.exerciseService.getExerciseById(exerciseId);
        return ResponseEntity.status(200).body(ExerciseMapper.toExerciseDto(exercise));
    }

    // used only for the development process
    @PostMapping
    public ResponseEntity<Exercise> createExercise(@RequestBody Exercise exercise){
        Exercise savedExercise = this.exerciseService.createExercise(exercise);
        return ResponseEntity.status(201).body(savedExercise);
    }

    @DeleteMapping("/{exerciseId}")
    public ResponseEntity<Void> deleteExercise(@PathVariable Long exerciseId){
        this.exerciseService.deleteById(exerciseId);
        return ResponseEntity.noContent().build();
    }

}
