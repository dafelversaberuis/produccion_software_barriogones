/**
 * TarjetaCreditoRespuesta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.iatai.ws;

public class TarjetaCreditoRespuesta  extends com.iatai.ws.TransaccionRespuesta  implements java.io.Serializable {
    private com.iatai.ws.TrasladoRespuesta trasladoRespuesta;

    private com.iatai.ws.SuscripcionTarjetaCreditoRespuesta suscripcionTarjetaCreditoRespuesta;

    public TarjetaCreditoRespuesta() {
    }

    public TarjetaCreditoRespuesta(
           java.lang.String idTransaccion,
           int idEstado,
           java.lang.String nombreEstado,
           java.lang.String referencia,
           java.lang.String codigoRespuesta,
           java.lang.String codigoAutorizacion,
           java.lang.String riesgo,
           float valor,
           float iva,
           float baseDevolucion,
           java.lang.String fechaProcesamiento,
           java.lang.String mensaje,
           com.iatai.ws.TrasladoRespuesta trasladoRespuesta,
           com.iatai.ws.SuscripcionTarjetaCreditoRespuesta suscripcionTarjetaCreditoRespuesta) {
        super(
            idTransaccion,
            idEstado,
            nombreEstado,
            referencia,
            codigoRespuesta,
            codigoAutorizacion,
            riesgo,
            valor,
            iva,
            baseDevolucion,
            fechaProcesamiento,
            mensaje);
        this.trasladoRespuesta = trasladoRespuesta;
        this.suscripcionTarjetaCreditoRespuesta = suscripcionTarjetaCreditoRespuesta;
    }


    /**
     * Gets the trasladoRespuesta value for this TarjetaCreditoRespuesta.
     * 
     * @return trasladoRespuesta
     */
    public com.iatai.ws.TrasladoRespuesta getTrasladoRespuesta() {
        return trasladoRespuesta;
    }


    /**
     * Sets the trasladoRespuesta value for this TarjetaCreditoRespuesta.
     * 
     * @param trasladoRespuesta
     */
    public void setTrasladoRespuesta(com.iatai.ws.TrasladoRespuesta trasladoRespuesta) {
        this.trasladoRespuesta = trasladoRespuesta;
    }


    /**
     * Gets the suscripcionTarjetaCreditoRespuesta value for this TarjetaCreditoRespuesta.
     * 
     * @return suscripcionTarjetaCreditoRespuesta
     */
    public com.iatai.ws.SuscripcionTarjetaCreditoRespuesta getSuscripcionTarjetaCreditoRespuesta() {
        return suscripcionTarjetaCreditoRespuesta;
    }


    /**
     * Sets the suscripcionTarjetaCreditoRespuesta value for this TarjetaCreditoRespuesta.
     * 
     * @param suscripcionTarjetaCreditoRespuesta
     */
    public void setSuscripcionTarjetaCreditoRespuesta(com.iatai.ws.SuscripcionTarjetaCreditoRespuesta suscripcionTarjetaCreditoRespuesta) {
        this.suscripcionTarjetaCreditoRespuesta = suscripcionTarjetaCreditoRespuesta;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TarjetaCreditoRespuesta)) return false;
        TarjetaCreditoRespuesta other = (TarjetaCreditoRespuesta) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.trasladoRespuesta==null && other.getTrasladoRespuesta()==null) || 
             (this.trasladoRespuesta!=null &&
              this.trasladoRespuesta.equals(other.getTrasladoRespuesta()))) &&
            ((this.suscripcionTarjetaCreditoRespuesta==null && other.getSuscripcionTarjetaCreditoRespuesta()==null) || 
             (this.suscripcionTarjetaCreditoRespuesta!=null &&
              this.suscripcionTarjetaCreditoRespuesta.equals(other.getSuscripcionTarjetaCreditoRespuesta())));
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
        if (getTrasladoRespuesta() != null) {
            _hashCode += getTrasladoRespuesta().hashCode();
        }
        if (getSuscripcionTarjetaCreditoRespuesta() != null) {
            _hashCode += getSuscripcionTarjetaCreditoRespuesta().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TarjetaCreditoRespuesta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "tarjetaCreditoRespuesta"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("trasladoRespuesta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.iatai.com/", "trasladoRespuesta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "trasladoRespuesta"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("suscripcionTarjetaCreditoRespuesta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionTarjetaCreditoRespuesta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionTarjetaCreditoRespuesta"));
        elemField.setMinOccurs(0);
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
