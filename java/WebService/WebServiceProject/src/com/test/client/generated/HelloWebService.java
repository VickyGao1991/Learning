
package com.test.client.generated;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "HelloWebService", targetNamespace = "http://services.test.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface HelloWebService {


    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "bye", targetNamespace = "http://services.test.com/", className = "com.test.client.generated.Bye")
    @ResponseWrapper(localName = "byeResponse", targetNamespace = "http://services.test.com/", className = "com.test.client.generated.ByeResponse")
    @Action(input = "http://services.test.com/HelloWebService/byeRequest", output = "http://services.test.com/HelloWebService/byeResponse")
    public String bye();

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "hello", targetNamespace = "http://services.test.com/", className = "com.test.client.generated.Hello")
    @ResponseWrapper(localName = "helloResponse", targetNamespace = "http://services.test.com/", className = "com.test.client.generated.HelloResponse")
    @Action(input = "http://services.test.com/HelloWebService/helloRequest", output = "http://services.test.com/HelloWebService/helloResponse")
    public String hello(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}