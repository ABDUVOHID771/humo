package com.example.springhumo.repository;

import java.util.List;
import java.util.Optional;

import com.example.springhumo.model.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Optional<Transaction> findByHumoPaymentId(String id);

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM transaction t WHERE  t.uzcard_id IS NOT NULL  AND t.instime BETWEEN :start_date AND :end_date  AND t.status = 'UZCARD_ERROR'  AND t.humo_reco_status = 0"
    )
    List<Transaction> findUnsuccessfulTransactions(@Param("start_date") String startDate, @Param("end_date") String endDate);
}
