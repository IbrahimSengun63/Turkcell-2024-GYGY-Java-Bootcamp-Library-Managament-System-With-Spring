package com.turkcell.library.system.business.rules;

import com.turkcell.library.system.core.utilities.exceptions.BusinessException;
import org.springframework.stereotype.Service;

@Service
public class TransactionBusinessRules {
    public void checkIsDebtNormal(Double debt) {
        if (debt < 0) {
            throw new BusinessException("Debt can not be negative");
        }
    }
}
