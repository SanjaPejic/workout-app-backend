package com.workoutapp.workoutbackend.service;

import com.workoutapp.workoutbackend.model.Exercise;
import com.workoutapp.workoutbackend.repository.ExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public void testService(){
        Exercise exercise = new Exercise();
        exercise.setName("push ups");
        exercise.setImageURL("http/something");
        exercise.setDescription("do it strong");
        exercise.setVideoURL("http/something2");
        Exercise savedExercise = this.exerciseRepository.save(exercise);
    }

    public List<Exercise> getAllExercises(){
        return this.exerciseRepository.findAll();
    }
}
