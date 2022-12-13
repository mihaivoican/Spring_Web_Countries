package com.fastrackit.countriesapplication.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor      //asa se cere la toate entitatile
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
