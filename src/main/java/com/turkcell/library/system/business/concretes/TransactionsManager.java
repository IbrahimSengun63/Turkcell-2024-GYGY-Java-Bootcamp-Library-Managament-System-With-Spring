package com.turkcell.library.system.business.concretes;

import com.turkcell.library.system.business.abstracts.TransactionService;
import com.turkcell.library.system.business.dto.request.transaction.AddRequestTransaction;
import com.turkcell.library.system.business.dto.request.transaction.UpdateRequestTransaction;
import com.turkcell.library.system.business.dto.response.transaction.*;
import com.turkcell.library.system.business.rules.TransactionBusinessRules;
import com.turkcell.library.system.core.utilities.mappers.TransactionMapper;
import com.turkcell.library.system.dataAccess.abstracts.*;
import com.turkcell.library.system.entities.Employee;
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
    public AddResponseTransaction addTransaction(AddRequestTransaction addRequestTransaction) {
        this.transactionBusinessRules.checkIfDebtNormal(addRequestTransaction.getDebt());
        Transaction transaction = TransactionMapper.INSTANCE.addRequestToTransaction(addRequestTransaction);
        transaction.setEmployee(this.employeeRepository.findById(addRequestTransaction.getEmployeeId()).orElseThrow());
        transaction.setRental(this.rentalRepository.findById(addRequestTransaction.getRentalId()).orElseThrow());
        Transaction savedTransaction = this.transactionRepository.save(transaction);
        return TransactionMapper.INSTANCE.transactionToAddResponse(savedTransaction);
    }

    @Override
    public UpdateResponseTransaction updateTransaction(UpdateRequestTransaction updateRequestTransaction) {
        Transaction transaction = TransactionMapper.INSTANCE.updateRequestToTransaction(updateRequestTransaction);
        transaction.setEmployee(this.employeeRepository.findById(updateRequestTransaction.getEmployeeId()).orElseThrow());
        transaction.setRental(this.rentalRepository.findById(updateRequestTransaction.getRentalId()).orElseThrow());
        Transaction updatedTransaction = this.transactionRepository.save(transaction);
        return TransactionMapper.INSTANCE.transactionToUpdateResponse(updatedTransaction);
    }

    @Override
    public GetByIdResponseTransaction getByIdTransaction(int id) {
        Transaction transaction = this.transactionRepository.findById(id).orElseThrow();
        return TransactionMapper.INSTANCE.transactionToGetByIdResponse(transaction);
    }

    @Override
    public List<GetAllResponseTransaction> getAllTransaction() {
        List<Transaction> transactions = this.transactionRepository.findAll();
        return TransactionMapper.INSTANCE.transactionsToGetAllResponse(transactions);
    }

    @Override
    public void deleteTransaction(int id) {
        this.transactionRepository.deleteById(id);
    }

    @Override
    public List<ListResponseTransactions> listEmployeeTransactions(int employeeId) {
        //busines rule define
        Employee employee = this.employeeRepository.findById(employeeId).orElseThrow();
        List<Transaction> transactions = this.transactionRepository.findByEmployeeId(employeeId);
        employee.setTransactions(transactions);
        return TransactionMapper.INSTANCE.transactionsToListResponse(transactions);
    }
}
