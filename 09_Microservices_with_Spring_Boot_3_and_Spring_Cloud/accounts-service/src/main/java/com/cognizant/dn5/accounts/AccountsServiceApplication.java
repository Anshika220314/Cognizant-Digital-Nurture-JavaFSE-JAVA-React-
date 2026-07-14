package com.cognizant.dn5.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Accounts microservice. Registers itself with the Eureka Discovery Server
 * (must be running on localhost:8761) under the name "ACCOUNTS-SERVICE".
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AccountsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountsServiceApplication.class, args);
    }
}
