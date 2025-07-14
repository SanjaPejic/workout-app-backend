package com.workoutapp.workoutbackend.mappers;

import com.workoutapp.workoutbackend.dto.UserDto;
import com.workoutapp.workoutbackend.dto.WorkoutDto;
import com.workoutapp.workoutbackend.dto.WorkoutExerciseDto;
import com.workoutapp.workoutbackend.model.Workout;
import com.workoutapp.workoutbackend.model.WorkoutExercise;

import java.util.ArrayList;
import java.util.List;
import static com.workoutapp.workoutbackend.mappers.ExerciseMapper.toWorkoutExerciseModelList;

public class WorkoutMapper {

    public static WorkoutDto toWorkoutDto(Workout workout) {
        List<WorkoutExerciseDto> workoutExercises = ExerciseMapper.toWorkoutExerciseDtoList(workout.getWorkoutExercises());
        Long userId = workout.getUser().getId();
        return new WorkoutDto(workout.getId(), workout.getName(), workout.getDate(), workoutExercises, userId);
    }

    public static List<WorkoutDto> toWorkoutDtoList(List<Workout> workouts) {
        return workouts.stream().map(WorkoutMapper::toWorkoutDto).toList();
    }

    public static Workout toWorkoutModel(WorkoutDto workoutDto) {
        Workout workout = new Workout();
        workout.setName(workoutDto.getName());
        workout.setDate(workoutDto.getDate());

        List<WorkoutExercise>  workoutExercises = ExerciseMapper.toWorkoutExerciseModelList(workoutDto.getWorkoutExercises());

        for (WorkoutExercise we : workoutExercises) {
            we.setWorkout(workout);
        }

        workout.setWorkoutExercises(workoutExercises);

        return workout;
    }
}
