/**
 * Suscripcion.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.iatai.ws;

public class Suscripcion  implements java.io.Serializable {
    private com.iatai.ws.SuscripcionCompra suscripcionCompra;

    private com.iatai.ws.SuscripcionTarjetaCredito suscripcionTarjetaCredito;

    private com.iatai.ws.SuscripcionTitular suscripcionTitular;

    private com.iatai.ws.SuscripcionUsuario suscripcionUsuario;

    private com.iatai.ws.SuscripcionFraudeValidacion suscripcionFraudeValidacion;

    public Suscripcion() {
    }

    public Suscripcion(
           com.iatai.ws.SuscripcionCompra suscripcionCompra,
           com.iatai.ws.SuscripcionTarjetaCredito suscripcionTarjetaCredito,
           com.iatai.ws.SuscripcionTitular suscripcionTitular,
           com.iatai.ws.SuscripcionUsuario suscripcionUsuario,
           com.iatai.ws.SuscripcionFraudeValidacion suscripcionFraudeValidacion) {
           this.suscripcionCompra = suscripcionCompra;
           this.suscripcionTarjetaCredito = suscripcionTarjetaCredito;
           this.suscripcionTitular = suscripcionTitular;
           this.suscripcionUsuario = suscripcionUsuario;
           this.suscripcionFraudeValidacion = suscripcionFraudeValidacion;
    }


    /**
     * Gets the suscripcionCompra value for this Suscripcion.
     * 
     * @return suscripcionCompra
     */
    public com.iatai.ws.SuscripcionCompra getSuscripcionCompra() {
        return suscripcionCompra;
    }


    /**
     * Sets the suscripcionCompra value for this Suscripcion.
     * 
     * @param suscripcionCompra
     */
    public void setSuscripcionCompra(com.iatai.ws.SuscripcionCompra suscripcionCompra) {
        this.suscripcionCompra = suscripcionCompra;
    }


    /**
     * Gets the suscripcionTarjetaCredito value for this Suscripcion.
     * 
     * @return suscripcionTarjetaCredito
     */
    public com.iatai.ws.SuscripcionTarjetaCredito getSuscripcionTarjetaCredito() {
        return suscripcionTarjetaCredito;
    }


    /**
     * Sets the suscripcionTarjetaCredito value for this Suscripcion.
     * 
     * @param suscripcionTarjetaCredito
     */
    public void setSuscripcionTarjetaCredito(com.iatai.ws.SuscripcionTarjetaCredito suscripcionTarjetaCredito) {
        this.suscripcionTarjetaCredito = suscripcionTarjetaCredito;
    }


    /**
     * Gets the suscripcionTitular value for this Suscripcion.
     * 
     * @return suscripcionTitular
     */
    public com.iatai.ws.SuscripcionTitular getSuscripcionTitular() {
        return suscripcionTitular;
    }


    /**
     * Sets the suscripcionTitular value for this Suscripcion.
     * 
     * @param suscripcionTitular
     */
    public void setSuscripcionTitular(com.iatai.ws.SuscripcionTitular suscripcionTitular) {
        this.suscripcionTitular = suscripcionTitular;
    }


    /**
     * Gets the suscripcionUsuario value for this Suscripcion.
     * 
     * @return suscripcionUsuario
     */
    public com.iatai.ws.SuscripcionUsuario getSuscripcionUsuario() {
        return suscripcionUsuario;
    }


    /**
     * Sets the suscripcionUsuario value for this Suscripcion.
     * 
     * @param suscripcionUsuario
     */
    public void setSuscripcionUsuario(com.iatai.ws.SuscripcionUsuario suscripcionUsuario) {
        this.suscripcionUsuario = suscripcionUsuario;
    }


    /**
     * Gets the suscripcionFraudeValidacion value for this Suscripcion.
     * 
     * @return suscripcionFraudeValidacion
     */
    public com.iatai.ws.SuscripcionFraudeValidacion getSuscripcionFraudeValidacion() {
        return suscripcionFraudeValidacion;
    }


    /**
     * Sets the suscripcionFraudeValidacion value for this Suscripcion.
     * 
     * @param suscripcionFraudeValidacion
     */
    public void setSuscripcionFraudeValidacion(com.iatai.ws.SuscripcionFraudeValidacion suscripcionFraudeValidacion) {
        this.suscripcionFraudeValidacion = suscripcionFraudeValidacion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Suscripcion)) return false;
        Suscripcion other = (Suscripcion) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.suscripcionCompra==null && other.getSuscripcionCompra()==null) || 
             (this.suscripcionCompra!=null &&
              this.suscripcionCompra.equals(other.getSuscripcionCompra()))) &&
            ((this.suscripcionTarjetaCredito==null && other.getSuscripcionTarjetaCredito()==null) || 
             (this.suscripcionTarjetaCredito!=null &&
              this.suscripcionTarjetaCredito.equals(other.getSuscripcionTarjetaCredito()))) &&
            ((this.suscripcionTitular==null && other.getSuscripcionTitular()==null) || 
             (this.suscripcionTitular!=null &&
              this.suscripcionTitular.equals(other.getSuscripcionTitular()))) &&
            ((this.suscripcionUsuario==null && other.getSuscripcionUsuario()==null) || 
             (this.suscripcionUsuario!=null &&
              this.suscripcionUsuario.equals(other.getSuscripcionUsuario()))) &&
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
        if (getSuscripcionCompra() != null) {
            _hashCode += getSuscripcionCompra().hashCode();
        }
        if (getSuscripcionTarjetaCredito() != null) {
            _hashCode += getSuscripcionTarjetaCredito().hashCode();
        }
        if (getSuscripcionTitular() != null) {
            _hashCode += getSuscripcionTitular().hashCode();
        }
        if (getSuscripcionUsuario() != null) {
            _hashCode += getSuscripcionUsuario().hashCode();
        }
        if (getSuscripcionFraudeValidacion() != null) {
            _hashCode += getSuscripcionFraudeValidacion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Suscripcion.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcion"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("suscripcionCompra");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SuscripcionCompra"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionCompra"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("suscripcionTarjetaCredito");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SuscripcionTarjetaCredito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionTarjetaCredito"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("suscripcionTitular");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SuscripcionTitular"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionTitular"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("suscripcionUsuario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SuscripcionUsuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionUsuario"));
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
