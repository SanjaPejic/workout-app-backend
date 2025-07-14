package com.workoutapp.workoutbackend.service;

import com.workoutapp.workoutbackend.dto.WorkoutDto;
import com.workoutapp.workoutbackend.dto.WorkoutExerciseDto;
import com.workoutapp.workoutbackend.exception.AppException;
import com.workoutapp.workoutbackend.mappers.ExerciseMapper;
import com.workoutapp.workoutbackend.mappers.WorkoutMapper;
import com.workoutapp.workoutbackend.model.Workout;
import com.workoutapp.workoutbackend.model.WorkoutExercise;
import com.workoutapp.workoutbackend.repository.WorkoutRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class WorkoutService {

    private final WorkoutRepository workoutRepository;
    private final UserService userService;
    private final ExerciseService exerciseService;

    public WorkoutService (WorkoutRepository workoutRepository, UserService userService, ExerciseService exerciseService) {
        this.workoutRepository = workoutRepository;
        this.userService = userService;
        this.exerciseService = exerciseService;
    }

    public List<Workout> getAllWorkouts (){
        return this.workoutRepository.findAll();
    }

    public List<Workout> getUserWorkouts(Long userId) {
        if (!this.userService.existsById(userId)) {
            throw new AppException("User not found with id: " + userId, 404);
        }
        return this.workoutRepository.findAllByUserId(userId);
    }

    public Workout getWorkoutById(Long id){
        return this.workoutRepository.findById(id).orElseThrow(() -> new AppException("Workout not found with id: " + id, 404));
    }

    public Workout createWorkout(WorkoutDto workoutDto){
        Long userId = workoutDto.getId();
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

        workout.setDate(LocalDate.now());

        return this.workoutRepository.save(workout);
    }

    public Workout updateWorkout(Long id, WorkoutDto workoutDto) {
        if (workoutDto.getId() != null && !workoutDto.getId().equals(id)) {
            throw new AppException("ID in path and body do not match", 400);
        }

        // get the old workout
        Workout workout = workoutRepository.findById(id).orElseThrow(() -> new AppException("Workout not found with id: " + id, 404));

        for (WorkoutExerciseDto weDto : workoutDto.getWorkoutExercises()) {
            Long exerciseId = weDto.getExercise().getId();
            if (!this.exerciseService.existsById(exerciseId)) {
                throw new AppException("Exercise not found with id: " + exerciseId, 404);
            }
        }

        // update the workout
        if (workoutDto.getName() != null) {
            workout.setName(workoutDto.getName());
        }

        workout.setDate(LocalDate.now());

        List<WorkoutExercise> newExercises = ExerciseMapper.toWorkoutExerciseModelList(workoutDto.getWorkoutExercises());

        workout.setWorkoutExercises(newExercises);

        for (WorkoutExercise we : newExercises) {
            we.setWorkout(workout);
        }

        return workoutRepository.save(workout);
    }

    //use for (PATCH) partial update workout
//        for (WorkoutExerciseDto weDto : workoutDto.getWorkoutExercises()) {
//            if (!this.workoutExerciseService.existsById(weDto.getId())) {
//                throw new AppException("Exercise not found", 404);
//            }
//        }

    public void deleteById(Long id){
        if (!this.workoutRepository.existsById(id)){
            throw new AppException("Workout not found by id: " + id, 404);
        }
        workoutRepository.deleteById(id);
    }

}
