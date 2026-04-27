package com.turkcell.library_app.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.library_app.dto.CreateUserRequest;
import com.turkcell.library_app.dto.EntityMapper;
import com.turkcell.library_app.dto.UserResponse;
import com.turkcell.library_app.entity.AppUser;
import com.turkcell.library_app.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    private final EntityMapper mapper;

    public UserController(UserService userService, EntityMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(
            @RequestBody CreateUserRequest request
    ) {
        AppUser user = userService.createUser(request);
        return ResponseEntity.ok(mapper.toUserResponse(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable UUID id) {
        AppUser user = userService.getUser(id);
        return ResponseEntity.ok(mapper.toUserResponse(user));
    }


}
