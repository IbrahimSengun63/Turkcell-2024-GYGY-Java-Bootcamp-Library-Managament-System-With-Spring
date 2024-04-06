package com.turkcell.library.system.webApi.controllers;

import com.turkcell.library.system.business.abstracts.EmployeeService;
import com.turkcell.library.system.business.dto.request.employee.AddEmployeeRequest;
import com.turkcell.library.system.business.dto.request.employee.UpdateEmployeeRequest;
import com.turkcell.library.system.business.dto.response.employee.AddEmployeeResponse;
import com.turkcell.library.system.business.dto.response.employee.GetAllEmployeeResponse;
import com.turkcell.library.system.business.dto.response.employee.GetByIdEmployeeResponse;
import com.turkcell.library.system.business.dto.response.employee.UpdateEmployeeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeesController {
    private final EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public ResponseEntity<AddEmployeeResponse> addEmployee(AddEmployeeRequest addEmployeeRequest) {
        AddEmployeeResponse response = this.employeeService.addEmployee(addEmployeeRequest);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @GetMapping("/getById/{id}")
    public GetByIdEmployeeResponse getByIdEmployee(@PathVariable int id) {
        return this.employeeService.getByIdEmployee(id);
    }

    @GetMapping("/getAll")
    public List<GetAllEmployeeResponse> getAllEmployee() {
        return this.employeeService.getAllEmployee();
    }

    @PutMapping("/updateEmployee")
    public ResponseEntity<UpdateEmployeeResponse> updateEmployee(UpdateEmployeeRequest updateEmployeeRequest) {
        UpdateEmployeeResponse response = this.employeeService.updateEmployee(updateEmployeeRequest);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        this.employeeService.deleteEmployee(id);
    }
}
