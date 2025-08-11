package com.workoutapp.workoutbackend.mappers;

import com.workoutapp.workoutbackend.dto.ExerciseDto;
import com.workoutapp.workoutbackend.dto.TargetMuscleDto;
import com.workoutapp.workoutbackend.dto.WorkoutExerciseDto;
import com.workoutapp.workoutbackend.model.Exercise;
import com.workoutapp.workoutbackend.model.HowToStep;
import com.workoutapp.workoutbackend.model.WorkoutExercise;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExerciseMapper {

    public static ExerciseDto toExerciseDto(Exercise exercise) {

        List<String> steps = exercise.getHowToSteps().stream().map(HowToStep::getText).toList();
        List<TargetMuscleDto> muscles = MuscleMapper.toTargetMuscleDtoList(exercise.getExerciseTargetMuscles());

        return new ExerciseDto(exercise.getId(), exercise.getName(), exercise.getImageURL(), exercise.getDescription(), exercise.getVideoURL(), steps, muscles);
    }

    public static Page<ExerciseDto> toExerciseDtoPage(Page<Exercise> exercisePage) {
        List<ExerciseDto> dtos = exercisePage.stream().map(ExerciseMapper::toExerciseDto).toList();
        return new PageImpl<>(dtos, exercisePage.getPageable(), exercisePage.getTotalElements());
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

    public static ArrayList<WorkoutExercise> toWorkoutExerciseModelList(List<WorkoutExerciseDto> dtos) {
        return dtos.stream().map(ExerciseMapper::toWorkoutExerciseModel).collect(Collectors.toCollection(ArrayList::new));
    }

}
