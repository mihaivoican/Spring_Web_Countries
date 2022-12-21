package com.fastrackit.countriesapplication.service.scheduler;



import com.fastrackit.countriesapplication.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
@AllArgsConstructor
//e o cls care lanseaza automat o metoda la un interval de timp precizat gen scheduler; executa automat o operatie recurenta fara actiunea user-ului.
public class LotteryTask {
    private final CountryService countryService;
// documentatie pt cron => https://spring.io/blog/2020/11/10/new-in-spring-5-3-improved-cron-expressions
//    @Scheduled(fixedDelay = 5, timeUnit=TimeUnit.SECONDS)       //ruleaza apoi asteapta 5 sec si iar ruleaza/ sau fixedRate=5, ruleaza la 5 sec/ sau initialDelay, cat asteapta dupa pornirea aplic
    @Scheduled(cron = "7 * * * * *")        //e varianta 2; vezi documentatia pt cron mai sus; * inseamna orice/fiecare, ****** inseamna orice secunda, orice minut, orice ora, orice zi a lunii, orice luna, orice zi a saptamanii..
    public void pickWinner() {
        Random random = new Random();
        int id = random.nextInt(countryService.getAllCountries().size());
        System.out.println("Winner country is: " + countryService.getById(id).getName());
    }
}