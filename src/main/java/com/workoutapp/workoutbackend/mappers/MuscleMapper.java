package com.workoutapp.workoutbackend.mappers;

import com.workoutapp.workoutbackend.dto.MuscleDto;
import com.workoutapp.workoutbackend.dto.TargetMuscleDto;
import com.workoutapp.workoutbackend.model.ExerciseTargetMuscle;
import com.workoutapp.workoutbackend.model.Muscle;

import java.util.List;

public class MuscleMapper {

    public static TargetMuscleDto toTargetMuscleDto (ExerciseTargetMuscle exerciseTargetMuscle){
        return new TargetMuscleDto(exerciseTargetMuscle.getId(), exerciseTargetMuscle.getPercentage(), toMuscleDto(exerciseTargetMuscle.getMuscle()));
    }

    public static MuscleDto toMuscleDto (Muscle muscle){
        return new MuscleDto(muscle.getId(), muscle.getName());
    }

    public static List<TargetMuscleDto> toTargetMuscleDtoList (List<ExerciseTargetMuscle> targetMuscles){
        return targetMuscles.stream().map(MuscleMapper::toTargetMuscleDto).toList();
    }

    public static List<MuscleDto> toMuscleDtoList (List<Muscle> muscles){
        return muscles.stream().map(MuscleMapper::toMuscleDto).toList();
    }

}
