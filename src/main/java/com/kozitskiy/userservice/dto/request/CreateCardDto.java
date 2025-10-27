package com.kozitskiy.userservice.dto.request;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CreateCardDto {

    @NotNull(message = "User ID is required")
    @Min(value = 1, message = "User ID must be positive")
    private Long userId;

    @NotBlank(message = "Card number is required")
    @Pattern(regexp = "\\d{16}", message = "Card number must be 16 digits")
    private String number;

    @NotBlank(message = "Cardholder name is required")
    @Size(max = 100)
    private String holder;

    @NotNull(message = "Expiration date is required")
    @Future(message = "Expiration date must be in the future")
    private Date expirationDate;
}
