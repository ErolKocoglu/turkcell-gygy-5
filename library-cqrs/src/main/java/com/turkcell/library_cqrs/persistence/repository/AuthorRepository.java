package com.turkcell.library_cqrs.persistence.repository;


import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.turkcell.library_cqrs.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, UUID> {
    Optional<Author> findByName(String name);

    List<Author> findByNameContainingIgnoreCase(String keyword);

}
