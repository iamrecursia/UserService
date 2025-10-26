package com.kozitskiy.userservice.service.card;

import com.kozitskiy.userservice.dto.CreateCardDto;
import com.kozitskiy.userservice.entity.Card;
import com.kozitskiy.userservice.entity.User;
import com.kozitskiy.userservice.repository.CardRepository;
import com.kozitskiy.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService{
    private final CardRepository cardRepository;
    private final UserRepository userRepository;

    @Override
    public Card createCard(CreateCardDto cardDto) {
        User user = userRepository.findById(cardDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Card card = Card.builder()
                .number(cardDto.getNumber())
                .expirationDate(cardDto.getExpirationDate())
                .holder(cardDto.getHolder())
                .user(user)
                .build();

        return cardRepository.save(card);
    }

    @Override
    public Card getCardById(long id) {
        return cardRepository.findCardById(id);
    }

    @Override
    public Page<Card> getAllCards(Pageable pageable) {
        return cardRepository.findAll(pageable);
    }

    @Override
    public void deleteCardById(long id) {
        cardRepository.deleteById(id);
    }
}
