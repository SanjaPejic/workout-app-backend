package com.workoutapp.workoutbackend.controller;


import com.workoutapp.workoutbackend.dto.MuscleDto;
import com.workoutapp.workoutbackend.mappers.MuscleMapper;
import com.workoutapp.workoutbackend.model.Muscle;
import com.workoutapp.workoutbackend.service.MuscleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/muscles")
public class MuscleController {

    private final MuscleService muscleService;

    public MuscleController(MuscleService muscleService) {
        this.muscleService = muscleService;
    }

    @GetMapping
    public ResponseEntity<List<MuscleDto>> getAllMuscles() {
        List<Muscle> allMuscles = this.muscleService.getAllMuscles();
        return ResponseEntity.status(200).body(MuscleMapper.toMuscleDtoList(allMuscles));
    }


}
