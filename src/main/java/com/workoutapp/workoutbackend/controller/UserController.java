package com.workoutapp.workoutbackend.controller;

import com.workoutapp.workoutbackend.dto.UserDto;
import com.workoutapp.workoutbackend.mappers.UserMapper;
import com.workoutapp.workoutbackend.model.User;
import com.workoutapp.workoutbackend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{username}")
    public ResponseEntity<Long> getUser(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        UserDto userDto = UserMapper.toUserDto(user);
        return ResponseEntity.status(200).body(userDto.getId());
    }
}
