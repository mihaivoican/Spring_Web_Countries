package com.fastrackit.countriesapplication.controller;



import com.fastrackit.countriesapplication.model.Transaction;
import com.fastrackit.countriesapplication.model.TransactionType;
import com.fastrackit.countriesapplication.service.TransactionService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("transactions")     //asta e calea /ruta comuna pt toate endpointurile
public class TransactionController {
    private final TransactionService transactionService;        //asa injectam clasaTransactionService care e un Bean

    @GetMapping     //parametrii de mai jos sunt optionali => required=false
    public List<Transaction> getAll(@RequestParam(required = false) String product, @RequestParam(required = false) TransactionType type,
                                    @RequestParam(required = false) Double minAmount, @RequestParam(required = false) Double maxAmount) {
        return transactionService.getAll(product, type, minAmount, maxAmount);
    }

    @PostMapping
    public Transaction add(@RequestBody Transaction transaction) {      //adnotarea spune ca iau param din body-ul requestului
        return transactionService.add(transaction);
    }

    @GetMapping("reports/type")
    public Map<TransactionType, List<Transaction>> reportByType() {
        return transactionService.getTransactionsByType();
    }

}