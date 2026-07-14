# 09 – Microservices with Spring Boot 3 and Spring Cloud

Four independent Spring Boot 3 applications that together demonstrate a
microservices architecture with service discovery and an API gateway,
built for a banking domain (accounts + loans), per the Cognizant Digital
Nurture 5.0 "Microservices with API gateway" module.

## Modules

| Module | Port | Role |
|---|---|---|
| `eureka-server` | 8761 | Eureka Discovery Server — registry of all running services |
| `accounts-service` | 8080 | REST API for customer accounts (CRUD, H2 in-memory DB) |
| `loans-service` | 8090 | REST API for customer loans (CRUD, H2 in-memory DB) |
| `api-gateway` | 8072 | Spring Cloud Gateway — single entry point, routes by service name, logs every request |

Each module is a **separate, standalone Maven project** with its own `pom.xml`
— exactly like the account/loan split described in the handbook — rather
than a multi-module reactor build, so each can be imported and run
independently in Eclipse/IntelliJ.

## Architecture

```
                     ┌─────────────────────┐
                     │   Eureka Server      │
                     │   localhost:8761     │
                     └──────────▲───────────┘
               registers/discovers│  registers/discovers
        ┌──────────────┬─────────┴─────────┬──────────────┐
        │              │                   │              │
 ┌──────▼──────┐ ┌──────▼───────┐   ┌───────▼──────┐       │
 │ accounts-   │ │ loans-       │   │ api-gateway  │◄──────┘ client requests
 │ service     │ │ service      │   │ :8072        │
 │ :8080       │ │ :8090        │   └──────────────┘
 └─────────────┘ └──────────────┘
```

## Run order

1. **eureka-server** — `cd eureka-server && mvn spring-boot:run`
   Wait for it to fully start, then check http://localhost:8761 — the
   registered-instances list should be empty.
2. **accounts-service** — `cd accounts-service && mvn spring-boot:run`
3. **loans-service** — `cd loans-service && mvn spring-boot:run`
4. **api-gateway** — `cd api-gateway && mvn spring-boot:run`

Refresh http://localhost:8761 after each service starts — you should see
`ACCOUNTS-SERVICE`, `LOANS-SERVICE`, and `API-GATEWAY` appear in the
registry.

## Testing the services directly

```bash
# Create an account
curl -X POST http://localhost:8080/api/accounts \
  -H "Content-Type: application/json" \
  -d '{"customerId":1,"accountType":"SAVINGS","branchAddress":"Dehradun Main Branch"}'

# Fetch it
curl http://localhost:8080/api/accounts/1

# Create a loan
curl -X POST http://localhost:8090/api/loans \
  -H "Content-Type: application/json" \
  -d '{"customerId":1,"loanType":"PERSONAL","totalLoan":400000}'

# Fetch it
curl http://localhost:8090/api/loans/1
```

## Testing through the API Gateway

Once all four services are registered with Eureka, the gateway routes
requests to the right service by name — the client never talks to
accounts-service or loans-service directly:

```bash
curl http://localhost:8072/accounts/api/accounts/1
curl http://localhost:8072/loans/api/loans/1
```

Spring Cloud Gateway's discovery locator is also enabled, so services are
additionally reachable by their lower-cased Eureka name directly, e.g.
`http://localhost:8072/accounts-service/api/accounts/1`.

Watch the **api-gateway console** while you run these — the `LogFilter`
global filter logs the method, full URI, and timestamp of every request
that passes through, before it's forwarded downstream.

## Why this setup is worth talking about in an interview

- **Service discovery**: no service hardcodes another's host:port. They all
  register with Eureka and are looked up by name (`lb://ACCOUNTS-SERVICE`).
- **Single entry point**: the gateway hides internal topology from clients
  and centralizes cross-cutting concerns (here: request logging via a
  `GlobalFilter`; in a real system you'd add auth, rate-limiting, etc. here).
- **Independent deployability**: accounts-service and loans-service can be
  built, deployed, restarted, and scaled independently — a bug or memory
  leak in one doesn't take down the other (the exact monolith failure mode
  this module's theory section describes).
- **Load balancing**: since routing goes through Eureka's registry rather
  than a fixed URL, running two instances of accounts-service (e.g. on
  8080 and 8081) lets the gateway load-balance between them automatically
  — try it and hit `/api/accounts/instance-info` to see the port change.
