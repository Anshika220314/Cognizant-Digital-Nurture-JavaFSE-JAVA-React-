package com.cognizant.dn5.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka Discovery Server.
 * Every microservice (accounts-service, loans-service, api-gateway) registers
 * itself here on startup so services can discover each other by name instead
 * of hardcoded host:port.
 *
 * Run this FIRST, then start accounts-service, loans-service, and api-gateway.
 * Dashboard: http://localhost:8761
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
