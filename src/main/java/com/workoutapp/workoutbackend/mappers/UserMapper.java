package com.workoutapp.workoutbackend.mappers;

import com.workoutapp.workoutbackend.dto.UserDto;
import com.workoutapp.workoutbackend.model.User;

public class UserMapper {

    public static UserDto toUserDto (User user) {
        return new UserDto(user.getId(), user.getUserName());
    }
}
