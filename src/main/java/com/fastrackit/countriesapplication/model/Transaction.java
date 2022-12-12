package com.fastrackit.countriesapplication.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Builder
public class Transaction {
    @Id
    @GeneratedValue
    @Column
    private long id;
    @Column
    private String product;
    @Column
    private TransactionType type;
    @Column
    private double amount;

}
