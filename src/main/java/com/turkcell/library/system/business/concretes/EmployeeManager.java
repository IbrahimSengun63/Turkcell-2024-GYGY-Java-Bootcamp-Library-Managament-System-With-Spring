package com.turkcell.library.system.business.concretes;

import com.turkcell.library.system.business.abstracts.EmployeeService;
import com.turkcell.library.system.business.dto.request.employee.AddEmployeeRequest;
import com.turkcell.library.system.business.dto.request.employee.UpdateEmployeeRequest;
import com.turkcell.library.system.business.dto.response.employee.AddEmployeeResponse;
import com.turkcell.library.system.business.dto.response.employee.GetAllEmployeeResponse;
import com.turkcell.library.system.business.dto.response.employee.GetByIdEmployeeResponse;
import com.turkcell.library.system.business.dto.response.employee.UpdateEmployeeResponse;
import com.turkcell.library.system.business.rules.EmployeeBusinessRules;
import com.turkcell.library.system.core.utilities.mappers.EmployeeMapper;
import com.turkcell.library.system.dataAccess.abstracts.EmployeeRepository;
import com.turkcell.library.system.entities.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EmployeeManager implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeBusinessRules employeeBusinessRules;

    @Override
    public AddEmployeeResponse addEmployee(AddEmployeeRequest addEmployeeRequest) {
        this.employeeBusinessRules.checkIfEmployeeNameExists(addEmployeeRequest.getName());
        Employee employee = EmployeeMapper.INSTANCE.employeeFromAddRequest(addEmployeeRequest);
        Employee savedEmployee = this.employeeRepository.save(employee);
        return EmployeeMapper.INSTANCE.employeeFromAddResponse(savedEmployee);
    }

    @Override
    public UpdateEmployeeResponse updateEmployee(UpdateEmployeeRequest updateEmployeeRequest) {
        Employee employee = EmployeeMapper.INSTANCE.employeeFromUpdateRequest(updateEmployeeRequest);
        Employee updatedEmployee = this.employeeRepository.save(employee);
        return EmployeeMapper.INSTANCE.employeeFromUpdateResponse(updatedEmployee);
    }

    @Override
    public GetByIdEmployeeResponse getByIdEmployee(int id) {
        Employee employee = this.employeeRepository.findById(id).orElseThrow();
        return EmployeeMapper.INSTANCE.employeeFromGetByIdResponse(employee);

    }

    @Override
    public List<GetAllEmployeeResponse> getAllEmployee() {
        List<Employee> employees = this.employeeRepository.findAll();
        return EmployeeMapper.INSTANCE.employeeFromGetAllEmployeeResponse(employees);
    }

    @Override
    public void deleteEmployee(int id) {
        this.employeeRepository.deleteById(id);
    }
}
