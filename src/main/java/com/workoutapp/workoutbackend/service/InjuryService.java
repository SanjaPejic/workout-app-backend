package com.workoutapp.workoutbackend.service;

import com.workoutapp.workoutbackend.dto.InjuryDto;
import com.workoutapp.workoutbackend.exception.AppException;
import com.workoutapp.workoutbackend.mappers.MuscleMapper;
import com.workoutapp.workoutbackend.model.Injury;
import com.workoutapp.workoutbackend.model.User;
import com.workoutapp.workoutbackend.repository.InjuryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InjuryService {
    private final InjuryRepository injuryRepository;
    private final UserService userService;
    private final MuscleService muscleService;

    public InjuryService(InjuryRepository injuryRepository, UserService userService,  MuscleService muscleService) {
        this.injuryRepository = injuryRepository;
        this.userService = userService;
        this.muscleService = muscleService;
    }

    public List<Injury> getUserInjuries(Long userId){
        if (!this.userService.existsById(userId)) {
            throw new AppException("User not found with id: " + userId, 404);
        }
        return this.injuryRepository.findAllByUserId(userId);
    }

    @Transactional
    public List<Injury> updateUserInjuries(Long  userId, List<InjuryDto> userInjuriesDto) {
        if (!this.userService.existsById(userId)) {
            throw new AppException("User not found with id: " + userId, 404);
        }

        // remove old injuries for the user
        this.injuryRepository.deleteAllByUserId(userId);

        for (InjuryDto injuryDto : userInjuriesDto) {
            Long muscleId = injuryDto.getMuscle().getId();
            if (!this.muscleService.existsById(muscleId)) {
                throw new AppException("Injured muscle not found with id: " + muscleId, 404);
            }
        }

        User user = this.userService.getUserById(userId);

        List<Injury> userInjuries = MuscleMapper.toInjuryModelList(userInjuriesDto);
        for (Injury injury : userInjuries) {
            injury.setUser(user);
        }


        return this.injuryRepository.saveAll(userInjuries);

    }

}
