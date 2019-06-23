package com.nick318.soap.demo.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class EmployeeDomain {
    private String firstName;
    private String lastName;
    private String address;
    private BigDecimal salary;
}
