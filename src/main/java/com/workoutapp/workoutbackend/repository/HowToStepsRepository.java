package com.workoutapp.workoutbackend.repository;

import com.workoutapp.workoutbackend.model.HowToSteps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HowToStepsRepository extends JpaRepository<HowToSteps, Long> {

}
