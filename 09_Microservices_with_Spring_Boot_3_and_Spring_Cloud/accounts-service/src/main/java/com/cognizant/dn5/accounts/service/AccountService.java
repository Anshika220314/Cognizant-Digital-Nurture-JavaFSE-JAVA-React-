package com.cognizant.dn5.accounts.service;

import com.cognizant.dn5.accounts.dto.AccountDto.AccountRequest;
import com.cognizant.dn5.accounts.dto.AccountDto.AccountResponse;
import com.cognizant.dn5.accounts.entity.Account;
import com.cognizant.dn5.accounts.exception.AccountNotFoundException;
import com.cognizant.dn5.accounts.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountResponse createAccount(AccountRequest request) {
        Account account = new Account();
        account.setCustomerId(request.customerId());
        account.setAccountType(request.accountType());
        account.setBranchAddress(request.branchAddress());
        Account saved = accountRepository.save(account);
        return toResponse(saved);
    }

    @Transactional(readOnly = true)
    public AccountResponse fetchAccount(Long customerId) {
        Account account = accountRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new AccountNotFoundException(customerId));
        return toResponse(account);
    }

    public AccountResponse updateAccount(Long customerId, AccountRequest request) {
        Account account = accountRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new AccountNotFoundException(customerId));
        account.setAccountType(request.accountType());
        account.setBranchAddress(request.branchAddress());
        return toResponse(accountRepository.save(account));
    }

    public void deleteAccount(Long customerId) {
        accountRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new AccountNotFoundException(customerId));
        accountRepository.deleteByCustomerId(customerId);
    }

    private AccountResponse toResponse(Account account) {
        return new AccountResponse(
                account.getAccountNumber(),
                account.getCustomerId(),
                account.getAccountType(),
                account.getBranchAddress()
        );
    }
}
