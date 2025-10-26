package com.kozitskiy.userservice.service.user;

import com.kozitskiy.userservice.dto.request.CreateUserDto;
import com.kozitskiy.userservice.dto.response.UserResponseDto;
import com.kozitskiy.userservice.entity.User;
import com.kozitskiy.userservice.exception.UserNotFoundException;
import com.kozitskiy.userservice.repository.UserRepository;
import com.kozitskiy.userservice.util.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    @Transactional
    public UserResponseDto createUser(CreateUserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User saved = userRepository.save(user);
        return userMapper.toDto(saved);
    }

    @Override
    public UserResponseDto getUserById(long id) {
       User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id = " + id + "not found"));
        return userMapper.toDto(user);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userMapper.toDtoList(userRepository.findAll());
    }

    @Override
    public UserResponseDto getUserByEmail(String email) {
        User user = userRepository.findByEmailNative(email)
                .orElseThrow(() -> new UserNotFoundException("User not found with email: " + email));
        return userMapper.toDto(user);
    }

    @Override
    @Transactional
    public UserResponseDto updateUserById(long id, CreateUserDto dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id " + id));

        userMapper.updateFromDto(dto, user);
        User updated = userRepository.save(user);

        return userMapper.toDto(updated);
    }

    @Override
    @Transactional
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }
}
