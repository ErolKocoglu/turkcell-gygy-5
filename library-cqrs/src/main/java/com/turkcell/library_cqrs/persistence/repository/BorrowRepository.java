package com.turkcell.library_cqrs.persistence.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.turkcell.library_cqrs.domain.Borrow;
import com.turkcell.library_cqrs.domain.BorrowStatus;

public interface BorrowRepository extends JpaRepository<Borrow, UUID> {
    List<Borrow> findByUser_Id(UUID userId);

    List<Borrow> findByStatus(BorrowStatus status);

    @Query("""
        SELECT b FROM Borrow b
        WHERE b.dueDate < CURRENT_TIMESTAMP
        AND b.status = 'BORROWED'
    """)
    List<Borrow> findOverdueBorrows();

    boolean existsByBookCopy_IdAndStatus(UUID bookCopyId, BorrowStatus status);
}
