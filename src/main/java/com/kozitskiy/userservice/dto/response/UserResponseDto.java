package com.kozitskiy.userservice.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class UserResponseDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private Date birthDate;
}
