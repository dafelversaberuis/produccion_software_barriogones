/**
 * Item.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.iatai.ws;

public class Item  implements java.io.Serializable {
    private java.lang.String codigoItem;

    private java.lang.String nombreItem;

    private float valorItem;

    private int cantidadItem;

    private java.lang.String codigoCategoria;

    private java.lang.String nombreCategoria;

    public Item() {
    }

    public Item(
           java.lang.String codigoItem,
           java.lang.String nombreItem,
           float valorItem,
           int cantidadItem,
           java.lang.String codigoCategoria,
           java.lang.String nombreCategoria) {
           this.codigoItem = codigoItem;
           this.nombreItem = nombreItem;
           this.valorItem = valorItem;
           this.cantidadItem = cantidadItem;
           this.codigoCategoria = codigoCategoria;
           this.nombreCategoria = nombreCategoria;
    }


    /**
     * Gets the codigoItem value for this Item.
     * 
     * @return codigoItem
     */
    public java.lang.String getCodigoItem() {
        return codigoItem;
    }


    /**
     * Sets the codigoItem value for this Item.
     * 
     * @param codigoItem
     */
    public void setCodigoItem(java.lang.String codigoItem) {
        this.codigoItem = codigoItem;
    }


    /**
     * Gets the nombreItem value for this Item.
     * 
     * @return nombreItem
     */
    public java.lang.String getNombreItem() {
        return nombreItem;
    }


    /**
     * Sets the nombreItem value for this Item.
     * 
     * @param nombreItem
     */
    public void setNombreItem(java.lang.String nombreItem) {
        this.nombreItem = nombreItem;
    }


    /**
     * Gets the valorItem value for this Item.
     * 
     * @return valorItem
     */
    public float getValorItem() {
        return valorItem;
    }


    /**
     * Sets the valorItem value for this Item.
     * 
     * @param valorItem
     */
    public void setValorItem(float valorItem) {
        this.valorItem = valorItem;
    }


    /**
     * Gets the cantidadItem value for this Item.
     * 
     * @return cantidadItem
     */
    public int getCantidadItem() {
        return cantidadItem;
    }


    /**
     * Sets the cantidadItem value for this Item.
     * 
     * @param cantidadItem
     */
    public void setCantidadItem(int cantidadItem) {
        this.cantidadItem = cantidadItem;
    }


    /**
     * Gets the codigoCategoria value for this Item.
     * 
     * @return codigoCategoria
     */
    public java.lang.String getCodigoCategoria() {
        return codigoCategoria;
    }


    /**
     * Sets the codigoCategoria value for this Item.
     * 
     * @param codigoCategoria
     */
    public void setCodigoCategoria(java.lang.String codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }


    /**
     * Gets the nombreCategoria value for this Item.
     * 
     * @return nombreCategoria
     */
    public java.lang.String getNombreCategoria() {
        return nombreCategoria;
    }


    /**
     * Sets the nombreCategoria value for this Item.
     * 
     * @param nombreCategoria
     */
    public void setNombreCategoria(java.lang.String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Item)) return false;
        Item other = (Item) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.codigoItem==null && other.getCodigoItem()==null) || 
             (this.codigoItem!=null &&
              this.codigoItem.equals(other.getCodigoItem()))) &&
            ((this.nombreItem==null && other.getNombreItem()==null) || 
             (this.nombreItem!=null &&
              this.nombreItem.equals(other.getNombreItem()))) &&
            this.valorItem == other.getValorItem() &&
            this.cantidadItem == other.getCantidadItem() &&
            ((this.codigoCategoria==null && other.getCodigoCategoria()==null) || 
             (this.codigoCategoria!=null &&
              this.codigoCategoria.equals(other.getCodigoCategoria()))) &&
            ((this.nombreCategoria==null && other.getNombreCategoria()==null) || 
             (this.nombreCategoria!=null &&
              this.nombreCategoria.equals(other.getNombreCategoria())));
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
        if (getCodigoItem() != null) {
            _hashCode += getCodigoItem().hashCode();
        }
        if (getNombreItem() != null) {
            _hashCode += getNombreItem().hashCode();
        }
        _hashCode += new Float(getValorItem()).hashCode();
        _hashCode += getCantidadItem();
        if (getCodigoCategoria() != null) {
            _hashCode += getCodigoCategoria().hashCode();
        }
        if (getNombreCategoria() != null) {
            _hashCode += getNombreCategoria().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Item.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.iatai.com/", "item"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoItem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codigoItem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombreItem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombreItem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valorItem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "valorItem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cantidadItem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cantidadItem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigoCategoria");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codigoCategoria"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombreCategoria");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombreCategoria"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
