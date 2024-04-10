package com.turkcell.library.system.business.rules;

import com.turkcell.library.system.core.utilities.exceptions.BusinessException;
import com.turkcell.library.system.dataAccess.abstracts.EmployeeRepository;
import com.turkcell.library.system.dataAccess.abstracts.MemberRepository;
import com.turkcell.library.system.dataAccess.abstracts.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionBusinessRules {
    private final RentalRepository rentalRepository;
    private final EmployeeRepository employeeRepository;

    public void checkIfDebtNormal(Double debt) {
        if (debt < 0) {
            throw new BusinessException("Debt can not be negative");
        }
    }

    public void checkIfRentalExists(int id) {
        if (this.rentalRepository.findById(id).isEmpty()) {
            throw new BusinessException("Rental with " + id + " id couldn't be found");
        }
    }

    public void checkIfEmployeeExists(int id) {
        if (this.employeeRepository.findById(id).isEmpty()) {
            throw new BusinessException("Employee with " + id + " id couldn't be found");
        }
    }
}
