/**
 * SuscripcionRespuesta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.iatai.ws;

public class SuscripcionRespuesta  implements java.io.Serializable {
    private java.lang.Integer idUsuarioSubscripcion;

    private java.lang.String suscripcionID;

    private java.lang.String fechaSuscripcion;

    private java.lang.String horaSuscripcion;

    private com.iatai.ws.SuscripcionTarjetaRespuesta suscripcionTarjetaRespuesta;

    private com.iatai.ws.SuscripcionTitularRespuesta suscripcionTitularRespuesta;

    public SuscripcionRespuesta() {
    }

    public SuscripcionRespuesta(
           java.lang.Integer idUsuarioSubscripcion,
           java.lang.String suscripcionID,
           java.lang.String fechaSuscripcion,
           java.lang.String horaSuscripcion,
           com.iatai.ws.SuscripcionTarjetaRespuesta suscripcionTarjetaRespuesta,
           com.iatai.ws.SuscripcionTitularRespuesta suscripcionTitularRespuesta) {
           this.idUsuarioSubscripcion = idUsuarioSubscripcion;
           this.suscripcionID = suscripcionID;
           this.fechaSuscripcion = fechaSuscripcion;
           this.horaSuscripcion = horaSuscripcion;
           this.suscripcionTarjetaRespuesta = suscripcionTarjetaRespuesta;
           this.suscripcionTitularRespuesta = suscripcionTitularRespuesta;
    }


    /**
     * Gets the idUsuarioSubscripcion value for this SuscripcionRespuesta.
     * 
     * @return idUsuarioSubscripcion
     */
    public java.lang.Integer getIdUsuarioSubscripcion() {
        return idUsuarioSubscripcion;
    }


    /**
     * Sets the idUsuarioSubscripcion value for this SuscripcionRespuesta.
     * 
     * @param idUsuarioSubscripcion
     */
    public void setIdUsuarioSubscripcion(java.lang.Integer idUsuarioSubscripcion) {
        this.idUsuarioSubscripcion = idUsuarioSubscripcion;
    }


    /**
     * Gets the suscripcionID value for this SuscripcionRespuesta.
     * 
     * @return suscripcionID
     */
    public java.lang.String getSuscripcionID() {
        return suscripcionID;
    }


    /**
     * Sets the suscripcionID value for this SuscripcionRespuesta.
     * 
     * @param suscripcionID
     */
    public void setSuscripcionID(java.lang.String suscripcionID) {
        this.suscripcionID = suscripcionID;
    }


    /**
     * Gets the fechaSuscripcion value for this SuscripcionRespuesta.
     * 
     * @return fechaSuscripcion
     */
    public java.lang.String getFechaSuscripcion() {
        return fechaSuscripcion;
    }


    /**
     * Sets the fechaSuscripcion value for this SuscripcionRespuesta.
     * 
     * @param fechaSuscripcion
     */
    public void setFechaSuscripcion(java.lang.String fechaSuscripcion) {
        this.fechaSuscripcion = fechaSuscripcion;
    }


    /**
     * Gets the horaSuscripcion value for this SuscripcionRespuesta.
     * 
     * @return horaSuscripcion
     */
    public java.lang.String getHoraSuscripcion() {
        return horaSuscripcion;
    }


    /**
     * Sets the horaSuscripcion value for this SuscripcionRespuesta.
     * 
     * @param horaSuscripcion
     */
    public void setHoraSuscripcion(java.lang.String horaSuscripcion) {
        this.horaSuscripcion = horaSuscripcion;
    }


    /**
     * Gets the suscripcionTarjetaRespuesta value for this SuscripcionRespuesta.
     * 
     * @return suscripcionTarjetaRespuesta
     */
    public com.iatai.ws.SuscripcionTarjetaRespuesta getSuscripcionTarjetaRespuesta() {
        return suscripcionTarjetaRespuesta;
    }


    /**
     * Sets the suscripcionTarjetaRespuesta value for this SuscripcionRespuesta.
     * 
     * @param suscripcionTarjetaRespuesta
     */
    public void setSuscripcionTarjetaRespuesta(com.iatai.ws.SuscripcionTarjetaRespuesta suscripcionTarjetaRespuesta) {
        this.suscripcionTarjetaRespuesta = suscripcionTarjetaRespuesta;
    }


    /**
     * Gets the suscripcionTitularRespuesta value for this SuscripcionRespuesta.
     * 
     * @return suscripcionTitularRespuesta
     */
    public com.iatai.ws.SuscripcionTitularRespuesta getSuscripcionTitularRespuesta() {
        return suscripcionTitularRespuesta;
    }


    /**
     * Sets the suscripcionTitularRespuesta value for this SuscripcionRespuesta.
     * 
     * @param suscripcionTitularRespuesta
     */
    public void setSuscripcionTitularRespuesta(com.iatai.ws.SuscripcionTitularRespuesta suscripcionTitularRespuesta) {
        this.suscripcionTitularRespuesta = suscripcionTitularRespuesta;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SuscripcionRespuesta)) return false;
        SuscripcionRespuesta other = (SuscripcionRespuesta) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.idUsuarioSubscripcion==null && other.getIdUsuarioSubscripcion()==null) || 
             (this.idUsuarioSubscripcion!=null &&
              this.idUsuarioSubscripcion.equals(other.getIdUsuarioSubscripcion()))) &&
            ((this.suscripcionID==null && other.getSuscripcionID()==null) || 
             (this.suscripcionID!=null &&
              this.suscripcionID.equals(other.getSuscripcionID()))) &&
            ((this.fechaSuscripcion==null && other.getFechaSuscripcion()==null) || 
             (this.fechaSuscripcion!=null &&
              this.fechaSuscripcion.equals(other.getFechaSuscripcion()))) &&
            ((this.horaSuscripcion==null && other.getHoraSuscripcion()==null) || 
             (this.horaSuscripcion!=null &&
              this.horaSuscripcion.equals(other.getHoraSuscripcion()))) &&
            ((this.suscripcionTarjetaRespuesta==null && other.getSuscripcionTarjetaRespuesta()==null) || 
             (this.suscripcionTarjetaRespuesta!=null &&
              this.suscripcionTarjetaRespuesta.equals(other.getSuscripcionTarjetaRespuesta()))) &&
            ((this.suscripcionTitularRespuesta==null && other.getSuscripcionTitularRespuesta()==null) || 
             (this.suscripcionTitularRespuesta!=null &&
              this.suscripcionTitularRespuesta.equals(other.getSuscripcionTitularRespuesta())));
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
        if (getIdUsuarioSubscripcion() != null) {
            _hashCode += getIdUsuarioSubscripcion().hashCode();
        }
        if (getSuscripcionID() != null) {
            _hashCode += getSuscripcionID().hashCode();
        }
        if (getFechaSuscripcion() != null) {
            _hashCode += getFechaSuscripcion().hashCode();
        }
        if (getHoraSuscripcion() != null) {
            _hashCode += getHoraSuscripcion().hashCode();
        }
        if (getSuscripcionTarjetaRespuesta() != null) {
            _hashCode += getSuscripcionTarjetaRespuesta().hashCode();
        }
        if (getSuscripcionTitularRespuesta() != null) {
            _hashCode += getSuscripcionTitularRespuesta().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SuscripcionRespuesta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionRespuesta"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idUsuarioSubscripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idUsuarioSubscripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("suscripcionID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "suscripcionID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaSuscripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaSuscripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("horaSuscripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "horaSuscripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("suscripcionTarjetaRespuesta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionTarjetaRespuesta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionTarjetaRespuesta"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("suscripcionTitularRespuesta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionTitularRespuesta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionTitularRespuesta"));
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
