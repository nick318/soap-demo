package com.nick318.soap.demo.repository;

import com.nick318.soap.demo.domain.Employee;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class LocalEmployeeRepository implements EmployeeRepository {

    private Map<String, Employee> employees = new HashMap<>();
    private final AtomicInteger counter = new AtomicInteger();

    @PostConstruct
    public void initData() {
        employees = Stream.of(
                createStubbedEmployee(),
                createStubbedEmployee(),
                createStubbedEmployee(),
                createStubbedEmployee(),
                createStubbedEmployee(),
                createStubbedEmployee(),
                createStubbedEmployee(),
                createStubbedEmployee(),
                createStubbedEmployee()
        ).collect(Collectors.toMap(Employee::getFirstName, Function.identity()));
    }


    @Override
    public Employee findByName(String name) {
        return employees.get(name);
    }

    private Employee createStubbedEmployee() {
        return new Employee()
                .setFirstName("Ivan " + counter.incrementAndGet())
                .setLastName("Ivanov")
                .setAddress("Russia")
                .setSalary(new BigDecimal(100));
    }
}
