package com.nick318.soap.demo.repository;

import org.springframework.stereotype.Component;
import employees.Employee;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class LocalEmployeeRepository implements EmployeeRepository {

    private final Map<String, Employee> employees = new HashMap<>();

    @PostConstruct
    public void initData() {

    }


    @Override
    public Employee findByName(String name) {
        return employees.get(name);
    }
}
