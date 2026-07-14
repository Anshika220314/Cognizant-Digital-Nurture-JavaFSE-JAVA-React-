package com.cognizant.dn5.loans.service;

import com.cognizant.dn5.loans.dto.LoanDto.LoanRequest;
import com.cognizant.dn5.loans.dto.LoanDto.LoanResponse;
import com.cognizant.dn5.loans.entity.Loan;
import com.cognizant.dn5.loans.exception.LoanNotFoundException;
import com.cognizant.dn5.loans.repository.LoanRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoanService {

    private final LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public LoanResponse createLoan(LoanRequest request) {
        Loan loan = new Loan();
        loan.setCustomerId(request.customerId());
        loan.setLoanType(request.loanType());
        loan.setTotalLoan(request.totalLoan());
        loan.setAmountPaid(0.0);
        loan.setOutstandingAmount(request.totalLoan());
        return toResponse(loanRepository.save(loan));
    }

    @Transactional(readOnly = true)
    public LoanResponse fetchLoan(Long customerId) {
        Loan loan = loanRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new LoanNotFoundException(customerId));
        return toResponse(loan);
    }

    public LoanResponse updateLoan(Long customerId, Double amountPaid) {
        Loan loan = loanRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new LoanNotFoundException(customerId));
        loan.setAmountPaid(loan.getAmountPaid() + amountPaid);
        loan.setOutstandingAmount(loan.getTotalLoan() - loan.getAmountPaid());
        return toResponse(loanRepository.save(loan));
    }

    public void deleteLoan(Long customerId) {
        loanRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new LoanNotFoundException(customerId));
        loanRepository.deleteByCustomerId(customerId);
    }

    private LoanResponse toResponse(Loan loan) {
        return new LoanResponse(
                loan.getLoanNumber(),
                loan.getCustomerId(),
                loan.getLoanType(),
                loan.getTotalLoan(),
                loan.getAmountPaid(),
                loan.getOutstandingAmount()
        );
    }
}
