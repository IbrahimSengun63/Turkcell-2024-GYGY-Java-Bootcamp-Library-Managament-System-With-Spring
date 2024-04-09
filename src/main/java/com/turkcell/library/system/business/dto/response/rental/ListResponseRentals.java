package com.turkcell.library.system.business.dto.response.rental;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListResponseRentals {
    private int memberId;
    private String memberName;
    private int rentalId;
    private int bookId;
    private String bookName;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean available;
}
