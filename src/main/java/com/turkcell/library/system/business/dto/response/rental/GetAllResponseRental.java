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
public class GetAllResponseRental {
    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private int memberId;
    private String memberName;
    private int bookId;
    private String bookName;
}
