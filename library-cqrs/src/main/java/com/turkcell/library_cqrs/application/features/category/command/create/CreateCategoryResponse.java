package com.turkcell.library_cqrs.application.features.category.command.create;

import java.util.UUID;

public class CreateCategoryResponse {
    private final UUID id;

    public CreateCategoryResponse(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
