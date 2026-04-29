package com.turkcell.library_app.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.turkcell.library_app.entity.Borrow;
import com.turkcell.library_app.entity.Fine;
import com.turkcell.library_app.entity.PaymentStatus;
import com.turkcell.library_app.exception.NotFoundException;
import com.turkcell.library_app.repository.FineRepository;

@Service
public class FineServiceImpl implements FineService {

    private final FineRepository fineRepository;

    public FineServiceImpl(FineRepository fineRepository) {
        this.fineRepository = fineRepository;
    }

    @Override
    public void createFine(Borrow borrow) {
        Fine fine = new Fine();
        fine.setBorrow(borrow);
        fine.setUser(borrow.getUser());
        fine.setPaymentStatus(PaymentStatus.UNPAID);

        fineRepository.save(fine);
    }

    @Override
    public void payFine(UUID fineId) {
        Fine fine = fineRepository.findById(fineId)
                .orElseThrow(() -> new NotFoundException("Fine not found"));

        fine.setPaymentStatus(PaymentStatus.PAID);
        fineRepository.save(fine);
    }

    @Override
    public List<Fine> getByUserId(UUID userId) {
        return fineRepository.findByUser_Id(userId);
    }

}
