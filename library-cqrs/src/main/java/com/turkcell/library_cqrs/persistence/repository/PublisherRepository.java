package com.turkcell.library_cqrs.persistence.repository;

import java.util.List;
import java.util.Optional;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.turkcell.library_cqrs.domain.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, UUID> {
    Optional<Publisher> findByName(String name);

    List<Publisher> findByNameContainingIgnoreCase(String keyword);

}
