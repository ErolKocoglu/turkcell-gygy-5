package com.turkcell.library_cqrs.application.features.book.command.create;

import com.turkcell.library_cqrs.core.mediator.cqrs.CommandHandler;
import com.turkcell.library_cqrs.domain.Book;
import com.turkcell.library_cqrs.persistence.repository.BookRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class CreateBookHandler implements CommandHandler<CreateBookCommand, CreateBookResponse> {

    private final BookRepository repository;

    public CreateBookHandler(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public CreateBookResponse handle(CreateBookCommand request) {
        Book entity = new Book();
        entity.setName(request.getName());
        
        com.turkcell.library_cqrs.domain.Category category = new com.turkcell.library_cqrs.domain.Category();
        category.setId(request.getCategoryId());
        entity.setCategory(category);
        
        entity = repository.save(entity);
        return new CreateBookResponse(entity.getId());
    }
}