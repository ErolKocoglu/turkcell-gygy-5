package com.turkcell.library_cqrs.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.library_cqrs.application.features.book.command.create.CreateBookCommand;
import com.turkcell.library_cqrs.application.features.book.command.create.CreateBookResponse;
import com.turkcell.library_cqrs.core.mediator.Mediator;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final Mediator mediator;

    public BookController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public ResponseEntity<CreateBookResponse> create(@RequestBody CreateBookCommand request) {
        return ResponseEntity.ok(mediator.send(request));
    }
}