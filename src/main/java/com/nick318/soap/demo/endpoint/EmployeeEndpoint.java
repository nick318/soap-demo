package com.nick318.soap.demo.endpoint;

import com.nick318.soap.demo.domain.Employee;
import com.nick318.soap.demo.service.EmployeeService;
import employees.EmployeeDto;
import employees.EmployeeDetailsRequest;
import employees.EmployeeDetailsResponse;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class EmployeeEndpoint
{
    public static final String NAMESPACE_URI = "employees";

    private final EmployeeService employeeService;
    private final MapperFacade mapperFacade;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "EmployeeDetailsRequest")
    @ResponsePayload
    public EmployeeDetailsResponse getEmployee(@RequestPayload EmployeeDetailsRequest request) {
        Employee domain = employeeService.findByName(request.getName());
        EmployeeDetailsResponse response = new EmployeeDetailsResponse();
        response.setEmployee(mapperFacade.map(domain, EmployeeDto.class));
        return response;
    }
}