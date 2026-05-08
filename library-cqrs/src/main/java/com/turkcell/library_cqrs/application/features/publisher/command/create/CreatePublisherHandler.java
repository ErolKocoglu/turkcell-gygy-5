package com.turkcell.library_cqrs.application.features.publisher.command.create;

import com.turkcell.library_cqrs.core.mediator.cqrs.CommandHandler;
import com.turkcell.library_cqrs.domain.Publisher;
import com.turkcell.library_cqrs.persistence.repository.PublisherRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class CreatePublisherHandler implements CommandHandler<CreatePublisherCommand, CreatePublisherResponse> {

    private final PublisherRepository repository;

    public CreatePublisherHandler(PublisherRepository repository) {
        this.repository = repository;
    }

    @Override
    public CreatePublisherResponse handle(CreatePublisherCommand request) {
        Publisher entity = new Publisher();
        entity.setName(request.getName());
        entity.setAddress(request.getAddress());
        entity.setPhone(request.getPhone());
        
        entity = repository.save(entity);
        return new CreatePublisherResponse(entity.getId());
    }
}