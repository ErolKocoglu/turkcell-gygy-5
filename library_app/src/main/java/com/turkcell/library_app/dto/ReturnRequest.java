package com.turkcell.library_app.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class ReturnRequest {
    private UUID borrowId;
    private UUID userId;
    private UUID bookCopyId;
    private String status;
    private LocalDateTime borrowDate;
    private LocalDateTime dueDate;
    private LocalDateTime returnDate;
    public UUID getBorrowId() {
        return borrowId;
    }
    public void setBorrowId(UUID borrowId) {
        this.borrowId = borrowId;
    }
    public UUID getUserId() {
        return userId;
    }
    public void setUserId(UUID userId) {
        this.userId = userId;
    }
    public UUID getBookCopyId() {
        return bookCopyId;
    }
    public void setBookCopyId(UUID bookCopyId) {
        this.bookCopyId = bookCopyId;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public LocalDateTime getBorrowDate() {
        return borrowDate;
    }
    public void setBorrowDate(LocalDateTime borrowDate) {
        this.borrowDate = borrowDate;
    }
    public LocalDateTime getDueDate() {
        return dueDate;
    }
    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
    public LocalDateTime getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    
}
