package com.employee.demo.service;

import com.employee.demo.entity.Employee;
import com.employee.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee getEmployeeByEmpId(long empId) {

        Optional<Employee> employeeOptional =  this.employeeRepository.findById(empId);
        if(!employeeOptional.isPresent())
            return null;
        return employeeOptional.get();
    }

    public Employee getEmployeeByFirstName(String firstName) {

        Optional<Employee> employeeOptional =  this.employeeRepository.findByFirstName(firstName);
        if(!employeeOptional.isPresent())
            return null;
        return employeeOptional.get();
    }

    public Employee addEmployee(Employee employee) {
        this.employeeRepository.save(employee);
        return employee;
    }

    public Employee updateEmployee(Employee employee) {
        this.employeeRepository.save(employee);
        return employee;
    }

    public void deleteEmployee(long empId) {
        this.employeeRepository.deleteById(empId);
    }

    public List<Employee> getAllEmployees() {
        return (List<Employee>) this.employeeRepository.findAll();
    }
}
