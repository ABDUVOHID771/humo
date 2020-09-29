package com.example.springhumo.repository;

import java.util.Optional;

import com.example.springhumo.model.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CardRepository extends JpaRepository<Card, Integer> {
    @Query(
            nativeQuery = true,
            value = "SELECT * FROM card WHERE enc_pan = :pan LIMIT 1"
    )
    Optional<Card> findByEncPan(@Param("pan") String pan);

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM card WHERE card_id = :token LIMIT 1"
    )
    Optional<Card> findByToken(@Param("token") String token);
}
