package com.ttn.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		var contrxt = SpringApplication.run(JpaApplication.class, args);

	}

}
