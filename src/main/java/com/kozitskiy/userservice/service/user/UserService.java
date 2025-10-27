package com.kozitskiy.userservice.service.user;

import com.kozitskiy.userservice.dto.request.CreateUserDto;
import com.kozitskiy.userservice.dto.response.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(CreateUserDto userDao);
    UserResponseDto getUserById(long id);
    List<UserResponseDto> getAllUsers();
    UserResponseDto getUserByEmail(String email);
    UserResponseDto updateUserById(long id, CreateUserDto dto);
    void deleteUserById(long id);
}
