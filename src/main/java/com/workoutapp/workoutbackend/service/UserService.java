package com.workoutapp.workoutbackend.service;

import com.workoutapp.workoutbackend.dto.UserDto;
import com.workoutapp.workoutbackend.exception.AppException;
import com.workoutapp.workoutbackend.mappers.UserMapper;
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

    public User createUser(UserDto userDto){

        String username = userDto.getUsername();

        if(userRepository.existsByUserName(username)){
            throw new AppException("User already exists with username: " + username, 403);
        }

        User user = UserMapper.toUserModel(userDto);
        return this.userRepository.save(user);
    }

}
