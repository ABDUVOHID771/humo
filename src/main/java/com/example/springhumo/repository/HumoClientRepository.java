package com.example.springhumo.repository;

import java.util.Optional;

import com.example.springhumo.model.entity.HumoClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HumoClientRepository extends JpaRepository<HumoClient, Long> {
    Optional<HumoClient> findByClientId(String clientId);
}