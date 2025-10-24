package com.kozitskiy.userservice.util;

import com.kozitskiy.userservice.dto.CreateUserDto;
import com.kozitskiy.userservice.dto.UpdateUserDto;
import com.kozitskiy.userservice.entity.User;

public class UserMapper {
    public static User toEntity(CreateUserDto dto){
        return  User.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .email(dto.getEmail())
                .birthDate(dto.getBirthDate())
                .build();
    }

    public static User toEntity(UpdateUserDto dto, User existing) {
        existing.setName(dto.getName());
        existing.setSurname(dto.getSurname());
        existing.setEmail(dto.getEmail());
        existing.setBirthDate(dto.getBirthDate());
        return existing;
    }
}
