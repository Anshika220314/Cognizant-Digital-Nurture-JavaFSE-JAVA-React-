package com.cognizant.dn5.loans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Loans microservice. Registers itself with the Eureka Discovery Server
 * (must be running on localhost:8761) under the name "LOANS-SERVICE".
 */
@SpringBootApplication
@EnableDiscoveryClient
public class LoansServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoansServiceApplication.class, args);
    }
}
