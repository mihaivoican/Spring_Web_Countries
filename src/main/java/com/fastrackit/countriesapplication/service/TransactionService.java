package com.fastrackit.countriesapplication.service;

import com.fastrackit.countriesapplication.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class TransactionService {
    private final List<Transaction> transactions = new ArrayList<>();
    private static long id=0;       //pt id tranzactie

    public Transaction add(Transaction transaction){
        Transaction newTransaction=Transaction.builder()
                .amount(transaction.getAmount())
                .type(transaction.getType())
                .product(transaction.getProduct())
                .id(id++)
                .build();
        transactions.add(newTransaction);
        return newTransaction;
    }

    //returnez tranzactii: toate sau filtrate
    public List<Transaction> getAll(){
        Stream<Transaction> stream = transactions.stream();
        return stream.toList();
    }
}
