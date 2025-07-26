package com.ttn.jpa.repository;

import com.ttn.jpa.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    public List<Employee> findByNameContaining(String pattern);

    public List<Employee> findByNameStartingWith(String prefix);

    public List<Employee> findByAgeBetween(byte low, byte high);
}
