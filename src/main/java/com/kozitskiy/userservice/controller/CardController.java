package com.kozitskiy.userservice.controller;

import com.kozitskiy.userservice.dto.CardResponseDto;
import com.kozitskiy.userservice.dto.CreateCardDto;
import com.kozitskiy.userservice.repository.CardRepository;
import com.kozitskiy.userservice.service.card.CardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cards")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CardResponseDto createCard(@Valid @RequestBody CreateCardDto dto){
        return cardService.createCard(dto);
    }

    @PutMapping("/{id}")
    public CardResponseDto updateCard(@PathVariable long id, @Valid @RequestBody CreateCardDto dto){
        return cardService.updateCard(id, dto);
    }

    @GetMapping("/{id}")
    public CardResponseDto getCardById(@PathVariable long id){
        return cardService.getCardById(id);
    }

    @GetMapping
    public Page<CardResponseDto> getAllCards(Pageable pageable){
        return cardService.getAllCards(pageable);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCard(@PathVariable long id){
        cardService.deleteCardById(id);
    }
}
