package com.turkcell.library_cqrs.application.features.author.command.create;

import com.turkcell.library_cqrs.core.mediator.cqrs.CommandHandler;
import com.turkcell.library_cqrs.domain.Author;
import com.turkcell.library_cqrs.persistence.repository.AuthorRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class CreateAuthorHandler implements CommandHandler<CreateAuthorCommand, CreateAuthorResponse> {

    private final AuthorRepository repository;

    public CreateAuthorHandler(AuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public CreateAuthorResponse handle(CreateAuthorCommand request) {
        Author entity = new Author();
        entity.setName(request.getName());
        
        entity = repository.save(entity);
        return new CreateAuthorResponse(entity.getId());
    }
}