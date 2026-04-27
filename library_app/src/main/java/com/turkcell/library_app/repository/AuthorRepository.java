package com.turkcell.library_app.repository;


import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.turkcell.library_app.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, UUID> {
    Optional<Author> findByName(String name);

    List<Author> findByNameContainingIgnoreCase(String keyword);

}
