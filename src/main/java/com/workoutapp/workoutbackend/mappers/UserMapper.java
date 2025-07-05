package com.workoutapp.workoutbackend.mappers;

import com.workoutapp.workoutbackend.dto.UserDto;
import com.workoutapp.workoutbackend.model.User;

public class UserMapper {

    public static UserDto toUserDto (User user) {
        return new UserDto(user.getId(), user.getUserName());
    }

    public static User toUserModel(UserDto userDto) {
        User user = new User();
        user.setUserName(userDto.getUsername());
//        don't need to set them for creation they are null by default
//        user.setId(userDto.getId());
//        user.setWorkouts(user.getWorkouts());
//        user.setInjuries(user.getInjuries());
        return user;
    }
}
