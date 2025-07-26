package com.ttn.jpa.service;

import com.ttn.jpa.entities.Employee;
import com.ttn.jpa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository repository;

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee save(Employee e){
        return repository.save(e);
    }

    public Employee getById(long id){
        return repository.findById(id).orElseThrow((RuntimeException::new));
    }

    public void deleteById(long id){
        repository.deleteById(id);
    }

    public Employee update(long id, Employee toUpdate){
        Employee old = getById(id);
        old.setAge(toUpdate.getAge());
        old.setName(toUpdate.getName());
        old.setLocation(toUpdate.getLocation());
        return repository.save(old);
    }

    public long getTotalEmployees(){
        return repository.count();
    }

    public List<Employee> getPaginatedSortedEmployees(int pgSize, int pgNum) {
        Pageable pageable = PageRequest.of(
                pgNum,
                pgSize,
                Sort.by(
                        Sort.Direction.DESC,
                        "age")
        );

        return repository.findAll(pageable).getContent();
    }

    public List<Employee> getEmployeesByName(String pattern){
        return repository.findByNameContaining(pattern);
    }

    public List<Employee> getEmployeeNameStartingWith(String prefix){
        return repository.findByNameStartingWith(prefix);
    }

    public List<Employee> getEmployeeInAgeRange(byte low, byte high){
        return repository.findByAgeBetween(low, high);
    }
}
