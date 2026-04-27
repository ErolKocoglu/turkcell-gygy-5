package com.turkcell.library_app.service;

import java.util.List;

import com.turkcell.library_app.repository.BookCopyStatusView;

public interface BookCopyService {
    List<BookCopyStatusView> getAllWithStatus();
}
