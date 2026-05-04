package com.turkcell.library_cqrs.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;
import com.turkcell.library_cqrs.domain.Book;

public interface BookRepository extends JpaRepository<Book, UUID> {
    List<Book> findByNameContainingIgnoreCase(String name);

    List<Book> findByCategory_Id(UUID categoryId);

    @Query("SELECT b FROM Book b JOIN b.authors a WHERE a.name ILIKE %:authorName%")
    List<Book> findByAuthorName(@Param("authorName") String authorName);
}
