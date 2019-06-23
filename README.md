# soap-demo

Demo project to show work example with soap.

# Install
mvn clean install
<br>java -jar demo-0.0.1-SNAPSHOT.jar

Wsdl is allowed by - http://localhost:8080/service/employeeDetailsWsdl.wsdl

Then you can create project inside SoapUI using given WSDL

Example of request:<br>
<code>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:emp="employees">
   <soapenv:Header/>
   <soapenv:Body>
      <emp:EmployeeDetailsRequest>
         <emp:name>Ivan 1</emp:name>
      </emp:EmployeeDetailsRequest>
   </soapenv:Body>
</soapenv:Envelope>
</code>

Answer:<br>
<code>
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header/>
   <SOAP-ENV:Body>
      <ns2:EmployeeDetailsResponse xmlns:ns2="employees">
         <ns2:Employee>
            <ns2:firstName>Ivan 1</ns2:firstName>
            <ns2:lastName>Ivanov</ns2:lastName>
            <ns2:address>Russia</ns2:address>
         </ns2:Employee>
      </ns2:EmployeeDetailsResponse>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
</code>

