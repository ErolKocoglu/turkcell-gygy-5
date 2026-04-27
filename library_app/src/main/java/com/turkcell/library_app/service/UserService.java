package com.turkcell.library_app.service;

import java.util.UUID;

import com.turkcell.library_app.dto.CreateUserRequest;
import com.turkcell.library_app.entity.AppUser;

public interface UserService {
    AppUser getUser(UUID id);

    AppUser createUser(CreateUserRequest request);
}
