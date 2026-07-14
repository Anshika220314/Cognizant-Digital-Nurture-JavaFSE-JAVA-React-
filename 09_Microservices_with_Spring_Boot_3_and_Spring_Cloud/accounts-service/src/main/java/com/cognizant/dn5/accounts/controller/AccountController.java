package com.cognizant.dn5.accounts.controller;

import com.cognizant.dn5.accounts.dto.AccountDto.AccountRequest;
import com.cognizant.dn5.accounts.dto.AccountDto.AccountResponse;
import com.cognizant.dn5.accounts.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    @Value("${server.port}")
    private String serverPort;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountResponse> createAccount(@Valid @RequestBody AccountRequest request) {
        AccountResponse response = accountService.createAccount(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<AccountResponse> fetchAccount(@PathVariable Long customerId) {
        return ResponseEntity.ok(accountService.fetchAccount(customerId));
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<AccountResponse> updateAccount(@PathVariable Long customerId,
                                                          @Valid @RequestBody AccountRequest request) {
        return ResponseEntity.ok(accountService.updateAccount(customerId, request));
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long customerId) {
        accountService.deleteAccount(customerId);
        return ResponseEntity.noContent().build();
    }

    // Useful for proving load-balancing works once multiple instances register with Eureka
    @GetMapping("/instance-info")
    public ResponseEntity<String> instanceInfo() {
        return ResponseEntity.ok("Response from accounts-service running on port: " + serverPort);
    }
}
