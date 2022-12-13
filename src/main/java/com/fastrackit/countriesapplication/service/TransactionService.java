package com.fastrackit.countriesapplication.service;

import com.fastrackit.countriesapplication.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class TransactionService {
//    private final TransactionReader transactionReader;
//   private  List<Transaction> transactions;

    private final TransactionRepository transactionRepository;
    public TransactionService(TransactionReader transactionReader, TransactionRepository transactionRepository) {
        this.transactionRepository=transactionRepository;       //aici se injecteaza Bean
        transactionRepository.saveAll(transactionReader.getTransactions()); //asa salvez in baza de date lista de tranzactii
        System.out.println("Finished reading transactions");
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
        return transactionRepository.findAll();
    }
}
