/**
 * IPPG_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.iatai.ws;

public interface IPPG_PortType extends java.rmi.Remote {
    public com.iatai.ws.TransaccionRespuesta_ transaccion(com.iatai.ws.TransaccionTarjetaCredito_ informacionTransaccion) throws java.rmi.RemoteException;
    public com.iatai.ws.FranquiciaWS[] obtenerFranquicias() throws java.rmi.RemoteException;
    public com.iatai.ws.TransaccionSuscripcionRespuesta_ transaccionarAereoSuscripcion(com.iatai.ws.TransaccionAereoSuscripcion informacionTransaccion) throws java.rmi.RemoteException;
    public com.iatai.ws.TransaccionRespuesta_ consultarTransaccion(com.iatai.ws.TransaccionConsulta informacionConsulta) throws java.rmi.RemoteException;
    public com.iatai.ws.TransaccionRespuesta_ transaccionAereo(com.iatai.ws.TransaccionAereoTarjetaCredito informacionTransaccion) throws java.rmi.RemoteException;
    public com.iatai.ws.TransaccionRespuesta_ reverso(com.iatai.ws.TransaccionReverso informacionReverso) throws java.rmi.RemoteException;
    public com.iatai.ws.TransaccionSuscripcionRespuesta transaccionarSuscripcion(com.iatai.ws.TransaccionSuscripcion informacionTransaccion) throws java.rmi.RemoteException;
    public com.iatai.ws.TarjetaCreditoRespuesta transacionTarjetaCredito(com.iatai.ws.TransaccionTarjetaCredito informacionTransaccion) throws java.rmi.RemoteException;
    public com.iatai.ws.TransaccionRespuesta consultarPorReferencia(java.lang.String referencia) throws java.rmi.RemoteException;
    public com.iatai.ws.SuscripcionTarjetaCreditoRespuesta agregarSuscripcion(com.iatai.ws.SuscripcionAgregar suscripcionAgregacion) throws java.rmi.RemoteException;
    public com.iatai.ws.SuscripcionEliminarRespuesta eliminarSuscripcion(com.iatai.ws.SuscripcionEliminar suscripcionEliminacion) throws java.rmi.RemoteException;
    public com.iatai.ws.UsuarioSuscripcionRespuesta obtenerSuscripciones(com.iatai.ws.Suscripcionconsulta suscripcionConsulta) throws java.rmi.RemoteException;
    public com.iatai.ws.SuscripcionTarjetaCreditoRespuesta suscribirTarjetaCredito(com.iatai.ws.Suscripcion informacionSuscripcion) throws java.rmi.RemoteException;
    public com.iatai.ws.VerificacionCSRespuesta[] verificarCodigoSeguridad(com.iatai.ws.VerificacionCS[] verificacionesCS) throws java.rmi.RemoteException;
    public com.iatai.ws.VerificacionRespuesta verificarTarjetaCredito(com.iatai.ws.VerificacionTarjetaCredito informacionVerificacion) throws java.rmi.RemoteException;
    public com.iatai.ws.TransaccionRespuesta_[] consultarTransacciones(com.iatai.ws.TransaccionConsultaFecha informacionConsulta) throws java.rmi.RemoteException;
}
