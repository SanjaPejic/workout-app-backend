package com.workoutapp.workoutbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutExercise extends JpaRepository<WorkoutExercise, Long> {
}
