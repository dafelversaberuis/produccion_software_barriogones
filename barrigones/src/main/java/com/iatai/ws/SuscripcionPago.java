/**
 * SuscripcionPago.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.iatai.ws;

public class SuscripcionPago  implements java.io.Serializable {
    private java.lang.String suscripcionID;

    private java.lang.String codigoSeguridad;

    public SuscripcionPago() {
    }

    public SuscripcionPago(
           java.lang.String suscripcionID,
           java.lang.String codigoSeguridad) {
           this.suscripcionID = suscripcionID;
           this.codigoSeguridad = codigoSeguridad;
    }


    /**
     * Gets the suscripcionID value for this SuscripcionPago.
     * 
     * @return suscripcionID
     */
    public java.lang.String getSuscripcionID() {
        return suscripcionID;
    }


    /**
     * Sets the suscripcionID value for this SuscripcionPago.
     * 
     * @param suscripcionID
     */
    public void setSuscripcionID(java.lang.String suscripcionID) {
        this.suscripcionID = suscripcionID;
    }


    /**
     * Gets the codigoSeguridad value for this SuscripcionPago.
     * 
     * @return codigoSeguridad
     */
    public java.lang.String getCodigoSeguridad() {
        return codigoSeguridad;
    }


    /**
     * Sets the codigoSeguridad value for this SuscripcionPago.
     * 
     * @param codigoSeguridad
     */
    public void setCodigoSeguridad(java.lang.String codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SuscripcionPago)) return false;
        SuscripcionPago other = (SuscripcionPago) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.suscripcionID==null && other.getSuscripcionID()==null) || 
             (this.suscripcionID!=null &&
              this.suscripcionID.equals(other.getSuscripcionID()))) &&
            ((this.codigoSeguridad==null && other.getCodigoSeguridad()==null) || 
             (this.codigoSeguridad!=null &&
              this.codigoSeguridad.equals(other.getCodigoSeguridad())));
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
        if (getSuscripcionID() != null) {
            _hashCode += getSuscripcionID().hashCode();
        }
        if (getCodigoSeguridad() != null) {
            _hashCode += getCodigoSeguridad().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SuscripcionPago.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionPago"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("suscripcionID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "suscripcionID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoSeguridad");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codigoSeguridad"));
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
