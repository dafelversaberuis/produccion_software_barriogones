/**
 * Compra_.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.iatai.ws;

public class Compra_  extends com.iatai.ws.CompraTarjetaCredito  implements java.io.Serializable {
    private float iva;

    private float baseDevolucionIva;

    public Compra_() {
    }

    public Compra_(
           java.lang.String referencia,
           java.lang.String descripcion,
           float valor,
           java.lang.String isoMoneda,
           int numeroCuotas,
           float iva,
           float baseDevolucionIva) {
        super(
            referencia,
            descripcion,
            valor,
            isoMoneda,
            numeroCuotas);
        this.iva = iva;
        this.baseDevolucionIva = baseDevolucionIva;
    }


    /**
     * Gets the iva value for this Compra_.
     * 
     * @return iva
     */
    public float getIva() {
        return iva;
    }


    /**
     * Sets the iva value for this Compra_.
     * 
     * @param iva
     */
    public void setIva(float iva) {
        this.iva = iva;
    }


    /**
     * Gets the baseDevolucionIva value for this Compra_.
     * 
     * @return baseDevolucionIva
     */
    public float getBaseDevolucionIva() {
        return baseDevolucionIva;
    }


    /**
     * Sets the baseDevolucionIva value for this Compra_.
     * 
     * @param baseDevolucionIva
     */
    public void setBaseDevolucionIva(float baseDevolucionIva) {
        this.baseDevolucionIva = baseDevolucionIva;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Compra_)) return false;
        Compra_ other = (Compra_) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.iva == other.getIva() &&
            this.baseDevolucionIva == other.getBaseDevolucionIva();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        _hashCode += new Float(getIva()).hashCode();
        _hashCode += new Float(getBaseDevolucionIva()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Compra_.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "compra_"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("iva");
        elemField.setXmlName(new javax.xml.namespace.QName("", "iva"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("baseDevolucionIva");
        elemField.setXmlName(new javax.xml.namespace.QName("", "baseDevolucionIva"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
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
