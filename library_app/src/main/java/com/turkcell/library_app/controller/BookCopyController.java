package com.turkcell.library_app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.library_app.dto.BookCopyResponse;
import com.turkcell.library_app.repository.BookCopyStatusView;
import com.turkcell.library_app.service.BookCopyService;

@RestController
@RequestMapping("/api/book-copies")
public class BookCopyController {
    private final BookCopyService bookCopyService;

    public BookCopyController(BookCopyService bookCopyService) {
        this.bookCopyService = bookCopyService;
    }

    @GetMapping
    public ResponseEntity<List<BookCopyResponse>> getAll() {

    List<BookCopyResponse> response = bookCopyService.getAllWithStatus()
            .stream()
            .map(v -> {
                BookCopyResponse dto = new BookCopyResponse();
                dto.setId(v.getId());
                dto.setStatus(v.getStatus());
                return dto;
            })
            .toList();

    return ResponseEntity.ok(response);
}
}
