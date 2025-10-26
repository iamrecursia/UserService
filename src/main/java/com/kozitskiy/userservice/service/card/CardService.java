package com.kozitskiy.userservice.service.card;

import com.kozitskiy.userservice.dto.CardResponseDto;
import com.kozitskiy.userservice.dto.CreateCardDto;
import com.kozitskiy.userservice.entity.Card;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CardService {
    CardResponseDto createCard(CreateCardDto cardDto);
    CardResponseDto updateCard(long id, CreateCardDto dto);
    CardResponseDto getCardById(long id);
    Page<CardResponseDto> getAllCards(Pageable pageable);
    void deleteCardById(long id);
}
