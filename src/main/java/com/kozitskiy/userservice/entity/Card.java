package com.kozitskiy.userservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Table(name = "card_info")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Card implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String number;

    private String holder;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;
}
