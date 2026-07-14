package com.cognizant.dn5.loans.repository;

import com.cognizant.dn5.loans.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    Optional<Loan> findByCustomerId(Long customerId);
    void deleteByCustomerId(Long customerId);
}
