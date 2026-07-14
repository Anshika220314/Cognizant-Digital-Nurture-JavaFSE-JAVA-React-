package com.cognizant.dn5.loans.exception;

public class LoanNotFoundException extends RuntimeException {
    public LoanNotFoundException(Long customerId) {
        super("Loan not found for customerId: " + customerId);
    }
}
