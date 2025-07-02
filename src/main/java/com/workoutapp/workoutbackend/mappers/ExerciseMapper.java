package com.workoutapp.workoutbackend.mappers;

import com.workoutapp.workoutbackend.dto.ExerciseDto;
import com.workoutapp.workoutbackend.dto.TargetMuscleDto;
import com.workoutapp.workoutbackend.dto.WorkoutExerciseDto;
import com.workoutapp.workoutbackend.model.Exercise;
import com.workoutapp.workoutbackend.model.HowToStep;
import com.workoutapp.workoutbackend.model.WorkoutExercise;
import java.util.List;

public class ExerciseMapper {

    public static ExerciseDto toExerciseDto(Exercise exercise) {

        List<String> steps = exercise.getHowToSteps().stream().map(HowToStep::getText).toList();
        List<TargetMuscleDto> muscles = MuscleMapper.toTargetMuscleDtoList(exercise.getExerciseTargetMuscles());

        return new ExerciseDto(exercise.getId(), exercise.getName(), exercise.getImageURL(), exercise.getDescription(), exercise.getVideoURL(), steps, muscles);
    }

    public static List<ExerciseDto> toExerciseDtoList(List<Exercise> exercises) {
        return exercises.stream().map(ExerciseMapper::toExerciseDto).toList();
    }

    public static WorkoutExerciseDto toWorkoutExerciseDto(WorkoutExercise workoutExercise) {
        return new WorkoutExerciseDto(workoutExercise.getId(), ExerciseMapper.toExerciseDto(workoutExercise.getExercise()), workoutExercise.getSets(), workoutExercise.getReps(), workoutExercise.getKilos());
    }

    public static List<WorkoutExerciseDto> toWorkoutExerciseDtoList(List<WorkoutExercise> workoutExercises) {
        return workoutExercises.stream().map(ExerciseMapper::toWorkoutExerciseDto).toList();
    }

    public static WorkoutExercise toWorkoutExerciseModel(WorkoutExerciseDto dto) {
        WorkoutExercise we = new WorkoutExercise();
        we.setSets(dto.getSets());
        we.setReps(dto.getReps());
        we.setKilos(dto.getKilos());
        Exercise exercise = new Exercise();
        exercise.setId(dto.getExercise().getId());
        we.setExercise(exercise);
        return we;
    }

    public static List<WorkoutExercise> toWorkoutExerciseModelList(List<WorkoutExerciseDto> dtos) {
        return dtos.stream().map(ExerciseMapper::toWorkoutExerciseModel).toList();
    }

}
