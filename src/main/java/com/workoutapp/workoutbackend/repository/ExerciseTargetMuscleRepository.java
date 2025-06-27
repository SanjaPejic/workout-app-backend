package com.workoutapp.workoutbackend.repository;

import com.workoutapp.workoutbackend.model.ExerciseTargetMuscle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseTargetMuscleRepository extends JpaRepository<ExerciseTargetMuscle,Long> {
}
