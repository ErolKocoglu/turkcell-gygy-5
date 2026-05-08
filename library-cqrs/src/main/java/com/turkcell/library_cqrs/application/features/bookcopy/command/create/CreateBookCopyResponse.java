package com.turkcell.library_cqrs.application.features.bookcopy.command.create;

import java.util.UUID;

public class CreateBookCopyResponse {
    private final UUID id;

    public CreateBookCopyResponse(UUID id) {
        this.id = id;
    }

    public UUID getId() { return id; }
}