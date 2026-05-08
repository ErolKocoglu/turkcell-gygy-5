package com.turkcell.library_cqrs.application.features.publisher.command.create;

import com.turkcell.library_cqrs.core.mediator.cqrs.Command;
import java.util.UUID;

public class CreatePublisherCommand implements Command<CreatePublisherResponse> {
    private final String name;
    private final String address;
    private final String phone;

    public CreatePublisherCommand(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
}