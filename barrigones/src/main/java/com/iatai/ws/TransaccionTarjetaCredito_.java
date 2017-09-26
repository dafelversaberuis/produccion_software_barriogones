/**
 * TransaccionTarjetaCredito_.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.iatai.ws;

public class TransaccionTarjetaCredito_  implements java.io.Serializable {
    private com.iatai.ws.Compra_ compra;

    private com.iatai.ws.Cliente_ cliente;

    private com.iatai.ws.TarjetaHabiente tarjetaHabiente;

    private com.iatai.ws.TarjetaCredito_ tarjetaCredito;

    private com.iatai.ws.Envio envio;

    private com.iatai.ws.FraudeBase informacionFraude;

    private com.iatai.ws.Item[] productos;

    private com.iatai.ws.SuscripcionTransaccion suscripcionTransaccion;

    public TransaccionTarjetaCredito_() {
    }

    public TransaccionTarjetaCredito_(
           com.iatai.ws.Compra_ compra,
           com.iatai.ws.Cliente_ cliente,
           com.iatai.ws.TarjetaHabiente tarjetaHabiente,
           com.iatai.ws.TarjetaCredito_ tarjetaCredito,
           com.iatai.ws.Envio envio,
           com.iatai.ws.FraudeBase informacionFraude,
           com.iatai.ws.Item[] productos,
           com.iatai.ws.SuscripcionTransaccion suscripcionTransaccion) {
           this.compra = compra;
           this.cliente = cliente;
           this.tarjetaHabiente = tarjetaHabiente;
           this.tarjetaCredito = tarjetaCredito;
           this.envio = envio;
           this.informacionFraude = informacionFraude;
           this.productos = productos;
           this.suscripcionTransaccion = suscripcionTransaccion;
    }


    /**
     * Gets the compra value for this TransaccionTarjetaCredito_.
     * 
     * @return compra
     */
    public com.iatai.ws.Compra_ getCompra() {
        return compra;
    }


    /**
     * Sets the compra value for this TransaccionTarjetaCredito_.
     * 
     * @param compra
     */
    public void setCompra(com.iatai.ws.Compra_ compra) {
        this.compra = compra;
    }


    /**
     * Gets the cliente value for this TransaccionTarjetaCredito_.
     * 
     * @return cliente
     */
    public com.iatai.ws.Cliente_ getCliente() {
        return cliente;
    }


    /**
     * Sets the cliente value for this TransaccionTarjetaCredito_.
     * 
     * @param cliente
     */
    public void setCliente(com.iatai.ws.Cliente_ cliente) {
        this.cliente = cliente;
    }


    /**
     * Gets the tarjetaHabiente value for this TransaccionTarjetaCredito_.
     * 
     * @return tarjetaHabiente
     */
    public com.iatai.ws.TarjetaHabiente getTarjetaHabiente() {
        return tarjetaHabiente;
    }


    /**
     * Sets the tarjetaHabiente value for this TransaccionTarjetaCredito_.
     * 
     * @param tarjetaHabiente
     */
    public void setTarjetaHabiente(com.iatai.ws.TarjetaHabiente tarjetaHabiente) {
        this.tarjetaHabiente = tarjetaHabiente;
    }


    /**
     * Gets the tarjetaCredito value for this TransaccionTarjetaCredito_.
     * 
     * @return tarjetaCredito
     */
    public com.iatai.ws.TarjetaCredito_ getTarjetaCredito() {
        return tarjetaCredito;
    }


    /**
     * Sets the tarjetaCredito value for this TransaccionTarjetaCredito_.
     * 
     * @param tarjetaCredito
     */
    public void setTarjetaCredito(com.iatai.ws.TarjetaCredito_ tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }


    /**
     * Gets the envio value for this TransaccionTarjetaCredito_.
     * 
     * @return envio
     */
    public com.iatai.ws.Envio getEnvio() {
        return envio;
    }


    /**
     * Sets the envio value for this TransaccionTarjetaCredito_.
     * 
     * @param envio
     */
    public void setEnvio(com.iatai.ws.Envio envio) {
        this.envio = envio;
    }


    /**
     * Gets the informacionFraude value for this TransaccionTarjetaCredito_.
     * 
     * @return informacionFraude
     */
    public com.iatai.ws.FraudeBase getInformacionFraude() {
        return informacionFraude;
    }


    /**
     * Sets the informacionFraude value for this TransaccionTarjetaCredito_.
     * 
     * @param informacionFraude
     */
    public void setInformacionFraude(com.iatai.ws.FraudeBase informacionFraude) {
        this.informacionFraude = informacionFraude;
    }


    /**
     * Gets the productos value for this TransaccionTarjetaCredito_.
     * 
     * @return productos
     */
    public com.iatai.ws.Item[] getProductos() {
        return productos;
    }


    /**
     * Sets the productos value for this TransaccionTarjetaCredito_.
     * 
     * @param productos
     */
    public void setProductos(com.iatai.ws.Item[] productos) {
        this.productos = productos;
    }


    /**
     * Gets the suscripcionTransaccion value for this TransaccionTarjetaCredito_.
     * 
     * @return suscripcionTransaccion
     */
    public com.iatai.ws.SuscripcionTransaccion getSuscripcionTransaccion() {
        return suscripcionTransaccion;
    }


    /**
     * Sets the suscripcionTransaccion value for this TransaccionTarjetaCredito_.
     * 
     * @param suscripcionTransaccion
     */
    public void setSuscripcionTransaccion(com.iatai.ws.SuscripcionTransaccion suscripcionTransaccion) {
        this.suscripcionTransaccion = suscripcionTransaccion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TransaccionTarjetaCredito_)) return false;
        TransaccionTarjetaCredito_ other = (TransaccionTarjetaCredito_) obj;
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
            ((this.tarjetaHabiente==null && other.getTarjetaHabiente()==null) || 
             (this.tarjetaHabiente!=null &&
              this.tarjetaHabiente.equals(other.getTarjetaHabiente()))) &&
            ((this.tarjetaCredito==null && other.getTarjetaCredito()==null) || 
             (this.tarjetaCredito!=null &&
              this.tarjetaCredito.equals(other.getTarjetaCredito()))) &&
            ((this.envio==null && other.getEnvio()==null) || 
             (this.envio!=null &&
              this.envio.equals(other.getEnvio()))) &&
            ((this.informacionFraude==null && other.getInformacionFraude()==null) || 
             (this.informacionFraude!=null &&
              this.informacionFraude.equals(other.getInformacionFraude()))) &&
            ((this.productos==null && other.getProductos()==null) || 
             (this.productos!=null &&
              java.util.Arrays.equals(this.productos, other.getProductos()))) &&
            ((this.suscripcionTransaccion==null && other.getSuscripcionTransaccion()==null) || 
             (this.suscripcionTransaccion!=null &&
              this.suscripcionTransaccion.equals(other.getSuscripcionTransaccion())));
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
        if (getTarjetaHabiente() != null) {
            _hashCode += getTarjetaHabiente().hashCode();
        }
        if (getTarjetaCredito() != null) {
            _hashCode += getTarjetaCredito().hashCode();
        }
        if (getEnvio() != null) {
            _hashCode += getEnvio().hashCode();
        }
        if (getInformacionFraude() != null) {
            _hashCode += getInformacionFraude().hashCode();
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
        if (getSuscripcionTransaccion() != null) {
            _hashCode += getSuscripcionTransaccion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TransaccionTarjetaCredito_.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "transaccionTarjetaCredito_"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("compra");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Compra"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "compra_"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cliente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Cliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "cliente_"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tarjetaHabiente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TarjetaHabiente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "tarjetaHabiente"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tarjetaCredito");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TarjetaCredito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "tarjetaCredito_"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("envio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Envio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "envio"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("informacionFraude");
        elemField.setXmlName(new javax.xml.namespace.QName("", "InformacionFraude"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "FraudeBase"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "item"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "producto"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("suscripcionTransaccion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SuscripcionTransaccion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionTransaccion"));
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
