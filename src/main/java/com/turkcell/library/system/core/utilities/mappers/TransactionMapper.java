package com.turkcell.library.system.core.utilities.mappers;

import com.turkcell.library.system.business.dto.request.transaction.AddRequestTransaction;
import com.turkcell.library.system.business.dto.request.transaction.UpdateRequestTransaction;
import com.turkcell.library.system.business.dto.response.transaction.*;
import com.turkcell.library.system.entities.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TransactionMapper{
    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);


    Transaction addRequestToTransaction(AddRequestTransaction addRequestTransaction);

    @Mapping(source = "employee.id",target = "employeeId")
    @Mapping(source = "rental.id",target = "rentalId")
    AddResponseTransaction transactionToAddResponse(Transaction transaction);

    @Mapping(source = "id",target = "id")
    Transaction updateRequestToTransaction(UpdateRequestTransaction updateRequestTransaction);

    @Mapping(source = "employee.id",target = "employeeId")
    @Mapping(source = "rental.id",target = "rentalId")
    UpdateResponseTransaction transactionToUpdateResponse(Transaction transaction);

    @Mapping(source = "employee.id",target = "employeeId")
    @Mapping(source = "employee.name",target = "employeeName")
    @Mapping(source = "rental.id",target = "rentalId")
    @Mapping(source = "rental.member.id", target = "memberId")
    @Mapping(source = "rental.member.name", target = "memberName")
    @Mapping(source = "rental.book.id", target = "bookId")
    @Mapping(source = "rental.book.name", target = "bookName")
    GetByIdResponseTransaction transactionToGetByIdResponse(Transaction transaction);

    @Mapping(source = "employee.id",target = "employeeId")
    @Mapping(source = "employee.name",target = "employeeName")
    @Mapping(source = "rental.id",target = "rentalId")
    @Mapping(source = "rental.member.id", target = "memberId")
    @Mapping(source = "rental.member.name", target = "memberName")
    @Mapping(source = "rental.book.id", target = "bookId")
    @Mapping(source = "rental.book.name", target = "bookName")
    GetAllResponseTransaction transactionToGetAllResponse(Transaction transaction);

    List<GetAllResponseTransaction> transactionsToGetAllResponse(List<Transaction> transactions);

    @Mapping(source = "employee.id",target = "employeeId")
    @Mapping(source = "employee.name",target = "employeeName")
    @Mapping(source = "id",target = "transactionId")
    @Mapping(source = "rental.id",target = "rentalId")
    @Mapping(source = "rental.startDate", target = "startDate")
    @Mapping(source = "rental.endDate", target = "endDate")
    @Mapping(source = "rental.member.id", target = "memberId")
    @Mapping(source = "rental.member.name", target = "memberName")
    @Mapping(source = "rental.book.id", target = "bookId")
    @Mapping(source = "rental.book.name", target = "bookName")
    @Mapping(source = "rental.book.available", target = "bookAvailability")
    ListResponseTransactions transactionToListResponse(Transaction transaction);

    List<ListResponseTransactions> transactionsToListResponse(List<Transaction> transactions);
}
