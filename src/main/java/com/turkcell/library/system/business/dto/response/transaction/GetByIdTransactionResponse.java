package com.turkcell.library.system.business.dto.response.transaction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdTransactionResponse {
    private double debt;
    private int operation;
    private int employeeId;
    private String employeeName;
    private int rentalId;
    private int memberId;
    private String memberName;
    private int bookId;
    private String bookName;
}
