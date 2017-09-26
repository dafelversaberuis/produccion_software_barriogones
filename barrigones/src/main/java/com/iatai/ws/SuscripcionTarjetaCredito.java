/**
 * SuscripcionTarjetaCredito.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.iatai.ws;

public class SuscripcionTarjetaCredito  implements java.io.Serializable {
    private int franquicia;

    private java.lang.String numeroTarjeta;

    private java.lang.String mesVencimiento;

    private java.lang.String anoVencimiento;

    private java.lang.String tipoCuenta;

    private java.lang.String codigoSeguridad;

    public SuscripcionTarjetaCredito() {
    }

    public SuscripcionTarjetaCredito(
           int franquicia,
           java.lang.String numeroTarjeta,
           java.lang.String mesVencimiento,
           java.lang.String anoVencimiento,
           java.lang.String tipoCuenta,
           java.lang.String codigoSeguridad) {
           this.franquicia = franquicia;
           this.numeroTarjeta = numeroTarjeta;
           this.mesVencimiento = mesVencimiento;
           this.anoVencimiento = anoVencimiento;
           this.tipoCuenta = tipoCuenta;
           this.codigoSeguridad = codigoSeguridad;
    }


    /**
     * Gets the franquicia value for this SuscripcionTarjetaCredito.
     * 
     * @return franquicia
     */
    public int getFranquicia() {
        return franquicia;
    }


    /**
     * Sets the franquicia value for this SuscripcionTarjetaCredito.
     * 
     * @param franquicia
     */
    public void setFranquicia(int franquicia) {
        this.franquicia = franquicia;
    }


    /**
     * Gets the numeroTarjeta value for this SuscripcionTarjetaCredito.
     * 
     * @return numeroTarjeta
     */
    public java.lang.String getNumeroTarjeta() {
        return numeroTarjeta;
    }


    /**
     * Sets the numeroTarjeta value for this SuscripcionTarjetaCredito.
     * 
     * @param numeroTarjeta
     */
    public void setNumeroTarjeta(java.lang.String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }


    /**
     * Gets the mesVencimiento value for this SuscripcionTarjetaCredito.
     * 
     * @return mesVencimiento
     */
    public java.lang.String getMesVencimiento() {
        return mesVencimiento;
    }


    /**
     * Sets the mesVencimiento value for this SuscripcionTarjetaCredito.
     * 
     * @param mesVencimiento
     */
    public void setMesVencimiento(java.lang.String mesVencimiento) {
        this.mesVencimiento = mesVencimiento;
    }


    /**
     * Gets the anoVencimiento value for this SuscripcionTarjetaCredito.
     * 
     * @return anoVencimiento
     */
    public java.lang.String getAnoVencimiento() {
        return anoVencimiento;
    }


    /**
     * Sets the anoVencimiento value for this SuscripcionTarjetaCredito.
     * 
     * @param anoVencimiento
     */
    public void setAnoVencimiento(java.lang.String anoVencimiento) {
        this.anoVencimiento = anoVencimiento;
    }


    /**
     * Gets the tipoCuenta value for this SuscripcionTarjetaCredito.
     * 
     * @return tipoCuenta
     */
    public java.lang.String getTipoCuenta() {
        return tipoCuenta;
    }


    /**
     * Sets the tipoCuenta value for this SuscripcionTarjetaCredito.
     * 
     * @param tipoCuenta
     */
    public void setTipoCuenta(java.lang.String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }


    /**
     * Gets the codigoSeguridad value for this SuscripcionTarjetaCredito.
     * 
     * @return codigoSeguridad
     */
    public java.lang.String getCodigoSeguridad() {
        return codigoSeguridad;
    }


    /**
     * Sets the codigoSeguridad value for this SuscripcionTarjetaCredito.
     * 
     * @param codigoSeguridad
     */
    public void setCodigoSeguridad(java.lang.String codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SuscripcionTarjetaCredito)) return false;
        SuscripcionTarjetaCredito other = (SuscripcionTarjetaCredito) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.franquicia == other.getFranquicia() &&
            ((this.numeroTarjeta==null && other.getNumeroTarjeta()==null) || 
             (this.numeroTarjeta!=null &&
              this.numeroTarjeta.equals(other.getNumeroTarjeta()))) &&
            ((this.mesVencimiento==null && other.getMesVencimiento()==null) || 
             (this.mesVencimiento!=null &&
              this.mesVencimiento.equals(other.getMesVencimiento()))) &&
            ((this.anoVencimiento==null && other.getAnoVencimiento()==null) || 
             (this.anoVencimiento!=null &&
              this.anoVencimiento.equals(other.getAnoVencimiento()))) &&
            ((this.tipoCuenta==null && other.getTipoCuenta()==null) || 
             (this.tipoCuenta!=null &&
              this.tipoCuenta.equals(other.getTipoCuenta()))) &&
            ((this.codigoSeguridad==null && other.getCodigoSeguridad()==null) || 
             (this.codigoSeguridad!=null &&
              this.codigoSeguridad.equals(other.getCodigoSeguridad())));
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
        if (getNumeroTarjeta() != null) {
            _hashCode += getNumeroTarjeta().hashCode();
        }
        if (getMesVencimiento() != null) {
            _hashCode += getMesVencimiento().hashCode();
        }
        if (getAnoVencimiento() != null) {
            _hashCode += getAnoVencimiento().hashCode();
        }
        if (getTipoCuenta() != null) {
            _hashCode += getTipoCuenta().hashCode();
        }
        if (getCodigoSeguridad() != null) {
            _hashCode += getCodigoSeguridad().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SuscripcionTarjetaCredito.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionTarjetaCredito"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("franquicia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "franquicia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroTarjeta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numeroTarjeta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mesVencimiento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mesVencimiento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("anoVencimiento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "anoVencimiento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoCuenta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipoCuenta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoSeguridad");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codigoSeguridad"));
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
