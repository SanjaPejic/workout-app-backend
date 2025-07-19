package com.workoutapp.workoutbackend.controller;

import com.workoutapp.workoutbackend.dto.WorkoutDto;
import com.workoutapp.workoutbackend.mappers.WorkoutMapper;
import com.workoutapp.workoutbackend.model.Exercise;
import com.workoutapp.workoutbackend.model.Workout;
import com.workoutapp.workoutbackend.service.WorkoutService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workouts")
public class WorkoutController {

    private final WorkoutService workoutService;

    public WorkoutController (WorkoutService workoutService) {this.workoutService = workoutService;}

    @GetMapping
    public ResponseEntity<List<WorkoutDto>> getAllWorkouts () {
        List<Workout> allWorkouts = this.workoutService.getAllWorkouts();
        return ResponseEntity.status(200).body(WorkoutMapper.toWorkoutDtoList(allWorkouts));
    }

    // get all workouts for one user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<WorkoutDto>> getUserWorkouts (@PathVariable Long userId) {
        List<Workout> userWorkouts = this.workoutService.getUserWorkouts(userId);
        return ResponseEntity.status(200).body(WorkoutMapper.toWorkoutDtoList(userWorkouts));
    }

    // you probably don't need it at all
    @GetMapping("{workoutId}")
    public ResponseEntity<WorkoutDto> getWorkoutById (@PathVariable Long workoutId) {
        Workout workout = this.workoutService.getWorkoutById(workoutId);
        return ResponseEntity.status(200).body(WorkoutMapper.toWorkoutDto(workout));
    }

    // decide if you want to add request body @Valid
    @PostMapping
    public ResponseEntity<WorkoutDto> createWorkout(@RequestBody WorkoutDto workoutDto) {
        Workout savedWorkout = this.workoutService.createWorkout(workoutDto);
        return ResponseEntity.status(201).body(WorkoutMapper.toWorkoutDto(savedWorkout));
    }

    @PutMapping
    public ResponseEntity<WorkoutDto> updateWorkout(@RequestBody WorkoutDto workoutDto) {
        Workout updatedWorkout = this.workoutService.updateWorkout(workoutDto);
        return ResponseEntity.status(200).body(WorkoutMapper.toWorkoutDto(updatedWorkout));
    }

    @DeleteMapping("{workoutId}")
    public ResponseEntity<Void> deleteExercise(@PathVariable Long workoutId){
        this.workoutService.deleteById(workoutId);
        return ResponseEntity.noContent().build();
    }

}
