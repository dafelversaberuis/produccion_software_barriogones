/**
 * TarjetaCredito_.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.iatai.ws;

public class TarjetaCredito_  extends com.iatai.ws.TarjetaCreditoBase_  implements java.io.Serializable {
    private java.lang.String tipoCuenta;

    public TarjetaCredito_() {
    }

    public TarjetaCredito_(
           int franquicia,
           java.lang.String numeroTarjeta,
           java.lang.String mesVencimiento,
           java.lang.String anoVencimiento,
           java.lang.String codigoSeguridad,
           java.lang.String tipoCuenta) {
        super(
            franquicia,
            numeroTarjeta,
            mesVencimiento,
            anoVencimiento,
            codigoSeguridad);
        this.tipoCuenta = tipoCuenta;
    }


    /**
     * Gets the tipoCuenta value for this TarjetaCredito_.
     * 
     * @return tipoCuenta
     */
    public java.lang.String getTipoCuenta() {
        return tipoCuenta;
    }


    /**
     * Sets the tipoCuenta value for this TarjetaCredito_.
     * 
     * @param tipoCuenta
     */
    public void setTipoCuenta(java.lang.String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TarjetaCredito_)) return false;
        TarjetaCredito_ other = (TarjetaCredito_) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.tipoCuenta==null && other.getTipoCuenta()==null) || 
             (this.tipoCuenta!=null &&
              this.tipoCuenta.equals(other.getTipoCuenta())));
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
        if (getTipoCuenta() != null) {
            _hashCode += getTipoCuenta().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TarjetaCredito_.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "tarjetaCredito_"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoCuenta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipoCuenta"));
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
