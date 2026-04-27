package com.turkcell.library_app.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.turkcell.library_app.entity.BookCopy;

public interface BookCopyRepository extends JpaRepository<BookCopy, UUID> {

    @Query("""
    SELECT 
        bc.id as id,
        CASE 
            WHEN EXISTS (
                SELECT 1 FROM Borrow b 
                WHERE b.bookCopy = bc 
                AND b.status = 'BORROWED'
            ) THEN 'BORROWED'
            ELSE 'AVAILABLE'
        END as status
    FROM BookCopy bc
    """)
    List<BookCopyStatusView> findAllWithStatus();

    @Query("SELECT bc FROM BookCopy bc WHERE bc.id = :id")
    Optional<BookCopy> findByIdForUpdate(@Param("id") UUID id);
}
