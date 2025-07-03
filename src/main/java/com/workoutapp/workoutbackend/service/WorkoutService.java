package com.workoutapp.workoutbackend.service;

import com.workoutapp.workoutbackend.dto.WorkoutDto;
import com.workoutapp.workoutbackend.dto.WorkoutExerciseDto;
import com.workoutapp.workoutbackend.exception.AppException;
import com.workoutapp.workoutbackend.mappers.WorkoutMapper;
import com.workoutapp.workoutbackend.model.Workout;
import com.workoutapp.workoutbackend.repository.WorkoutRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutService {

    private final WorkoutRepository workoutRepository;
    private final UserService userService;
    private final ExerciseService exerciseService;

    private WorkoutService (WorkoutRepository workoutRepository, UserService userService, ExerciseService exerciseService) {
        this.workoutRepository = workoutRepository;
        this.userService = userService;
        this.exerciseService = exerciseService;
    }

    public List<Workout> getAllWorkouts (){
        return this.workoutRepository.findAll();
    }

    public Workout getWorkoutById(Long id){
        return this.workoutRepository.findById(id).orElseThrow(() -> new AppException("Workout not found with id: " + id, 404));
    }

    public Workout createWorkout(WorkoutDto workoutDto){
        Long userId = workoutDto.getUser().getId();
        if(!this.userService.existsById(userId)){
            throw new AppException("User not found with id: " + userId, 404);
        }

        for (WorkoutExerciseDto weDto : workoutDto.getWorkoutExercises()) {
            Long exerciseId = weDto.getExercise().getId();
            if (!this.exerciseService.existsById(exerciseId)) {
                throw new AppException("Exercise not found with id: " + exerciseId, 404);
            }
        }

        Workout workout = WorkoutMapper.toWorkoutModel(workoutDto);

        workout.setUser(userService.getUserById(userId));

        return this.workoutRepository.save(workout);
    }

    //use for update workout and not for create workout
//        for (WorkoutExerciseDto weDto : workoutDto.getWorkoutExercises()) {
//            if (!this.workoutExerciseService.existsById(weDto.getId())) {
//                throw new AppException("Exercise not found", 404);
//            }
//        }

}
