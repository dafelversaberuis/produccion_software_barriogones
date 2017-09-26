/**
 * CompraAereo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.iatai.ws;

public class CompraAereo  extends com.iatai.ws.CompraTarjetaCredito  implements java.io.Serializable {
    private float valorAereo;

    private float ivaAereo;

    private float baseDevolucionIvaAereo;

    private float tasaAeroportuaria;

    private float valorAdmin;

    private float ivaAdmin;

    private float baseDevolucionIvaAdmin;

    public CompraAereo() {
    }

    public CompraAereo(
           java.lang.String referencia,
           java.lang.String descripcion,
           float valor,
           java.lang.String isoMoneda,
           int numeroCuotas,
           float valorAereo,
           float ivaAereo,
           float baseDevolucionIvaAereo,
           float tasaAeroportuaria,
           float valorAdmin,
           float ivaAdmin,
           float baseDevolucionIvaAdmin) {
        super(
            referencia,
            descripcion,
            valor,
            isoMoneda,
            numeroCuotas);
        this.valorAereo = valorAereo;
        this.ivaAereo = ivaAereo;
        this.baseDevolucionIvaAereo = baseDevolucionIvaAereo;
        this.tasaAeroportuaria = tasaAeroportuaria;
        this.valorAdmin = valorAdmin;
        this.ivaAdmin = ivaAdmin;
        this.baseDevolucionIvaAdmin = baseDevolucionIvaAdmin;
    }


    /**
     * Gets the valorAereo value for this CompraAereo.
     * 
     * @return valorAereo
     */
    public float getValorAereo() {
        return valorAereo;
    }


    /**
     * Sets the valorAereo value for this CompraAereo.
     * 
     * @param valorAereo
     */
    public void setValorAereo(float valorAereo) {
        this.valorAereo = valorAereo;
    }


    /**
     * Gets the ivaAereo value for this CompraAereo.
     * 
     * @return ivaAereo
     */
    public float getIvaAereo() {
        return ivaAereo;
    }


    /**
     * Sets the ivaAereo value for this CompraAereo.
     * 
     * @param ivaAereo
     */
    public void setIvaAereo(float ivaAereo) {
        this.ivaAereo = ivaAereo;
    }


    /**
     * Gets the baseDevolucionIvaAereo value for this CompraAereo.
     * 
     * @return baseDevolucionIvaAereo
     */
    public float getBaseDevolucionIvaAereo() {
        return baseDevolucionIvaAereo;
    }


    /**
     * Sets the baseDevolucionIvaAereo value for this CompraAereo.
     * 
     * @param baseDevolucionIvaAereo
     */
    public void setBaseDevolucionIvaAereo(float baseDevolucionIvaAereo) {
        this.baseDevolucionIvaAereo = baseDevolucionIvaAereo;
    }


    /**
     * Gets the tasaAeroportuaria value for this CompraAereo.
     * 
     * @return tasaAeroportuaria
     */
    public float getTasaAeroportuaria() {
        return tasaAeroportuaria;
    }


    /**
     * Sets the tasaAeroportuaria value for this CompraAereo.
     * 
     * @param tasaAeroportuaria
     */
    public void setTasaAeroportuaria(float tasaAeroportuaria) {
        this.tasaAeroportuaria = tasaAeroportuaria;
    }


    /**
     * Gets the valorAdmin value for this CompraAereo.
     * 
     * @return valorAdmin
     */
    public float getValorAdmin() {
        return valorAdmin;
    }


    /**
     * Sets the valorAdmin value for this CompraAereo.
     * 
     * @param valorAdmin
     */
    public void setValorAdmin(float valorAdmin) {
        this.valorAdmin = valorAdmin;
    }


    /**
     * Gets the ivaAdmin value for this CompraAereo.
     * 
     * @return ivaAdmin
     */
    public float getIvaAdmin() {
        return ivaAdmin;
    }


    /**
     * Sets the ivaAdmin value for this CompraAereo.
     * 
     * @param ivaAdmin
     */
    public void setIvaAdmin(float ivaAdmin) {
        this.ivaAdmin = ivaAdmin;
    }


    /**
     * Gets the baseDevolucionIvaAdmin value for this CompraAereo.
     * 
     * @return baseDevolucionIvaAdmin
     */
    public float getBaseDevolucionIvaAdmin() {
        return baseDevolucionIvaAdmin;
    }


    /**
     * Sets the baseDevolucionIvaAdmin value for this CompraAereo.
     * 
     * @param baseDevolucionIvaAdmin
     */
    public void setBaseDevolucionIvaAdmin(float baseDevolucionIvaAdmin) {
        this.baseDevolucionIvaAdmin = baseDevolucionIvaAdmin;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CompraAereo)) return false;
        CompraAereo other = (CompraAereo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.valorAereo == other.getValorAereo() &&
            this.ivaAereo == other.getIvaAereo() &&
            this.baseDevolucionIvaAereo == other.getBaseDevolucionIvaAereo() &&
            this.tasaAeroportuaria == other.getTasaAeroportuaria() &&
            this.valorAdmin == other.getValorAdmin() &&
            this.ivaAdmin == other.getIvaAdmin() &&
            this.baseDevolucionIvaAdmin == other.getBaseDevolucionIvaAdmin();
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
        _hashCode += new Float(getValorAereo()).hashCode();
        _hashCode += new Float(getIvaAereo()).hashCode();
        _hashCode += new Float(getBaseDevolucionIvaAereo()).hashCode();
        _hashCode += new Float(getTasaAeroportuaria()).hashCode();
        _hashCode += new Float(getValorAdmin()).hashCode();
        _hashCode += new Float(getIvaAdmin()).hashCode();
        _hashCode += new Float(getBaseDevolucionIvaAdmin()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CompraAereo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "compraAereo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valorAereo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "valorAereo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ivaAereo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ivaAereo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("baseDevolucionIvaAereo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "baseDevolucionIvaAereo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tasaAeroportuaria");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tasaAeroportuaria"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valorAdmin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "valorAdmin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ivaAdmin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ivaAdmin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("baseDevolucionIvaAdmin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "baseDevolucionIvaAdmin"));
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
