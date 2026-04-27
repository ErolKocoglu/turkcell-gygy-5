package com.turkcell.library_app.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.library_app.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
    Optional<Category> findByName(String name);

    List<Category> findByNameContainingIgnoreCase(String keyword);
}
