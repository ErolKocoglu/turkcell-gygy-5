package com.turkcell.library_cqrs.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.library_cqrs.application.features.publisher.command.create.CreatePublisherCommand;
import com.turkcell.library_cqrs.application.features.publisher.command.create.CreatePublisherResponse;
import com.turkcell.library_cqrs.core.mediator.Mediator;

@RestController
@RequestMapping("/api/publishers")
public class PublisherController {

    private final Mediator mediator;

    public PublisherController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public ResponseEntity<CreatePublisherResponse> create(@RequestBody CreatePublisherCommand request) {
        return ResponseEntity.ok(mediator.send(request));
    }
}