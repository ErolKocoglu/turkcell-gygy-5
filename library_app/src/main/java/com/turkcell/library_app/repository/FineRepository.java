package com.turkcell.library_app.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.turkcell.library_app.entity.Fine;
import com.turkcell.library_app.entity.PaymentStatus;


public interface FineRepository extends JpaRepository<Fine, UUID> {
    List<Fine> findByUser_Id(UUID userId);

    List<Fine> findByPaymentStatus(PaymentStatus status);

    @Query("""
        SELECT f FROM Fine f
        WHERE f.paymentStatus = 'UNPAID'
    """)
    List<Fine> findUnpaidFines();
}
