package com.workoutapp.workoutbackend.repository;

import com.workoutapp.workoutbackend.model.HowToStep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HowToStepRepository extends JpaRepository<HowToStep, Long> {

}
