/**
 * Aereo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.iatai.ws;

public class Aereo  implements java.io.Serializable {
    private java.lang.String codigoAerolinea;

    private boolean nacional;

    private java.lang.String codigoAdmin;

    private java.lang.String codigoReserva;

    private com.iatai.ws.Pasajero[] pasajeros;

    private com.iatai.ws.Ruta ruta;

    public Aereo() {
    }

    public Aereo(
           java.lang.String codigoAerolinea,
           boolean nacional,
           java.lang.String codigoAdmin,
           java.lang.String codigoReserva,
           com.iatai.ws.Pasajero[] pasajeros,
           com.iatai.ws.Ruta ruta) {
           this.codigoAerolinea = codigoAerolinea;
           this.nacional = nacional;
           this.codigoAdmin = codigoAdmin;
           this.codigoReserva = codigoReserva;
           this.pasajeros = pasajeros;
           this.ruta = ruta;
    }


    /**
     * Gets the codigoAerolinea value for this Aereo.
     * 
     * @return codigoAerolinea
     */
    public java.lang.String getCodigoAerolinea() {
        return codigoAerolinea;
    }


    /**
     * Sets the codigoAerolinea value for this Aereo.
     * 
     * @param codigoAerolinea
     */
    public void setCodigoAerolinea(java.lang.String codigoAerolinea) {
        this.codigoAerolinea = codigoAerolinea;
    }


    /**
     * Gets the nacional value for this Aereo.
     * 
     * @return nacional
     */
    public boolean isNacional() {
        return nacional;
    }


    /**
     * Sets the nacional value for this Aereo.
     * 
     * @param nacional
     */
    public void setNacional(boolean nacional) {
        this.nacional = nacional;
    }


    /**
     * Gets the codigoAdmin value for this Aereo.
     * 
     * @return codigoAdmin
     */
    public java.lang.String getCodigoAdmin() {
        return codigoAdmin;
    }


    /**
     * Sets the codigoAdmin value for this Aereo.
     * 
     * @param codigoAdmin
     */
    public void setCodigoAdmin(java.lang.String codigoAdmin) {
        this.codigoAdmin = codigoAdmin;
    }


    /**
     * Gets the codigoReserva value for this Aereo.
     * 
     * @return codigoReserva
     */
    public java.lang.String getCodigoReserva() {
        return codigoReserva;
    }


    /**
     * Sets the codigoReserva value for this Aereo.
     * 
     * @param codigoReserva
     */
    public void setCodigoReserva(java.lang.String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }


    /**
     * Gets the pasajeros value for this Aereo.
     * 
     * @return pasajeros
     */
    public com.iatai.ws.Pasajero[] getPasajeros() {
        return pasajeros;
    }


    /**
     * Sets the pasajeros value for this Aereo.
     * 
     * @param pasajeros
     */
    public void setPasajeros(com.iatai.ws.Pasajero[] pasajeros) {
        this.pasajeros = pasajeros;
    }


    /**
     * Gets the ruta value for this Aereo.
     * 
     * @return ruta
     */
    public com.iatai.ws.Ruta getRuta() {
        return ruta;
    }


    /**
     * Sets the ruta value for this Aereo.
     * 
     * @param ruta
     */
    public void setRuta(com.iatai.ws.Ruta ruta) {
        this.ruta = ruta;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Aereo)) return false;
        Aereo other = (Aereo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codigoAerolinea==null && other.getCodigoAerolinea()==null) || 
             (this.codigoAerolinea!=null &&
              this.codigoAerolinea.equals(other.getCodigoAerolinea()))) &&
            this.nacional == other.isNacional() &&
            ((this.codigoAdmin==null && other.getCodigoAdmin()==null) || 
             (this.codigoAdmin!=null &&
              this.codigoAdmin.equals(other.getCodigoAdmin()))) &&
            ((this.codigoReserva==null && other.getCodigoReserva()==null) || 
             (this.codigoReserva!=null &&
              this.codigoReserva.equals(other.getCodigoReserva()))) &&
            ((this.pasajeros==null && other.getPasajeros()==null) || 
             (this.pasajeros!=null &&
              java.util.Arrays.equals(this.pasajeros, other.getPasajeros()))) &&
            ((this.ruta==null && other.getRuta()==null) || 
             (this.ruta!=null &&
              this.ruta.equals(other.getRuta())));
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
        if (getCodigoAerolinea() != null) {
            _hashCode += getCodigoAerolinea().hashCode();
        }
        _hashCode += (isNacional() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getCodigoAdmin() != null) {
            _hashCode += getCodigoAdmin().hashCode();
        }
        if (getCodigoReserva() != null) {
            _hashCode += getCodigoReserva().hashCode();
        }
        if (getPasajeros() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPasajeros());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPasajeros(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRuta() != null) {
            _hashCode += getRuta().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Aereo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "aereo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoAerolinea");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codigoAerolinea"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nacional");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nacional"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoAdmin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codigoAdmin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoReserva");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codigoReserva"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pasajeros");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Pasajeros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "pasajero"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "Pasajero"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ruta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Ruta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "ruta"));
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
