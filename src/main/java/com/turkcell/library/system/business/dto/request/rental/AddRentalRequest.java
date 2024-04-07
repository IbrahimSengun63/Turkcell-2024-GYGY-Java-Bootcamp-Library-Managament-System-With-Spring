package com.turkcell.library.system.business.dto.request.rental;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddRentalRequest {
    @NotBlank
    private LocalDate startDate;
    private LocalDate endDate;
    private int memberId;
    private int bookId;
}
