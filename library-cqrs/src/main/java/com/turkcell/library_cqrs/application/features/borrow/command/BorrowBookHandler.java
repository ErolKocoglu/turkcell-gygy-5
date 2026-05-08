package com.turkcell.library_cqrs.application.features.borrow.command;



import com.turkcell.library_cqrs.core.mediator.cqrs.CommandHandler;
import com.turkcell.library_cqrs.domain.*;
import com.turkcell.library_cqrs.persistence.repository.AppUserRepository;
import com.turkcell.library_cqrs.persistence.repository.BookCopyRepository;
import com.turkcell.library_cqrs.persistence.repository.BorrowRepository;
import com.turkcell.library_cqrs.persistence.repository.OfficerRepository;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Component
@Transactional
public class BorrowBookHandler implements CommandHandler<BorrowBookCommand, BorrowResponse> {

    private final BorrowRepository borrowRepository;
    private final BookCopyRepository bookCopyRepository;
    private final AppUserRepository userRepository;
    private final OfficerRepository officerRepository;

    public BorrowBookHandler(BorrowRepository borrowRepository,
                             BookCopyRepository bookCopyRepository,
                             AppUserRepository userRepository,
                             OfficerRepository officerRepository) {
        this.borrowRepository = borrowRepository;
        this.bookCopyRepository = bookCopyRepository;
        this.userRepository = userRepository;
        this.officerRepository = officerRepository;
    }

    @Override
    public BorrowResponse handle(BorrowBookCommand cmd) {
        
        try {
            Thread.sleep(3500);//yavaş request deneme
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Interrupted while sleeping");
        }

        BookCopy bookCopy = bookCopyRepository.findByIdForUpdate(cmd.getBookCopyId())
                .orElseThrow(() -> new RuntimeException("Book copy not found"));

        boolean isBorrowed = borrowRepository
                .existsByBookCopy_IdAndStatus(cmd.getBookCopyId(), BorrowStatus.BORROWED);

        if (isBorrowed) {
            throw new RuntimeException("Book already borrowed");
        }

        AppUser user = userRepository.findById(cmd.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Officer officer = officerRepository.findById(cmd.getOfficerId())
                .orElseThrow(() -> new RuntimeException("Officer not found"));

        Borrow borrow = new Borrow();
        borrow.setUser(user);
        borrow.setBookCopy(bookCopy);
        borrow.setIssuedBy(officer);
        borrow.setStatus(BorrowStatus.BORROWED);
        borrow.setBorrowDate(LocalDateTime.now());
        borrow.setDueDate(LocalDateTime.now().plusDays(14));

        borrowRepository.save(borrow);

        return new BorrowResponse(
                borrow.getId(),
                user.getId(),
                bookCopy.getId(),
                borrow.getStatus().name(),
                borrow.getBorrowDate(),
                borrow.getDueDate()
        );
    }
}
