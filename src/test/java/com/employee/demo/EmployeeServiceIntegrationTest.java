package com.employee.demo;

import com.employee.demo.entity.Employee;
import com.employee.demo.repository.EmployeeRepository;
import com.employee.demo.service.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class EmployeeServiceIntegrationTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenValidName_thenEmployeeShouldBeFound() {
        String name = "alex";
        Employee alex = new Employee("alex");
        Mockito.when(employeeRepository.findByFirstName(name))
                .thenReturn(java.util.Optional.of(alex));
        Employee found = employeeService.getEmployeeByFirstName(name);
        assertEquals(found.getFirstName(), name);
    }
}
