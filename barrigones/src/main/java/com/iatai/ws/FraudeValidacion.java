/**
 * FraudeValidacion.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.iatai.ws;

public class FraudeValidacion  extends com.iatai.ws.FraudeValidacionBase  implements java.io.Serializable {
    private java.lang.String paisCorrespondencia;

    private java.lang.String estadoProvincia;

    private java.lang.String ciudadCorrespondencia;

    private java.lang.String direccionCorrespondencia;

    private java.lang.String codigoPostal;

    private com.iatai.ws.Item[] productos;

    public FraudeValidacion() {
    }

    public FraudeValidacion(
           com.iatai.ws.Envio envio,
           java.lang.String ipComprador,
           java.lang.String hostComprador,
           java.lang.String cookie,
           java.lang.String userAgent,
           java.lang.String deviceFingerPrint,
           java.lang.String paisCorrespondencia,
           java.lang.String estadoProvincia,
           java.lang.String ciudadCorrespondencia,
           java.lang.String direccionCorrespondencia,
           java.lang.String codigoPostal,
           com.iatai.ws.Item[] productos) {
        super(
            envio,
            ipComprador,
            hostComprador,
            cookie,
            userAgent,
            deviceFingerPrint);
        this.paisCorrespondencia = paisCorrespondencia;
        this.estadoProvincia = estadoProvincia;
        this.ciudadCorrespondencia = ciudadCorrespondencia;
        this.direccionCorrespondencia = direccionCorrespondencia;
        this.codigoPostal = codigoPostal;
        this.productos = productos;
    }


    /**
     * Gets the paisCorrespondencia value for this FraudeValidacion.
     * 
     * @return paisCorrespondencia
     */
    public java.lang.String getPaisCorrespondencia() {
        return paisCorrespondencia;
    }


    /**
     * Sets the paisCorrespondencia value for this FraudeValidacion.
     * 
     * @param paisCorrespondencia
     */
    public void setPaisCorrespondencia(java.lang.String paisCorrespondencia) {
        this.paisCorrespondencia = paisCorrespondencia;
    }


    /**
     * Gets the estadoProvincia value for this FraudeValidacion.
     * 
     * @return estadoProvincia
     */
    public java.lang.String getEstadoProvincia() {
        return estadoProvincia;
    }


    /**
     * Sets the estadoProvincia value for this FraudeValidacion.
     * 
     * @param estadoProvincia
     */
    public void setEstadoProvincia(java.lang.String estadoProvincia) {
        this.estadoProvincia = estadoProvincia;
    }


    /**
     * Gets the ciudadCorrespondencia value for this FraudeValidacion.
     * 
     * @return ciudadCorrespondencia
     */
    public java.lang.String getCiudadCorrespondencia() {
        return ciudadCorrespondencia;
    }


    /**
     * Sets the ciudadCorrespondencia value for this FraudeValidacion.
     * 
     * @param ciudadCorrespondencia
     */
    public void setCiudadCorrespondencia(java.lang.String ciudadCorrespondencia) {
        this.ciudadCorrespondencia = ciudadCorrespondencia;
    }


    /**
     * Gets the direccionCorrespondencia value for this FraudeValidacion.
     * 
     * @return direccionCorrespondencia
     */
    public java.lang.String getDireccionCorrespondencia() {
        return direccionCorrespondencia;
    }


    /**
     * Sets the direccionCorrespondencia value for this FraudeValidacion.
     * 
     * @param direccionCorrespondencia
     */
    public void setDireccionCorrespondencia(java.lang.String direccionCorrespondencia) {
        this.direccionCorrespondencia = direccionCorrespondencia;
    }


    /**
     * Gets the codigoPostal value for this FraudeValidacion.
     * 
     * @return codigoPostal
     */
    public java.lang.String getCodigoPostal() {
        return codigoPostal;
    }


    /**
     * Sets the codigoPostal value for this FraudeValidacion.
     * 
     * @param codigoPostal
     */
    public void setCodigoPostal(java.lang.String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }


    /**
     * Gets the productos value for this FraudeValidacion.
     * 
     * @return productos
     */
    public com.iatai.ws.Item[] getProductos() {
        return productos;
    }


    /**
     * Sets the productos value for this FraudeValidacion.
     * 
     * @param productos
     */
    public void setProductos(com.iatai.ws.Item[] productos) {
        this.productos = productos;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FraudeValidacion)) return false;
        FraudeValidacion other = (FraudeValidacion) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.paisCorrespondencia==null && other.getPaisCorrespondencia()==null) || 
             (this.paisCorrespondencia!=null &&
              this.paisCorrespondencia.equals(other.getPaisCorrespondencia()))) &&
            ((this.estadoProvincia==null && other.getEstadoProvincia()==null) || 
             (this.estadoProvincia!=null &&
              this.estadoProvincia.equals(other.getEstadoProvincia()))) &&
            ((this.ciudadCorrespondencia==null && other.getCiudadCorrespondencia()==null) || 
             (this.ciudadCorrespondencia!=null &&
              this.ciudadCorrespondencia.equals(other.getCiudadCorrespondencia()))) &&
            ((this.direccionCorrespondencia==null && other.getDireccionCorrespondencia()==null) || 
             (this.direccionCorrespondencia!=null &&
              this.direccionCorrespondencia.equals(other.getDireccionCorrespondencia()))) &&
            ((this.codigoPostal==null && other.getCodigoPostal()==null) || 
             (this.codigoPostal!=null &&
              this.codigoPostal.equals(other.getCodigoPostal()))) &&
            ((this.productos==null && other.getProductos()==null) || 
             (this.productos!=null &&
              java.util.Arrays.equals(this.productos, other.getProductos())));
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
        if (getPaisCorrespondencia() != null) {
            _hashCode += getPaisCorrespondencia().hashCode();
        }
        if (getEstadoProvincia() != null) {
            _hashCode += getEstadoProvincia().hashCode();
        }
        if (getCiudadCorrespondencia() != null) {
            _hashCode += getCiudadCorrespondencia().hashCode();
        }
        if (getDireccionCorrespondencia() != null) {
            _hashCode += getDireccionCorrespondencia().hashCode();
        }
        if (getCodigoPostal() != null) {
            _hashCode += getCodigoPostal().hashCode();
        }
        if (getProductos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getProductos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getProductos(), i);
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
        new org.apache.axis.description.TypeDesc(FraudeValidacion.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "FraudeValidacion"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paisCorrespondencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paisCorrespondencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estadoProvincia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estadoProvincia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ciudadCorrespondencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ciudadCorrespondencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("direccionCorrespondencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "direccionCorrespondencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoPostal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codigoPostal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "item"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "producto"));
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
