package com.workoutapp.workoutbackend.service;

import com.workoutapp.workoutbackend.exception.ExerciseNotFoundException;
import com.workoutapp.workoutbackend.exception.WorkoutNotFoundException;
import com.workoutapp.workoutbackend.mappers.WorkoutMapper;
import com.workoutapp.workoutbackend.model.Workout;
import com.workoutapp.workoutbackend.repository.ExerciseRepository;
import com.workoutapp.workoutbackend.repository.WorkoutRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutService {

    private final WorkoutRepository workoutRepository;

    private WorkoutService (WorkoutRepository workoutRepository) {this.workoutRepository = workoutRepository;}

    public List<Workout> getAllWorkouts (){
        return this.workoutRepository.findAll();
    }

    public Workout getWorkoutById(Long id){
        return this.workoutRepository.findById(id).orElseThrow(() -> new WorkoutNotFoundException(id));
    }

}
