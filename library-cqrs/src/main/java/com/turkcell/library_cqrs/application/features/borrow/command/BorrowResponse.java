package com.turkcell.library_cqrs.application.features.borrow.command;



import java.time.LocalDateTime;
import java.util.UUID;

public class BorrowResponse {

    private UUID borrowId;
    private UUID userId;
    private UUID bookCopyId;
    private String status;
    private LocalDateTime borrowDate;
    private LocalDateTime dueDate;

    public BorrowResponse(UUID borrowId, UUID userId, UUID bookCopyId,
                          String status, LocalDateTime borrowDate, LocalDateTime dueDate) {
        this.borrowId = borrowId;
        this.userId = userId;
        this.bookCopyId = bookCopyId;
        this.status = status;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
    }

    // getter
}
