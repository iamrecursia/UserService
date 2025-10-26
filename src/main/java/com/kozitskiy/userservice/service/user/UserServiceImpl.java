package com.kozitskiy.userservice.service.user;

import com.kozitskiy.userservice.dto.CreateUserDto;
import com.kozitskiy.userservice.dto.UpdateUserDto;
import com.kozitskiy.userservice.entity.User;
import com.kozitskiy.userservice.repository.UserRepository;
import com.kozitskiy.userservice.util.UserMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public User createUser(CreateUserDto userDto) {
        User user = UserMapper.toEntity(userDto);
        return userRepository.save(user);
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User with id = " + id + "not found"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("User not found with email: " + email));
    }

    @Override
    public User updateUserById(long id, UpdateUserDto dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));

        UserMapper.toEntity(dto, user);
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }
}
