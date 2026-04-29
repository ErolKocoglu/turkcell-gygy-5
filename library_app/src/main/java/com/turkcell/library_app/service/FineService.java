package com.turkcell.library_app.service;

import java.util.List;
import java.util.UUID;

import com.turkcell.library_app.entity.Borrow;
import com.turkcell.library_app.entity.Fine;

public interface FineService {

    void createFine(Borrow borrow);
    void payFine(UUID fineId);
    List<Fine> getByUserId(UUID userId);
}
