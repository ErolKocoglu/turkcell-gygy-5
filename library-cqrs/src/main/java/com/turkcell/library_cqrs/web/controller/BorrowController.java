package com.turkcell.library_cqrs.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.library_cqrs.application.features.borrow.command.BorrowBookCommand;
import com.turkcell.library_cqrs.application.features.borrow.command.BorrowResponse;
import com.turkcell.library_cqrs.core.mediator.Mediator;

@RestController
@RequestMapping("/api/borrows")
public class BorrowController {

    private final Mediator mediator;

    public BorrowController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public ResponseEntity<BorrowResponse> borrow(@RequestBody BorrowBookCommand req) {

        BorrowBookCommand command = new BorrowBookCommand(
                req.getUserId(),
                req.getBookCopyId(),
                req.getOfficerId()
        );

        return ResponseEntity.ok(mediator.send(command));
    }
}
