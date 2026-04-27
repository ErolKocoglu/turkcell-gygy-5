package com.turkcell.library_app.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.library_app.entity.Officer;

public interface OfficerRepository extends JpaRepository<Officer, UUID> {
    List<Officer> findByNameContainingIgnoreCase(String keyword);
    
}
