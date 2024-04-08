package com.turkcell.library.system.core.utilities.mappers;

import com.turkcell.library.system.business.dto.request.employee.AddRequestEmployee;
import com.turkcell.library.system.business.dto.request.employee.UpdateRequestEmployee;
import com.turkcell.library.system.business.dto.response.employee.AddResponseEmployee;
import com.turkcell.library.system.business.dto.response.employee.GetAllResponseEmployee;
import com.turkcell.library.system.business.dto.response.employee.GetByIdResponseEmployee;
import com.turkcell.library.system.business.dto.response.employee.UpdateResponseEmployee;
import com.turkcell.library.system.entities.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    Employee addRequestToEmployee(AddRequestEmployee addRequestEmployee);
    AddResponseEmployee employeeToAddResponse(Employee employee);

    Employee updateRequestToEmployee(UpdateRequestEmployee updateRequestEmployee);
    UpdateResponseEmployee employeeToUpdateResponse(Employee employee);

    GetByIdResponseEmployee employeeToGetByIdResponse(Employee employee);
    List<GetAllResponseEmployee> employeesToGetAllResponse(List<Employee> employees);
}
