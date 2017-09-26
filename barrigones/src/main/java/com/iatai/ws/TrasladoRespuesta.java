/**
 * TrasladoRespuesta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.iatai.ws;

public class TrasladoRespuesta  implements java.io.Serializable {
    private boolean trasladado;

    private java.lang.String codigoError;

    private com.iatai.ws.TransaccionRespuestaBase transaccionRespuesta;

    public TrasladoRespuesta() {
    }

    public TrasladoRespuesta(
           boolean trasladado,
           java.lang.String codigoError,
           com.iatai.ws.TransaccionRespuestaBase transaccionRespuesta) {
           this.trasladado = trasladado;
           this.codigoError = codigoError;
           this.transaccionRespuesta = transaccionRespuesta;
    }


    /**
     * Gets the trasladado value for this TrasladoRespuesta.
     * 
     * @return trasladado
     */
    public boolean isTrasladado() {
        return trasladado;
    }


    /**
     * Sets the trasladado value for this TrasladoRespuesta.
     * 
     * @param trasladado
     */
    public void setTrasladado(boolean trasladado) {
        this.trasladado = trasladado;
    }


    /**
     * Gets the codigoError value for this TrasladoRespuesta.
     * 
     * @return codigoError
     */
    public java.lang.String getCodigoError() {
        return codigoError;
    }


    /**
     * Sets the codigoError value for this TrasladoRespuesta.
     * 
     * @param codigoError
     */
    public void setCodigoError(java.lang.String codigoError) {
        this.codigoError = codigoError;
    }


    /**
     * Gets the transaccionRespuesta value for this TrasladoRespuesta.
     * 
     * @return transaccionRespuesta
     */
    public com.iatai.ws.TransaccionRespuestaBase getTransaccionRespuesta() {
        return transaccionRespuesta;
    }


    /**
     * Sets the transaccionRespuesta value for this TrasladoRespuesta.
     * 
     * @param transaccionRespuesta
     */
    public void setTransaccionRespuesta(com.iatai.ws.TransaccionRespuestaBase transaccionRespuesta) {
        this.transaccionRespuesta = transaccionRespuesta;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TrasladoRespuesta)) return false;
        TrasladoRespuesta other = (TrasladoRespuesta) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.trasladado == other.isTrasladado() &&
            ((this.codigoError==null && other.getCodigoError()==null) || 
             (this.codigoError!=null &&
              this.codigoError.equals(other.getCodigoError()))) &&
            ((this.transaccionRespuesta==null && other.getTransaccionRespuesta()==null) || 
             (this.transaccionRespuesta!=null &&
              this.transaccionRespuesta.equals(other.getTransaccionRespuesta())));
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
        _hashCode += (isTrasladado() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getCodigoError() != null) {
            _hashCode += getCodigoError().hashCode();
        }
        if (getTransaccionRespuesta() != null) {
            _hashCode += getTransaccionRespuesta().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TrasladoRespuesta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "trasladoRespuesta"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("trasladado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "trasladado"));
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
        elemField.setFieldName("transaccionRespuesta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transaccionRespuesta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "transaccionRespuestaBase"));
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
