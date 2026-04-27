package com.turkcell.library_app.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.library_app.entity.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, UUID> {
    List<AppUser> findByNameContainingIgnoreCase(String keyword);
    
}
