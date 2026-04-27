package com.turkcell.library_app.service;

import com.turkcell.library_app.entity.Borrow;

public interface FineService {

    void createFine(Borrow borrow);
}
