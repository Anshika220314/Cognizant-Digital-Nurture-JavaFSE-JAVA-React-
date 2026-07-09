package main.java.com.example.demo.repository;

import com.example.demo.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {
    
    // 1. Derived Query Method (Automated by Spring Data JPA)
    Optional<Country> findByCountryCode(String countryCode);

    // 2. HQL / JPQL Query
    @Query("SELECT c FROM Country c WHERE c.name = :name")
    Optional<Country> findByNameUsingHQL(@Param("name") String name);

    // 3. Native SQL Query
    @Query(value = "SELECT * FROM countries WHERE country_code = :code", nativeQuery = true)
    Optional<Country> findByCountryCodeNative(@Param("code") String code);
}