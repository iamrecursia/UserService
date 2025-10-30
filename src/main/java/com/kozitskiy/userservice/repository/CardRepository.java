package com.kozitskiy.userservice.repository;

import com.kozitskiy.userservice.entity.Card;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    @Query(value = "SELECT * FROM card_info WHERE user_id = :userId",
            countQuery = "SELECT COUNT(*) FROM card_info WHERE user_id = :userId",
    nativeQuery = true)
    Page<Card> findCardsByUserIdNative(@Param("userId") Long userId, Pageable pageable);
}
