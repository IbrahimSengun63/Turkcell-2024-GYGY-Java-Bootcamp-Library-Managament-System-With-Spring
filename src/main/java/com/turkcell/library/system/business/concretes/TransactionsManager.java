package com.turkcell.library.system.business.concretes;

import com.turkcell.library.system.business.abstracts.TransactionService;
import com.turkcell.library.system.business.dto.request.transaction.AddTransactionRequest;
import com.turkcell.library.system.business.dto.request.transaction.UpdateTransactionRequest;
import com.turkcell.library.system.business.dto.response.transaction.AddTransactionResponse;
import com.turkcell.library.system.business.dto.response.transaction.GetAllTransactionResponse;
import com.turkcell.library.system.business.dto.response.transaction.GetByIdTransactionResponse;
import com.turkcell.library.system.business.dto.response.transaction.UpdateTransactionResponse;
import com.turkcell.library.system.business.rules.TransactionBusinessRules;
import com.turkcell.library.system.core.utilities.mappers.TransactionMapper;
import com.turkcell.library.system.dataAccess.abstracts.*;
import com.turkcell.library.system.entities.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionsManager implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final BookRepository bookRepository;
    private final EmployeeRepository employeeRepository;
    private final MemberRepository memberRepository;
    private final RentalRepository rentalRepository;
    private final TransactionBusinessRules transactionBusinessRules;

    @Override
    public AddTransactionResponse addTransaction(AddTransactionRequest addTransactionRequest) {
        this.transactionBusinessRules.checkIfDebtNormal(addTransactionRequest.getDebt());
        Transaction transaction = TransactionMapper.INSTANCE.transactionFromAddRequest(addTransactionRequest);
        transaction.setEmployee(this.employeeRepository.findById(addTransactionRequest.getEmployeeId()).orElseThrow());
        transaction.setRental(this.rentalRepository.findById(addTransactionRequest.getRentalId()).orElseThrow());
        Transaction savedTransaction = this.transactionRepository.save(transaction);
        return TransactionMapper.INSTANCE.addResponseFromTransaction(savedTransaction);
    }

    @Override
    public UpdateTransactionResponse updateTransaction(UpdateTransactionRequest updateTransactionRequest) {
        Transaction transaction = TransactionMapper.INSTANCE.transactionFromUpdateRequest(updateTransactionRequest);
        transaction.setEmployee(this.employeeRepository.findById(updateTransactionRequest.getEmployeeId()).orElseThrow());
        transaction.setRental(this.rentalRepository.findById(updateTransactionRequest.getRentalId()).orElseThrow());
        Transaction updatedTransaction = this.transactionRepository.save(transaction);
        return TransactionMapper.INSTANCE.updateResponseFromTransaction(updatedTransaction);
    }

    @Override
    public GetByIdTransactionResponse getByIdTransaction(int id) {
        // manuel mapping
        Transaction transaction = this.transactionRepository.findById(id).orElseThrow();
        return TransactionMapper.INSTANCE.getByIdTransactionResponseFromTransaction(transaction);

    }

    @Override
    public List<GetAllTransactionResponse> getAllTransaction() {
        List<Transaction> transactions = this.transactionRepository.findAll();
        return TransactionMapper.INSTANCE.getAllTransactionResponseFromTransactions(transactions);
    }

    @Override
    public void deleteTransaction(int id) {
        this.transactionRepository.deleteById(id);
    }
}
