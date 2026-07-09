package main.java.com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country_code", unique = true, nullable = false)
    private String countryCode;

    @Column(name = "country_name", nullable = false)
    private String name;

    public Country() {}
    public Country(String countryCode, String name) {
        this.countryCode = countryCode;
        this.name = name;
    }

    public Long getId() { return id; }
    public String getCountryCode() { return countryCode; }
    public void setCountryCode(String countryCode) { this.countryCode = countryCode; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}