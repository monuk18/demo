package com.employee.demo.service;


import com.employee.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class InitDbService {

	@Autowired
	private EmployeeService employeeService;

	/*@PostConstruct annotated methods will be
	called after the bean has been constructed, but
	before its returned to the requesting object*/
	@PostConstruct
	public void init() {
		{
			Employee emp = new Employee();
			emp.setFirstName("SONU");
			employeeService.addEmployee(emp);
		}
		{
			Employee emp = new Employee();
			emp.setFirstName("MONU");
			employeeService.addEmployee(emp);
		}
	}
}
