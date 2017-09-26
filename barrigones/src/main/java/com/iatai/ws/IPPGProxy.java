package com.iatai.ws;

public class IPPGProxy implements com.iatai.ws.IPPG_PortType {
  private String _endpoint = null;
  private com.iatai.ws.IPPG_PortType iPPG_PortType = null;
  
  public IPPGProxy() {
    _initIPPGProxy();
  }
  
  public IPPGProxy(String endpoint) {
    _endpoint = endpoint;
    _initIPPGProxy();
  }
  
  private void _initIPPGProxy() {
    try {
      iPPG_PortType = (new com.iatai.ws.IPPG_ServiceLocator()).getIPPGPort();
      if (iPPG_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iPPG_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iPPG_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iPPG_PortType != null)
      ((javax.xml.rpc.Stub)iPPG_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.iatai.ws.IPPG_PortType getIPPG_PortType() {
    if (iPPG_PortType == null)
      _initIPPGProxy();
    return iPPG_PortType;
  }
  
  public com.iatai.ws.TransaccionRespuesta_ transaccion(com.iatai.ws.TransaccionTarjetaCredito_ informacionTransaccion) throws java.rmi.RemoteException{
    if (iPPG_PortType == null)
      _initIPPGProxy();
    return iPPG_PortType.transaccion(informacionTransaccion);
  }
  
  public com.iatai.ws.FranquiciaWS[] obtenerFranquicias() throws java.rmi.RemoteException{
    if (iPPG_PortType == null)
      _initIPPGProxy();
    return iPPG_PortType.obtenerFranquicias();
  }
  
  public com.iatai.ws.TransaccionSuscripcionRespuesta_ transaccionarAereoSuscripcion(com.iatai.ws.TransaccionAereoSuscripcion informacionTransaccion) throws java.rmi.RemoteException{
    if (iPPG_PortType == null)
      _initIPPGProxy();
    return iPPG_PortType.transaccionarAereoSuscripcion(informacionTransaccion);
  }
  
  public com.iatai.ws.TransaccionRespuesta_ consultarTransaccion(com.iatai.ws.TransaccionConsulta informacionConsulta) throws java.rmi.RemoteException{
    if (iPPG_PortType == null)
      _initIPPGProxy();
    return iPPG_PortType.consultarTransaccion(informacionConsulta);
  }
  
  public com.iatai.ws.TransaccionRespuesta_ transaccionAereo(com.iatai.ws.TransaccionAereoTarjetaCredito informacionTransaccion) throws java.rmi.RemoteException{
    if (iPPG_PortType == null)
      _initIPPGProxy();
    return iPPG_PortType.transaccionAereo(informacionTransaccion);
  }
  
  public com.iatai.ws.TransaccionRespuesta_ reverso(com.iatai.ws.TransaccionReverso informacionReverso) throws java.rmi.RemoteException{
    if (iPPG_PortType == null)
      _initIPPGProxy();
    return iPPG_PortType.reverso(informacionReverso);
  }
  
  public com.iatai.ws.TransaccionSuscripcionRespuesta transaccionarSuscripcion(com.iatai.ws.TransaccionSuscripcion informacionTransaccion) throws java.rmi.RemoteException{
    if (iPPG_PortType == null)
      _initIPPGProxy();
    return iPPG_PortType.transaccionarSuscripcion(informacionTransaccion);
  }
  
  public com.iatai.ws.TarjetaCreditoRespuesta transacionTarjetaCredito(com.iatai.ws.TransaccionTarjetaCredito informacionTransaccion) throws java.rmi.RemoteException{
    if (iPPG_PortType == null)
      _initIPPGProxy();
    return iPPG_PortType.transacionTarjetaCredito(informacionTransaccion);
  }
  
  public com.iatai.ws.TransaccionRespuesta consultarPorReferencia(java.lang.String referencia) throws java.rmi.RemoteException{
    if (iPPG_PortType == null)
      _initIPPGProxy();
    return iPPG_PortType.consultarPorReferencia(referencia);
  }
  
  public com.iatai.ws.SuscripcionTarjetaCreditoRespuesta agregarSuscripcion(com.iatai.ws.SuscripcionAgregar suscripcionAgregacion) throws java.rmi.RemoteException{
    if (iPPG_PortType == null)
      _initIPPGProxy();
    return iPPG_PortType.agregarSuscripcion(suscripcionAgregacion);
  }
  
  public com.iatai.ws.SuscripcionEliminarRespuesta eliminarSuscripcion(com.iatai.ws.SuscripcionEliminar suscripcionEliminacion) throws java.rmi.RemoteException{
    if (iPPG_PortType == null)
      _initIPPGProxy();
    return iPPG_PortType.eliminarSuscripcion(suscripcionEliminacion);
  }
  
  public com.iatai.ws.UsuarioSuscripcionRespuesta obtenerSuscripciones(com.iatai.ws.Suscripcionconsulta suscripcionConsulta) throws java.rmi.RemoteException{
    if (iPPG_PortType == null)
      _initIPPGProxy();
    return iPPG_PortType.obtenerSuscripciones(suscripcionConsulta);
  }
  
  public com.iatai.ws.SuscripcionTarjetaCreditoRespuesta suscribirTarjetaCredito(com.iatai.ws.Suscripcion informacionSuscripcion) throws java.rmi.RemoteException{
    if (iPPG_PortType == null)
      _initIPPGProxy();
    return iPPG_PortType.suscribirTarjetaCredito(informacionSuscripcion);
  }
  
  public com.iatai.ws.VerificacionCSRespuesta[] verificarCodigoSeguridad(com.iatai.ws.VerificacionCS[] verificacionesCS) throws java.rmi.RemoteException{
    if (iPPG_PortType == null)
      _initIPPGProxy();
    return iPPG_PortType.verificarCodigoSeguridad(verificacionesCS);
  }
  
  public com.iatai.ws.VerificacionRespuesta verificarTarjetaCredito(com.iatai.ws.VerificacionTarjetaCredito informacionVerificacion) throws java.rmi.RemoteException{
    if (iPPG_PortType == null)
      _initIPPGProxy();
    return iPPG_PortType.verificarTarjetaCredito(informacionVerificacion);
  }
  
  public com.iatai.ws.TransaccionRespuesta_[] consultarTransacciones(com.iatai.ws.TransaccionConsultaFecha informacionConsulta) throws java.rmi.RemoteException{
    if (iPPG_PortType == null)
      _initIPPGProxy();
    return iPPG_PortType.consultarTransacciones(informacionConsulta);
  }
  
  
}