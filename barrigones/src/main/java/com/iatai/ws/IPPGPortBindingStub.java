/**
 * IPPGPortBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.iatai.ws;

public class IPPGPortBindingStub extends org.apache.axis.client.Stub implements com.iatai.ws.IPPG_PortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[16];
        _initOperationDesc1();
        _initOperationDesc2();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("transaccion");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "informacionTransaccion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ws.iatai.com/", "transaccionTarjetaCredito_"), com.iatai.ws.TransaccionTarjetaCredito_.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ws.iatai.com/", "transaccionRespuesta_"));
        oper.setReturnClass(com.iatai.ws.TransaccionRespuesta_.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "respuestaTransaccion"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("obtenerFranquicias");
        oper.setReturnType(new javax.xml.namespace.QName("http://ws.iatai.com/", "franquiciaWS"));
        oper.setReturnClass(com.iatai.ws.FranquiciaWS[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "respuestaFranquicias"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("transaccionarAereoSuscripcion");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "informacionTransaccion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ws.iatai.com/", "transaccionAereoSuscripcion"), com.iatai.ws.TransaccionAereoSuscripcion.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ws.iatai.com/", "transaccionSuscripcionRespuesta_"));
        oper.setReturnClass(com.iatai.ws.TransaccionSuscripcionRespuesta_.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "respuestaTransaccionarAereoSuscripcion"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarTransaccion");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "informacionConsulta"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ws.iatai.com/", "transaccionConsulta"), com.iatai.ws.TransaccionConsulta.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ws.iatai.com/", "transaccionRespuesta_"));
        oper.setReturnClass(com.iatai.ws.TransaccionRespuesta_.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "respuestaConsultarTransaccion"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("transaccionAereo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "informacionTransaccion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ws.iatai.com/", "transaccionAereoTarjetaCredito"), com.iatai.ws.TransaccionAereoTarjetaCredito.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ws.iatai.com/", "transaccionRespuesta_"));
        oper.setReturnClass(com.iatai.ws.TransaccionRespuesta_.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "respuestaTransaccionAereo"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("reverso");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "informacionReverso"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ws.iatai.com/", "transaccionReverso"), com.iatai.ws.TransaccionReverso.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ws.iatai.com/", "transaccionRespuesta_"));
        oper.setReturnClass(com.iatai.ws.TransaccionRespuesta_.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "respuestaReverso"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("transaccionarSuscripcion");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "informacionTransaccion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ws.iatai.com/", "transaccionSuscripcion"), com.iatai.ws.TransaccionSuscripcion.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ws.iatai.com/", "transaccionSuscripcionRespuesta"));
        oper.setReturnClass(com.iatai.ws.TransaccionSuscripcionRespuesta.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "respuestaTransaccionSuscripcion"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("transacionTarjetaCredito");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "informacionTransaccion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ws.iatai.com/", "transaccionTarjetaCredito"), com.iatai.ws.TransaccionTarjetaCredito.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ws.iatai.com/", "tarjetaCreditoRespuesta"));
        oper.setReturnClass(com.iatai.ws.TarjetaCreditoRespuesta.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "respuestaTarjetaCredito"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarPorReferencia");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "referencia"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ws.iatai.com/", "transaccionRespuesta"));
        oper.setReturnClass(com.iatai.ws.TransaccionRespuesta.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "respuestaTransaccionReferencia"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("agregarSuscripcion");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "suscripcionAgregacion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionAgregar"), com.iatai.ws.SuscripcionAgregar.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionTarjetaCreditoRespuesta"));
        oper.setReturnClass(com.iatai.ws.SuscripcionTarjetaCreditoRespuesta.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "respuestaAgregarSuscripcion"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("eliminarSuscripcion");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "suscripcionEliminacion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionEliminar"), com.iatai.ws.SuscripcionEliminar.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionEliminarRespuesta"));
        oper.setReturnClass(com.iatai.ws.SuscripcionEliminarRespuesta.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "respuestaSuscripcionEliminar"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("obtenerSuscripciones");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "suscripcionConsulta"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionconsulta"), com.iatai.ws.Suscripcionconsulta.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ws.iatai.com/", "usuarioSuscripcionRespuesta"));
        oper.setReturnClass(com.iatai.ws.UsuarioSuscripcionRespuesta.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "respuestaUsuarioSuscripcion"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("suscribirTarjetaCredito");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "informacionSuscripcion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcion"), com.iatai.ws.Suscripcion.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionTarjetaCreditoRespuesta"));
        oper.setReturnClass(com.iatai.ws.SuscripcionTarjetaCreditoRespuesta.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "respuestaSuscripcionTarjetaCredito"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("verificarCodigoSeguridad");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "verificacionesCS"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ws.iatai.com/", "listaVerificacionCS"), com.iatai.ws.VerificacionCS[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("", "VerificacionCS"));
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ws.iatai.com/", "listaVerificacionCSRespuesta"));
        oper.setReturnClass(com.iatai.ws.VerificacionCSRespuesta[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "respuestaVerificarCodigoSeguridad"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "VerificacionCSRespuesta"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("verificarTarjetaCredito");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "informacionVerificacion"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ws.iatai.com/", "verificacionTarjetaCredito"), com.iatai.ws.VerificacionTarjetaCredito.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ws.iatai.com/", "verificacionRespuesta"));
        oper.setReturnClass(com.iatai.ws.VerificacionRespuesta.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "respuestaVerificarTarjetaCredito"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("consultarTransacciones");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "informacionConsulta"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://ws.iatai.com/", "transaccionConsultaFecha"), com.iatai.ws.TransaccionConsultaFecha.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://ws.iatai.com/", "transaccionRespuesta_"));
        oper.setReturnClass(com.iatai.ws.TransaccionRespuesta_[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "respuestaConsultarTransacciones"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[15] = oper;

    }

    public IPPGPortBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public IPPGPortBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public IPPGPortBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "aereo");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.Aereo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "aeropuerto");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.Aeropuerto.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "aeropuertos");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.Aeropuerto[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "aeropuerto");
            qName2 = new javax.xml.namespace.QName("", "Aeropuerto");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "antifraudeRespuesta");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.AntifraudeRespuesta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "cliente");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.Cliente.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "cliente_");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.Cliente_.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "compra");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.Compra.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "compra_");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.Compra_.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "compraAereo");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.CompraAereo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "compraBase");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.CompraBase.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "compraCS");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.CompraCS.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "compraTarjetaCredito");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.CompraTarjetaCredito.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "consultaBase");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.ConsultaBase.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "dispersionesRespuesta");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.DispersionRespuesta[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "dispersionRespuesta");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "dispersionRespuesta");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.DispersionRespuesta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "envio");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.Envio.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "franquiciaWS");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.FranquiciaWS.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "FraudeBase");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.FraudeBase.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "FraudeValidacion");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.FraudeValidacion.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "FraudeValidacionBase");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.FraudeValidacionBase.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "FraudeValidacionProducto");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.FraudeValidacionProducto.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "item");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.Item.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "items");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.Item[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "item");
            qName2 = new javax.xml.namespace.QName("", "producto");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "listaVerificacionCS");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.VerificacionCS[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "verificacionCS");
            qName2 = new javax.xml.namespace.QName("", "VerificacionCS");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "listaVerificacionCSRespuesta");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.VerificacionCSRespuesta[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "verificacionCSRespuesta");
            qName2 = new javax.xml.namespace.QName("", "VerificacionCSRespuesta");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "pasajero");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.Pasajero.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "pasajeros");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.Pasajero[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "pasajero");
            qName2 = new javax.xml.namespace.QName("", "Pasajero");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "procesadorRespuesta");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.ProcesadorRespuesta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "ruta");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.Ruta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcion");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.Suscripcion.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionAgregar");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.SuscripcionAgregar.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionCompra");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.SuscripcionCompra.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionconsulta");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.Suscripcionconsulta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionEliminar");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.SuscripcionEliminar.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionEliminarRespuesta");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.SuscripcionEliminarRespuesta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionesListRespuesta");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.SuscripcionRespuesta[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionRespuesta");
            qName2 = new javax.xml.namespace.QName("", "suscripcionRespuesta");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "SuscripcionFraudeValidacion");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.SuscripcionFraudeValidacion.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionPago");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.SuscripcionPago.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionRespuesta");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.SuscripcionRespuesta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionTarjetaCredito");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.SuscripcionTarjetaCredito.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionTarjetaCreditoRespuesta");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.SuscripcionTarjetaCreditoRespuesta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionTarjetaRespuesta");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.SuscripcionTarjetaRespuesta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionTitular");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.SuscripcionTitular.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionTitularRespuesta");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.SuscripcionTitularRespuesta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionTransaccion");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.SuscripcionTransaccion.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionUsuario");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.SuscripcionUsuario.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "suscripcionVerificacion");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.SuscripcionVerificacion.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "tarjetaCredito");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.TarjetaCredito.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "tarjetaCredito_");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.TarjetaCredito_.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "tarjetaCreditoBase");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.TarjetaCreditoBase.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "tarjetaCreditoBase_");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.TarjetaCreditoBase_.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "tarjetaCreditoCS");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.TarjetaCreditoCS.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "tarjetaCreditoRespuesta");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.TarjetaCreditoRespuesta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "tarjetaHabiente");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.TarjetaHabiente.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "tarjetaRespuesta");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.TarjetaRespuesta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "transaccionAereoSuscripcion");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.TransaccionAereoSuscripcion.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "transaccionAereoTarjetaCredito");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.TransaccionAereoTarjetaCredito.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "transaccionConsulta");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.TransaccionConsulta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "transaccionConsultaFecha");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.TransaccionConsultaFecha.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "transaccionRespuesta");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.TransaccionRespuesta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "transaccionRespuesta_");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.TransaccionRespuesta_.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "transaccionRespuestaBase");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.TransaccionRespuestaBase.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "transaccionReverso");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.TransaccionReverso.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "transaccionSuscripcion");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.TransaccionSuscripcion.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "transaccionSuscripcionRespuesta");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.TransaccionSuscripcionRespuesta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "transaccionSuscripcionRespuesta_");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.TransaccionSuscripcionRespuesta_.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "transaccionTarjetaCredito");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.TransaccionTarjetaCredito.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "transaccionTarjetaCredito_");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.TransaccionTarjetaCredito_.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "trasladoRespuesta");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.TrasladoRespuesta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "usuarioRespuesta");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.UsuarioRespuesta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "usuarioSuscripcionRespuesta");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.UsuarioSuscripcionRespuesta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "verificacionCS");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.VerificacionCS.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "verificacionCSRespuesta");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.VerificacionCSRespuesta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "verificacionRespuesta");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.VerificacionRespuesta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://ws.iatai.com/", "verificacionTarjetaCredito");
            cachedSerQNames.add(qName);
            cls = com.iatai.ws.VerificacionTarjetaCredito.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public com.iatai.ws.TransaccionRespuesta_ transaccion(com.iatai.ws.TransaccionTarjetaCredito_ informacionTransaccion) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ws.iatai.com/", "transaccion"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {informacionTransaccion});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.iatai.ws.TransaccionRespuesta_) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.iatai.ws.TransaccionRespuesta_) org.apache.axis.utils.JavaUtils.convert(_resp, com.iatai.ws.TransaccionRespuesta_.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.iatai.ws.FranquiciaWS[] obtenerFranquicias() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ws.iatai.com/", "obtenerFranquicias"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.iatai.ws.FranquiciaWS[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.iatai.ws.FranquiciaWS[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.iatai.ws.FranquiciaWS[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.iatai.ws.TransaccionSuscripcionRespuesta_ transaccionarAereoSuscripcion(com.iatai.ws.TransaccionAereoSuscripcion informacionTransaccion) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ws.iatai.com/", "transaccionarAereoSuscripcion"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {informacionTransaccion});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.iatai.ws.TransaccionSuscripcionRespuesta_) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.iatai.ws.TransaccionSuscripcionRespuesta_) org.apache.axis.utils.JavaUtils.convert(_resp, com.iatai.ws.TransaccionSuscripcionRespuesta_.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.iatai.ws.TransaccionRespuesta_ consultarTransaccion(com.iatai.ws.TransaccionConsulta informacionConsulta) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ws.iatai.com/", "consultarTransaccion"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {informacionConsulta});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.iatai.ws.TransaccionRespuesta_) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.iatai.ws.TransaccionRespuesta_) org.apache.axis.utils.JavaUtils.convert(_resp, com.iatai.ws.TransaccionRespuesta_.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.iatai.ws.TransaccionRespuesta_ transaccionAereo(com.iatai.ws.TransaccionAereoTarjetaCredito informacionTransaccion) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ws.iatai.com/", "transaccionAereo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {informacionTransaccion});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.iatai.ws.TransaccionRespuesta_) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.iatai.ws.TransaccionRespuesta_) org.apache.axis.utils.JavaUtils.convert(_resp, com.iatai.ws.TransaccionRespuesta_.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.iatai.ws.TransaccionRespuesta_ reverso(com.iatai.ws.TransaccionReverso informacionReverso) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ws.iatai.com/", "reverso"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {informacionReverso});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.iatai.ws.TransaccionRespuesta_) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.iatai.ws.TransaccionRespuesta_) org.apache.axis.utils.JavaUtils.convert(_resp, com.iatai.ws.TransaccionRespuesta_.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.iatai.ws.TransaccionSuscripcionRespuesta transaccionarSuscripcion(com.iatai.ws.TransaccionSuscripcion informacionTransaccion) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ws.iatai.com/", "transaccionarSuscripcion"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {informacionTransaccion});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.iatai.ws.TransaccionSuscripcionRespuesta) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.iatai.ws.TransaccionSuscripcionRespuesta) org.apache.axis.utils.JavaUtils.convert(_resp, com.iatai.ws.TransaccionSuscripcionRespuesta.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.iatai.ws.TarjetaCreditoRespuesta transacionTarjetaCredito(com.iatai.ws.TransaccionTarjetaCredito informacionTransaccion) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ws.iatai.com/", "transacionTarjetaCredito"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {informacionTransaccion});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.iatai.ws.TarjetaCreditoRespuesta) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.iatai.ws.TarjetaCreditoRespuesta) org.apache.axis.utils.JavaUtils.convert(_resp, com.iatai.ws.TarjetaCreditoRespuesta.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.iatai.ws.TransaccionRespuesta consultarPorReferencia(java.lang.String referencia) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ws.iatai.com/", "consultarPorReferencia"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {referencia});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.iatai.ws.TransaccionRespuesta) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.iatai.ws.TransaccionRespuesta) org.apache.axis.utils.JavaUtils.convert(_resp, com.iatai.ws.TransaccionRespuesta.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.iatai.ws.SuscripcionTarjetaCreditoRespuesta agregarSuscripcion(com.iatai.ws.SuscripcionAgregar suscripcionAgregacion) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ws.iatai.com/", "agregarSuscripcion"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {suscripcionAgregacion});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.iatai.ws.SuscripcionTarjetaCreditoRespuesta) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.iatai.ws.SuscripcionTarjetaCreditoRespuesta) org.apache.axis.utils.JavaUtils.convert(_resp, com.iatai.ws.SuscripcionTarjetaCreditoRespuesta.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.iatai.ws.SuscripcionEliminarRespuesta eliminarSuscripcion(com.iatai.ws.SuscripcionEliminar suscripcionEliminacion) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ws.iatai.com/", "eliminarSuscripcion"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {suscripcionEliminacion});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.iatai.ws.SuscripcionEliminarRespuesta) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.iatai.ws.SuscripcionEliminarRespuesta) org.apache.axis.utils.JavaUtils.convert(_resp, com.iatai.ws.SuscripcionEliminarRespuesta.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.iatai.ws.UsuarioSuscripcionRespuesta obtenerSuscripciones(com.iatai.ws.Suscripcionconsulta suscripcionConsulta) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ws.iatai.com/", "obtenerSuscripciones"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {suscripcionConsulta});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.iatai.ws.UsuarioSuscripcionRespuesta) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.iatai.ws.UsuarioSuscripcionRespuesta) org.apache.axis.utils.JavaUtils.convert(_resp, com.iatai.ws.UsuarioSuscripcionRespuesta.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.iatai.ws.SuscripcionTarjetaCreditoRespuesta suscribirTarjetaCredito(com.iatai.ws.Suscripcion informacionSuscripcion) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ws.iatai.com/", "suscribirTarjetaCredito"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {informacionSuscripcion});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.iatai.ws.SuscripcionTarjetaCreditoRespuesta) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.iatai.ws.SuscripcionTarjetaCreditoRespuesta) org.apache.axis.utils.JavaUtils.convert(_resp, com.iatai.ws.SuscripcionTarjetaCreditoRespuesta.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.iatai.ws.VerificacionCSRespuesta[] verificarCodigoSeguridad(com.iatai.ws.VerificacionCS[] verificacionesCS) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ws.iatai.com/", "verificarCodigoSeguridad"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {verificacionesCS});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.iatai.ws.VerificacionCSRespuesta[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.iatai.ws.VerificacionCSRespuesta[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.iatai.ws.VerificacionCSRespuesta[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.iatai.ws.VerificacionRespuesta verificarTarjetaCredito(com.iatai.ws.VerificacionTarjetaCredito informacionVerificacion) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ws.iatai.com/", "verificarTarjetaCredito"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {informacionVerificacion});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.iatai.ws.VerificacionRespuesta) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.iatai.ws.VerificacionRespuesta) org.apache.axis.utils.JavaUtils.convert(_resp, com.iatai.ws.VerificacionRespuesta.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public com.iatai.ws.TransaccionRespuesta_[] consultarTransacciones(com.iatai.ws.TransaccionConsultaFecha informacionConsulta) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://ws.iatai.com/", "consultarTransacciones"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {informacionConsulta});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.iatai.ws.TransaccionRespuesta_[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.iatai.ws.TransaccionRespuesta_[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.iatai.ws.TransaccionRespuesta_[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
