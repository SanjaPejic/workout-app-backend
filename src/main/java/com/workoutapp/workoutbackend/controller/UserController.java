package com.workoutapp.workoutbackend.controller;

import com.workoutapp.workoutbackend.dto.UserDto;
import com.workoutapp.workoutbackend.mappers.UserMapper;
import com.workoutapp.workoutbackend.model.User;
import com.workoutapp.workoutbackend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{username}")
    public ResponseEntity<UserDto> getUser(@PathVariable String username) {
        User user = this.userService.getUserByUsername(username);
        return ResponseEntity.status(200).body(UserMapper.toUserDto(user));
    }

    // maybe add @Valid, and then also add @NotBlank(message = "Username is required") in UserDto
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        User newUser = this.userService.createUser(userDto);
        return ResponseEntity.status(201).body(UserMapper.toUserDto(newUser));
    }
}
