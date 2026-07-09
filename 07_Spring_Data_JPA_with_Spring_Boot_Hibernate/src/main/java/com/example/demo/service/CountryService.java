package main.java.com.example.demo.service;

import com.example.demo.entity.Country;
import com.example.demo.repository.CountryRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CountryService {
    private final CountryRepository repository;

    public CountryService(CountryRepository repository) {
        this.repository = repository;
    }

    public Country saveCountry(Country country) {
        return repository.save(country);
    }

    public Optional<Country> getCountryByCode(String code) {
        return repository.findByCountryCode(code);
    }
}