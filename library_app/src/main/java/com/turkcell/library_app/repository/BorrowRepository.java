package com.turkcell.library_app.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.turkcell.library_app.entity.Borrow;
import com.turkcell.library_app.entity.BorrowStatus;

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
