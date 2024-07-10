package com.example.Employee_SpringBoot_JPA;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.Employee_SpringBoot_JPA.employee")
public class EmployeeSpringBootJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeSpringBootJpaApplication.class, args);
	}

}
