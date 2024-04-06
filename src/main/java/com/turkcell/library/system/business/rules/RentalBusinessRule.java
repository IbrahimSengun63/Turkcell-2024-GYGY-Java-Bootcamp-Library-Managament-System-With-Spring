package com.turkcell.library.system.business.rules;

import com.turkcell.library.system.core.utilities.exceptions.BusinessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class RentalBusinessRule {
    public void checkIfDatesIsNormal(LocalDate startDate,LocalDate endDate) {
        if(endDate.isBefore(startDate)) {
            throw new BusinessException("End date can not before start date");
        }
    }
}
