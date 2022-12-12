package com.fastrackit.countriesapplication.service;

import com.fastrackit.countriesapplication.model.Transaction;
import com.fastrackit.countriesapplication.model.TransactionType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TransactionReader {
    @Value("${file.transactions}")
    private String fileTransactionPath;

    public static int transactionId=0;

    public List<Transaction> getTransactions() {
        try {
            return Files.lines(Path.of(fileTransactionPath))
                    .map(this::lineToTransaction)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Transaction lineToTransaction(String line) {
        String[] transParts = line.split("\\|");
        return new Transaction(transactionId++, transParts[0], TransactionType.valueOf(transParts[1]), Double.parseDouble(transParts[2]));
    }
}
