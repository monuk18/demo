package com.employee.connectionpool;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(
        // instead of setting this property, we can exclude the dependency to org.apache.tomcat:tomcat-jdbc in pom.xml
        properties = "spring.datasource.type=com.zaxxer.hikari.HikariDataSource")
public class HikariIntegrationTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void hikariConnectionPoolIsConfigured() {
        assertEquals("com.zaxxer.hikari.HikariDataSource", dataSource.getClass()
                .getName());
    }

}