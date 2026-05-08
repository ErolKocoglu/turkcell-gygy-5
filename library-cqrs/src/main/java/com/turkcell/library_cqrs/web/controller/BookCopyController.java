package com.turkcell.library_cqrs.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.library_cqrs.application.features.bookcopy.command.create.CreateBookCopyCommand;
import com.turkcell.library_cqrs.application.features.bookcopy.command.create.CreateBookCopyResponse;
import com.turkcell.library_cqrs.core.mediator.Mediator;

@RestController
@RequestMapping("/api/bookcopy")
public class BookCopyController {

    private final Mediator mediator;

    public BookCopyController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public ResponseEntity<CreateBookCopyResponse> create(@RequestBody CreateBookCopyCommand request) {
        return ResponseEntity.ok(mediator.send(request));
    }
}