package com.cognizant.dn5.loans.controller;

import com.cognizant.dn5.loans.dto.LoanDto.LoanRequest;
import com.cognizant.dn5.loans.dto.LoanDto.LoanResponse;
import com.cognizant.dn5.loans.service.LoanService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/loans")
@Validated
public class LoanController {

    private final LoanService loanService;

    @Value("${server.port}")
    private String serverPort;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping
    public ResponseEntity<LoanResponse> createLoan(@Valid @RequestBody LoanRequest request) {
        LoanResponse response = loanService.createLoan(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<LoanResponse> fetchLoan(@PathVariable Long customerId) {
        return ResponseEntity.ok(loanService.fetchLoan(customerId));
    }

    @PutMapping("/{customerId}/payment")
    public ResponseEntity<LoanResponse> makePayment(@PathVariable Long customerId,
                                                     @RequestParam @Positive Double amountPaid) {
        return ResponseEntity.ok(loanService.updateLoan(customerId, amountPaid));
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteLoan(@PathVariable Long customerId) {
        loanService.deleteLoan(customerId);
        return ResponseEntity.noContent().build();
    }

    // Useful for proving load-balancing works once multiple instances register with Eureka
    @GetMapping("/instance-info")
    public ResponseEntity<String> instanceInfo() {
        return ResponseEntity.ok("Response from loans-service running on port: " + serverPort);
    }
}
