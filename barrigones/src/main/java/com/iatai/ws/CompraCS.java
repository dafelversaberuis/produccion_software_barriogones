/**
 * CompraCS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.iatai.ws;

public class CompraCS  implements java.io.Serializable {
    private float valor;

    private java.lang.String isoMoneda;

    public CompraCS() {
    }

    public CompraCS(
           float valor,
           java.lang.String isoMoneda) {
           this.valor = valor;
           this.isoMoneda = isoMoneda;
    }


    /**
     * Gets the valor value for this CompraCS.
     * 
     * @return valor
     */
    public float getValor() {
        return valor;
    }


    /**
     * Sets the valor value for this CompraCS.
     * 
     * @param valor
     */
    public void setValor(float valor) {
        this.valor = valor;
    }


    /**
     * Gets the isoMoneda value for this CompraCS.
     * 
     * @return isoMoneda
     */
    public java.lang.String getIsoMoneda() {
        return isoMoneda;
    }


    /**
     * Sets the isoMoneda value for this CompraCS.
     * 
     * @param isoMoneda
     */
    public void setIsoMoneda(java.lang.String isoMoneda) {
        this.isoMoneda = isoMoneda;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CompraCS)) return false;
        CompraCS other = (CompraCS) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.valor == other.getValor() &&
            ((this.isoMoneda==null && other.getIsoMoneda()==null) || 
             (this.isoMoneda!=null &&
              this.isoMoneda.equals(other.getIsoMoneda())));
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
        _hashCode += new Float(getValor()).hashCode();
        if (getIsoMoneda() != null) {
            _hashCode += getIsoMoneda().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CompraCS.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "compraCS"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "valor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isoMoneda");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isoMoneda"));
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
