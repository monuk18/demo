package com.employee.demo.repository;


import com.employee.demo.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    public Optional<Employee> findByEmpId(long id);
    public Optional<Employee> findByFirstName(String s);

}
