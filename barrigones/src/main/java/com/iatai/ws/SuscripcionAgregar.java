/**
 * SuscripcionAgregar.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.iatai.ws;

public class SuscripcionAgregar  implements java.io.Serializable {
    private java.lang.String suscripcionID;

    private com.iatai.ws.SuscripcionUsuario suscripcionUsuario;

    private com.iatai.ws.SuscripcionVerificacion suscripcionVerificacion;

    private com.iatai.ws.SuscripcionFraudeValidacion suscripcionFraudeValidacion;

    public SuscripcionAgregar() {
    }

    public SuscripcionAgregar(
           java.lang.String suscripcionID,
           com.iatai.ws.SuscripcionUsuario suscripcionUsuario,
           com.iatai.ws.SuscripcionVerificacion suscripcionVerificacion,
           com.iatai.ws.SuscripcionFraudeValidacion suscripcionFraudeValidacion) {
           this.suscripcionID = suscripcionID;
           this.suscripcionUsuario = suscripcionUsuario;
           this.suscripcionVerificacion = suscripcionVerificacion;
           this.suscripcionFraudeValidacion = suscripcionFraudeValidacion;
    }


    /**
     * Gets the suscripcionID value for this SuscripcionAgregar.
     * 
     * @return suscripcionID
     */
    public java.lang.String getSuscripcionID() {
        return suscripcionID;
    }


    /**
     * Sets the suscripcionID value for this SuscripcionAgregar.
     * 
     * @param suscripcionID
     */
    public void setSuscripcionID(java.lang.String suscripcionID) {
        this.suscripcionID = suscripcionID;
    }


    /**
     * Gets the suscripcionUsuario value for this SuscripcionAgregar.
     * 
     * @return suscripcionUsuario
     */
    public com.iatai.ws.SuscripcionUsuario getSuscripcionUsuario() {
        return suscripcionUsuario;
    }


    /**
     * Sets the suscripcionUsuario value for this SuscripcionAgregar.
     * 
     * @param suscripcionUsuario
     */
    public void setSuscripcionUsuario(com.iatai.ws.SuscripcionUsuario suscripcionUsuario) {
        this.suscripcionUsuario = suscripcionUsuario;
    }


    /**
     * Gets the suscripcionVerificacion value for this SuscripcionAgregar.
     * 
     * @return suscripcionVerificacion
     */
    public com.iatai.ws.SuscripcionVerificacion getSuscripcionVerificacion() {
        return suscripcionVerificacion;
    }


    /**
     * Sets the suscripcionVerificacion value for this SuscripcionAgregar.
     * 
     * @param suscripcionVerificacion
     */
    public void setSuscripcionVerificacion(com.iatai.ws.SuscripcionVerificacion suscripcionVerificacion) {
        this.suscripcionVerificacion = suscripcionVerificacion;
    }


    /**
     * Gets the suscripcionFraudeValidacion value for this SuscripcionAgregar.
     * 
     * @return suscripcionFraudeValidacion
     */
    public com.iatai.ws.SuscripcionFraudeValidacion getSuscripcionFraudeValidacion() {
        return suscripcionFraudeValidacion;
    }


    /**
     * Sets the suscripcionFraudeValidacion value for this SuscripcionAgregar.
     * 
     * @param suscripcionFraudeValidacion
     */
    public void setSuscripcionFraudeValidacion(com.iatai.ws.SuscripcionFraudeValidacion suscripcionFraudeValidacion) {
        this.suscripcionFraudeValidacion = suscripcionFraudeValidacion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SuscripcionAgregar)) return false;
        SuscripcionAgregar other = (SuscripcionAgregar) obj;
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
            ((this.suscripcionUsuario==null && other.getSuscripcionUsuario()==null) || 
             (this.suscripcionUsuario!=null &&
              this.suscripcionUsuario.equals(other.getSuscripcionUsuario()))) &&
            ((this.suscripcionVerificacion==null && other.getSuscripcionVerificacion()==null) || 
             (this.suscripcionVerificacion!=null &&
              this.suscripcionVerificacion.equals(other.getSuscripcionVerificacion()))) &&
            ((this.suscripcionFraudeValidacion==null && other.getSuscripcionFraudeValidacion()==null) || 
             (this.suscripcionFraudeValidacion!=null &&
              this.suscripcionFraudeValidacion.equals(other.getSuscripcionFraudeValidacion())));
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
        if (getSuscripcionUsuario() != null) {
            _hashCode += getSuscripcionUsuario().hashCode();
        }
        if (getSuscripcionVerificacion() != null) {
            _hashCode += getSuscripcionVerificacion().hashCode();
        }
        if (getSuscripcionFraudeValidacion() != null) {
            _hashCode += getSuscripcionFraudeValidacion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SuscripcionAgregar.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionAgregar"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("suscripcionID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "suscripcionID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("suscripcionUsuario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SuscripcionUsuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionUsuario"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("suscripcionVerificacion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SuscripcionVerificacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionVerificacion"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("suscripcionFraudeValidacion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "suscripcionFraudeValidacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "SuscripcionFraudeValidacion"));
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
