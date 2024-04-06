package com.turkcell.library.system.business.abstracts;

import com.turkcell.library.system.business.dto.request.employee.AddEmployeeRequest;
import com.turkcell.library.system.business.dto.request.employee.UpdateEmployeeRequest;
import com.turkcell.library.system.business.dto.response.employee.AddEmployeeResponse;
import com.turkcell.library.system.business.dto.response.employee.GetAllEmployeeResponse;
import com.turkcell.library.system.business.dto.response.employee.GetByIdEmployeeResponse;
import com.turkcell.library.system.business.dto.response.employee.UpdateEmployeeResponse;

import java.util.List;

public interface EmployeeService {
    AddEmployeeResponse addEmployee(AddEmployeeRequest addEmployeeRequest);
    UpdateEmployeeResponse updateEmployee(UpdateEmployeeRequest updateEmployeeRequest);
    GetByIdEmployeeResponse getByIdEmployee(int id);
    List<GetAllEmployeeResponse> getAllEmployee();
    void deleteEmployee(int id);
}
