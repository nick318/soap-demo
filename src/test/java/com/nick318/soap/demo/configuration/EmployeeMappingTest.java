package com.nick318.soap.demo.configuration;

import com.nick318.soap.demo.domain.Employee;
import employees.EmployeeDto;
import ma.glasnost.orika.MapperFacade;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@ContextConfiguration(classes = MapperTestConfig.class)
@RunWith(SpringRunner.class)
public class EmployeeMappingTest {

    @Autowired
    private MapperFacade mapperFacade;

    @Test
    public void shouldMapDomainEmployeeToDto() {
        Employee domain = new Employee()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setAddress("Russia")
                .setSalary(new BigDecimal(100));

        EmployeeDto dto = mapperFacade.map(domain, EmployeeDto.class);

        Assert.assertEquals("Ivan", dto.getFirstName());
        Assert.assertEquals("Ivanov", dto.getLastName());
        Assert.assertEquals(domain.getAddress(), dto.getAddress());
    }

    @Test
    public void shouldSplitDtoNameIntoTwoParts() {
        EmployeeDto dto = new EmployeeDto();
        dto.setFirstName("Ivan");
        dto.setLastName("Ivanov");

        Employee domain = mapperFacade.map(dto, Employee.class);

        Assert.assertEquals("Ivan", domain.getFirstName());
        Assert.assertEquals("Ivanov", domain.getLastName());
    }

    @Test
    public void shouldWorkWithNullNames() {
        EmployeeDto dto = new EmployeeDto();
        dto.setFirstName(null);
        dto.setLastName(null);

        Employee domain = mapperFacade.map(dto, Employee.class);

        Assert.assertNull(domain.getFirstName());
        Assert.assertNull(domain.getLastName());
    }


    @Test
    public void shouldMapDomainEmployeeToDtoForNullNames() {
        Employee domain = new Employee()
                .setFirstName(null)
                .setLastName(null);

        EmployeeDto dto = mapperFacade.map(domain, EmployeeDto.class);

        Assert.assertNull(dto.getFirstName());
        Assert.assertNull(dto.getLastName());
    }
}