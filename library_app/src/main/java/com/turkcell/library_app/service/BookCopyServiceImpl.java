package com.turkcell.library_app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.turkcell.library_app.repository.BookCopyRepository;
import com.turkcell.library_app.repository.BookCopyStatusView;

@Service
public class BookCopyServiceImpl implements BookCopyService {

    private final BookCopyRepository bookCopyRepository;
    public BookCopyServiceImpl(BookCopyRepository bookCopyRepository) {
        this.bookCopyRepository = bookCopyRepository;
    }

    @Override
    public List<BookCopyStatusView> getAllWithStatus() {
        return bookCopyRepository.findAllWithStatus();
    }

}
