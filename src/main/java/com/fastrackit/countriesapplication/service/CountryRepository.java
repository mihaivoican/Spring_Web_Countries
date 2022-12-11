package com.fastrackit.countriesapplication.service;



import com.fastrackit.countriesapplication.model.Country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    //MAI JOS E O METODA CUSTOM DEFINITA NUMAI CU NUMELE pe care JPA a implementat-o fiindca am respectat o conventie de nume
//    ac documentatie pt denumire metode se gaseste la: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.details
    List<Country> findByContinent(String name);

    @Query("select c from Country c where c.continent=:name")
    List<Country> findByContinentByQuery(@Param("name") String name);

//mai jos e varianata 3 cu query nativ sql
//    @Query(value = "select * from COUNTRY where continent=:name", nativeQuery = true)
//    List<Country> findByContinentByNativeQuery(@Param("name") String name);
}