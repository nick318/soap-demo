package com.nick318.soap.demo.service;

import employees.Employee;

public interface EmployeeService {
    Employee findByName(String name);
}
