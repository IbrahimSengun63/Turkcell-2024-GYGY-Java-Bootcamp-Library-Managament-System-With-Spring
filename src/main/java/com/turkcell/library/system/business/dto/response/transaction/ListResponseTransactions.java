package com.turkcell.library.system.business.dto.response.transaction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListResponseTransactions {
    private int employeeId;
    private String employeeName;
    private int transactionId;
    private int operation;
    private double debt;
    private int rentalId;
    private LocalDate startDate;
    private LocalDate endDate;
    private int memberId;
    private String memberName;
    private int bookId;
    private String bookName;
    private boolean bookAvailability;
}
