/**
 * TarjetaCreditoCS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.iatai.ws;

public class TarjetaCreditoCS  implements java.io.Serializable {
    private int franquicia;

    private java.lang.String binTarjeta;

    public TarjetaCreditoCS() {
    }

    public TarjetaCreditoCS(
           int franquicia,
           java.lang.String binTarjeta) {
           this.franquicia = franquicia;
           this.binTarjeta = binTarjeta;
    }


    /**
     * Gets the franquicia value for this TarjetaCreditoCS.
     * 
     * @return franquicia
     */
    public int getFranquicia() {
        return franquicia;
    }


    /**
     * Sets the franquicia value for this TarjetaCreditoCS.
     * 
     * @param franquicia
     */
    public void setFranquicia(int franquicia) {
        this.franquicia = franquicia;
    }


    /**
     * Gets the binTarjeta value for this TarjetaCreditoCS.
     * 
     * @return binTarjeta
     */
    public java.lang.String getBinTarjeta() {
        return binTarjeta;
    }


    /**
     * Sets the binTarjeta value for this TarjetaCreditoCS.
     * 
     * @param binTarjeta
     */
    public void setBinTarjeta(java.lang.String binTarjeta) {
        this.binTarjeta = binTarjeta;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TarjetaCreditoCS)) return false;
        TarjetaCreditoCS other = (TarjetaCreditoCS) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.franquicia == other.getFranquicia() &&
            ((this.binTarjeta==null && other.getBinTarjeta()==null) || 
             (this.binTarjeta!=null &&
              this.binTarjeta.equals(other.getBinTarjeta())));
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
        _hashCode += getFranquicia();
        if (getBinTarjeta() != null) {
            _hashCode += getBinTarjeta().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TarjetaCreditoCS.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "tarjetaCreditoCS"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("franquicia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "franquicia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("binTarjeta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "binTarjeta"));
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
