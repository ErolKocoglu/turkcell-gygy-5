package com.turkcell.library_cqrs.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.library_cqrs.application.features.author.command.create.CreateAuthorCommand;
import com.turkcell.library_cqrs.application.features.author.command.create.CreateAuthorResponse;
import com.turkcell.library_cqrs.core.mediator.Mediator;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final Mediator mediator;

    public AuthorController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public ResponseEntity<CreateAuthorResponse> create(@RequestBody CreateAuthorCommand request) {
        return ResponseEntity.ok(mediator.send(request));
    }
}