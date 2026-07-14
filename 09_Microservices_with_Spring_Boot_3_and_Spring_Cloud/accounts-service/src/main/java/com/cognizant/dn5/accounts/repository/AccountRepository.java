package com.cognizant.dn5.accounts.repository;

import com.cognizant.dn5.accounts.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByCustomerId(Long customerId);
    void deleteByCustomerId(Long customerId);
}
