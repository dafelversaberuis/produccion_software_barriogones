/**
 * TransaccionSuscripcionRespuesta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.iatai.ws;

public class TransaccionSuscripcionRespuesta  extends com.iatai.ws.TransaccionRespuesta  implements java.io.Serializable {
    public TransaccionSuscripcionRespuesta() {
    }

    public TransaccionSuscripcionRespuesta(
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
           java.lang.String mensaje) {
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
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TransaccionSuscripcionRespuesta)) return false;
        TransaccionSuscripcionRespuesta other = (TransaccionSuscripcionRespuesta) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj);
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TransaccionSuscripcionRespuesta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "transaccionSuscripcionRespuesta"));
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
