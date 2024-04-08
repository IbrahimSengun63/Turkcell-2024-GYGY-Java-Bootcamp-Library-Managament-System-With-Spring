package com.turkcell.library.system.core.utilities.mappers;

import com.turkcell.library.system.business.dto.request.transaction.AddTransactionRequest;
import com.turkcell.library.system.business.dto.request.transaction.UpdateTransactionRequest;
import com.turkcell.library.system.business.dto.response.transaction.AddTransactionResponse;
import com.turkcell.library.system.business.dto.response.transaction.GetAllTransactionResponse;
import com.turkcell.library.system.business.dto.response.transaction.GetByIdTransactionResponse;
import com.turkcell.library.system.business.dto.response.transaction.UpdateTransactionResponse;
import com.turkcell.library.system.entities.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TransactionMapper{
    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);


    Transaction transactionFromAddRequest(AddTransactionRequest addTransactionRequest);

    @Mapping(source = "employee.id",target = "employeeId")
    @Mapping(source = "rental.id",target = "rentalId")
    AddTransactionResponse addResponseFromTransaction(Transaction transaction);

    Transaction transactionFromUpdateRequest(UpdateTransactionRequest updateTransactionRequest);

    @Mapping(source = "employee.id",target = "employeeId")
    @Mapping(source = "rental.id",target = "rentalId")
    UpdateTransactionResponse updateResponseFromTransaction(Transaction transaction);

    @Mapping(source = "employee.id",target = "employeeId")
    @Mapping(source = "employee.name",target = "employeeName")
    @Mapping(source = "rental.id",target = "rentalId")
    @Mapping(source = "member.id", target = "memberId")
    @Mapping(source = "member.name", target = "memberName")
    @Mapping(source = "book.id", target = "bookId")
    @Mapping(source = "book.name", target = "bookName")
    GetByIdTransactionResponse getByIdTransactionResponseFromTransaction(Transaction transaction);

    @Mapping(source = "employee.id",target = "employeeId")
    @Mapping(source = "employee.name",target = "employeeName")
    @Mapping(source = "rental.id",target = "rentalId")
    @Mapping(source = "member.id", target = "memberId")
    @Mapping(source = "member.name", target = "memberName")
    @Mapping(source = "book.id", target = "bookId")
    @Mapping(source = "book.name", target = "bookName")
    GetAllTransactionResponse transactionToGetAllTransactionResponse(Transaction transaction);

    List<GetAllTransactionResponse> getAllTransactionResponseFromTransactions(List<Transaction> transactions);
}
