package com.juliluis.bankms.controller;

import com.juliluis.bankms.model.Transaction;
import com.juliluis.bankms.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> create(@RequestBody Transaction transaction) {
        Transaction tranx = transactionService.create(transaction);

        return ResponseEntity.status(201).body(tranx);
    }
}
