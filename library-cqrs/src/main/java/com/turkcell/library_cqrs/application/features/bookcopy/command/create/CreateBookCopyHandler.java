package com.turkcell.library_cqrs.application.features.bookcopy.command.create;

import com.turkcell.library_cqrs.core.mediator.cqrs.CommandHandler;
import com.turkcell.library_cqrs.domain.BookCopy;
import com.turkcell.library_cqrs.persistence.repository.BookCopyRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class CreateBookCopyHandler implements CommandHandler<CreateBookCopyCommand, CreateBookCopyResponse> {

    private final BookCopyRepository repository;

    public CreateBookCopyHandler(BookCopyRepository repository) {
        this.repository = repository;
    }

    @Override
    public CreateBookCopyResponse handle(CreateBookCopyCommand request) {
        BookCopy entity = new BookCopy();
        
        com.turkcell.library_cqrs.domain.Book book = new com.turkcell.library_cqrs.domain.Book();
        book.setId(request.getBookId());
        entity.setBook(book);
        
        com.turkcell.library_cqrs.domain.Publisher publisher = new com.turkcell.library_cqrs.domain.Publisher();
        publisher.setId(request.getPublisherId());
        entity.setPublisher(publisher);
        entity.setYearPublished(request.getYearPublished());
        entity.setPageCount(request.getPageCount());
        
        entity = repository.save(entity);
        return new CreateBookCopyResponse(entity.getId());
    }
}