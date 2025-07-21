package com.ttn.restful.employee;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id){
        return employeeService.findOne(id);
    }

    @PostMapping("/employees/")
    public ResponseEntity<Object> createEmployee(@Valid @RequestBody Employee Employee){
        Employee newEmployee = employeeService.save(Employee);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(newEmployee.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/employees/{id}")
    public void delete(@PathVariable("id") int id){
        employeeService.delete(id);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Object> updateEmployee(
            @PathVariable("id") Integer id, @RequestBody @Valid Employee updatedEmployee) {
        Employee employee = employeeService.update(id, updatedEmployee);
        return ResponseEntity.ok(employee);
    }
}
