package com.cognizant.dn5.accounts.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountNumber;

    @Column(nullable = false)
    private Long customerId;

    @Column(nullable = false)
    private String accountType;   // SAVINGS, CURRENT

    @Column(nullable = false)
    private String branchAddress;
}
