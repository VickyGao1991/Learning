
package com.test.client.generated;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "HelloWebServiceService", targetNamespace = "http://services.test.com/", wsdlLocation = "http://localhost:8080/helloWebService?wsdl")
public class HelloWebServiceService
    extends Service
{

    private final static URL HELLOWEBSERVICESERVICE_WSDL_LOCATION;
    private final static WebServiceException HELLOWEBSERVICESERVICE_EXCEPTION;
    private final static QName HELLOWEBSERVICESERVICE_QNAME = new QName("http://services.test.com/", "HelloWebServiceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/helloWebService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        HELLOWEBSERVICESERVICE_WSDL_LOCATION = url;
        HELLOWEBSERVICESERVICE_EXCEPTION = e;
    }

    public HelloWebServiceService() {
        super(__getWsdlLocation(), HELLOWEBSERVICESERVICE_QNAME);
    }

    public HelloWebServiceService(WebServiceFeature... features) {
        super(__getWsdlLocation(), HELLOWEBSERVICESERVICE_QNAME, features);
    }

    public HelloWebServiceService(URL wsdlLocation) {
        super(wsdlLocation, HELLOWEBSERVICESERVICE_QNAME);
    }

    public HelloWebServiceService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, HELLOWEBSERVICESERVICE_QNAME, features);
    }

    public HelloWebServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HelloWebServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns HelloWebService
     */
    @WebEndpoint(name = "HelloWebServicePort")
    public HelloWebService getHelloWebServicePort() {
        return super.getPort(new QName("http://services.test.com/", "HelloWebServicePort"), HelloWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns HelloWebService
     */
    @WebEndpoint(name = "HelloWebServicePort")
    public HelloWebService getHelloWebServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://services.test.com/", "HelloWebServicePort"), HelloWebService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (HELLOWEBSERVICESERVICE_EXCEPTION!= null) {
            throw HELLOWEBSERVICESERVICE_EXCEPTION;
        }
        return HELLOWEBSERVICESERVICE_WSDL_LOCATION;
    }

}
