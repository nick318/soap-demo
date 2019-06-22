package com.nick318.soap.demo.endpoint;

import com.nick318.soap.demo.repository.EmployeeRepository;
import employees.EmployeeDetailsRequest;
import employees.EmployeeDetailsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class EmployeeEndpoint
{
    public static final String NAMESPACE_URI = "employees";

    private final EmployeeRepository EmployeeRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "EmployeeDetailsRequest")
    @ResponsePayload
    public EmployeeDetailsResponse getEmployee(@RequestPayload EmployeeDetailsRequest request) {
        EmployeeDetailsResponse response = new EmployeeDetailsResponse();
        response.setEmployee(EmployeeRepository.findByName(request.getName()));
        return response;
    }
}