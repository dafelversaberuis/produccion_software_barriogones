/**
 * TransaccionAereoSuscripcion.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.iatai.ws;

public class TransaccionAereoSuscripcion  implements java.io.Serializable {
    private com.iatai.ws.CompraAereo compra;

    private com.iatai.ws.Cliente_ cliente;

    private com.iatai.ws.SuscripcionPago suscripcionPago;

    private com.iatai.ws.Envio envio;

    private com.iatai.ws.FraudeBase informacionFraude;

    private com.iatai.ws.Aereo aereo;

    public TransaccionAereoSuscripcion() {
    }

    public TransaccionAereoSuscripcion(
           com.iatai.ws.CompraAereo compra,
           com.iatai.ws.Cliente_ cliente,
           com.iatai.ws.SuscripcionPago suscripcionPago,
           com.iatai.ws.Envio envio,
           com.iatai.ws.FraudeBase informacionFraude,
           com.iatai.ws.Aereo aereo) {
           this.compra = compra;
           this.cliente = cliente;
           this.suscripcionPago = suscripcionPago;
           this.envio = envio;
           this.informacionFraude = informacionFraude;
           this.aereo = aereo;
    }


    /**
     * Gets the compra value for this TransaccionAereoSuscripcion.
     * 
     * @return compra
     */
    public com.iatai.ws.CompraAereo getCompra() {
        return compra;
    }


    /**
     * Sets the compra value for this TransaccionAereoSuscripcion.
     * 
     * @param compra
     */
    public void setCompra(com.iatai.ws.CompraAereo compra) {
        this.compra = compra;
    }


    /**
     * Gets the cliente value for this TransaccionAereoSuscripcion.
     * 
     * @return cliente
     */
    public com.iatai.ws.Cliente_ getCliente() {
        return cliente;
    }


    /**
     * Sets the cliente value for this TransaccionAereoSuscripcion.
     * 
     * @param cliente
     */
    public void setCliente(com.iatai.ws.Cliente_ cliente) {
        this.cliente = cliente;
    }


    /**
     * Gets the suscripcionPago value for this TransaccionAereoSuscripcion.
     * 
     * @return suscripcionPago
     */
    public com.iatai.ws.SuscripcionPago getSuscripcionPago() {
        return suscripcionPago;
    }


    /**
     * Sets the suscripcionPago value for this TransaccionAereoSuscripcion.
     * 
     * @param suscripcionPago
     */
    public void setSuscripcionPago(com.iatai.ws.SuscripcionPago suscripcionPago) {
        this.suscripcionPago = suscripcionPago;
    }


    /**
     * Gets the envio value for this TransaccionAereoSuscripcion.
     * 
     * @return envio
     */
    public com.iatai.ws.Envio getEnvio() {
        return envio;
    }


    /**
     * Sets the envio value for this TransaccionAereoSuscripcion.
     * 
     * @param envio
     */
    public void setEnvio(com.iatai.ws.Envio envio) {
        this.envio = envio;
    }


    /**
     * Gets the informacionFraude value for this TransaccionAereoSuscripcion.
     * 
     * @return informacionFraude
     */
    public com.iatai.ws.FraudeBase getInformacionFraude() {
        return informacionFraude;
    }


    /**
     * Sets the informacionFraude value for this TransaccionAereoSuscripcion.
     * 
     * @param informacionFraude
     */
    public void setInformacionFraude(com.iatai.ws.FraudeBase informacionFraude) {
        this.informacionFraude = informacionFraude;
    }


    /**
     * Gets the aereo value for this TransaccionAereoSuscripcion.
     * 
     * @return aereo
     */
    public com.iatai.ws.Aereo getAereo() {
        return aereo;
    }


    /**
     * Sets the aereo value for this TransaccionAereoSuscripcion.
     * 
     * @param aereo
     */
    public void setAereo(com.iatai.ws.Aereo aereo) {
        this.aereo = aereo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TransaccionAereoSuscripcion)) return false;
        TransaccionAereoSuscripcion other = (TransaccionAereoSuscripcion) obj;
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
            ((this.cliente==null && other.getCliente()==null) || 
             (this.cliente!=null &&
              this.cliente.equals(other.getCliente()))) &&
            ((this.suscripcionPago==null && other.getSuscripcionPago()==null) || 
             (this.suscripcionPago!=null &&
              this.suscripcionPago.equals(other.getSuscripcionPago()))) &&
            ((this.envio==null && other.getEnvio()==null) || 
             (this.envio!=null &&
              this.envio.equals(other.getEnvio()))) &&
            ((this.informacionFraude==null && other.getInformacionFraude()==null) || 
             (this.informacionFraude!=null &&
              this.informacionFraude.equals(other.getInformacionFraude()))) &&
            ((this.aereo==null && other.getAereo()==null) || 
             (this.aereo!=null &&
              this.aereo.equals(other.getAereo())));
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
        if (getCliente() != null) {
            _hashCode += getCliente().hashCode();
        }
        if (getSuscripcionPago() != null) {
            _hashCode += getSuscripcionPago().hashCode();
        }
        if (getEnvio() != null) {
            _hashCode += getEnvio().hashCode();
        }
        if (getInformacionFraude() != null) {
            _hashCode += getInformacionFraude().hashCode();
        }
        if (getAereo() != null) {
            _hashCode += getAereo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TransaccionAereoSuscripcion.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "transaccionAereoSuscripcion"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("compra");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Compra"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "compraAereo"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cliente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Cliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "cliente_"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("suscripcionPago");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SuscripcionPago"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionPago"));
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
        elemField.setFieldName("aereo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Aereo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "aereo"));
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
