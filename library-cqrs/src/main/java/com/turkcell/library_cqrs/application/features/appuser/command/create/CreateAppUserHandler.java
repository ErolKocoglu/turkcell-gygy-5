package com.turkcell.library_cqrs.application.features.appuser.command.create;

import com.turkcell.library_cqrs.core.mediator.cqrs.CommandHandler;
import com.turkcell.library_cqrs.domain.AppUser;
import com.turkcell.library_cqrs.persistence.repository.AppUserRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class CreateAppUserHandler implements CommandHandler<CreateAppUserCommand, CreateAppUserResponse> {

    private final AppUserRepository repository;

    public CreateAppUserHandler(AppUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public CreateAppUserResponse handle(CreateAppUserCommand request) {
        AppUser entity = new AppUser();
        entity.setName(request.getName());
        entity.setJob(request.getJob());
        entity.setAddress(request.getAddress());
        entity.setPhone(request.getPhone());
        
        entity = repository.save(entity);
        return new CreateAppUserResponse(entity.getId());
    }
}