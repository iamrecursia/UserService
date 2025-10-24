package com.kozitskiy.userservice.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CreateCardDto {
    private Long userId;
    private String number;
    private String holder;
    private Date expirationDate;
}
