package com.fastrackit.countriesapplication.service;

import com.fastrackit.countriesapplication.exception.ResourceNotFoundException;
import com.fastrackit.countriesapplication.model.Transaction;
import com.fastrackit.countriesapplication.model.TransactionType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
//    private final TransactionReader transactionReader;
//   private  List<Transaction> transactions;

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionReader transactionReader, TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;       //aici se injecteaza Bean
        transactionRepository.saveAll(transactionReader.getTransactions()); //asa salvez in baza de date lista de tranzactii
        System.out.println("Finished reading transactions");
    }


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
    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }

    //liste filtrate
    public List<Transaction> getByType(TransactionType type) {
        return transactionRepository.findByType(type);
    }

    //filtrat dupa cantitate minima
    public List<Transaction> getByMinAmount(Double minAmount) {
        return transactionRepository.findByMinAmount(minAmount);
    }

    //filtrat dupa cantitate max
    public List<Transaction> getByMaxAmount(Double maxAmount) {
        return transactionRepository.findByMaxAmount(maxAmount);
    }

    //fitre combinate cate 2
    public List<Transaction> getByTypeAndMin(TransactionType type, Double minAmount) {
        return transactionRepository.findByTypeAndMin(type, minAmount);
    }

    public List<Transaction> getByTypeAndMax(TransactionType type, Double maxAmount) {
        return transactionRepository.findByTypeAndMax(type, maxAmount);
    }

    public List<Transaction> getByMinAndMax(Double minAmount, Double maxAmount) {
        return transactionRepository.findByMinAndMax(minAmount, maxAmount);
    }

    //cu 3 filtre
    public List<Transaction> getByTypeAndMinAndMax(TransactionType type,Double minAmount, Double maxAmount) {
        return transactionRepository.findByTypeAndMinAndMax(type,minAmount, maxAmount);
    }

    //caut dupa ID
    public Transaction getById(Long id){
        return transactionRepository.findById(id)
                .orElseThrow(() ->new ResourceNotFoundException("Nu gasesc tranzactia",id));
    }

    //metoda de insert
    public Transaction add(Transaction transaction){
        return transactionRepository.save(transaction);     //asa se adauga in baza
    }

    //metoda de update
    public Transaction update(long id, Transaction transaction){
        Transaction transToUpdate = getById(id);
        transToUpdate.setProduct(transaction.getProduct());
        transToUpdate.setType(transaction.getType());
        transToUpdate.setAmount(transaction.getAmount());
        return transToUpdate;
    }

}
