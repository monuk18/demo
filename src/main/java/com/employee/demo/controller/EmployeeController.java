package com.employee.demo.controller;


import com.employee.demo.entity.Employee;
import com.employee.demo.exception.EmployeeNotFoundException;
import com.employee.demo.repository.EmployeeRepository;
import com.employee.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("employee")
@CrossOrigin
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
    @Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employeeList= employeeService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(employeeList,HttpStatus.OK);
	}

	@GetMapping("/{emp_id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("emp_id") final long emp_id) {
		Employee employee= employeeService.getEmployeeByEmpId(emp_id);
		if(employee == null) {
			throw new EmployeeNotFoundException("Invalid employee id : " + emp_id);
		}
		return  new ResponseEntity<Employee>(employee,HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Employee> addEmployee(@RequestBody final Employee employee){
		Employee emp = employeeService.addEmployee(employee);
		return  new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}

	@PutMapping("/{emp_id}")
	public  ResponseEntity<Employee> updateEmployee(@PathVariable("emp_id") final Long emp_id, @RequestBody final Employee employee) {
		Employee emp= employeeService.getEmployeeByEmpId(emp_id);
		if (null != emp)
		{
			employee.setEmpId(emp_id);
			employeeService.updateEmployee(employee);
			return new ResponseEntity<Employee>(emp,HttpStatus.OK);
		}
		return new ResponseEntity<Employee>(emp,HttpStatus.NOT_FOUND);
	}

	/*@PatchMapping("/{emp_id}")
    public ResponseEntity<Employee>
    partialupdateEmployee(@RequestBody Map<String, Object> updates,@PathVariable("id") Long emp_id){
        Employee emp= employeeService.getEmployeeByEmpId(emp_id);
        employeeRepository.save(updates,emp);
        return null;
    }*/

	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable("id") final Long id) {
		this.employeeService.deleteEmployee(id);
	}

}
