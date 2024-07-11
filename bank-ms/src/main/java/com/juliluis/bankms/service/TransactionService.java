package com.juliluis.bankms.service;

import com.juliluis.bankms.model.Transaction;
import com.juliluis.bankms.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction create(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}
