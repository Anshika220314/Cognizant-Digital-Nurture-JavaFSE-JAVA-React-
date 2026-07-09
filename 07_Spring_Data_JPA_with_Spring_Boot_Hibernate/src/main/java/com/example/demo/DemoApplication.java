package main.java.com.example.demo;

import com.example.demo.entity.Country;
import com.example.demo.repository.CountryRepository;
import com.example.demo.service.CountryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CountryService service, CountryRepository repository) {
        return args -> {
            // Add new countries
            service.saveCountry(new Country("IN", "India"));
            service.saveCountry(new Country("US", "United States"));

            // Find a country based on code (Derived Method)
            service.getCountryByCode("IN").ifPresent(c -> 
                System.out.println("Found (Derived Method): " + c.getName()));

            // Find using HQL
            repository.findByNameUsingHQL("United States").ifPresent(c -> 
                System.out.println("Found (HQL Query): " + c.getCountryCode()));

            // Find using Native Query
            repository.findByCountryCodeNative("IN").ifPresent(c -> 
                System.out.println("Found (Native Query): " + c.getName()));
        };
    }
}