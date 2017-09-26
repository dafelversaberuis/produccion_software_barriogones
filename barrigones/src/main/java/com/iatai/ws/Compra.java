/**
 * Compra.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.iatai.ws;

public class Compra  extends com.iatai.ws.CompraTarjetaCredito  implements java.io.Serializable {
    private float iva;

    private float baseDebolucionIva;

    public Compra() {
    }

    public Compra(
           java.lang.String referencia,
           java.lang.String descripcion,
           float valor,
           java.lang.String isoMoneda,
           int numeroCuotas,
           float iva,
           float baseDebolucionIva) {
        super(
            referencia,
            descripcion,
            valor,
            isoMoneda,
            numeroCuotas);
        this.iva = iva;
        this.baseDebolucionIva = baseDebolucionIva;
    }


    /**
     * Gets the iva value for this Compra.
     * 
     * @return iva
     */
    public float getIva() {
        return iva;
    }


    /**
     * Sets the iva value for this Compra.
     * 
     * @param iva
     */
    public void setIva(float iva) {
        this.iva = iva;
    }


    /**
     * Gets the baseDebolucionIva value for this Compra.
     * 
     * @return baseDebolucionIva
     */
    public float getBaseDebolucionIva() {
        return baseDebolucionIva;
    }


    /**
     * Sets the baseDebolucionIva value for this Compra.
     * 
     * @param baseDebolucionIva
     */
    public void setBaseDebolucionIva(float baseDebolucionIva) {
        this.baseDebolucionIva = baseDebolucionIva;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Compra)) return false;
        Compra other = (Compra) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.iva == other.getIva() &&
            this.baseDebolucionIva == other.getBaseDebolucionIva();
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
        _hashCode += new Float(getBaseDebolucionIva()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Compra.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "compra"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("iva");
        elemField.setXmlName(new javax.xml.namespace.QName("", "iva"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("baseDebolucionIva");
        elemField.setXmlName(new javax.xml.namespace.QName("", "baseDebolucionIva"));
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
