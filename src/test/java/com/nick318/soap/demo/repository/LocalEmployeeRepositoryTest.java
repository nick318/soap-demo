package com.nick318.soap.demo.repository;

import com.nick318.soap.demo.domain.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LocalEmployeeRepositoryTest {

    private LocalEmployeeRepository repository = new LocalEmployeeRepository();

    @Before
    public void setUp() throws Exception {
        repository.initData();
    }

    @Test
    public void shouldReturnOneEmployee() {
        Employee domain = repository.findByName("Ivan 1");
        Assert.assertNotNull(domain);
        Assert.assertEquals("Ivan 1", domain.getFirstName());
    }
}