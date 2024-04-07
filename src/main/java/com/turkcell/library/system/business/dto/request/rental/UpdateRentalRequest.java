package com.turkcell.library.system.business.dto.request.rental;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRentalRequest {
    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private int memberId;
    private int bookId;
}
