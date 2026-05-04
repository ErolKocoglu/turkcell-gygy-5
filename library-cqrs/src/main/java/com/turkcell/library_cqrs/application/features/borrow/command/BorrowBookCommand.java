package com.turkcell.library_cqrs.application.features.borrow.command;


import com.turkcell.library_cqrs.core.mediator.cqrs.Command;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class BorrowBookCommand implements Command<BorrowResponse> {

    @NotBlank
    private final UUID userId;
    @NotBlank
    private final UUID bookCopyId;
    @NotBlank
    private final UUID officerId;

    public BorrowBookCommand(UUID userId, UUID bookCopyId, UUID officerId) {
        this.userId = userId;
        this.bookCopyId = bookCopyId;
        this.officerId = officerId;
    }

    public UUID getUserId() {
        return userId;
    }

    public UUID getBookCopyId() {
        return bookCopyId;
    }

    public UUID getOfficerId() {
        return officerId;
    }
}
