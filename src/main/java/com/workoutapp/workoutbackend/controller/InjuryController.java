package com.workoutapp.workoutbackend.controller;

import com.workoutapp.workoutbackend.dto.InjuryDto;
import com.workoutapp.workoutbackend.mappers.MuscleMapper;
import com.workoutapp.workoutbackend.model.Injury;
import com.workoutapp.workoutbackend.service.InjuryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/injuries")
public class InjuryController {

    private final InjuryService injuryService;
    public InjuryController(InjuryService injuryService) {this.injuryService = injuryService;}

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<InjuryDto>> getAllInjuries(@PathVariable Long userId) {
        List<Injury> userInjuries = this.injuryService.getUserInjuries(userId);
        return ResponseEntity.status(200).body(MuscleMapper.toInjuryDtoList(userInjuries));
    }

    @PutMapping("/user/{userId}")
    public ResponseEntity<List<InjuryDto>> updateUserInjuries(@PathVariable Long userId, @RequestBody List<InjuryDto> userInjuriesDto) {
        List<Injury> updatedUserInjuries = this.injuryService.updateUserInjuries(userId, userInjuriesDto);
        return ResponseEntity.status(200).body(MuscleMapper.toInjuryDtoList(updatedUserInjuries));
    }
}
