package com.fastrackit.countriesapplication.service;

import com.fastrackit.countriesapplication.model.Transaction;
import com.fastrackit.countriesapplication.model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    //filtrare dupa tip
    List<Transaction> findByType(TransactionType type);

    @Query("Select t from Transaction t where amount >= :minAmount")
    List<Transaction>findByMinAmount(Double minAmount);


    @Query("Select t from Transaction t where amount <= :maxAmount")
    List<Transaction>findByMaxAmount(Double maxAmount);

    //2 filtre/parametri active
    @Query("Select t from Transaction t where type = :type and amount >= :minAmount")
    List<Transaction>findByTypeAndMin(TransactionType type, Double minAmount);

    @Query("Select t from Transaction t where type = :type and amount <= :maxAmount")
    List<Transaction>findByTypeAndMax(TransactionType type, Double maxAmount);

    @Query("Select t from Transaction t where amount >= :minAmount and amount <= :maxAmount")
    List<Transaction>findByMinAndMax(Double minAmount, Double maxAmount);

    //3 param/filtre active
    @Query("Select t from Transaction t where  type = :type and amount >= :minAmount and amount <= :maxAmount")
    List<Transaction>findByTypeAndMinAndMax(TransactionType type,Double minAmount, Double maxAmount);
}



