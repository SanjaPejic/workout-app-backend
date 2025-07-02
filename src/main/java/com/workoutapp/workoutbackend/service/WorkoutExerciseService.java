package com.workoutapp.workoutbackend.service;

import com.workoutapp.workoutbackend.repository.WorkoutExerciseRepository;
import org.springframework.stereotype.Service;

@Service
public class WorkoutExerciseService {

    private final WorkoutExerciseRepository workoutExerciseRepository;

    public WorkoutExerciseService(WorkoutExerciseRepository workoutExerciseRepository) {
        this.workoutExerciseRepository = workoutExerciseRepository;
    }

    public Boolean existsById (Long id){
        return this.workoutExerciseRepository.existsById(id);
    }

}
