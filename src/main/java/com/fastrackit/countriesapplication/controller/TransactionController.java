package com.fastrackit.countriesapplication.controller;

import com.fastrackit.countriesapplication.model.Transaction;
import com.fastrackit.countriesapplication.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("transactions")
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping
    public List<Transaction> getAll(){
        return transactionService.getAll();
    }

//    @PostMapping
//    public Transaction add(Transaction transaction){
//        return transactionService.add(transaction);
//    }
}
