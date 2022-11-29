package com.fastrackit.countriesapplication.service;

import com.fastrackit.countriesapplication.model.Country;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    private final CountryReader countryReader;
    private List<Country> countries;

    public CountryService(CountryReader countryReader) {
        this.countryReader = countryReader;
        countries = countryReader.getCountries();
        System.out.println("Finished reading countries");
    }

    public List<Country> getAllCountries() {
        return countries;
    }

    public List<Country> getByContinent(String continent) {
        return countries.stream().filter(c -> c.getContinent().equals(continent)).toList();
    }

    //get countries that neighbor X but not neighbor Y :-> returns list of Country objects
    public List<Country> getByNeighbour(String includedNeighbour, String excludedNeighbour) {
        return countries.stream()
                .filter(c -> c.getNeighbours() != null && c.getNeighbours().size() > 0)
                .filter(c -> c.getNeighbours().contains(includedNeighbour) && !c.getNeighbours().contains(excludedNeighbour))
                .toList();
    }

    public Country getById(int id) {
        return countries.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
               .orElseThrow(() -> new RuntimeException());           //asa era initial pana sa-mi definesc eu exceptiile (tip unchecked/care nu se declara la incep metodei)
//                .orElseThrow(() -> new ResourceNotFoundException("Country missing", id));
    }

    //metoda delete de regula e bine sa returneze ob sters
    public Country deleteById(int id) {
        Country countryToBeDeleted = getById(id);       //gasesc tara dupa id
        countries.remove(countryToBeDeleted);           //sterg tara
        return countryToBeDeleted;          //returnez tara stearsa
    }

    public Country add(Country country) {
        //in param primit tara nu are id; dupa adaugare, returnam tara cu id ca user-ul sa vada ca s-a adaugat si a primit un id
        country.setId(CountryReader.countryId++);       //asa setam Id-ul urmator
        countries.add(country);
        return country;
    }

    public Country update(int id, Country country) {
        Country countryToBeUpdated = getById(id);
        countryToBeUpdated.setArea(country.getArea());
        countryToBeUpdated.setCapital(country.getCapital());
        countryToBeUpdated.setContinent(country.getContinent());
        countryToBeUpdated.setName(country.getName());
        countryToBeUpdated.setNeighbours(country.getNeighbours());
        countryToBeUpdated.setPopulation(country.getPopulation());
        return countryToBeUpdated;
    }

}