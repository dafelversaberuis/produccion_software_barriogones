/**
 * SuscripcionTransaccion.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.iatai.ws;

public class SuscripcionTransaccion  implements java.io.Serializable {
    private boolean suscribir;

    private com.iatai.ws.SuscripcionUsuario suscripcionUsuario;

    public SuscripcionTransaccion() {
    }

    public SuscripcionTransaccion(
           boolean suscribir,
           com.iatai.ws.SuscripcionUsuario suscripcionUsuario) {
           this.suscribir = suscribir;
           this.suscripcionUsuario = suscripcionUsuario;
    }


    /**
     * Gets the suscribir value for this SuscripcionTransaccion.
     * 
     * @return suscribir
     */
    public boolean isSuscribir() {
        return suscribir;
    }


    /**
     * Sets the suscribir value for this SuscripcionTransaccion.
     * 
     * @param suscribir
     */
    public void setSuscribir(boolean suscribir) {
        this.suscribir = suscribir;
    }


    /**
     * Gets the suscripcionUsuario value for this SuscripcionTransaccion.
     * 
     * @return suscripcionUsuario
     */
    public com.iatai.ws.SuscripcionUsuario getSuscripcionUsuario() {
        return suscripcionUsuario;
    }


    /**
     * Sets the suscripcionUsuario value for this SuscripcionTransaccion.
     * 
     * @param suscripcionUsuario
     */
    public void setSuscripcionUsuario(com.iatai.ws.SuscripcionUsuario suscripcionUsuario) {
        this.suscripcionUsuario = suscripcionUsuario;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SuscripcionTransaccion)) return false;
        SuscripcionTransaccion other = (SuscripcionTransaccion) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.suscribir == other.isSuscribir() &&
            ((this.suscripcionUsuario==null && other.getSuscripcionUsuario()==null) || 
             (this.suscripcionUsuario!=null &&
              this.suscripcionUsuario.equals(other.getSuscripcionUsuario())));
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
        _hashCode += (isSuscribir() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getSuscripcionUsuario() != null) {
            _hashCode += getSuscripcionUsuario().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SuscripcionTransaccion.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionTransaccion"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("suscribir");
        elemField.setXmlName(new javax.xml.namespace.QName("", "suscribir"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("suscripcionUsuario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SuscripcionUsuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionUsuario"));
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
