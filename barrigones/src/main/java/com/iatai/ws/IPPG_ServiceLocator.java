/**
 * IPPG_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.iatai.ws;

public class IPPG_ServiceLocator extends org.apache.axis.client.Service implements com.iatai.ws.IPPG_Service {

    public IPPG_ServiceLocator() {
    }


    public IPPG_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public IPPG_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for IPPGPort
    private java.lang.String IPPGPort_address = "http://pruebas.allegraplatform.com:80/GatewayIatai/IPPG";

    public java.lang.String getIPPGPortAddress() {
        return IPPGPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String IPPGPortWSDDServiceName = "IPPGPort";

    public java.lang.String getIPPGPortWSDDServiceName() {
        return IPPGPortWSDDServiceName;
    }

    public void setIPPGPortWSDDServiceName(java.lang.String name) {
        IPPGPortWSDDServiceName = name;
    }

    public com.iatai.ws.IPPG_PortType getIPPGPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(IPPGPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getIPPGPort(endpoint);
    }

    public com.iatai.ws.IPPG_PortType getIPPGPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.iatai.ws.IPPGPortBindingStub _stub = new com.iatai.ws.IPPGPortBindingStub(portAddress, this);
            _stub.setPortName(getIPPGPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setIPPGPortEndpointAddress(java.lang.String address) {
        IPPGPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.iatai.ws.IPPG_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.iatai.ws.IPPGPortBindingStub _stub = new com.iatai.ws.IPPGPortBindingStub(new java.net.URL(IPPGPort_address), this);
                _stub.setPortName(getIPPGPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("IPPGPort".equals(inputPortName)) {
            return getIPPGPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.iatai.com/", "IPPG");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.iatai.com/", "IPPGPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("IPPGPort".equals(portName)) {
            setIPPGPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
