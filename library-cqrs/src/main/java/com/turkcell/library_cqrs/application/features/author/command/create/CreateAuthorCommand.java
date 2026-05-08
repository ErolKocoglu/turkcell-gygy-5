package com.turkcell.library_cqrs.application.features.author.command.create;

import com.turkcell.library_cqrs.core.mediator.cqrs.Command;
import java.util.UUID;

public class CreateAuthorCommand implements Command<CreateAuthorResponse> {
    private final String name;

    public CreateAuthorCommand(String name) {
        this.name = name;
    }

    public String getName() { return name; }
}