package com.nick318.soap.demo.repository;


import com.nick318.soap.demo.domain.Employee;

/**
 * Repository for employees.
 *
 * @author Nikita_Salomatin
 */
public interface EmployeeRepository {
    Employee findByName(String name);
}
