package com.turkcell.library.system.webApi.controllers;

import com.turkcell.library.system.business.abstracts.EmployeeService;
import com.turkcell.library.system.business.dto.request.employee.AddRequestEmployee;
import com.turkcell.library.system.business.dto.request.employee.UpdateRequestEmployee;
import com.turkcell.library.system.business.dto.response.employee.AddResponseEmployee;
import com.turkcell.library.system.business.dto.response.employee.GetAllResponseEmployee;
import com.turkcell.library.system.business.dto.response.employee.GetByIdResponseEmployee;
import com.turkcell.library.system.business.dto.response.employee.UpdateResponseEmployee;
import jakarta.validation.Valid;
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

    @PostMapping("/add")
    public ResponseEntity<AddResponseEmployee> addEmployee(@RequestBody @Valid AddRequestEmployee addRequestEmployee) {
        AddResponseEmployee response = this.employeeService.addEmployee(addRequestEmployee);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @GetMapping("/getById/{id}")
    public GetByIdResponseEmployee getByIdEmployee(@PathVariable int id) {
        return this.employeeService.getByIdEmployee(id);
    }

    @GetMapping("/getAll")
    public List<GetAllResponseEmployee> getAllEmployee() {
        return this.employeeService.getAllEmployee();
    }

    @PutMapping("/update")
    public ResponseEntity<UpdateResponseEmployee> updateEmployee(@RequestBody @Valid UpdateRequestEmployee updateRequestEmployee) {
        UpdateResponseEmployee response = this.employeeService.updateEmployee(updateRequestEmployee);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable int id) {
        this.employeeService.deleteEmployee(id);
    }
}
