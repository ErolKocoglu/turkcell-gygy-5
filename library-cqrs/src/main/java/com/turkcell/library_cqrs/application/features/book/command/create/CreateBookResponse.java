package com.turkcell.library_cqrs.application.features.book.command.create;

import java.util.UUID;

public class CreateBookResponse {
    private final UUID id;

    public CreateBookResponse(UUID id) {
        this.id = id;
    }

    public UUID getId() { return id; }
}