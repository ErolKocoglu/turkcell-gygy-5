package com.turkcell.library_cqrs.application.features.appuser.command.create;

import com.turkcell.library_cqrs.core.mediator.cqrs.Command;
import java.util.UUID;

public class CreateAppUserCommand implements Command<CreateAppUserResponse> {
    private final String name;
    private final String job;
    private final String address;
    private final String phone;

    public CreateAppUserCommand(String name, String job, String address, String phone) {
        this.name = name;
        this.job = job;
        this.address = address;
        this.phone = phone;
    }

    public String getName() { return name; }
    public String getJob() { return job; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
}