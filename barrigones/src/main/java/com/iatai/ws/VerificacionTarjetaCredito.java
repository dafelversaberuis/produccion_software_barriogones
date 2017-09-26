/**
 * VerificacionTarjetaCredito.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.iatai.ws;

public class VerificacionTarjetaCredito  implements java.io.Serializable {
    private com.iatai.ws.CompraBase compra;

    private com.iatai.ws.TarjetaHabiente tarjetaHabiente;

    private com.iatai.ws.TarjetaCreditoBase_ tarjetaCredito;

    private com.iatai.ws.Envio envio;

    private com.iatai.ws.FraudeBase informacionFraude;

    private com.iatai.ws.Item[] productos;

    public VerificacionTarjetaCredito() {
    }

    public VerificacionTarjetaCredito(
           com.iatai.ws.CompraBase compra,
           com.iatai.ws.TarjetaHabiente tarjetaHabiente,
           com.iatai.ws.TarjetaCreditoBase_ tarjetaCredito,
           com.iatai.ws.Envio envio,
           com.iatai.ws.FraudeBase informacionFraude,
           com.iatai.ws.Item[] productos) {
           this.compra = compra;
           this.tarjetaHabiente = tarjetaHabiente;
           this.tarjetaCredito = tarjetaCredito;
           this.envio = envio;
           this.informacionFraude = informacionFraude;
           this.productos = productos;
    }


    /**
     * Gets the compra value for this VerificacionTarjetaCredito.
     * 
     * @return compra
     */
    public com.iatai.ws.CompraBase getCompra() {
        return compra;
    }


    /**
     * Sets the compra value for this VerificacionTarjetaCredito.
     * 
     * @param compra
     */
    public void setCompra(com.iatai.ws.CompraBase compra) {
        this.compra = compra;
    }


    /**
     * Gets the tarjetaHabiente value for this VerificacionTarjetaCredito.
     * 
     * @return tarjetaHabiente
     */
    public com.iatai.ws.TarjetaHabiente getTarjetaHabiente() {
        return tarjetaHabiente;
    }


    /**
     * Sets the tarjetaHabiente value for this VerificacionTarjetaCredito.
     * 
     * @param tarjetaHabiente
     */
    public void setTarjetaHabiente(com.iatai.ws.TarjetaHabiente tarjetaHabiente) {
        this.tarjetaHabiente = tarjetaHabiente;
    }


    /**
     * Gets the tarjetaCredito value for this VerificacionTarjetaCredito.
     * 
     * @return tarjetaCredito
     */
    public com.iatai.ws.TarjetaCreditoBase_ getTarjetaCredito() {
        return tarjetaCredito;
    }


    /**
     * Sets the tarjetaCredito value for this VerificacionTarjetaCredito.
     * 
     * @param tarjetaCredito
     */
    public void setTarjetaCredito(com.iatai.ws.TarjetaCreditoBase_ tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }


    /**
     * Gets the envio value for this VerificacionTarjetaCredito.
     * 
     * @return envio
     */
    public com.iatai.ws.Envio getEnvio() {
        return envio;
    }


    /**
     * Sets the envio value for this VerificacionTarjetaCredito.
     * 
     * @param envio
     */
    public void setEnvio(com.iatai.ws.Envio envio) {
        this.envio = envio;
    }


    /**
     * Gets the informacionFraude value for this VerificacionTarjetaCredito.
     * 
     * @return informacionFraude
     */
    public com.iatai.ws.FraudeBase getInformacionFraude() {
        return informacionFraude;
    }


    /**
     * Sets the informacionFraude value for this VerificacionTarjetaCredito.
     * 
     * @param informacionFraude
     */
    public void setInformacionFraude(com.iatai.ws.FraudeBase informacionFraude) {
        this.informacionFraude = informacionFraude;
    }


    /**
     * Gets the productos value for this VerificacionTarjetaCredito.
     * 
     * @return productos
     */
    public com.iatai.ws.Item[] getProductos() {
        return productos;
    }


    /**
     * Sets the productos value for this VerificacionTarjetaCredito.
     * 
     * @param productos
     */
    public void setProductos(com.iatai.ws.Item[] productos) {
        this.productos = productos;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof VerificacionTarjetaCredito)) return false;
        VerificacionTarjetaCredito other = (VerificacionTarjetaCredito) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.compra==null && other.getCompra()==null) || 
             (this.compra!=null &&
              this.compra.equals(other.getCompra()))) &&
            ((this.tarjetaHabiente==null && other.getTarjetaHabiente()==null) || 
             (this.tarjetaHabiente!=null &&
              this.tarjetaHabiente.equals(other.getTarjetaHabiente()))) &&
            ((this.tarjetaCredito==null && other.getTarjetaCredito()==null) || 
             (this.tarjetaCredito!=null &&
              this.tarjetaCredito.equals(other.getTarjetaCredito()))) &&
            ((this.envio==null && other.getEnvio()==null) || 
             (this.envio!=null &&
              this.envio.equals(other.getEnvio()))) &&
            ((this.informacionFraude==null && other.getInformacionFraude()==null) || 
             (this.informacionFraude!=null &&
              this.informacionFraude.equals(other.getInformacionFraude()))) &&
            ((this.productos==null && other.getProductos()==null) || 
             (this.productos!=null &&
              java.util.Arrays.equals(this.productos, other.getProductos())));
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
        if (getCompra() != null) {
            _hashCode += getCompra().hashCode();
        }
        if (getTarjetaHabiente() != null) {
            _hashCode += getTarjetaHabiente().hashCode();
        }
        if (getTarjetaCredito() != null) {
            _hashCode += getTarjetaCredito().hashCode();
        }
        if (getEnvio() != null) {
            _hashCode += getEnvio().hashCode();
        }
        if (getInformacionFraude() != null) {
            _hashCode += getInformacionFraude().hashCode();
        }
        if (getProductos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getProductos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getProductos(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(VerificacionTarjetaCredito.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "verificacionTarjetaCredito"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("compra");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Compra"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "compraBase"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tarjetaHabiente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TarjetaHabiente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "tarjetaHabiente"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tarjetaCredito");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TarjetaCredito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "tarjetaCreditoBase_"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("envio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Envio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "envio"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("informacionFraude");
        elemField.setXmlName(new javax.xml.namespace.QName("", "InformacionFraude"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "FraudeBase"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "item"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "producto"));
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
