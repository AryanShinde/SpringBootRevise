package com.springboot.msci;

import com.springboot.msci.Controllers.EmployeeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories

public class MsciApplication {
	@Autowired
	EmployeeController employeeController;

	public MsciApplication(EmployeeController employeeController) {
		this.employeeController = employeeController;
	}

	public static void main(String[] args) {

		SpringApplication.run(MsciApplication.class, args);
	}

}
