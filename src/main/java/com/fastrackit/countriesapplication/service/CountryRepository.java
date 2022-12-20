package com.fastrackit.countriesapplication.service;



import com.fastrackit.countriesapplication.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    List<Country> findByContinent(String name);

    @Query("select c from Country c where c.continent=:name")
    List<Country> findByContinentByQuery(@Param("name") String name);

    //f interesant ac query poate fi folosit si cu 3 param si cu 2, si cu 1, si cu niciunul
    @Query("select c from Country c where (c.continent=:continent or :continent is null) " +
            "and (c.population >= :minPopulation or :minPopulation is null) " +
            "and (c.population <= :maxPopulation or :maxPopulation is null)")
    List<Country> getByContinentAndMinPopulationAndMaxPopulation(@Param("continent") String continent,
                                                                 @Param("minPopulation") Long minPopulation,
                                                                 @Param("maxPopulation") Long maxPopulation);

//    Query ca in SQL nativ
//    @Query(value = "select * from COUNTRY where continent=:name", nativeQuery = true)
//    List<Country> findByContinentByNativeQuery(@Param("name") String name);
}