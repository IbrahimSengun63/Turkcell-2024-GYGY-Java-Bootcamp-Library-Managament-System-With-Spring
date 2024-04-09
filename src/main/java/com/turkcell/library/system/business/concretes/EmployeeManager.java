package com.turkcell.library.system.business.concretes;

import com.turkcell.library.system.business.abstracts.EmployeeService;
import com.turkcell.library.system.business.dto.request.employee.AddRequestEmployee;
import com.turkcell.library.system.business.dto.request.employee.UpdateRequestEmployee;
import com.turkcell.library.system.business.dto.response.employee.AddResponseEmployee;
import com.turkcell.library.system.business.dto.response.employee.GetAllResponseEmployee;
import com.turkcell.library.system.business.dto.response.employee.GetByIdResponseEmployee;
import com.turkcell.library.system.business.dto.response.employee.UpdateResponseEmployee;
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
    public AddResponseEmployee addEmployee(AddRequestEmployee addRequestEmployee) {
        this.employeeBusinessRules.checkIfEmployeeNameExists(addRequestEmployee.getName());
        Employee employee = EmployeeMapper.INSTANCE.addRequestToEmployee(addRequestEmployee);
        Employee savedEmployee = this.employeeRepository.save(employee);
        return EmployeeMapper.INSTANCE.employeeToAddResponse(savedEmployee);
    }

    @Override
    public UpdateResponseEmployee updateEmployee(UpdateRequestEmployee updateRequestEmployee) {
        this.employeeBusinessRules.checkIfEmployeeExists(updateRequestEmployee.getId());
        this.employeeBusinessRules.checkIfEmployeeNameExists(updateRequestEmployee.getName());
        Employee employee = EmployeeMapper.INSTANCE.updateRequestToEmployee(updateRequestEmployee);
        Employee updatedEmployee = this.employeeRepository.save(employee);
        return EmployeeMapper.INSTANCE.employeeToUpdateResponse(updatedEmployee);
    }

    @Override
    public GetByIdResponseEmployee getByIdEmployee(int id) {
        Employee employee = this.employeeRepository.findById(id).orElseThrow();
        return EmployeeMapper.INSTANCE.employeeToGetByIdResponse(employee);

    }

    @Override
    public List<GetAllResponseEmployee> getAllEmployee() {
        List<Employee> employees = this.employeeRepository.findAll();
        return EmployeeMapper.INSTANCE.employeesToGetAllResponse(employees);
    }

    @Override
    public void deleteEmployee(int id) {
        this.employeeRepository.deleteById(id);
    }
}
