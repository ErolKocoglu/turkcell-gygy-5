package com.turkcell.library_cqrs.application.features.author.command.create;

import java.util.UUID;

public class CreateAuthorResponse {
    private final UUID id;

    public CreateAuthorResponse(UUID id) {
        this.id = id;
    }

    public UUID getId() { return id; }
}