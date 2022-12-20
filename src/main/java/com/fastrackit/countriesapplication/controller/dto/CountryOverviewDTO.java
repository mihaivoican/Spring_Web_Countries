package com.fastrackit.countriesapplication.controller.dto;

//DTO vine de la DataTransferObject ; se folos mai mult la comunicare intre microservicii
//aici il folosesc sa intorc date partial; nu tot obiectul country; si get, sila stergere; si la patch=update partial de coloane/fielduri
public record CountryOverviewDTO(Long id, String name) {

}