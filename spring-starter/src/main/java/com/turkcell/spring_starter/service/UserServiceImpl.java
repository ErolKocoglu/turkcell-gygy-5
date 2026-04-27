package com.turkcell.spring_starter.service;

import org.springframework.stereotype.Service;

import com.turkcell.spring_starter.repository.UserRepository;

@Service
public class UserServiceImpl {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
