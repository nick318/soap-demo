package com.nick318.soap.demo.repository;


import com.nick318.soap.demo.domain.EmployeeDomain;

/**
 * Repository for employees.
 *
 * @author Nikita_Salomatin
 */
public interface EmployeeRepository {
    EmployeeDomain findByName(String name);
}
