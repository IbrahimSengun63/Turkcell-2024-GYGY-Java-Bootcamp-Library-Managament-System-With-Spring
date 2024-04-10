package com.turkcell.library.system.business.dto.request.transaction;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddRequestTransaction {

    private double debt = 0.0;
    @NotNull
    private int operation;
    @NotNull
    private int employeeId;
    @NotNull
    private int rentalId;
}
