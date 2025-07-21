package com.ttn.restful.employee;

import com.ttn.restful.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class EmployeeService {
    private static List<Employee> employees = new ArrayList<>();
    private static Integer employeeCount;

    static {
        employees.add(new Employee(1, "Talha", 17));
        employees.add(new Employee(2, "Anjani", 71));
        employees.add(new Employee(3, "Punam", 27));
        employees.add(new Employee(4, "Phalki", 80));
        employeeCount = 4;
    }

    public List<Employee> findAll() {
        return employees;
    }

    public Employee findOne(int id) {
        Optional<Employee> Employee = employees.stream().filter(e->e.getId() == id).findFirst();
        return Employee.orElseThrow(()->new ResourceNotFoundException(
                "Employee"));
    }

    public Employee save(Employee Employee) {
        Employee.setId(++employeeCount);
        employees.add(Employee);
        return Employee;
    }

    public Employee update(int id, Employee updatedEmployee) {
        Employee existingEmployee = findOne(id);  // ResourceNotFoundException
        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setAge(updatedEmployee.getAge());

        return existingEmployee;
    }

    public void delete(int id){
        employees.removeIf(e->e.getId()==id);
    }
}