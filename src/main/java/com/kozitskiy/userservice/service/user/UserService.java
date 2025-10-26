package com.kozitskiy.userservice.service.user;

import com.kozitskiy.userservice.dto.CreateUserDto;
import com.kozitskiy.userservice.dto.UpdateUserDto;
import com.kozitskiy.userservice.entity.User;

import java.util.List;

public interface UserService {
    User createUser(CreateUserDto userDao);

    User getUserById(long id);

    List<User> getAllUsers();

    User getUserByEmail(String email);

    User updateUserById(long id, UpdateUserDto dto);

    void deleteUserById(long id);
}
