package com.workoutapp.workoutbackend.mappers;

import com.workoutapp.workoutbackend.dto.WorkoutDto;
import com.workoutapp.workoutbackend.dto.WorkoutExerciseDto;
import com.workoutapp.workoutbackend.model.Workout;

import java.util.List;

public class WorkoutMapper {

    public static WorkoutDto toWorkoutDto(Workout workout) {
        List<WorkoutExerciseDto> workoutExercises = ExerciseMapper.toWorkoutExerciseList(workout.getWorkoutExercises());
        return new WorkoutDto(workout.getId(), workout.getName(), workout.getDate(), workoutExercises);
    }

    public static List<WorkoutDto> toWorkoutDtoList(List<Workout> workouts) {
        return workouts.stream().map(WorkoutMapper::toWorkoutDto).toList();
    }
}
