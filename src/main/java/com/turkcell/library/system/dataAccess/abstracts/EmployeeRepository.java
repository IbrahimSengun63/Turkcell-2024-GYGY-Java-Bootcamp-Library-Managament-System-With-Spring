package com.turkcell.library.system.dataAccess.abstracts;

import com.turkcell.library.system.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
