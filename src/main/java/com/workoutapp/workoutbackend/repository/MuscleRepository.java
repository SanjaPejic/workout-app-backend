package com.workoutapp.workoutbackend.repository;

import com.workoutapp.workoutbackend.model.Muscle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuscleRepository extends JpaRepository<Muscle, Integer> {
}
