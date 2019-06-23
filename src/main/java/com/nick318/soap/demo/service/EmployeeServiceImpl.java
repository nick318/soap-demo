package com.nick318.soap.demo.service;

import com.nick318.soap.demo.ErrorHandler;
import com.nick318.soap.demo.repository.EmployeeRepository;
import employees.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee findByName(String name) {
        ErrorHandler.requireNotNull(name);
        return employeeRepository.findByName(name);
    }
}
