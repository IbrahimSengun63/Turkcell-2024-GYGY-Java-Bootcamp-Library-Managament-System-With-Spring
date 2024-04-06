package com.turkcell.library.system.dataAccess.abstracts;

import com.turkcell.library.system.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Boolean existsByName(String name);
}
