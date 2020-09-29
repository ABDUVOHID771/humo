package com.example.springhumo.repository;

import com.example.springhumo.model.entity.BankBin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankBinRepository extends JpaRepository<BankBin, Integer> {
    Optional<BankBin> findByBin(String bin);
}
