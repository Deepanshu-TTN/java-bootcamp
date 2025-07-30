package com.ttn.jpa;

import com.ttn.jpa.entity.embedded.EmbeddedEmployee;
import com.ttn.jpa.entity.embedded.SalaryDetails;
import com.ttn.jpa.repository.EmbeddedEmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmbeddedTests {
    @Autowired
    EmbeddedEmployeeRepository repository;

    @Test
    public void testEmbeddedEntity() {
        SalaryDetails salary = new SalaryDetails();
        salary.setBasicSalary(60000);
        salary.setBonusSalary(7000);
        salary.setTaxAmount(9000);
        salary.setSpecialAllowanceSalary(4000);

        EmbeddedEmployee employee = new EmbeddedEmployee();
        employee.setFirstName("Ambani");
        employee.setLastName("Raidu");
        employee.setAge(28);
        employee.setSalaryDetails(salary);
        repository.save(employee);
    }
}
