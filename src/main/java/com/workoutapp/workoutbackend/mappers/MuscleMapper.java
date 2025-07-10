package com.workoutapp.workoutbackend.mappers;

import com.workoutapp.workoutbackend.dto.*;
import com.workoutapp.workoutbackend.model.*;

import java.util.ArrayList;
import java.util.List;

public class MuscleMapper {

    public static MuscleDto toMuscleDto (Muscle muscle){
        return new MuscleDto(muscle.getId(), muscle.getName());
    }

    public static List<MuscleDto> toMuscleDtoList (List<Muscle> muscles){
        return muscles.stream().map(MuscleMapper::toMuscleDto).toList();
    }

    public static TargetMuscleDto toTargetMuscleDto (ExerciseTargetMuscle exerciseTargetMuscle){
        return new TargetMuscleDto(exerciseTargetMuscle.getId(), exerciseTargetMuscle.getPercentage(), toMuscleDto(exerciseTargetMuscle.getMuscle()));
    }

    public static List<TargetMuscleDto> toTargetMuscleDtoList (List<ExerciseTargetMuscle> targetMuscles){
        return targetMuscles.stream().map(MuscleMapper::toTargetMuscleDto).toList();
    }

    public static InjuryDto toInjuryDto (Injury injury){
        UserDto userDto = UserMapper.toUserDto(injury.getUser());
        MuscleDto muscleDto = toMuscleDto(injury.getMuscle());
        return new InjuryDto(injury.getId(), userDto, muscleDto);
    }

    public static List<InjuryDto> toInjuryDtoList (List<Injury> injuries){
        return injuries.stream().map(MuscleMapper::toInjuryDto).toList();
    }

    public static Injury toInjuryModel (InjuryDto injuryDto){
        Injury injury = new Injury();
        injury.setId(injuryDto.getId());
//        User user = new User();
//        user.setId(injuryDto.getUser().getId());
//        user.setUserName(injuryDto.getUser().getUsername());
//        injury.setUser(user);
        Muscle muscle = new Muscle();
        muscle.setId(injuryDto.getMuscle().getId());
        muscle.setName(injuryDto.getMuscle().getName());
        injury.setMuscle(muscle);
        return injury;
    }

    public static List<Injury> toInjuryModelList(List<InjuryDto> dtos) {
        return dtos.stream().map(MuscleMapper::toInjuryModel).toList();
    }
}
