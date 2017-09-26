/**
 * VerificacionRespuesta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.iatai.ws;

public class VerificacionRespuesta  implements java.io.Serializable {
    private int idEstado;

    private java.lang.String nombreEstado;

    private java.lang.String referencia;

    private java.lang.String codigoRespuesta;

    private float riesgo;

    private java.lang.String fechaProcesamiento;

    public VerificacionRespuesta() {
    }

    public VerificacionRespuesta(
           int idEstado,
           java.lang.String nombreEstado,
           java.lang.String referencia,
           java.lang.String codigoRespuesta,
           float riesgo,
           java.lang.String fechaProcesamiento) {
           this.idEstado = idEstado;
           this.nombreEstado = nombreEstado;
           this.referencia = referencia;
           this.codigoRespuesta = codigoRespuesta;
           this.riesgo = riesgo;
           this.fechaProcesamiento = fechaProcesamiento;
    }


    /**
     * Gets the idEstado value for this VerificacionRespuesta.
     * 
     * @return idEstado
     */
    public int getIdEstado() {
        return idEstado;
    }


    /**
     * Sets the idEstado value for this VerificacionRespuesta.
     * 
     * @param idEstado
     */
    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }


    /**
     * Gets the nombreEstado value for this VerificacionRespuesta.
     * 
     * @return nombreEstado
     */
    public java.lang.String getNombreEstado() {
        return nombreEstado;
    }


    /**
     * Sets the nombreEstado value for this VerificacionRespuesta.
     * 
     * @param nombreEstado
     */
    public void setNombreEstado(java.lang.String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }


    /**
     * Gets the referencia value for this VerificacionRespuesta.
     * 
     * @return referencia
     */
    public java.lang.String getReferencia() {
        return referencia;
    }


    /**
     * Sets the referencia value for this VerificacionRespuesta.
     * 
     * @param referencia
     */
    public void setReferencia(java.lang.String referencia) {
        this.referencia = referencia;
    }


    /**
     * Gets the codigoRespuesta value for this VerificacionRespuesta.
     * 
     * @return codigoRespuesta
     */
    public java.lang.String getCodigoRespuesta() {
        return codigoRespuesta;
    }


    /**
     * Sets the codigoRespuesta value for this VerificacionRespuesta.
     * 
     * @param codigoRespuesta
     */
    public void setCodigoRespuesta(java.lang.String codigoRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
    }


    /**
     * Gets the riesgo value for this VerificacionRespuesta.
     * 
     * @return riesgo
     */
    public float getRiesgo() {
        return riesgo;
    }


    /**
     * Sets the riesgo value for this VerificacionRespuesta.
     * 
     * @param riesgo
     */
    public void setRiesgo(float riesgo) {
        this.riesgo = riesgo;
    }


    /**
     * Gets the fechaProcesamiento value for this VerificacionRespuesta.
     * 
     * @return fechaProcesamiento
     */
    public java.lang.String getFechaProcesamiento() {
        return fechaProcesamiento;
    }


    /**
     * Sets the fechaProcesamiento value for this VerificacionRespuesta.
     * 
     * @param fechaProcesamiento
     */
    public void setFechaProcesamiento(java.lang.String fechaProcesamiento) {
        this.fechaProcesamiento = fechaProcesamiento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof VerificacionRespuesta)) return false;
        VerificacionRespuesta other = (VerificacionRespuesta) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idEstado == other.getIdEstado() &&
            ((this.nombreEstado==null && other.getNombreEstado()==null) || 
             (this.nombreEstado!=null &&
              this.nombreEstado.equals(other.getNombreEstado()))) &&
            ((this.referencia==null && other.getReferencia()==null) || 
             (this.referencia!=null &&
              this.referencia.equals(other.getReferencia()))) &&
            ((this.codigoRespuesta==null && other.getCodigoRespuesta()==null) || 
             (this.codigoRespuesta!=null &&
              this.codigoRespuesta.equals(other.getCodigoRespuesta()))) &&
            this.riesgo == other.getRiesgo() &&
            ((this.fechaProcesamiento==null && other.getFechaProcesamiento()==null) || 
             (this.fechaProcesamiento!=null &&
              this.fechaProcesamiento.equals(other.getFechaProcesamiento())));
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
        _hashCode += getIdEstado();
        if (getNombreEstado() != null) {
            _hashCode += getNombreEstado().hashCode();
        }
        if (getReferencia() != null) {
            _hashCode += getReferencia().hashCode();
        }
        if (getCodigoRespuesta() != null) {
            _hashCode += getCodigoRespuesta().hashCode();
        }
        _hashCode += new Float(getRiesgo()).hashCode();
        if (getFechaProcesamiento() != null) {
            _hashCode += getFechaProcesamiento().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(VerificacionRespuesta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "verificacionRespuesta"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idEstado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idEstado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombreEstado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombreEstado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "referencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoRespuesta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codigoRespuesta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("riesgo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "riesgo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaProcesamiento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaProcesamiento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
