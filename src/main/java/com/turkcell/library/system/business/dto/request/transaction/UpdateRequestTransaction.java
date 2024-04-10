package com.turkcell.library.system.business.dto.request.transaction;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRequestTransaction {
    private int id;
    private double debt;
    @NotNull
    private int operation;
    @NotNull
    private int employeeId;
    @NotNull
    private int rentalId;
}
