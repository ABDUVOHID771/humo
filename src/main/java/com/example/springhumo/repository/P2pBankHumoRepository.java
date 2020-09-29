package com.example.springhumo.repository;

import java.util.Optional;

import com.example.springhumo.model.entity.P2pBankHumo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface P2pBankHumoRepository extends JpaRepository<P2pBankHumo, Integer> {
    Optional<P2pBankHumo> findByBank_BankId(Integer id);
}