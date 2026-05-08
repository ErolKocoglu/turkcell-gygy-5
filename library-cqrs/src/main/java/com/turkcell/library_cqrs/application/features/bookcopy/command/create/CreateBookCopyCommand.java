package com.turkcell.library_cqrs.application.features.bookcopy.command.create;

import com.turkcell.library_cqrs.core.mediator.cqrs.Command;
import java.util.UUID;

public class CreateBookCopyCommand implements Command<CreateBookCopyResponse> {
    private final java.util.UUID bookId;
    private final java.util.UUID publisherId;
    private final java.time.LocalDateTime yearPublished;
    private final Integer pageCount;

    public CreateBookCopyCommand(java.util.UUID bookId, java.util.UUID publisherId, java.time.LocalDateTime yearPublished, Integer pageCount) {
        this.bookId = bookId;
        this.publisherId = publisherId;
        this.yearPublished = yearPublished;
        this.pageCount = pageCount;
    }

    public java.util.UUID getBookId() { return bookId; }
    public java.util.UUID getPublisherId() { return publisherId; }
    public java.time.LocalDateTime getYearPublished() { return yearPublished; }
    public Integer getPageCount() { return pageCount; }
}