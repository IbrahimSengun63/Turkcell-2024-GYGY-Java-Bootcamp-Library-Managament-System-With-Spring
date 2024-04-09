package com.turkcell.library.system.business.abstracts;

import com.turkcell.library.system.business.dto.request.transaction.AddRequestTransaction;
import com.turkcell.library.system.business.dto.request.transaction.UpdateRequestTransaction;
import com.turkcell.library.system.business.dto.response.transaction.*;

import java.util.List;

public interface TransactionService {
    AddResponseTransaction addTransaction(AddRequestTransaction addRequestTransaction);

    UpdateResponseTransaction updateTransaction(UpdateRequestTransaction updateRequestTransaction);

    GetByIdResponseTransaction getByIdTransaction(int id);

    List<GetAllResponseTransaction> getAllTransaction();

    void deleteTransaction(int id);

    List<ListResponseTransactions> listEmployeeTransactions(int employeeId);
}
