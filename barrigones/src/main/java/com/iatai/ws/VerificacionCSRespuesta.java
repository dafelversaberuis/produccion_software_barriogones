/**
 * VerificacionCSRespuesta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.iatai.ws;

public class VerificacionCSRespuesta  implements java.io.Serializable {
    private int numero;

    private com.iatai.ws.CompraCS compraCS;

    private com.iatai.ws.TarjetaCreditoCS tarjetaCreditoCS;

    private boolean codigoSeguridadRequerido;

    public VerificacionCSRespuesta() {
    }

    public VerificacionCSRespuesta(
           int numero,
           com.iatai.ws.CompraCS compraCS,
           com.iatai.ws.TarjetaCreditoCS tarjetaCreditoCS,
           boolean codigoSeguridadRequerido) {
           this.numero = numero;
           this.compraCS = compraCS;
           this.tarjetaCreditoCS = tarjetaCreditoCS;
           this.codigoSeguridadRequerido = codigoSeguridadRequerido;
    }


    /**
     * Gets the numero value for this VerificacionCSRespuesta.
     * 
     * @return numero
     */
    public int getNumero() {
        return numero;
    }


    /**
     * Sets the numero value for this VerificacionCSRespuesta.
     * 
     * @param numero
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }


    /**
     * Gets the compraCS value for this VerificacionCSRespuesta.
     * 
     * @return compraCS
     */
    public com.iatai.ws.CompraCS getCompraCS() {
        return compraCS;
    }


    /**
     * Sets the compraCS value for this VerificacionCSRespuesta.
     * 
     * @param compraCS
     */
    public void setCompraCS(com.iatai.ws.CompraCS compraCS) {
        this.compraCS = compraCS;
    }


    /**
     * Gets the tarjetaCreditoCS value for this VerificacionCSRespuesta.
     * 
     * @return tarjetaCreditoCS
     */
    public com.iatai.ws.TarjetaCreditoCS getTarjetaCreditoCS() {
        return tarjetaCreditoCS;
    }


    /**
     * Sets the tarjetaCreditoCS value for this VerificacionCSRespuesta.
     * 
     * @param tarjetaCreditoCS
     */
    public void setTarjetaCreditoCS(com.iatai.ws.TarjetaCreditoCS tarjetaCreditoCS) {
        this.tarjetaCreditoCS = tarjetaCreditoCS;
    }


    /**
     * Gets the codigoSeguridadRequerido value for this VerificacionCSRespuesta.
     * 
     * @return codigoSeguridadRequerido
     */
    public boolean isCodigoSeguridadRequerido() {
        return codigoSeguridadRequerido;
    }


    /**
     * Sets the codigoSeguridadRequerido value for this VerificacionCSRespuesta.
     * 
     * @param codigoSeguridadRequerido
     */
    public void setCodigoSeguridadRequerido(boolean codigoSeguridadRequerido) {
        this.codigoSeguridadRequerido = codigoSeguridadRequerido;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof VerificacionCSRespuesta)) return false;
        VerificacionCSRespuesta other = (VerificacionCSRespuesta) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.numero == other.getNumero() &&
            ((this.compraCS==null && other.getCompraCS()==null) || 
             (this.compraCS!=null &&
              this.compraCS.equals(other.getCompraCS()))) &&
            ((this.tarjetaCreditoCS==null && other.getTarjetaCreditoCS()==null) || 
             (this.tarjetaCreditoCS!=null &&
              this.tarjetaCreditoCS.equals(other.getTarjetaCreditoCS()))) &&
            this.codigoSeguridadRequerido == other.isCodigoSeguridadRequerido();
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
        _hashCode += getNumero();
        if (getCompraCS() != null) {
            _hashCode += getCompraCS().hashCode();
        }
        if (getTarjetaCreditoCS() != null) {
            _hashCode += getTarjetaCreditoCS().hashCode();
        }
        _hashCode += (isCodigoSeguridadRequerido() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(VerificacionCSRespuesta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "verificacionCSRespuesta"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numero");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numero"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("compraCS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CompraCS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "compraCS"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tarjetaCreditoCS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TarjetaCreditoCS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "tarjetaCreditoCS"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoSeguridadRequerido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CodigoSeguridadRequerido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
