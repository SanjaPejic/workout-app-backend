package com.workoutapp.workoutbackend.controller;

import com.workoutapp.workoutbackend.dto.WorkoutDto;
import com.workoutapp.workoutbackend.mappers.WorkoutMapper;
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

    // !probably will have to change it to getWorkoutByUserId
    @GetMapping("{workoutId}")
    public ResponseEntity<WorkoutDto> getWorkoutById (@PathVariable("workoutId") Long workoutId) {
        Workout workout = this.workoutService.getWorkoutById(workoutId);
        return ResponseEntity.status(200).body(WorkoutMapper.toWorkoutDto(workout));
    }

    // decide if you want to add request body @Valid
    @PostMapping
    public ResponseEntity<WorkoutDto> createWorkout(@RequestBody WorkoutDto workoutDto) {
        Workout savedWorkout = workoutService.createWorkout(workoutDto);
        Workout fullSavedWorkout = workoutService.getWorkoutById(savedWorkout.getId());
        return ResponseEntity.status(201).body(WorkoutMapper.toWorkoutDto(fullSavedWorkout));
    }

//    @PutMapping("{workoutId}")
//    public ResponseEntity<Workout> updateWorkout(@PathVariable("workoutId") Long workoutId, @RequestBody Workout workoutDetails) {
//        Workout updatedWorkout = workoutService.updateWorkout(workoutId, workoutDetails);
//        return ResponseEntity.status(200).body(updatedWorkout);
//    }


}
