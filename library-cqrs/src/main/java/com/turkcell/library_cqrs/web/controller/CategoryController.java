package com.turkcell.library_cqrs.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.library_cqrs.application.features.category.command.create.CreateCategoryCommand;
import com.turkcell.library_cqrs.application.features.category.command.create.CreateCategoryResponse;
import com.turkcell.library_cqrs.core.mediator.Mediator;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final Mediator mediator;

    public CategoryController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public ResponseEntity<CreateCategoryResponse> create(@RequestBody CreateCategoryCommand request) {
        return ResponseEntity.ok(mediator.send(request));
    }
}
