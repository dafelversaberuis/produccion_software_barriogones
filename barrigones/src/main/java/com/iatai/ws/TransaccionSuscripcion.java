/**
 * TransaccionSuscripcion.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.iatai.ws;

public class TransaccionSuscripcion  implements java.io.Serializable {
    private com.iatai.ws.Compra compra;

    private com.iatai.ws.Cliente cliente;

    private com.iatai.ws.SuscripcionPago suscripcionPago;

    private com.iatai.ws.FraudeValidacionProducto informacionFraude;

    public TransaccionSuscripcion() {
    }

    public TransaccionSuscripcion(
           com.iatai.ws.Compra compra,
           com.iatai.ws.Cliente cliente,
           com.iatai.ws.SuscripcionPago suscripcionPago,
           com.iatai.ws.FraudeValidacionProducto informacionFraude) {
           this.compra = compra;
           this.cliente = cliente;
           this.suscripcionPago = suscripcionPago;
           this.informacionFraude = informacionFraude;
    }


    /**
     * Gets the compra value for this TransaccionSuscripcion.
     * 
     * @return compra
     */
    public com.iatai.ws.Compra getCompra() {
        return compra;
    }


    /**
     * Sets the compra value for this TransaccionSuscripcion.
     * 
     * @param compra
     */
    public void setCompra(com.iatai.ws.Compra compra) {
        this.compra = compra;
    }


    /**
     * Gets the cliente value for this TransaccionSuscripcion.
     * 
     * @return cliente
     */
    public com.iatai.ws.Cliente getCliente() {
        return cliente;
    }


    /**
     * Sets the cliente value for this TransaccionSuscripcion.
     * 
     * @param cliente
     */
    public void setCliente(com.iatai.ws.Cliente cliente) {
        this.cliente = cliente;
    }


    /**
     * Gets the suscripcionPago value for this TransaccionSuscripcion.
     * 
     * @return suscripcionPago
     */
    public com.iatai.ws.SuscripcionPago getSuscripcionPago() {
        return suscripcionPago;
    }


    /**
     * Sets the suscripcionPago value for this TransaccionSuscripcion.
     * 
     * @param suscripcionPago
     */
    public void setSuscripcionPago(com.iatai.ws.SuscripcionPago suscripcionPago) {
        this.suscripcionPago = suscripcionPago;
    }


    /**
     * Gets the informacionFraude value for this TransaccionSuscripcion.
     * 
     * @return informacionFraude
     */
    public com.iatai.ws.FraudeValidacionProducto getInformacionFraude() {
        return informacionFraude;
    }


    /**
     * Sets the informacionFraude value for this TransaccionSuscripcion.
     * 
     * @param informacionFraude
     */
    public void setInformacionFraude(com.iatai.ws.FraudeValidacionProducto informacionFraude) {
        this.informacionFraude = informacionFraude;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TransaccionSuscripcion)) return false;
        TransaccionSuscripcion other = (TransaccionSuscripcion) obj;
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
            ((this.informacionFraude==null && other.getInformacionFraude()==null) || 
             (this.informacionFraude!=null &&
              this.informacionFraude.equals(other.getInformacionFraude())));
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
        if (getInformacionFraude() != null) {
            _hashCode += getInformacionFraude().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TransaccionSuscripcion.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "transaccionSuscripcion"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("compra");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Compra"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "compra"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cliente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Cliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "cliente"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("suscripcionPago");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SuscripcionPago"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionPago"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("informacionFraude");
        elemField.setXmlName(new javax.xml.namespace.QName("", "InformacionFraude"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "FraudeValidacionProducto"));
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
