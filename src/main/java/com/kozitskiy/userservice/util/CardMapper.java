package com.kozitskiy.userservice.util;

import com.kozitskiy.userservice.dto.response.CardResponseDto;
import com.kozitskiy.userservice.dto.request.CreateCardDto;
import com.kozitskiy.userservice.entity.Card;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CardMapper {
    Card toEntity(CreateCardDto dto);
    CardResponseDto toDto(Card card);

    void updateFromDto(CreateCardDto dto, @MappingTarget Card card);
}
