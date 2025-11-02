package com.kozitskiy.userservice.util;

import com.kozitskiy.userservice.dto.CardResponseDto;
import com.kozitskiy.userservice.dto.CreateCardDto;
import com.kozitskiy.userservice.dto.CreateUserDto;
import com.kozitskiy.userservice.entity.Card;
import com.kozitskiy.userservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CardMapper {
    Card toEntity(CreateCardDto dto);
    CardResponseDto toDto(Card card);

    void updateFromDto(CreateCardDto dto, @MappingTarget Card card);
}
