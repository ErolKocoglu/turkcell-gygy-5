package com.turkcell.library_app.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.library_app.dto.BorrowRequest;
import com.turkcell.library_app.dto.BorrowResponse;
import com.turkcell.library_app.dto.EntityMapper;
import com.turkcell.library_app.entity.Borrow;
import com.turkcell.library_app.service.BorrowService;

@RestController
@RequestMapping("/api/borrows")
public class BorrowController {
    private final BorrowService borrowService;
    private final EntityMapper mapper;

    public BorrowController(BorrowService borrowService, EntityMapper mapper) {
        this.borrowService = borrowService;
        this.mapper = mapper;
    }

    @PostMapping("/borrow")
    public ResponseEntity<BorrowResponse> borrow(@RequestBody BorrowRequest request) {

    Borrow borrow = borrowService.borrowBook(
            request.getUserId(),
            request.getBookCopyId(),
            request.getOfficerId()
    );

    return ResponseEntity.ok(mapper.toBorrowResponse(borrow));
}

    @PostMapping("/return")
    public ResponseEntity<String> returnBook(
            @RequestParam UUID borrowId,
            @RequestParam UUID officerId
    ) {
        borrowService.returnBook(borrowId, officerId);
        return ResponseEntity.ok("Book returned successfully");
    }
}
