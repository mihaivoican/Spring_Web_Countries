package com.fastrackit.countriesapplication.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {

    public City(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    //prin adnotarea de mai jos mai fac o relatie inversa de la orase la tari, tot 1 la 1. Dar cu mappedby +camp din partea cealalta  Hybernate nu mai construieste campul si in City, ci boloseste relatia de mai sus
    //iar prin Json ignore nu se mai serializeaza ac camp cand e returnat in raspuns; altfel dadea o eroare fiindca era o bucla de la tara, oras, apoi iat tara ....
    @OneToOne(mappedBy = "capital")
    @JsonIgnore
    private Country capitalOf;


    //asa e de preferat a declara o rel 1 la mai multi; in partea cu many
    @ManyToOne
    @JsonIgnore
    private Country country;
}