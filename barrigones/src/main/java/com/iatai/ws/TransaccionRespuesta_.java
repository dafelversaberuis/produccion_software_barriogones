/**
 * TransaccionRespuesta_.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.iatai.ws;

public class TransaccionRespuesta_  extends com.iatai.ws.TransaccionRespuestaBase  implements java.io.Serializable {
    private com.iatai.ws.AntifraudeRespuesta antifraudeRespuesta;

    private com.iatai.ws.TrasladoRespuesta trasladoRespuesta;

    private com.iatai.ws.SuscripcionTarjetaCreditoRespuesta suscripcionTarjetaCreditoRespuesta;

    private com.iatai.ws.DispersionRespuesta[] dispersionesRespuesta;

    public TransaccionRespuesta_() {
    }

    public TransaccionRespuesta_(
           java.lang.String idTransaccion,
           java.lang.String referencia,
           int idEstado,
           java.lang.String nombreEstado,
           java.lang.String codigoRespuesta,
           java.lang.String codigoAutorizacion,
           float valor,
           float iva,
           float baseDevolucion,
           java.lang.String isoMoneda,
           java.lang.String fechaProcesamiento,
           java.lang.String mensaje,
           com.iatai.ws.TarjetaRespuesta tarjetaRespuesta,
           com.iatai.ws.ProcesadorRespuesta procesadorRespuesta,
           com.iatai.ws.AntifraudeRespuesta antifraudeRespuesta,
           com.iatai.ws.TrasladoRespuesta trasladoRespuesta,
           com.iatai.ws.SuscripcionTarjetaCreditoRespuesta suscripcionTarjetaCreditoRespuesta,
           com.iatai.ws.DispersionRespuesta[] dispersionesRespuesta) {
        super(
            idTransaccion,
            referencia,
            idEstado,
            nombreEstado,
            codigoRespuesta,
            codigoAutorizacion,
            valor,
            iva,
            baseDevolucion,
            isoMoneda,
            fechaProcesamiento,
            mensaje,
            tarjetaRespuesta,
            procesadorRespuesta);
        this.antifraudeRespuesta = antifraudeRespuesta;
        this.trasladoRespuesta = trasladoRespuesta;
        this.suscripcionTarjetaCreditoRespuesta = suscripcionTarjetaCreditoRespuesta;
        this.dispersionesRespuesta = dispersionesRespuesta;
    }


    /**
     * Gets the antifraudeRespuesta value for this TransaccionRespuesta_.
     * 
     * @return antifraudeRespuesta
     */
    public com.iatai.ws.AntifraudeRespuesta getAntifraudeRespuesta() {
        return antifraudeRespuesta;
    }


    /**
     * Sets the antifraudeRespuesta value for this TransaccionRespuesta_.
     * 
     * @param antifraudeRespuesta
     */
    public void setAntifraudeRespuesta(com.iatai.ws.AntifraudeRespuesta antifraudeRespuesta) {
        this.antifraudeRespuesta = antifraudeRespuesta;
    }


    /**
     * Gets the trasladoRespuesta value for this TransaccionRespuesta_.
     * 
     * @return trasladoRespuesta
     */
    public com.iatai.ws.TrasladoRespuesta getTrasladoRespuesta() {
        return trasladoRespuesta;
    }


    /**
     * Sets the trasladoRespuesta value for this TransaccionRespuesta_.
     * 
     * @param trasladoRespuesta
     */
    public void setTrasladoRespuesta(com.iatai.ws.TrasladoRespuesta trasladoRespuesta) {
        this.trasladoRespuesta = trasladoRespuesta;
    }


    /**
     * Gets the suscripcionTarjetaCreditoRespuesta value for this TransaccionRespuesta_.
     * 
     * @return suscripcionTarjetaCreditoRespuesta
     */
    public com.iatai.ws.SuscripcionTarjetaCreditoRespuesta getSuscripcionTarjetaCreditoRespuesta() {
        return suscripcionTarjetaCreditoRespuesta;
    }


    /**
     * Sets the suscripcionTarjetaCreditoRespuesta value for this TransaccionRespuesta_.
     * 
     * @param suscripcionTarjetaCreditoRespuesta
     */
    public void setSuscripcionTarjetaCreditoRespuesta(com.iatai.ws.SuscripcionTarjetaCreditoRespuesta suscripcionTarjetaCreditoRespuesta) {
        this.suscripcionTarjetaCreditoRespuesta = suscripcionTarjetaCreditoRespuesta;
    }


    /**
     * Gets the dispersionesRespuesta value for this TransaccionRespuesta_.
     * 
     * @return dispersionesRespuesta
     */
    public com.iatai.ws.DispersionRespuesta[] getDispersionesRespuesta() {
        return dispersionesRespuesta;
    }


    /**
     * Sets the dispersionesRespuesta value for this TransaccionRespuesta_.
     * 
     * @param dispersionesRespuesta
     */
    public void setDispersionesRespuesta(com.iatai.ws.DispersionRespuesta[] dispersionesRespuesta) {
        this.dispersionesRespuesta = dispersionesRespuesta;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TransaccionRespuesta_)) return false;
        TransaccionRespuesta_ other = (TransaccionRespuesta_) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.antifraudeRespuesta==null && other.getAntifraudeRespuesta()==null) || 
             (this.antifraudeRespuesta!=null &&
              this.antifraudeRespuesta.equals(other.getAntifraudeRespuesta()))) &&
            ((this.trasladoRespuesta==null && other.getTrasladoRespuesta()==null) || 
             (this.trasladoRespuesta!=null &&
              this.trasladoRespuesta.equals(other.getTrasladoRespuesta()))) &&
            ((this.suscripcionTarjetaCreditoRespuesta==null && other.getSuscripcionTarjetaCreditoRespuesta()==null) || 
             (this.suscripcionTarjetaCreditoRespuesta!=null &&
              this.suscripcionTarjetaCreditoRespuesta.equals(other.getSuscripcionTarjetaCreditoRespuesta()))) &&
            ((this.dispersionesRespuesta==null && other.getDispersionesRespuesta()==null) || 
             (this.dispersionesRespuesta!=null &&
              java.util.Arrays.equals(this.dispersionesRespuesta, other.getDispersionesRespuesta())));
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
        if (getAntifraudeRespuesta() != null) {
            _hashCode += getAntifraudeRespuesta().hashCode();
        }
        if (getTrasladoRespuesta() != null) {
            _hashCode += getTrasladoRespuesta().hashCode();
        }
        if (getSuscripcionTarjetaCreditoRespuesta() != null) {
            _hashCode += getSuscripcionTarjetaCreditoRespuesta().hashCode();
        }
        if (getDispersionesRespuesta() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDispersionesRespuesta());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDispersionesRespuesta(), i);
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
        new org.apache.axis.description.TypeDesc(TransaccionRespuesta_.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "transaccionRespuesta_"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("antifraudeRespuesta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.iatai.com/", "antifraudeRespuesta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "antifraudeRespuesta"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dispersionesRespuesta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.iatai.com/", "dispersionesRespuesta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "dispersionesRespuesta"));
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
