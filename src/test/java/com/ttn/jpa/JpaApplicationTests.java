package com.ttn.jpa;

import com.ttn.jpa.entity.Employee;
import com.ttn.jpa.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class JpaApplicationTests {

	@Autowired
	EmployeeRepository repository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testQ1(){
		repository.findEmployeesMoreThanAvgSalarySorted().forEach(
				e-> System.out.println(e[0] +" " + e[1])
		);
	}

	@Test
	@Transactional
	public void testQ2() {
		System.out.println("---Data Before---");
		repository.findAll().forEach(System.out::println);
		double avgSalary = repository.getEmployeeAvgSalary();
		System.out.println(avgSalary);
		repository.incrementEmployeeSalary(75000, avgSalary);
		System.out.println("---Data After----");
		repository.findAll().forEach(System.out::println);
	}

	@Test
	@Transactional
	public void testQ3() {
		System.out.println("---Data Before---");
		repository.findAll().forEach(System.out::println);
		double minSalary  = repository.getEmployeeMinSalary();
		repository.deleteEmployeeWithMinSalary(minSalary);
		System.out.println("---Data After----");
		repository.findAll().forEach(System.out::println);
	}

	@Test
	public void testQ4(){
		repository.getEmployeeWithLastName("singh").forEach(
				e-> System.out.println(
						e[0] + " " + e[1] + " " + e[2]
				)
		);
	}

	@Test
	@Transactional
	public void testQ5(){
		System.out.println("---Data Before---");
		repository.findAll().forEach(System.out::println);
		repository.purgeOldEmployees(45);
		System.out.println("---Data After----");
		repository.findAll().forEach(System.out::println);
	}

}
