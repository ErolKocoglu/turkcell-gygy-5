package com.turkcell.library_cqrs.application.features.category.command.create;

import com.turkcell.library_cqrs.core.mediator.cqrs.Command;

public class CreateCategoryCommand implements Command<CreateCategoryResponse> {
    private final String name;

    public CreateCategoryCommand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
