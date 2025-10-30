package com.kozitskiy.userservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardResponseDto {
    private Long id;
    private Long userId;
    private String number;
    private String holder;
    private Date expirationDate;
}
