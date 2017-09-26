/**
 * FraudeBase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.iatai.ws;

public class FraudeBase  implements java.io.Serializable {
    private java.lang.String ipComprador;

    private java.lang.String hostComprador;

    private java.lang.String cookie;

    private java.lang.String userAgent;

    private java.lang.String deviceFingerPrint;

    public FraudeBase() {
    }

    public FraudeBase(
           java.lang.String ipComprador,
           java.lang.String hostComprador,
           java.lang.String cookie,
           java.lang.String userAgent,
           java.lang.String deviceFingerPrint) {
           this.ipComprador = ipComprador;
           this.hostComprador = hostComprador;
           this.cookie = cookie;
           this.userAgent = userAgent;
           this.deviceFingerPrint = deviceFingerPrint;
    }


    /**
     * Gets the ipComprador value for this FraudeBase.
     * 
     * @return ipComprador
     */
    public java.lang.String getIpComprador() {
        return ipComprador;
    }


    /**
     * Sets the ipComprador value for this FraudeBase.
     * 
     * @param ipComprador
     */
    public void setIpComprador(java.lang.String ipComprador) {
        this.ipComprador = ipComprador;
    }


    /**
     * Gets the hostComprador value for this FraudeBase.
     * 
     * @return hostComprador
     */
    public java.lang.String getHostComprador() {
        return hostComprador;
    }


    /**
     * Sets the hostComprador value for this FraudeBase.
     * 
     * @param hostComprador
     */
    public void setHostComprador(java.lang.String hostComprador) {
        this.hostComprador = hostComprador;
    }


    /**
     * Gets the cookie value for this FraudeBase.
     * 
     * @return cookie
     */
    public java.lang.String getCookie() {
        return cookie;
    }


    /**
     * Sets the cookie value for this FraudeBase.
     * 
     * @param cookie
     */
    public void setCookie(java.lang.String cookie) {
        this.cookie = cookie;
    }


    /**
     * Gets the userAgent value for this FraudeBase.
     * 
     * @return userAgent
     */
    public java.lang.String getUserAgent() {
        return userAgent;
    }


    /**
     * Sets the userAgent value for this FraudeBase.
     * 
     * @param userAgent
     */
    public void setUserAgent(java.lang.String userAgent) {
        this.userAgent = userAgent;
    }


    /**
     * Gets the deviceFingerPrint value for this FraudeBase.
     * 
     * @return deviceFingerPrint
     */
    public java.lang.String getDeviceFingerPrint() {
        return deviceFingerPrint;
    }


    /**
     * Sets the deviceFingerPrint value for this FraudeBase.
     * 
     * @param deviceFingerPrint
     */
    public void setDeviceFingerPrint(java.lang.String deviceFingerPrint) {
        this.deviceFingerPrint = deviceFingerPrint;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FraudeBase)) return false;
        FraudeBase other = (FraudeBase) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ipComprador==null && other.getIpComprador()==null) || 
             (this.ipComprador!=null &&
              this.ipComprador.equals(other.getIpComprador()))) &&
            ((this.hostComprador==null && other.getHostComprador()==null) || 
             (this.hostComprador!=null &&
              this.hostComprador.equals(other.getHostComprador()))) &&
            ((this.cookie==null && other.getCookie()==null) || 
             (this.cookie!=null &&
              this.cookie.equals(other.getCookie()))) &&
            ((this.userAgent==null && other.getUserAgent()==null) || 
             (this.userAgent!=null &&
              this.userAgent.equals(other.getUserAgent()))) &&
            ((this.deviceFingerPrint==null && other.getDeviceFingerPrint()==null) || 
             (this.deviceFingerPrint!=null &&
              this.deviceFingerPrint.equals(other.getDeviceFingerPrint())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getIpComprador() != null) {
            _hashCode += getIpComprador().hashCode();
        }
        if (getHostComprador() != null) {
            _hashCode += getHostComprador().hashCode();
        }
        if (getCookie() != null) {
            _hashCode += getCookie().hashCode();
        }
        if (getUserAgent() != null) {
            _hashCode += getUserAgent().hashCode();
        }
        if (getDeviceFingerPrint() != null) {
            _hashCode += getDeviceFingerPrint().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FraudeBase.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "FraudeBase"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ipComprador");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ipComprador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hostComprador");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hostComprador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cookie");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cookie"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userAgent");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userAgent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deviceFingerPrint");
        elemField.setXmlName(new javax.xml.namespace.QName("", "deviceFingerPrint"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
