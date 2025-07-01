package com.workoutapp.workoutbackend.controller;

import com.workoutapp.workoutbackend.dto.WorkoutDto;
import com.workoutapp.workoutbackend.mappers.WorkoutMapper;
import com.workoutapp.workoutbackend.model.Workout;
import com.workoutapp.workoutbackend.service.WorkoutService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("{workoutId}")
    public ResponseEntity<WorkoutDto> getWorkoutById (@PathVariable("workoutId") Long workoutId) {
        Workout workout = this.workoutService.getWorkoutById(workoutId);
        return ResponseEntity.status(200).body(WorkoutMapper.toWorkoutDto(workout));
    }

}
