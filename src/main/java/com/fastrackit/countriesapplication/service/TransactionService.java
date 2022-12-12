package com.fastrackit.countriesapplication.service;

import com.fastrackit.countriesapplication.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class TransactionService {
    private final TransactionReader transactionReader;
   private  List<Transaction> transactions;

    public TransactionService(TransactionReader transactionReader) {
        this.transactionReader = transactionReader;
        transactions = transactionReader.getTransactions();
        System.out.println("Finished reading transactions");
    }

    public List<Transaction> getAllTransactions(){
        return transactions;
    }
//    private static long id=0;       //pt id tranzactie

//    public Transaction add(Transaction transaction){
//        Transaction newTransaction=Transaction.builder()
//                .amount(transaction.getAmount())
//                .type(transaction.getType())
//                .product(transaction.getProduct())
//                .id(id++)
//                .build();
//        transactions.add(newTransaction);
//        return newTransaction;
//    }

    //returnez tranzactii: toate sau filtrate
    public List<Transaction> getAll(){
        Stream<Transaction> stream = transactions.stream();
        return stream.toList();
    }
}
