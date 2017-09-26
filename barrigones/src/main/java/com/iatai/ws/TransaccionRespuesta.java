/**
 * TransaccionRespuesta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.iatai.ws;

public class TransaccionRespuesta  implements java.io.Serializable {
    private java.lang.String idTransaccion;

    private int idEstado;

    private java.lang.String nombreEstado;

    private java.lang.String referencia;

    private java.lang.String codigoRespuesta;

    private java.lang.String codigoAutorizacion;

    private java.lang.String riesgo;

    private float valor;

    private float iva;

    private float baseDevolucion;

    private java.lang.String fechaProcesamiento;

    private java.lang.String mensaje;

    public TransaccionRespuesta() {
    }

    public TransaccionRespuesta(
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
           this.idTransaccion = idTransaccion;
           this.idEstado = idEstado;
           this.nombreEstado = nombreEstado;
           this.referencia = referencia;
           this.codigoRespuesta = codigoRespuesta;
           this.codigoAutorizacion = codigoAutorizacion;
           this.riesgo = riesgo;
           this.valor = valor;
           this.iva = iva;
           this.baseDevolucion = baseDevolucion;
           this.fechaProcesamiento = fechaProcesamiento;
           this.mensaje = mensaje;
    }


    /**
     * Gets the idTransaccion value for this TransaccionRespuesta.
     * 
     * @return idTransaccion
     */
    public java.lang.String getIdTransaccion() {
        return idTransaccion;
    }


    /**
     * Sets the idTransaccion value for this TransaccionRespuesta.
     * 
     * @param idTransaccion
     */
    public void setIdTransaccion(java.lang.String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }


    /**
     * Gets the idEstado value for this TransaccionRespuesta.
     * 
     * @return idEstado
     */
    public int getIdEstado() {
        return idEstado;
    }


    /**
     * Sets the idEstado value for this TransaccionRespuesta.
     * 
     * @param idEstado
     */
    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }


    /**
     * Gets the nombreEstado value for this TransaccionRespuesta.
     * 
     * @return nombreEstado
     */
    public java.lang.String getNombreEstado() {
        return nombreEstado;
    }


    /**
     * Sets the nombreEstado value for this TransaccionRespuesta.
     * 
     * @param nombreEstado
     */
    public void setNombreEstado(java.lang.String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }


    /**
     * Gets the referencia value for this TransaccionRespuesta.
     * 
     * @return referencia
     */
    public java.lang.String getReferencia() {
        return referencia;
    }


    /**
     * Sets the referencia value for this TransaccionRespuesta.
     * 
     * @param referencia
     */
    public void setReferencia(java.lang.String referencia) {
        this.referencia = referencia;
    }


    /**
     * Gets the codigoRespuesta value for this TransaccionRespuesta.
     * 
     * @return codigoRespuesta
     */
    public java.lang.String getCodigoRespuesta() {
        return codigoRespuesta;
    }


    /**
     * Sets the codigoRespuesta value for this TransaccionRespuesta.
     * 
     * @param codigoRespuesta
     */
    public void setCodigoRespuesta(java.lang.String codigoRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
    }


    /**
     * Gets the codigoAutorizacion value for this TransaccionRespuesta.
     * 
     * @return codigoAutorizacion
     */
    public java.lang.String getCodigoAutorizacion() {
        return codigoAutorizacion;
    }


    /**
     * Sets the codigoAutorizacion value for this TransaccionRespuesta.
     * 
     * @param codigoAutorizacion
     */
    public void setCodigoAutorizacion(java.lang.String codigoAutorizacion) {
        this.codigoAutorizacion = codigoAutorizacion;
    }


    /**
     * Gets the riesgo value for this TransaccionRespuesta.
     * 
     * @return riesgo
     */
    public java.lang.String getRiesgo() {
        return riesgo;
    }


    /**
     * Sets the riesgo value for this TransaccionRespuesta.
     * 
     * @param riesgo
     */
    public void setRiesgo(java.lang.String riesgo) {
        this.riesgo = riesgo;
    }


    /**
     * Gets the valor value for this TransaccionRespuesta.
     * 
     * @return valor
     */
    public float getValor() {
        return valor;
    }


    /**
     * Sets the valor value for this TransaccionRespuesta.
     * 
     * @param valor
     */
    public void setValor(float valor) {
        this.valor = valor;
    }


    /**
     * Gets the iva value for this TransaccionRespuesta.
     * 
     * @return iva
     */
    public float getIva() {
        return iva;
    }


    /**
     * Sets the iva value for this TransaccionRespuesta.
     * 
     * @param iva
     */
    public void setIva(float iva) {
        this.iva = iva;
    }


    /**
     * Gets the baseDevolucion value for this TransaccionRespuesta.
     * 
     * @return baseDevolucion
     */
    public float getBaseDevolucion() {
        return baseDevolucion;
    }


    /**
     * Sets the baseDevolucion value for this TransaccionRespuesta.
     * 
     * @param baseDevolucion
     */
    public void setBaseDevolucion(float baseDevolucion) {
        this.baseDevolucion = baseDevolucion;
    }


    /**
     * Gets the fechaProcesamiento value for this TransaccionRespuesta.
     * 
     * @return fechaProcesamiento
     */
    public java.lang.String getFechaProcesamiento() {
        return fechaProcesamiento;
    }


    /**
     * Sets the fechaProcesamiento value for this TransaccionRespuesta.
     * 
     * @param fechaProcesamiento
     */
    public void setFechaProcesamiento(java.lang.String fechaProcesamiento) {
        this.fechaProcesamiento = fechaProcesamiento;
    }


    /**
     * Gets the mensaje value for this TransaccionRespuesta.
     * 
     * @return mensaje
     */
    public java.lang.String getMensaje() {
        return mensaje;
    }


    /**
     * Sets the mensaje value for this TransaccionRespuesta.
     * 
     * @param mensaje
     */
    public void setMensaje(java.lang.String mensaje) {
        this.mensaje = mensaje;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TransaccionRespuesta)) return false;
        TransaccionRespuesta other = (TransaccionRespuesta) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.idTransaccion==null && other.getIdTransaccion()==null) || 
             (this.idTransaccion!=null &&
              this.idTransaccion.equals(other.getIdTransaccion()))) &&
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
            ((this.codigoAutorizacion==null && other.getCodigoAutorizacion()==null) || 
             (this.codigoAutorizacion!=null &&
              this.codigoAutorizacion.equals(other.getCodigoAutorizacion()))) &&
            ((this.riesgo==null && other.getRiesgo()==null) || 
             (this.riesgo!=null &&
              this.riesgo.equals(other.getRiesgo()))) &&
            this.valor == other.getValor() &&
            this.iva == other.getIva() &&
            this.baseDevolucion == other.getBaseDevolucion() &&
            ((this.fechaProcesamiento==null && other.getFechaProcesamiento()==null) || 
             (this.fechaProcesamiento!=null &&
              this.fechaProcesamiento.equals(other.getFechaProcesamiento()))) &&
            ((this.mensaje==null && other.getMensaje()==null) || 
             (this.mensaje!=null &&
              this.mensaje.equals(other.getMensaje())));
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
        if (getIdTransaccion() != null) {
            _hashCode += getIdTransaccion().hashCode();
        }
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
        if (getCodigoAutorizacion() != null) {
            _hashCode += getCodigoAutorizacion().hashCode();
        }
        if (getRiesgo() != null) {
            _hashCode += getRiesgo().hashCode();
        }
        _hashCode += new Float(getValor()).hashCode();
        _hashCode += new Float(getIva()).hashCode();
        _hashCode += new Float(getBaseDevolucion()).hashCode();
        if (getFechaProcesamiento() != null) {
            _hashCode += getFechaProcesamiento().hashCode();
        }
        if (getMensaje() != null) {
            _hashCode += getMensaje().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TransaccionRespuesta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "transaccionRespuesta"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idTransaccion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idTransaccion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("codigoAutorizacion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codigoAutorizacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("riesgo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "riesgo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "valor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("iva");
        elemField.setXmlName(new javax.xml.namespace.QName("", "iva"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("baseDevolucion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "baseDevolucion"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mensaje");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mensaje"));
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
