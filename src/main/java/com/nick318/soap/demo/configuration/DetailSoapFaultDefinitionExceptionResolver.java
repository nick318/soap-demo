package com.nick318.soap.demo.configuration;

import com.nick318.soap.demo.exception.ServiceFaultException;
import employees.ServiceStatus;
import org.springframework.ws.soap.SoapFault;
import org.springframework.ws.soap.SoapFaultDetail;
import org.springframework.ws.soap.server.endpoint.SoapFaultMappingExceptionResolver;

import javax.xml.namespace.QName;

public class DetailSoapFaultDefinitionExceptionResolver extends SoapFaultMappingExceptionResolver {

    private static final QName CODE = new QName("statusCode");
    private static final QName MESSAGE = new QName("message");

    @Override
    protected void customizeFault(Object endpoint, Exception ex, SoapFault fault) {
        logger.warn("Exception processed ", ex);
        if (ex instanceof NullPointerException) {
            SoapFaultDetail detail = fault.addFaultDetail();
            detail.addFaultDetailElement(CODE).addText("500");
            detail.addFaultDetailElement(MESSAGE).addText(ex.getMessage());
        }
        if (ex instanceof ServiceFaultException) {
            ServiceStatus status = ((ServiceFaultException) ex).getServiceStatus();
            SoapFaultDetail detail = fault.addFaultDetail();
            detail.addFaultDetailElement(CODE).addText(status.getStatusCode());
            detail.addFaultDetailElement(MESSAGE).addText(status.getMessage());
        }
    }
}
