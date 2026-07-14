package com.cognizant.dn5.loans.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "loans")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanNumber;

    @Column(nullable = false)
    private Long customerId;

    @Column(nullable = false)
    private String loanType;   // HOME, VEHICLE, PERSONAL

    @Column(nullable = false)
    private Double totalLoan;

    @Column(nullable = false)
    private Double amountPaid;

    @Column(nullable = false)
    private Double outstandingAmount;
}
