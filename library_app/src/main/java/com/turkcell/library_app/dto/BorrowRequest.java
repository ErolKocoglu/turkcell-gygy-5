package com.turkcell.library_app.dto;

import java.util.UUID;

public class BorrowRequest {
    private UUID userId;
    private UUID bookCopyId;
    private UUID officerId;
    
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
    public UUID getOfficerId() {
        return officerId;
    }
    public void setOfficerId(UUID officerId) {
        this.officerId = officerId;
    }

    
}
