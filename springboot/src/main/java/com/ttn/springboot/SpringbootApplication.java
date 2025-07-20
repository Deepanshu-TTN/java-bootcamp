package com.ttn.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootApplication {

	@Value("${application.user.name}")
	String user;

	@Value("${application.user.age}")
	String age;

	public static void main(String[] args) {
		var context = SpringApplication.run(SpringbootApplication.class, args);

		SpringbootApplication s = context.getBean(SpringbootApplication.class);

		System.out.printf("%s is %s years old.", s.user, s.age);
	}

}
