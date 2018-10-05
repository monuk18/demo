package com.employee.demo;


import com.employee.demo.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CustomCommandLineRunner implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(CustomCommandLineRunner.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(final String... arg0) throws Exception {
		this.logger.info("COMMAND LINE RUNNER");

	}

}
