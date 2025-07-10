package com.workoutapp.workoutbackend.service;

import com.workoutapp.workoutbackend.model.Muscle;
import com.workoutapp.workoutbackend.repository.MuscleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MuscleService {

    private final MuscleRepository muscleRepository;

    public MuscleService(MuscleRepository muscleRepository) {
        this.muscleRepository = muscleRepository;
    }

    public List<Muscle> getAllMuscles() {
        return this.muscleRepository.findAll();
    }

    public Boolean existsById(Long id){
        return this.muscleRepository.existsById(id);
    }


}
