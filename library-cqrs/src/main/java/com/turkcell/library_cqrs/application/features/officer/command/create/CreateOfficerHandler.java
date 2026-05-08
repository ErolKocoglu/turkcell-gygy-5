package com.turkcell.library_cqrs.application.features.officer.command.create;

import com.turkcell.library_cqrs.core.mediator.cqrs.CommandHandler;
import com.turkcell.library_cqrs.domain.Officer;
import com.turkcell.library_cqrs.persistence.repository.OfficerRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class CreateOfficerHandler implements CommandHandler<CreateOfficerCommand, CreateOfficerResponse> {

    private final OfficerRepository repository;

    public CreateOfficerHandler(OfficerRepository repository) {
        this.repository = repository;
    }

    @Override
    public CreateOfficerResponse handle(CreateOfficerCommand request) {
        Officer entity = new Officer();
        entity.setName(request.getName());
        entity.setJob(request.getJob());
        entity.setAddress(request.getAddress());
        entity.setPhone(request.getPhone());
        
        entity = repository.save(entity);
        return new CreateOfficerResponse(entity.getId());
    }
}