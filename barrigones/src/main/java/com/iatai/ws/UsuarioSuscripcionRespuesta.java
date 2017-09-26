/**
 * UsuarioSuscripcionRespuesta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.iatai.ws;

public class UsuarioSuscripcionRespuesta  implements java.io.Serializable {
    private com.iatai.ws.UsuarioRespuesta usuarioRespuesta;

    private com.iatai.ws.SuscripcionRespuesta[] suscripcionesListRespuesta;

    public UsuarioSuscripcionRespuesta() {
    }

    public UsuarioSuscripcionRespuesta(
           com.iatai.ws.UsuarioRespuesta usuarioRespuesta,
           com.iatai.ws.SuscripcionRespuesta[] suscripcionesListRespuesta) {
           this.usuarioRespuesta = usuarioRespuesta;
           this.suscripcionesListRespuesta = suscripcionesListRespuesta;
    }


    /**
     * Gets the usuarioRespuesta value for this UsuarioSuscripcionRespuesta.
     * 
     * @return usuarioRespuesta
     */
    public com.iatai.ws.UsuarioRespuesta getUsuarioRespuesta() {
        return usuarioRespuesta;
    }


    /**
     * Sets the usuarioRespuesta value for this UsuarioSuscripcionRespuesta.
     * 
     * @param usuarioRespuesta
     */
    public void setUsuarioRespuesta(com.iatai.ws.UsuarioRespuesta usuarioRespuesta) {
        this.usuarioRespuesta = usuarioRespuesta;
    }


    /**
     * Gets the suscripcionesListRespuesta value for this UsuarioSuscripcionRespuesta.
     * 
     * @return suscripcionesListRespuesta
     */
    public com.iatai.ws.SuscripcionRespuesta[] getSuscripcionesListRespuesta() {
        return suscripcionesListRespuesta;
    }


    /**
     * Sets the suscripcionesListRespuesta value for this UsuarioSuscripcionRespuesta.
     * 
     * @param suscripcionesListRespuesta
     */
    public void setSuscripcionesListRespuesta(com.iatai.ws.SuscripcionRespuesta[] suscripcionesListRespuesta) {
        this.suscripcionesListRespuesta = suscripcionesListRespuesta;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UsuarioSuscripcionRespuesta)) return false;
        UsuarioSuscripcionRespuesta other = (UsuarioSuscripcionRespuesta) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.usuarioRespuesta==null && other.getUsuarioRespuesta()==null) || 
             (this.usuarioRespuesta!=null &&
              this.usuarioRespuesta.equals(other.getUsuarioRespuesta()))) &&
            ((this.suscripcionesListRespuesta==null && other.getSuscripcionesListRespuesta()==null) || 
             (this.suscripcionesListRespuesta!=null &&
              java.util.Arrays.equals(this.suscripcionesListRespuesta, other.getSuscripcionesListRespuesta())));
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
        if (getUsuarioRespuesta() != null) {
            _hashCode += getUsuarioRespuesta().hashCode();
        }
        if (getSuscripcionesListRespuesta() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSuscripcionesListRespuesta());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSuscripcionesListRespuesta(), i);
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
        new org.apache.axis.description.TypeDesc(UsuarioSuscripcionRespuesta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "usuarioSuscripcionRespuesta"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("usuarioRespuesta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.iatai.com/", "usuarioRespuesta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "usuarioRespuesta"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("suscripcionesListRespuesta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionesListRespuesta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionesListRespuesta"));
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
