package com.turkcell.library_app.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.turkcell.library_app.entity.AppUser;
import com.turkcell.library_app.entity.BookCopy;
import com.turkcell.library_app.entity.Borrow;
import com.turkcell.library_app.entity.BorrowStatus;
import com.turkcell.library_app.entity.Officer;
import com.turkcell.library_app.repository.AppUserRepository;
import com.turkcell.library_app.repository.BookCopyRepository;
import com.turkcell.library_app.repository.BorrowRepository;
import com.turkcell.library_app.repository.OfficerRepository;

@Service
public class BorrowServiceImpl implements BorrowService {

    private final BorrowRepository borrowRepository;
    private final BookCopyRepository bookCopyRepository;
    private final AppUserRepository userRepository;
    private final OfficerRepository officerRepository;
    private final FineService fineService;

    public BorrowServiceImpl(BorrowRepository borrowRepository, BookCopyRepository bookCopyRepository,
                             AppUserRepository userRepository, OfficerRepository officerRepository,
                             FineService fineService) {
        this.borrowRepository = borrowRepository;
        this.bookCopyRepository = bookCopyRepository;
        this.userRepository = userRepository;
        this.officerRepository = officerRepository;
        this.fineService = fineService;
    }

    @Override
    public Borrow borrowBook(UUID userId, UUID bookCopyId, UUID officerId) {
        BookCopy bookCopy = bookCopyRepository.findByIdForUpdate(bookCopyId)
                .orElseThrow(() -> new RuntimeException("Book copy not found"));

        boolean isBorrowed = borrowRepository
                .existsByBookCopy_IdAndStatus(bookCopyId, BorrowStatus.BORROWED);

        if (isBorrowed) {
            throw new RuntimeException("Book already borrowed");
        }

        AppUser user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Officer officer = officerRepository.findById(officerId)
                .orElseThrow(() -> new RuntimeException("Officer not found"));

        Borrow borrow = new Borrow();
        borrow.setUser(user);
        borrow.setBookCopy(bookCopy);
        borrow.setIssuedBy(officer);
        borrow.setStatus(BorrowStatus.BORROWED);
        borrow.setBorrowDate(LocalDateTime.now());
        borrow.setDueDate(LocalDateTime.now().plusDays(14));

        Borrow savedBorrow=borrowRepository.save(borrow);
        return savedBorrow;

    }

    @Override
    public Borrow returnBook(UUID borrowId, UUID officerId) {
        Borrow borrow = borrowRepository.findById(borrowId)
                .orElseThrow(() -> new RuntimeException("Borrow not found"));

        if (borrow.getStatus() != BorrowStatus.BORROWED) {
            throw new RuntimeException("Book already returned");
        }

        Officer officer = officerRepository.findById(officerId)
                .orElseThrow(() -> new RuntimeException("Officer not found"));

        borrow.setReturnDate(LocalDateTime.now());
        borrow.setReceivedBy(officer);

        if (borrow.getDueDate().isBefore(LocalDateTime.now())) {
            borrow.setStatus(BorrowStatus.OVERDUE);
            fineService.createFine(borrow);
        } else {
            borrow.setStatus(BorrowStatus.RETURNED);
        }

        Borrow savedBorrow=borrowRepository.save(borrow);
        return savedBorrow;
    }

}
