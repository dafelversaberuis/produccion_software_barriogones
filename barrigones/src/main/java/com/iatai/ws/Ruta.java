/**
 * Ruta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.iatai.ws;

public class Ruta  implements java.io.Serializable {
    private boolean idaVuelta;

    private java.util.Calendar fechaSalida;

    private com.iatai.ws.Aeropuerto[] aeropuertos;

    public Ruta() {
    }

    public Ruta(
           boolean idaVuelta,
           java.util.Calendar fechaSalida,
           com.iatai.ws.Aeropuerto[] aeropuertos) {
           this.idaVuelta = idaVuelta;
           this.fechaSalida = fechaSalida;
           this.aeropuertos = aeropuertos;
    }


    /**
     * Gets the idaVuelta value for this Ruta.
     * 
     * @return idaVuelta
     */
    public boolean isIdaVuelta() {
        return idaVuelta;
    }


    /**
     * Sets the idaVuelta value for this Ruta.
     * 
     * @param idaVuelta
     */
    public void setIdaVuelta(boolean idaVuelta) {
        this.idaVuelta = idaVuelta;
    }


    /**
     * Gets the fechaSalida value for this Ruta.
     * 
     * @return fechaSalida
     */
    public java.util.Calendar getFechaSalida() {
        return fechaSalida;
    }


    /**
     * Sets the fechaSalida value for this Ruta.
     * 
     * @param fechaSalida
     */
    public void setFechaSalida(java.util.Calendar fechaSalida) {
        this.fechaSalida = fechaSalida;
    }


    /**
     * Gets the aeropuertos value for this Ruta.
     * 
     * @return aeropuertos
     */
    public com.iatai.ws.Aeropuerto[] getAeropuertos() {
        return aeropuertos;
    }


    /**
     * Sets the aeropuertos value for this Ruta.
     * 
     * @param aeropuertos
     */
    public void setAeropuertos(com.iatai.ws.Aeropuerto[] aeropuertos) {
        this.aeropuertos = aeropuertos;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ruta)) return false;
        Ruta other = (Ruta) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idaVuelta == other.isIdaVuelta() &&
            ((this.fechaSalida==null && other.getFechaSalida()==null) || 
             (this.fechaSalida!=null &&
              this.fechaSalida.equals(other.getFechaSalida()))) &&
            ((this.aeropuertos==null && other.getAeropuertos()==null) || 
             (this.aeropuertos!=null &&
              java.util.Arrays.equals(this.aeropuertos, other.getAeropuertos())));
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
        _hashCode += (isIdaVuelta() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getFechaSalida() != null) {
            _hashCode += getFechaSalida().hashCode();
        }
        if (getAeropuertos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAeropuertos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAeropuertos(), i);
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
        new org.apache.axis.description.TypeDesc(Ruta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "ruta"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idaVuelta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idaVuelta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaSalida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaSalida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aeropuertos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Aeropuertos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "aeropuerto"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "Aeropuerto"));
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
