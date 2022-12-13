package com.fastrackit.countriesapplication.controller;

import com.fastrackit.countriesapplication.model.Transaction;
import com.fastrackit.countriesapplication.model.TransactionType;
import com.fastrackit.countriesapplication.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("transactions")
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping
    public List<Transaction> getAll(@RequestParam(required = false) TransactionType type,
                                    @RequestParam(required=false) Double minAmount,
                                    @RequestParam(required=false) Double maxAmount) {
        if (type == null && minAmount==null && maxAmount ==null ) {
            return transactionService.getAll();
        } else if (type !=null && minAmount == null && maxAmount ==null){
            return transactionService.getByType(type);
        } else if (type ==null && minAmount != null && maxAmount ==null){
            return transactionService.getByMinAmount(minAmount);
        } else if (type ==null && minAmount == null && maxAmount !=null){
            return transactionService.getByMaxAmount(maxAmount);
        } else if (type !=null && minAmount != null && maxAmount ==null){
            return transactionService.getByTypeAndMin(type,minAmount);
        } else if (type !=null && minAmount == null && maxAmount !=null){
            return transactionService.getByTypeAndMax(type,maxAmount);
        } else if (type ==null && minAmount != null && maxAmount !=null){
            return transactionService.getByMinAndMax(minAmount,maxAmount);
        } else if(type !=null && minAmount != null && maxAmount !=null){
            return transactionService.getByTypeAndMinAndMax(type,minAmount,maxAmount);

        }
        return null;
    }
//    @PostMapping
//    public Transaction add(Transaction transaction){
//        return transactionService.add(transaction);
//    }
}
