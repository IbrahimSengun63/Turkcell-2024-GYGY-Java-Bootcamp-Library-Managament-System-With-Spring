package com.turkcell.library.system.business.abstracts;

import com.turkcell.library.system.business.dto.request.transaction.AddTransactionRequest;
import com.turkcell.library.system.business.dto.request.transaction.UpdateTransactionRequest;
import com.turkcell.library.system.business.dto.response.transaction.AddTransactionResponse;
import com.turkcell.library.system.business.dto.response.transaction.GetAllTransactionResponse;
import com.turkcell.library.system.business.dto.response.transaction.GetByIdTransactionResponse;
import com.turkcell.library.system.business.dto.response.transaction.UpdateTransactionResponse;

import java.util.List;

public interface TransactionService {
    AddTransactionResponse addTransaction(AddTransactionRequest addTransactionRequest);
    UpdateTransactionResponse updateTransaction(UpdateTransactionRequest updateTransactionRequest);

    GetByIdTransactionResponse getByIdTransaction(int id);

    List<GetAllTransactionResponse> getAllTransaction();
    void deleteTransaction();
}
