package com.turkcell.library.system.business.abstracts;

import com.turkcell.library.system.business.dto.request.employee.AddRequestEmployee;
import com.turkcell.library.system.business.dto.request.employee.UpdateRequestEmployee;
import com.turkcell.library.system.business.dto.response.employee.AddResponseEmployee;
import com.turkcell.library.system.business.dto.response.employee.GetAllResponseEmployee;
import com.turkcell.library.system.business.dto.response.employee.GetByIdResponseEmployee;
import com.turkcell.library.system.business.dto.response.employee.UpdateResponseEmployee;

import java.util.List;

public interface EmployeeService {

    AddResponseEmployee addEmployee(AddRequestEmployee addRequestEmployee);

    UpdateResponseEmployee updateEmployee(UpdateRequestEmployee updateRequestEmployee);

    GetByIdResponseEmployee getByIdEmployee(int id);

    List<GetAllResponseEmployee> getAllEmployee();

    void deleteEmployee(int id);
}
