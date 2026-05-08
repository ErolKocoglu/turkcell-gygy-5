package com.turkcell.library_cqrs.application.features.publisher.command.create;

import java.util.UUID;

public class CreatePublisherResponse {
    private final UUID id;

    public CreatePublisherResponse(UUID id) {
        this.id = id;
    }

    public UUID getId() { return id; }
}