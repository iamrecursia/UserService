package com.kozitskiy.userservice.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CardResponseDto {
    private Long id;
    private Long userId;
    private String number;
    private String holder;
    private Date expirationDate;
}
