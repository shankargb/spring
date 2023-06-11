package com.realtech.mapper;

import com.realtech.dto.UserDto;
import com.realtech.entity.User;

public class UserMapper {

	// Convert User JPA Entity to UserDto
	public static UserDto mapToUserDto(User user) {
		UserDto userDto = new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
		return userDto;
	}

	// Convert UserDto to User JPA Entity
	public static User mapToUser(UserDto userDto) {
		User user = new User(userDto.getId(), userDto.getFirstName(), userDto.getLastName(), userDto.getEmail());
		return user;
	}
}
