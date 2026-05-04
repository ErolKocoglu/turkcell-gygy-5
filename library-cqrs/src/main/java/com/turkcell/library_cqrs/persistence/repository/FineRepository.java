package com.turkcell.library_cqrs.persistence.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.turkcell.library_cqrs.domain.Fine;
import com.turkcell.library_cqrs.domain.PaymentStatus;


public interface FineRepository extends JpaRepository<Fine, UUID> {
    List<Fine> findByUser_Id(UUID userId);

    List<Fine> findByPaymentStatus(PaymentStatus status);

    @Query("""
        SELECT f FROM Fine f
        WHERE f.paymentStatus = 'UNPAID'
    """)
    List<Fine> findUnpaidFines();
}
