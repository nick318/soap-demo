package com.nick318.soap.demo.configuration;

import net.rakugakibox.spring.boot.orika.OrikaAutoConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Import;

@TestConfiguration
@Import({MapperConfig.class, OrikaAutoConfiguration.class})
public class MapperTestConfig {
}
