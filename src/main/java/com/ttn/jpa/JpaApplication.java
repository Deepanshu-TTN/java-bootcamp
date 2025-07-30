package com.ttn.jpa;

import com.ttn.jpa.repository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(JpaApplication.class, args);
		EmployeeRepository repository = context.getBean(EmployeeRepository.class);
		repository.findEmployeesMoreThanAvgSalarySorted().forEach(
				e-> System.out.println(e[0] + " " + e[1])
		);
	}

}
