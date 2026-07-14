package com.cognizant.dn5.gateway.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.Instant;

/**
 * Global filter applied to every request that passes through the gateway.
 * Logs the method, path, and a timestamp before forwarding the request
 * downstream to the resolved microservice.
 */
@Component
public class LogFilter implements GlobalFilter, Ordered {

    private static final Logger logger = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("====> Incoming request [{}] {} at {}",
                exchange.getRequest().getMethod(),
                exchange.getRequest().getURI(),
                Instant.now());
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1; // run early, before the request is routed
    }
}
