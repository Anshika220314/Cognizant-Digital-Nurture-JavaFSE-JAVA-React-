package com.cognizant.dn5.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Spring Cloud API Gateway.
 * Registers with Eureka, then routes incoming traffic to accounts-service and
 * loans-service by looking up their instances in the Eureka registry
 * (load-balanced via the "lb://SERVICE-NAME" URI scheme).
 *
 * Example calls through the gateway (gateway runs on port 8072):
 *   GET  http://localhost:8072/accounts/api/accounts/1
 *   GET  http://localhost:8072/loans/api/loans/1
 *
 * Every request passing through is logged by LogFilter (a GlobalFilter).
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }
}
