/**
 * SuscripcionTarjetaCreditoRespuesta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.iatai.ws;

public class SuscripcionTarjetaCreditoRespuesta  implements java.io.Serializable {
    private boolean suscrito;

    private java.lang.String codigoError;

    private com.iatai.ws.SuscripcionRespuesta suscripcionRespuesta;

    public SuscripcionTarjetaCreditoRespuesta() {
    }

    public SuscripcionTarjetaCreditoRespuesta(
           boolean suscrito,
           java.lang.String codigoError,
           com.iatai.ws.SuscripcionRespuesta suscripcionRespuesta) {
           this.suscrito = suscrito;
           this.codigoError = codigoError;
           this.suscripcionRespuesta = suscripcionRespuesta;
    }


    /**
     * Gets the suscrito value for this SuscripcionTarjetaCreditoRespuesta.
     * 
     * @return suscrito
     */
    public boolean isSuscrito() {
        return suscrito;
    }


    /**
     * Sets the suscrito value for this SuscripcionTarjetaCreditoRespuesta.
     * 
     * @param suscrito
     */
    public void setSuscrito(boolean suscrito) {
        this.suscrito = suscrito;
    }


    /**
     * Gets the codigoError value for this SuscripcionTarjetaCreditoRespuesta.
     * 
     * @return codigoError
     */
    public java.lang.String getCodigoError() {
        return codigoError;
    }


    /**
     * Sets the codigoError value for this SuscripcionTarjetaCreditoRespuesta.
     * 
     * @param codigoError
     */
    public void setCodigoError(java.lang.String codigoError) {
        this.codigoError = codigoError;
    }


    /**
     * Gets the suscripcionRespuesta value for this SuscripcionTarjetaCreditoRespuesta.
     * 
     * @return suscripcionRespuesta
     */
    public com.iatai.ws.SuscripcionRespuesta getSuscripcionRespuesta() {
        return suscripcionRespuesta;
    }


    /**
     * Sets the suscripcionRespuesta value for this SuscripcionTarjetaCreditoRespuesta.
     * 
     * @param suscripcionRespuesta
     */
    public void setSuscripcionRespuesta(com.iatai.ws.SuscripcionRespuesta suscripcionRespuesta) {
        this.suscripcionRespuesta = suscripcionRespuesta;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SuscripcionTarjetaCreditoRespuesta)) return false;
        SuscripcionTarjetaCreditoRespuesta other = (SuscripcionTarjetaCreditoRespuesta) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.suscrito == other.isSuscrito() &&
            ((this.codigoError==null && other.getCodigoError()==null) || 
             (this.codigoError!=null &&
              this.codigoError.equals(other.getCodigoError()))) &&
            ((this.suscripcionRespuesta==null && other.getSuscripcionRespuesta()==null) || 
             (this.suscripcionRespuesta!=null &&
              this.suscripcionRespuesta.equals(other.getSuscripcionRespuesta())));
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
        _hashCode += (isSuscrito() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getCodigoError() != null) {
            _hashCode += getCodigoError().hashCode();
        }
        if (getSuscripcionRespuesta() != null) {
            _hashCode += getSuscripcionRespuesta().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SuscripcionTarjetaCreditoRespuesta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionTarjetaCreditoRespuesta"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("suscrito");
        elemField.setXmlName(new javax.xml.namespace.QName("", "suscrito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoError");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codigoError"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("suscripcionRespuesta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionRespuesta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionRespuesta"));
        elemField.setMinOccurs(0);
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
