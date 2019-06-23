package com.nick318.soap.demo.configuration;

import com.nick318.soap.demo.domain.EmployeeDomain;
import employees.Employee;
import ma.glasnost.orika.MapperFactory;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig implements OrikaMapperFactoryConfigurer {
    @Override
    public void configure(MapperFactory mapperFactory) {
        mapperFactory.classMap(EmployeeDomain.class, Employee.class)
                .byDefault()
                .register();
    }
}
