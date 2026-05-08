package com.turkcell.library_cqrs.application.features.officer.command.create;

import java.util.UUID;

public class CreateOfficerResponse {
    private final UUID id;

    public CreateOfficerResponse(UUID id) {
        this.id = id;
    }

    public UUID getId() { return id; }
}