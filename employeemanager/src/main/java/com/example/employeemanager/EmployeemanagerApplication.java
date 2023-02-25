package com.example.employeemanager;

import com.example.employeemanager.model.Employee;
import com.example.employeemanager.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeemanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeemanagerApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(EmployeeService employeeService) {
		return (args) -> {
		    employeeService.addEmployee(new Employee(1L,"amine","amine1@gmail.com","freeLancer","012345678","http://amine12",""));
			employeeService.addEmployee(new Employee(2L,"amine1","amine2@gmail.com","freeLancer1","012345678","http://amine13",""));
			employeeService.addEmployee(new Employee(3L,"amine2","amine3@gmail.com","freeLance2","012345678","http://amine14",""));
		};

		};
}
