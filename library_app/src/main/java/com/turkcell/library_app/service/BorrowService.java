package com.turkcell.library_app.service;

import java.util.UUID;

import com.turkcell.library_app.entity.Borrow;

public interface BorrowService {
    Borrow borrowBook(UUID userId, UUID bookCopyId, UUID officerId);

    Borrow returnBook(UUID borrowId, UUID officerId);
}
