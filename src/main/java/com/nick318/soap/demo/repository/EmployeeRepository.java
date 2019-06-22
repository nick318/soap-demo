package com.nick318.soap.demo.repository;


import employees.Employee;

/**
 * Repository for employees.
 *
 * @author Nikita_Salomatin
 */
public interface EmployeeRepository {
    Employee findByName(String name);
}
