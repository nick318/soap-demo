package com.nick318.soap.demo.service;

import com.nick318.soap.demo.domain.Employee;

public interface EmployeeService {
    Employee findByName(String name);
}
