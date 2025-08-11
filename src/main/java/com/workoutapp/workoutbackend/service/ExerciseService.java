package com.workoutapp.workoutbackend.service;

import com.workoutapp.workoutbackend.exception.AppException;
import com.workoutapp.workoutbackend.model.Exercise;
import com.workoutapp.workoutbackend.repository.ExerciseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public Page<Exercise> getAllExercises(Pageable pageable, String searchTerm, List<String> targetMuscNames) {
        if (targetMuscNames.isEmpty()) {
            return this.exerciseRepository.findByNameContainingIgnoreCase(searchTerm, pageable);
        } else {
            return this.exerciseRepository.findByNameContainingIgnoreCaseAndTargetMusclesIn(searchTerm, targetMuscNames, targetMuscNames.size(), pageable);
        }
    }

    public Exercise getExerciseById(Long id) {
        return this.exerciseRepository.findById(id).orElseThrow(() -> new AppException("Exercise not found by id: " + id, 404));
    }

    public Exercise createExercise(Exercise exercise){
        return this.exerciseRepository.save(exercise);
    }

    public void deleteById(Long id){
        if (!this.exerciseRepository.existsById(id)){
            throw new AppException("Exercise not found by id: " + id, 404);
        }
        exerciseRepository.deleteById(id);
    }

    public Boolean existsById(Long id){
        return this.exerciseRepository.existsById(id);
    }
}
