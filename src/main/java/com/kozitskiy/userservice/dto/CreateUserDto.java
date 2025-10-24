package com.kozitskiy.userservice.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CreateUserDto {
    private String name;
    private String surname;
    private Date birthDate;
    private String email;
}
