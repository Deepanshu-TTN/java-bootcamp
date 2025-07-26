package com.ttn.jpa;

import com.ttn.jpa.entities.Employee;
import com.ttn.jpa.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JpaApplicationTests {
	@Autowired
	EmployeeRepository repository;

	@Test
	void contextLoads() {

		Optional<Employee> e = repository.findById(0L);
		if (e.isEmpty()) fail("e not found");
		repository.deleteById(0L);
		Optional<Employee> eAgain = repository.findById(0L);
		assertTrue(eAgain.isEmpty());

	}

}
