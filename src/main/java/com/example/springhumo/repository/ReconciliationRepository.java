package com.example.springhumo.repository;

import com.example.springhumo.model.entity.HumoReconciliation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReconciliationRepository extends JpaRepository<HumoReconciliation, Integer> {
}
