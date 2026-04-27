package com.turkcell.library_app.dto;

import org.springframework.stereotype.Component;

import com.turkcell.library_app.entity.AppUser;
import com.turkcell.library_app.entity.Borrow;

@Component
public class EntityMapper {

    public BorrowResponse toBorrowResponse(Borrow borrow) {
        BorrowResponse dto = new BorrowResponse();
        dto.setBorrowId(borrow.getId());
        dto.setUserId(borrow.getUser().getId());
        dto.setBookCopyId(borrow.getBookCopy().getId());
        dto.setStatus(borrow.getStatus().name());
        dto.setBorrowDate(borrow.getBorrowDate());
        dto.setDueDate(borrow.getDueDate());
        dto.setReturnDate(borrow.getReturnDate());
        return dto;
    }


    public UserResponse toUserResponse(AppUser user) {
    UserResponse dto = new UserResponse();
    dto.setId(user.getId());
    dto.setName(user.getName());
    dto.setJob(user.getJob());
    dto.setAddress(user.getAddress());
    dto.setPhoneNumber(user.getPhone());
    return dto;
}
}
