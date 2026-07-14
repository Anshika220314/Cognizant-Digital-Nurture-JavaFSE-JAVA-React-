package com.cognizant.dn5.loans.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public class LoanDto {

    public record LoanRequest(
            @NotNull(message = "customerId is required") Long customerId,
            @Pattern(regexp = "HOME|VEHICLE|PERSONAL", message = "loanType must be HOME, VEHICLE or PERSONAL") String loanType,
            @NotNull @Positive(message = "totalLoan must be positive") Double totalLoan
    ) {}

    public record LoanResponse(
            Long loanNumber,
            Long customerId,
            String loanType,
            Double totalLoan,
            Double amountPaid,
            Double outstandingAmount
    ) {}
}
