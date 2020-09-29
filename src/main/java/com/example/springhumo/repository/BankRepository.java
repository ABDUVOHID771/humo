package com.example.springhumo.repository;
import com.example.springhumo.model.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BankRepository extends JpaRepository<Bank, Integer> {
}
