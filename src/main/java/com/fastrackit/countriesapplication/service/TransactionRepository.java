package com.fastrackit.countriesapplication.service;

import com.fastrackit.countriesapplication.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
