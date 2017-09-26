/**
 * TransaccionRespuestaBase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.iatai.ws;

public class TransaccionRespuestaBase  implements java.io.Serializable {
    private java.lang.String idTransaccion;

    private java.lang.String referencia;

    private int idEstado;

    private java.lang.String nombreEstado;

    private java.lang.String codigoRespuesta;

    private java.lang.String codigoAutorizacion;

    private float valor;

    private float iva;

    private float baseDevolucion;

    private java.lang.String isoMoneda;

    private java.lang.String fechaProcesamiento;

    private java.lang.String mensaje;

    private com.iatai.ws.TarjetaRespuesta tarjetaRespuesta;

    private com.iatai.ws.ProcesadorRespuesta procesadorRespuesta;

    public TransaccionRespuestaBase() {
    }

    public TransaccionRespuestaBase(
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
           com.iatai.ws.ProcesadorRespuesta procesadorRespuesta) {
           this.idTransaccion = idTransaccion;
           this.referencia = referencia;
           this.idEstado = idEstado;
           this.nombreEstado = nombreEstado;
           this.codigoRespuesta = codigoRespuesta;
           this.codigoAutorizacion = codigoAutorizacion;
           this.valor = valor;
           this.iva = iva;
           this.baseDevolucion = baseDevolucion;
           this.isoMoneda = isoMoneda;
           this.fechaProcesamiento = fechaProcesamiento;
           this.mensaje = mensaje;
           this.tarjetaRespuesta = tarjetaRespuesta;
           this.procesadorRespuesta = procesadorRespuesta;
    }


    /**
     * Gets the idTransaccion value for this TransaccionRespuestaBase.
     * 
     * @return idTransaccion
     */
    public java.lang.String getIdTransaccion() {
        return idTransaccion;
    }


    /**
     * Sets the idTransaccion value for this TransaccionRespuestaBase.
     * 
     * @param idTransaccion
     */
    public void setIdTransaccion(java.lang.String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }


    /**
     * Gets the referencia value for this TransaccionRespuestaBase.
     * 
     * @return referencia
     */
    public java.lang.String getReferencia() {
        return referencia;
    }


    /**
     * Sets the referencia value for this TransaccionRespuestaBase.
     * 
     * @param referencia
     */
    public void setReferencia(java.lang.String referencia) {
        this.referencia = referencia;
    }


    /**
     * Gets the idEstado value for this TransaccionRespuestaBase.
     * 
     * @return idEstado
     */
    public int getIdEstado() {
        return idEstado;
    }


    /**
     * Sets the idEstado value for this TransaccionRespuestaBase.
     * 
     * @param idEstado
     */
    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }


    /**
     * Gets the nombreEstado value for this TransaccionRespuestaBase.
     * 
     * @return nombreEstado
     */
    public java.lang.String getNombreEstado() {
        return nombreEstado;
    }


    /**
     * Sets the nombreEstado value for this TransaccionRespuestaBase.
     * 
     * @param nombreEstado
     */
    public void setNombreEstado(java.lang.String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }


    /**
     * Gets the codigoRespuesta value for this TransaccionRespuestaBase.
     * 
     * @return codigoRespuesta
     */
    public java.lang.String getCodigoRespuesta() {
        return codigoRespuesta;
    }


    /**
     * Sets the codigoRespuesta value for this TransaccionRespuestaBase.
     * 
     * @param codigoRespuesta
     */
    public void setCodigoRespuesta(java.lang.String codigoRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
    }


    /**
     * Gets the codigoAutorizacion value for this TransaccionRespuestaBase.
     * 
     * @return codigoAutorizacion
     */
    public java.lang.String getCodigoAutorizacion() {
        return codigoAutorizacion;
    }


    /**
     * Sets the codigoAutorizacion value for this TransaccionRespuestaBase.
     * 
     * @param codigoAutorizacion
     */
    public void setCodigoAutorizacion(java.lang.String codigoAutorizacion) {
        this.codigoAutorizacion = codigoAutorizacion;
    }


    /**
     * Gets the valor value for this TransaccionRespuestaBase.
     * 
     * @return valor
     */
    public float getValor() {
        return valor;
    }


    /**
     * Sets the valor value for this TransaccionRespuestaBase.
     * 
     * @param valor
     */
    public void setValor(float valor) {
        this.valor = valor;
    }


    /**
     * Gets the iva value for this TransaccionRespuestaBase.
     * 
     * @return iva
     */
    public float getIva() {
        return iva;
    }


    /**
     * Sets the iva value for this TransaccionRespuestaBase.
     * 
     * @param iva
     */
    public void setIva(float iva) {
        this.iva = iva;
    }


    /**
     * Gets the baseDevolucion value for this TransaccionRespuestaBase.
     * 
     * @return baseDevolucion
     */
    public float getBaseDevolucion() {
        return baseDevolucion;
    }


    /**
     * Sets the baseDevolucion value for this TransaccionRespuestaBase.
     * 
     * @param baseDevolucion
     */
    public void setBaseDevolucion(float baseDevolucion) {
        this.baseDevolucion = baseDevolucion;
    }


    /**
     * Gets the isoMoneda value for this TransaccionRespuestaBase.
     * 
     * @return isoMoneda
     */
    public java.lang.String getIsoMoneda() {
        return isoMoneda;
    }


    /**
     * Sets the isoMoneda value for this TransaccionRespuestaBase.
     * 
     * @param isoMoneda
     */
    public void setIsoMoneda(java.lang.String isoMoneda) {
        this.isoMoneda = isoMoneda;
    }


    /**
     * Gets the fechaProcesamiento value for this TransaccionRespuestaBase.
     * 
     * @return fechaProcesamiento
     */
    public java.lang.String getFechaProcesamiento() {
        return fechaProcesamiento;
    }


    /**
     * Sets the fechaProcesamiento value for this TransaccionRespuestaBase.
     * 
     * @param fechaProcesamiento
     */
    public void setFechaProcesamiento(java.lang.String fechaProcesamiento) {
        this.fechaProcesamiento = fechaProcesamiento;
    }


    /**
     * Gets the mensaje value for this TransaccionRespuestaBase.
     * 
     * @return mensaje
     */
    public java.lang.String getMensaje() {
        return mensaje;
    }


    /**
     * Sets the mensaje value for this TransaccionRespuestaBase.
     * 
     * @param mensaje
     */
    public void setMensaje(java.lang.String mensaje) {
        this.mensaje = mensaje;
    }


    /**
     * Gets the tarjetaRespuesta value for this TransaccionRespuestaBase.
     * 
     * @return tarjetaRespuesta
     */
    public com.iatai.ws.TarjetaRespuesta getTarjetaRespuesta() {
        return tarjetaRespuesta;
    }


    /**
     * Sets the tarjetaRespuesta value for this TransaccionRespuestaBase.
     * 
     * @param tarjetaRespuesta
     */
    public void setTarjetaRespuesta(com.iatai.ws.TarjetaRespuesta tarjetaRespuesta) {
        this.tarjetaRespuesta = tarjetaRespuesta;
    }


    /**
     * Gets the procesadorRespuesta value for this TransaccionRespuestaBase.
     * 
     * @return procesadorRespuesta
     */
    public com.iatai.ws.ProcesadorRespuesta getProcesadorRespuesta() {
        return procesadorRespuesta;
    }


    /**
     * Sets the procesadorRespuesta value for this TransaccionRespuestaBase.
     * 
     * @param procesadorRespuesta
     */
    public void setProcesadorRespuesta(com.iatai.ws.ProcesadorRespuesta procesadorRespuesta) {
        this.procesadorRespuesta = procesadorRespuesta;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TransaccionRespuestaBase)) return false;
        TransaccionRespuestaBase other = (TransaccionRespuestaBase) obj;
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
            ((this.referencia==null && other.getReferencia()==null) || 
             (this.referencia!=null &&
              this.referencia.equals(other.getReferencia()))) &&
            this.idEstado == other.getIdEstado() &&
            ((this.nombreEstado==null && other.getNombreEstado()==null) || 
             (this.nombreEstado!=null &&
              this.nombreEstado.equals(other.getNombreEstado()))) &&
            ((this.codigoRespuesta==null && other.getCodigoRespuesta()==null) || 
             (this.codigoRespuesta!=null &&
              this.codigoRespuesta.equals(other.getCodigoRespuesta()))) &&
            ((this.codigoAutorizacion==null && other.getCodigoAutorizacion()==null) || 
             (this.codigoAutorizacion!=null &&
              this.codigoAutorizacion.equals(other.getCodigoAutorizacion()))) &&
            this.valor == other.getValor() &&
            this.iva == other.getIva() &&
            this.baseDevolucion == other.getBaseDevolucion() &&
            ((this.isoMoneda==null && other.getIsoMoneda()==null) || 
             (this.isoMoneda!=null &&
              this.isoMoneda.equals(other.getIsoMoneda()))) &&
            ((this.fechaProcesamiento==null && other.getFechaProcesamiento()==null) || 
             (this.fechaProcesamiento!=null &&
              this.fechaProcesamiento.equals(other.getFechaProcesamiento()))) &&
            ((this.mensaje==null && other.getMensaje()==null) || 
             (this.mensaje!=null &&
              this.mensaje.equals(other.getMensaje()))) &&
            ((this.tarjetaRespuesta==null && other.getTarjetaRespuesta()==null) || 
             (this.tarjetaRespuesta!=null &&
              this.tarjetaRespuesta.equals(other.getTarjetaRespuesta()))) &&
            ((this.procesadorRespuesta==null && other.getProcesadorRespuesta()==null) || 
             (this.procesadorRespuesta!=null &&
              this.procesadorRespuesta.equals(other.getProcesadorRespuesta())));
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
        if (getReferencia() != null) {
            _hashCode += getReferencia().hashCode();
        }
        _hashCode += getIdEstado();
        if (getNombreEstado() != null) {
            _hashCode += getNombreEstado().hashCode();
        }
        if (getCodigoRespuesta() != null) {
            _hashCode += getCodigoRespuesta().hashCode();
        }
        if (getCodigoAutorizacion() != null) {
            _hashCode += getCodigoAutorizacion().hashCode();
        }
        _hashCode += new Float(getValor()).hashCode();
        _hashCode += new Float(getIva()).hashCode();
        _hashCode += new Float(getBaseDevolucion()).hashCode();
        if (getIsoMoneda() != null) {
            _hashCode += getIsoMoneda().hashCode();
        }
        if (getFechaProcesamiento() != null) {
            _hashCode += getFechaProcesamiento().hashCode();
        }
        if (getMensaje() != null) {
            _hashCode += getMensaje().hashCode();
        }
        if (getTarjetaRespuesta() != null) {
            _hashCode += getTarjetaRespuesta().hashCode();
        }
        if (getProcesadorRespuesta() != null) {
            _hashCode += getProcesadorRespuesta().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TransaccionRespuestaBase.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "transaccionRespuestaBase"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idTransaccion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idTransaccion"));
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
        elemField.setFieldName("isoMoneda");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isoMoneda"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tarjetaRespuesta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.iatai.com/", "tarjetaRespuesta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "tarjetaRespuesta"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("procesadorRespuesta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.iatai.com/", "procesadorRespuesta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "procesadorRespuesta"));
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
