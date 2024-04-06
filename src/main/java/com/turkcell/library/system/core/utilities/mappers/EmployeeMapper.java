package com.turkcell.library.system.core.utilities.mappers;

import com.turkcell.library.system.business.dto.request.employee.AddEmployeeRequest;
import com.turkcell.library.system.business.dto.request.employee.UpdateEmployeeRequest;
import com.turkcell.library.system.business.dto.response.employee.AddEmployeeResponse;
import com.turkcell.library.system.business.dto.response.employee.GetAllEmployeeResponse;
import com.turkcell.library.system.business.dto.response.employee.GetByIdEmployeeResponse;
import com.turkcell.library.system.business.dto.response.employee.UpdateEmployeeResponse;
import com.turkcell.library.system.entities.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    Employee employeeFromAddRequest(AddEmployeeRequest request);
    AddEmployeeResponse employeeFromAddResponse(Employee employee);

    Employee employeeFromUpdateRequest(UpdateEmployeeRequest request);
    UpdateEmployeeResponse employeeFromUpdateResponse(Employee employee);

    GetByIdEmployeeResponse employeeFromGetByIdResponse(Employee employee);
    List<GetAllEmployeeResponse> employeeFromGetAllEmployeeResponse(List<Employee> employees);
}
