package com.turkcell.library_cqrs.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.library_cqrs.application.features.officer.command.create.CreateOfficerCommand;
import com.turkcell.library_cqrs.application.features.officer.command.create.CreateOfficerResponse;
import com.turkcell.library_cqrs.core.mediator.Mediator;

@RestController
@RequestMapping("/api/officers")
public class OfficerController {

    private final Mediator mediator;

    public OfficerController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public ResponseEntity<CreateOfficerResponse> create(@RequestBody CreateOfficerCommand request) {
        return ResponseEntity.ok(mediator.send(request));
    }
}