package com.cognizant.dn5.accounts.exception;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(Long customerId) {
        super("Account not found for customerId: " + customerId);
    }
}
