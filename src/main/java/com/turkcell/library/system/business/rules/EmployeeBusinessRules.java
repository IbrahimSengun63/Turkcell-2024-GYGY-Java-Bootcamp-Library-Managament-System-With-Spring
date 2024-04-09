package com.turkcell.library.system.business.rules;

import com.turkcell.library.system.core.utilities.exceptions.BusinessException;
import com.turkcell.library.system.dataAccess.abstracts.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmployeeBusinessRules {
    private final EmployeeRepository employeeRepository;

    public void checkIfEmployeeNameExists(String name) {
        if (this.employeeRepository.existsByName(name)){
            throw new BusinessException("Employee already exists.");
        }
    }

    public void checkIfEmployeeExists(int id) {
        if (this.employeeRepository.findById(id).isEmpty()) {
            throw new BusinessException("Employee with " + id + " id couldn't be found");
        }
    }
}
