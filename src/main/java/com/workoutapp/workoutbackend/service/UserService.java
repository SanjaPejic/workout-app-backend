package com.workoutapp.workoutbackend.service;

import com.workoutapp.workoutbackend.exception.AppException;
import com.workoutapp.workoutbackend.model.User;
import com.workoutapp.workoutbackend.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {this.userRepository = userRepository;}

    public Boolean existsById (Long id){
        return this.userRepository.existsById(id);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new AppException("User not found with id: " + id, 404));
    }

    public User getUserByUsername(String username) { return userRepository.findByUserName(username).orElseThrow(() -> new AppException("User doesn't exist with username: " + username, 404)); }

}
