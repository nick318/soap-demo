package com.nick318.soap.demo.service;

import com.nick318.soap.demo.domain.Employee;
import com.nick318.soap.demo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@RequiredArgsConstructor
@Component
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee findByName(String name) {
        Objects.requireNonNull(name, "Employee name should be not null");
        return employeeRepository.findByName(name);
    }
}
