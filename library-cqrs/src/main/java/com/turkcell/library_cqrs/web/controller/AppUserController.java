package com.turkcell.library_cqrs.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.library_cqrs.application.features.appuser.command.create.CreateAppUserCommand;
import com.turkcell.library_cqrs.application.features.appuser.command.create.CreateAppUserResponse;
import com.turkcell.library_cqrs.core.mediator.Mediator;

@RestController
@RequestMapping("/api/appusers")
public class AppUserController {

    private final Mediator mediator;

    public AppUserController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public ResponseEntity<CreateAppUserResponse> create(@RequestBody CreateAppUserCommand request) {
        return ResponseEntity.ok(mediator.send(request));
    }
}