package com.nick318.soap.demo.repository;

import com.nick318.soap.demo.domain.EmployeeDomain;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class LocalEmployeeRepository implements EmployeeRepository {

    private Map<String, EmployeeDomain> employees = new HashMap<>();

    @PostConstruct
    public void initData() {
        AtomicInteger counter = new AtomicInteger();
        employees = Stream.of(
                new EmployeeDomain().setFirstName("Ivan " + counter.incrementAndGet()),
                new EmployeeDomain().setFirstName("Ivan " + counter.incrementAndGet()),
                new EmployeeDomain().setFirstName("Ivan " + counter.incrementAndGet()),
                new EmployeeDomain().setFirstName("Ivan " + counter.incrementAndGet()),
                new EmployeeDomain().setFirstName("Ivan " + counter.incrementAndGet()),
                new EmployeeDomain().setFirstName("Ivan " + counter.incrementAndGet()),
                new EmployeeDomain().setFirstName("Ivan " + counter.incrementAndGet()),
                new EmployeeDomain().setFirstName("Ivan " + counter.incrementAndGet()),
                new EmployeeDomain().setFirstName("Ivan " + counter.incrementAndGet()),
                new EmployeeDomain().setFirstName("Ivan " + counter.incrementAndGet())
        ).collect(Collectors.toMap(EmployeeDomain::getFirstName, Function.identity()));
    }


    @Override
    public EmployeeDomain findByName(String name) {
        return employees.get(name);
    }
}
