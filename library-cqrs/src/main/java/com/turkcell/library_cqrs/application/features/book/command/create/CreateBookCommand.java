package com.turkcell.library_cqrs.application.features.book.command.create;

import com.turkcell.library_cqrs.core.mediator.cqrs.Command;
import java.util.UUID;

public class CreateBookCommand implements Command<CreateBookResponse> {
    private final String name;
    private final java.util.UUID categoryId;

    public CreateBookCommand(String name, UUID categoryId) {
        this.name = name;
        this.categoryId = categoryId;
    }

    public String getName() { return name; }
    public java.util.UUID getCategoryId() { return categoryId; }
}