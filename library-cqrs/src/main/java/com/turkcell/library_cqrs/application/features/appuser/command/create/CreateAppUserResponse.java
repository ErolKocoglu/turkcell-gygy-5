package com.turkcell.library_cqrs.application.features.appuser.command.create;

import java.util.UUID;

public class CreateAppUserResponse {
    private final UUID id;

    public CreateAppUserResponse(UUID id) {
        this.id = id;
    }

    public UUID getId() { return id; }
}