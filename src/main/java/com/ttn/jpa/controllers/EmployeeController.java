package com.ttn.jpa.controllers;


import com.ttn.jpa.entities.Employee;
import com.ttn.jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee e){
        return service.save(e);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return service.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable("id") long id){
        return service.getById(id);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployeeById(@PathVariable("id") long id){
        service.deleteById(id);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployeeById(@PathVariable("id") long id, @RequestBody Employee e){
        return service.update(id, e);
    }

    @GetMapping("/employees/count")
    public long getEmployeeCount(){
        return service.getTotalEmployees();
    }

    @GetMapping(value = "/employees", params = {"pgNum", "pgSize"})
    public List<Employee> getEmployeePageSorted(@RequestParam int pgNum, @RequestParam int pgSize){
        return service.getPaginatedSortedEmployees(pgSize, pgNum);
    }

    @GetMapping(value = "/employees", params = {"name"})
    public List<Employee> getEmployeeByName(@RequestParam String name){
        return service.getEmployeesByName(name);
    }

    @GetMapping(value = "/employees", params = "nameStartsWith")
    public List<Employee> getEmployeeNameStartingWith(@RequestParam String nameStartsWith) {
        return service.getEmployeeNameStartingWith(nameStartsWith);
    }

    @GetMapping(value="/employees", params = {"ageFrom", "ageTo"})
    public List<Employee> getEmployeeInAgeRange(@RequestParam byte ageFrom, @RequestParam byte ageTo) {
        return service.getEmployeeInAgeRange(ageFrom, ageTo);
    }
}
