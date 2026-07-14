package com.cognizant.dn5.accounts.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class AccountDto {

    public record AccountRequest(
            @NotNull(message = "customerId is required") Long customerId,
            @Pattern(regexp = "SAVINGS|CURRENT", message = "accountType must be SAVINGS or CURRENT") String accountType,
            @NotNull(message = "branchAddress is required") String branchAddress
    ) {}

    public record AccountResponse(
            Long accountNumber,
            Long customerId,
            String accountType,
            String branchAddress
    ) {}
}
