package com.kozitskiy.userservice.controller;

import com.kozitskiy.userservice.dto.CreateUserDto;
import com.kozitskiy.userservice.dto.UserResponseDto;
import com.kozitskiy.userservice.service.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto createUser(@Valid @RequestBody CreateUserDto dto){
        return userService.createUser(dto);
    }

    @PutMapping("/{id}")
    public UserResponseDto updateUser(@PathVariable long id, @Valid @RequestBody CreateUserDto dto){
        return userService.updateUserById(id, dto);
    }

    @GetMapping("/{id}")
    public UserResponseDto getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }

    @GetMapping
    public List<UserResponseDto> getAllUsers(){
        return userService.getAllUsers();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable long id){
        userService.deleteUserById(id);
    }

    @GetMapping("/email/{email}")
    public UserResponseDto getUserByEmail(@PathVariable String email){
        return userService.getUserByEmail(email);
    }
}
