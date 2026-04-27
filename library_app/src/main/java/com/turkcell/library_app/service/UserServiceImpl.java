package com.turkcell.library_app.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.turkcell.library_app.dto.CreateUserRequest;
import com.turkcell.library_app.entity.AppUser;
import com.turkcell.library_app.repository.AppUserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final AppUserRepository userRepository;

    public UserServiceImpl(AppUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public AppUser getUser(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public AppUser createUser(CreateUserRequest request) {

        AppUser user = new AppUser();
        user.setName(request.getName());
        user.setJob(request.getJob());
        user.setAddress(request.getAddress());
        user.setPhone(request.getPhone());

        return userRepository.save(user);
    }
}
