/**
 * TransaccionTarjetaCredito.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.iatai.ws;

public class TransaccionTarjetaCredito  implements java.io.Serializable {
    private com.iatai.ws.Compra compra;

    private com.iatai.ws.Cliente cliente;

    private com.iatai.ws.TarjetaCredito tarjetaCredito;

    private com.iatai.ws.FraudeValidacion informacionFraude;

    private boolean suscribir;

    private com.iatai.ws.SuscripcionUsuario suscripcionUsuario;

    public TransaccionTarjetaCredito() {
    }

    public TransaccionTarjetaCredito(
           com.iatai.ws.Compra compra,
           com.iatai.ws.Cliente cliente,
           com.iatai.ws.TarjetaCredito tarjetaCredito,
           com.iatai.ws.FraudeValidacion informacionFraude,
           boolean suscribir,
           com.iatai.ws.SuscripcionUsuario suscripcionUsuario) {
           this.compra = compra;
           this.cliente = cliente;
           this.tarjetaCredito = tarjetaCredito;
           this.informacionFraude = informacionFraude;
           this.suscribir = suscribir;
           this.suscripcionUsuario = suscripcionUsuario;
    }


    /**
     * Gets the compra value for this TransaccionTarjetaCredito.
     * 
     * @return compra
     */
    public com.iatai.ws.Compra getCompra() {
        return compra;
    }


    /**
     * Sets the compra value for this TransaccionTarjetaCredito.
     * 
     * @param compra
     */
    public void setCompra(com.iatai.ws.Compra compra) {
        this.compra = compra;
    }


    /**
     * Gets the cliente value for this TransaccionTarjetaCredito.
     * 
     * @return cliente
     */
    public com.iatai.ws.Cliente getCliente() {
        return cliente;
    }


    /**
     * Sets the cliente value for this TransaccionTarjetaCredito.
     * 
     * @param cliente
     */
    public void setCliente(com.iatai.ws.Cliente cliente) {
        this.cliente = cliente;
    }


    /**
     * Gets the tarjetaCredito value for this TransaccionTarjetaCredito.
     * 
     * @return tarjetaCredito
     */
    public com.iatai.ws.TarjetaCredito getTarjetaCredito() {
        return tarjetaCredito;
    }


    /**
     * Sets the tarjetaCredito value for this TransaccionTarjetaCredito.
     * 
     * @param tarjetaCredito
     */
    public void setTarjetaCredito(com.iatai.ws.TarjetaCredito tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }


    /**
     * Gets the informacionFraude value for this TransaccionTarjetaCredito.
     * 
     * @return informacionFraude
     */
    public com.iatai.ws.FraudeValidacion getInformacionFraude() {
        return informacionFraude;
    }


    /**
     * Sets the informacionFraude value for this TransaccionTarjetaCredito.
     * 
     * @param informacionFraude
     */
    public void setInformacionFraude(com.iatai.ws.FraudeValidacion informacionFraude) {
        this.informacionFraude = informacionFraude;
    }


    /**
     * Gets the suscribir value for this TransaccionTarjetaCredito.
     * 
     * @return suscribir
     */
    public boolean isSuscribir() {
        return suscribir;
    }


    /**
     * Sets the suscribir value for this TransaccionTarjetaCredito.
     * 
     * @param suscribir
     */
    public void setSuscribir(boolean suscribir) {
        this.suscribir = suscribir;
    }


    /**
     * Gets the suscripcionUsuario value for this TransaccionTarjetaCredito.
     * 
     * @return suscripcionUsuario
     */
    public com.iatai.ws.SuscripcionUsuario getSuscripcionUsuario() {
        return suscripcionUsuario;
    }


    /**
     * Sets the suscripcionUsuario value for this TransaccionTarjetaCredito.
     * 
     * @param suscripcionUsuario
     */
    public void setSuscripcionUsuario(com.iatai.ws.SuscripcionUsuario suscripcionUsuario) {
        this.suscripcionUsuario = suscripcionUsuario;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TransaccionTarjetaCredito)) return false;
        TransaccionTarjetaCredito other = (TransaccionTarjetaCredito) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.compra==null && other.getCompra()==null) || 
             (this.compra!=null &&
              this.compra.equals(other.getCompra()))) &&
            ((this.cliente==null && other.getCliente()==null) || 
             (this.cliente!=null &&
              this.cliente.equals(other.getCliente()))) &&
            ((this.tarjetaCredito==null && other.getTarjetaCredito()==null) || 
             (this.tarjetaCredito!=null &&
              this.tarjetaCredito.equals(other.getTarjetaCredito()))) &&
            ((this.informacionFraude==null && other.getInformacionFraude()==null) || 
             (this.informacionFraude!=null &&
              this.informacionFraude.equals(other.getInformacionFraude()))) &&
            this.suscribir == other.isSuscribir() &&
            ((this.suscripcionUsuario==null && other.getSuscripcionUsuario()==null) || 
             (this.suscripcionUsuario!=null &&
              this.suscripcionUsuario.equals(other.getSuscripcionUsuario())));
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
        if (getCompra() != null) {
            _hashCode += getCompra().hashCode();
        }
        if (getCliente() != null) {
            _hashCode += getCliente().hashCode();
        }
        if (getTarjetaCredito() != null) {
            _hashCode += getTarjetaCredito().hashCode();
        }
        if (getInformacionFraude() != null) {
            _hashCode += getInformacionFraude().hashCode();
        }
        _hashCode += (isSuscribir() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getSuscripcionUsuario() != null) {
            _hashCode += getSuscripcionUsuario().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TransaccionTarjetaCredito.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "transaccionTarjetaCredito"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("compra");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Compra"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "compra"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cliente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Cliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "cliente"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tarjetaCredito");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TarjetaCredito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "tarjetaCredito"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("informacionFraude");
        elemField.setXmlName(new javax.xml.namespace.QName("", "InformacionFraude"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "FraudeValidacion"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("suscribir");
        elemField.setXmlName(new javax.xml.namespace.QName("", "suscribir"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("suscripcionUsuario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SuscripcionUsuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionUsuario"));
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
