package com.kozitskiy.userservice.service.card;

import com.kozitskiy.userservice.dto.CreateCardDto;
import com.kozitskiy.userservice.entity.Card;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CardService {
    Card createCard(CreateCardDto cardDto);

    Card getCardById(long id);

    Page<Card> getAllCards(Pageable pageable);

    void deleteCardById(long id);
}
