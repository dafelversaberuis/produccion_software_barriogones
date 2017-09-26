/**
 * TarjetaRespuesta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.iatai.ws;

public class TarjetaRespuesta  implements java.io.Serializable {
    private java.lang.Integer idFranquicia;

    private java.lang.String nombreFranquicia;

    private java.lang.String numeroBin;

    private java.lang.String numeroProducto;

    public TarjetaRespuesta() {
    }

    public TarjetaRespuesta(
           java.lang.Integer idFranquicia,
           java.lang.String nombreFranquicia,
           java.lang.String numeroBin,
           java.lang.String numeroProducto) {
           this.idFranquicia = idFranquicia;
           this.nombreFranquicia = nombreFranquicia;
           this.numeroBin = numeroBin;
           this.numeroProducto = numeroProducto;
    }


    /**
     * Gets the idFranquicia value for this TarjetaRespuesta.
     * 
     * @return idFranquicia
     */
    public java.lang.Integer getIdFranquicia() {
        return idFranquicia;
    }


    /**
     * Sets the idFranquicia value for this TarjetaRespuesta.
     * 
     * @param idFranquicia
     */
    public void setIdFranquicia(java.lang.Integer idFranquicia) {
        this.idFranquicia = idFranquicia;
    }


    /**
     * Gets the nombreFranquicia value for this TarjetaRespuesta.
     * 
     * @return nombreFranquicia
     */
    public java.lang.String getNombreFranquicia() {
        return nombreFranquicia;
    }


    /**
     * Sets the nombreFranquicia value for this TarjetaRespuesta.
     * 
     * @param nombreFranquicia
     */
    public void setNombreFranquicia(java.lang.String nombreFranquicia) {
        this.nombreFranquicia = nombreFranquicia;
    }


    /**
     * Gets the numeroBin value for this TarjetaRespuesta.
     * 
     * @return numeroBin
     */
    public java.lang.String getNumeroBin() {
        return numeroBin;
    }


    /**
     * Sets the numeroBin value for this TarjetaRespuesta.
     * 
     * @param numeroBin
     */
    public void setNumeroBin(java.lang.String numeroBin) {
        this.numeroBin = numeroBin;
    }


    /**
     * Gets the numeroProducto value for this TarjetaRespuesta.
     * 
     * @return numeroProducto
     */
    public java.lang.String getNumeroProducto() {
        return numeroProducto;
    }


    /**
     * Sets the numeroProducto value for this TarjetaRespuesta.
     * 
     * @param numeroProducto
     */
    public void setNumeroProducto(java.lang.String numeroProducto) {
        this.numeroProducto = numeroProducto;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TarjetaRespuesta)) return false;
        TarjetaRespuesta other = (TarjetaRespuesta) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.idFranquicia==null && other.getIdFranquicia()==null) || 
             (this.idFranquicia!=null &&
              this.idFranquicia.equals(other.getIdFranquicia()))) &&
            ((this.nombreFranquicia==null && other.getNombreFranquicia()==null) || 
             (this.nombreFranquicia!=null &&
              this.nombreFranquicia.equals(other.getNombreFranquicia()))) &&
            ((this.numeroBin==null && other.getNumeroBin()==null) || 
             (this.numeroBin!=null &&
              this.numeroBin.equals(other.getNumeroBin()))) &&
            ((this.numeroProducto==null && other.getNumeroProducto()==null) || 
             (this.numeroProducto!=null &&
              this.numeroProducto.equals(other.getNumeroProducto())));
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
        if (getIdFranquicia() != null) {
            _hashCode += getIdFranquicia().hashCode();
        }
        if (getNombreFranquicia() != null) {
            _hashCode += getNombreFranquicia().hashCode();
        }
        if (getNumeroBin() != null) {
            _hashCode += getNumeroBin().hashCode();
        }
        if (getNumeroProducto() != null) {
            _hashCode += getNumeroProducto().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TarjetaRespuesta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "tarjetaRespuesta"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idFranquicia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idFranquicia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombreFranquicia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombreFranquicia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroBin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numeroBin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroProducto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numeroProducto"));
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
