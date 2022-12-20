package com.fastrackit.countriesapplication.controller;



import com.fastrackit.countriesapplication.controller.dto.CountryOverviewDTO;
import com.fastrackit.countriesapplication.controller.dto.PatchCountryRequest;
import com.fastrackit.countriesapplication.model.City;
import com.fastrackit.countriesapplication.model.Country;
import com.fastrackit.countriesapplication.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("countries") // http://host:port/countries
public class CountryController {

    private final CountryService countryService;

    @GetMapping
    // GET http://host:port/countries?continent={continent}&sortBy=continent&sortDirection=DESC&limit=10&offset=30
    public List<CountryOverviewDTO> getAll(@RequestParam(required = false) String continent,
                                           @RequestParam(required = false) Long minPopulation,
                                           @RequestParam(required = false) Long maxPopulation) {
        System.out.println("Requested all countries");
        return countryService.getCountriesFiltered(continent, minPopulation, maxPopulation).stream()
                .map(country -> new CountryOverviewDTO(country.getId(), country.getName())).toList();
    }

    @GetMapping("{id}") // GET http://host:port/countries/3
    public Country getById(@PathVariable int id) {
        Country country = countryService.getById(id);
        System.out.println("Before calling for cities");
        country.getCities().stream().count();
        return country;
    }

    @DeleteMapping("{id}") // DELETE http://host:port/countries/3
    public Country deleteById(@PathVariable int id) {
        return countryService.deleteById(id);
    }

    @PostMapping // POST http://host:port/countries
    public Country add(@RequestBody Country country) {
        return countryService.add(country);
    }

    @PutMapping("{id}")
    public Country update(@PathVariable int id, @RequestBody Country country) {
        return countryService.update(id, country);
    }

    @PatchMapping("{id}")
    public Country patch(@PathVariable long id, @RequestBody PatchCountryRequest request) {
        return countryService.patch(id, request.capital(), request.diffPopulation());
    }

    @PostMapping("{id}/cities")
    Country addCityToCountry(@PathVariable int id, @RequestBody City city){
        return countryService.addCityToCountry(id, city);
    }

    @PostMapping("{id}/neighbours/{neighbourId}")
    Country addNeighbourToCountry(@PathVariable int id, @PathVariable int neighbourId){
        return countryService.addNeighbourToCountry(id, neighbourId);
    }
}
