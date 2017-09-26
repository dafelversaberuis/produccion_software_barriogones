package fundacionFRC.modulos.ventas;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import fundacionFRC.Conexion;
import fundacionFRC.beans.Arbolito;
import fundacionFRC.beans.Convenio;
import fundacionFRC.beans.DetalleArbolitoVendido;
import fundacionFRC.beans.Estado;
import fundacionFRC.beans.FotoArbolito;
import fundacionFRC.beans.HistoricoArbolitoVendido;
import fundacionFRC.beans.HistoricoEstado;
import fundacionFRC.beans.Lote;
import fundacionFRC.beans.Tarjeta;
import fundacionFRC.beans.Venta;
import fundacionFRC.generales.ConsultarFuncionesAPI;
import fundacionFRC.generales.IConstantes;
import fundacionFRC.generales.IEmail;
import fundacionFRC.modulos.IConsultasDAO;
import fundacionFRC.modulos.arbolitos.AdministrarSesionCliente;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@ManagedBean
@ViewScoped
public class AdministrarVenta extends ConsultarFuncionesAPI implements Serializable {

	/**
	 * 
	 */
	private static final long								serialVersionUID	= 2034107393479426042L;

	private Arbolito												arbolito;
	private Venta														venta;
	private Venta														ventaTransaccion;
	private Tarjeta													tarjeta;
	private Tarjeta													tarjetaTransaccion;
	private Tarjeta													tarjetaEliminacion;
	private List<Venta>											ventas;
	private List<Tarjeta>										tarjetas;
	private List<DetalleArbolitoVendido>		detallesVentas;
	private List<HistoricoArbolitoVendido>	historicos;
	private List<SelectItem>								itemsArbolitos;
	private Map<String, Object>							totales;
	private Map<String, Object>							totalesDetalle;

	// privados

	/**
	 * Obtiene una tajeta de alfanumérica de n dígitos
	 * 
	 * @return clave
	 */
	private String getTarjetaAleatoria() {
		String clave = "";
		int numero = 0;
		int numeroAscii = 0;
		int carcaterNumero = 0;
		try {
			for (int i = 1; i <= IConstantes.NUMERO_CARACTERES_TARJETA.intValue(); i++) {

				// priemro decidimos si es caracter o número, si es 0->numero,
				// 1->caracter
				carcaterNumero = (int) (2.0 * Math.random());

				if (carcaterNumero == 0) {
					// si es número buscamos un aletorio de 0-9
					numero = (int) (10.0 * Math.random());
					clave += "" + numero;

				} else {

					// si es caracter buscamos una letra aleatoria entre a y z
					// para eso buscamos su número ascii entre 0 y 25 y le sumamos 97 ya
					// que a-z es (97-122)
					numeroAscii = (int) (26.0 * Math.random()) + 97;

					clave += (char) numeroAscii;

				}

			}
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return clave;

	}

	/**
	 * Valida la creación de la tarjeta
	 * 
	 * @return ok
	 */
	private boolean isOkTarjeta() {
		boolean ok = true;

		try {
			Arbolito arbolitoId = new Arbolito();
			arbolitoId.setId(this.tarjeta.getArbolito().getId());
			List<Arbolito> arbolitos = IConsultasDAO.getArbolitos(arbolitoId);
			this.tarjeta.setArbolito(arbolitos.get(0));

			Convenio convenioId = new Convenio();
			convenioId.setId(this.tarjeta.getConvenio().getId());
			List<Convenio> convenios = IConsultasDAO.getConvenios(convenioId);
			this.tarjeta.setConvenio(convenios.get(0));

			if (!(this.tarjeta != null && this.tarjeta.gettCantidadTarjetas() != null && this.tarjeta.getArbolito() != null && this.tarjeta.getArbolito().getCantidadDisponible() != null && this.tarjeta.getArbolito().getCantidadDisponible().intValue() > 0 && this.tarjeta.getArbolito().getCantidadDisponible().intValue() >= this.tarjeta.gettCantidadTarjetas().intValue())) {
				ok = false;
				this.mostrarMensajeGlobal("cantidadNoDisponible", "advertencia");
			}

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}

		return ok;
	}

	/**
	 * Valida la consulta realizada
	 * 
	 * @return ok
	 */
	private boolean isOkConsultaVenta() {
		boolean ok = true;

		if (this.venta != null && ((this.venta.gettOperadorConsulta() != null && this.venta.getCantidadTotalVenta() == null) || (this.venta.gettOperadorConsulta() == null && this.venta.getCantidadTotalVenta() != null))) {
			ok = false;
			this.mostrarMensajeGlobal("cantidadArbolitosIncompleto", "advertencia");
		}
		if (this.venta != null && ((this.venta.gettOperadorVentas() != null && this.venta.getValorTotalConIva() == null) || (this.venta.gettOperadorVentas() == null && this.venta.getValorTotalConIva() != null))) {
			ok = false;
			this.mostrarMensajeGlobal("valorArbolitosIncompleto", "advertencia");
		}

		return ok;
	}

	// publicos

	/**
	 * Imprime las tarjetas
	 * 
	 * @param aTipoReporte
	 */
	public void listarTarjetas(String aTipoReporte) {

		Map<String, Object> parametros = new HashMap<String, Object>();

		parametros.put("pTipoReporte", "pdf");

		this.generarListado(new JRBeanCollectionDataSource(this.tarjetas), IConstantes.REPORTE_TARJETAS, IConstantes.NOMBRE_REPORTE_TARJETAS, aTipoReporte, parametros);

	}

	/**
	 * Prepara la transacción para ser registrada en su fase inicial
	 * 
	 *
	 */
	public void registrarTransaccionAprobada(Conexion conexion, Tarjeta aTarjeta) throws Exception {

		Venta venta = null;
		AdministrarSesionCliente inventario = new AdministrarSesionCliente();
		DetalleArbolitoVendido detalle = null;
		HistoricoArbolitoVendido historico = null;
		List<Estado> estadosIniciales = null;
		List<Lote> lotesConsultados = null;

		HistoricoEstado historicoEstado = null;

		try {

			Estado estado = new Estado();
			estado.setEstadoInicial(IConstantes.AFIRMACION);
			estadosIniciales = IConsultasDAO.getEstados(estado);
			if (estadosIniciales != null && estadosIniciales.size() > 0) {

				// 1-registro de la venta
				venta = new Venta();
				venta.setComprador(null); // no tiene comprador aún

				aTarjeta.getCamposBD();
				venta.getTarjeta().setId(conexion.getUltimoSerialTransaccion(aTarjeta.getEstructuraTabla().getTabla()));// el
																																																								// id
																																																								// de
																																																								// la
																																																								// tarjeta
				venta.setEstadoTransaccion(IConstantes.ESTADO_INICIAL_TRANSACCION);
				venta.setFechaTransaccion(aTarjeta.getFechaRegistro());
				venta.setHoraTransaccion(aTarjeta.getFechaRegistro());

				venta.setIdiomaTransaccion(aTarjeta.getIdiomaTarjeta());
				venta.setMoneda(aTarjeta.gettVenta().getMoneda());

				venta.setCantidadTotalVenta(IConstantes.ARBOLITO_POR_DONACION);

				if (venta.getMoneda().equals(IConstantes.PESO_COLOMBIANO)) {

					venta.setValorTotalVenta(aTarjeta.getArbolito().getPrecioVentaPesos());
					venta.setValorTotalIva(aTarjeta.getArbolito().getIvaPesos());
					venta.setValorTotalConIva(aTarjeta.getArbolito().getPrecioVentaPesosConIva());
				} else {

					venta.setValorTotalVenta(aTarjeta.getArbolito().getPrecioVentaUS());
					venta.setValorTotalIva(aTarjeta.getArbolito().getIvaUs());
					venta.setValorTotalConIva(aTarjeta.getArbolito().getPrecioVentaUSConIva());

				}

				// comisión ganada en la tarjeta
				venta.setGananaciaConvenio(this.getValorRedondeado(venta.getValorTotalConIva().multiply(aTarjeta.getPorcentajeComisionAplicado()).divide(new BigDecimal(100)), IConstantes.DECIMALES_REDONDEAR));

				venta.getCamposBD();
				conexion.insertarBD(venta.getEstructuraTabla().getTabla(), venta.getEstructuraTabla().getPersistencia());

				venta.setId(conexion.getUltimoSerialTransaccion(venta.getEstructuraTabla().getTabla()));

				// 2-guarda los detalles de la venta

				detalle = new DetalleArbolitoVendido();
				detalle.setVenta(venta);
				detalle.setArbolito(aTarjeta.getArbolito());

				detalle.setCantidadArbolitos(IConstantes.ARBOLITO_POR_DONACION);
				detalle.setPorcentajeIvaAplicado(aTarjeta.getArbolito().getIva().getValorIva());

				if (venta.getMoneda().equals(IConstantes.PESO_COLOMBIANO)) {

					detalle.setValorTotal(aTarjeta.getArbolito().getPrecioVentaPesos());
					detalle.setValorIva(aTarjeta.getArbolito().getIvaPesos());
					detalle.setValorTotalConIva(aTarjeta.getArbolito().getPrecioVentaPesosConIva());

				} else {

					detalle.setValorTotal(aTarjeta.getArbolito().getPrecioVentaUS());
					detalle.setValorIva(aTarjeta.getArbolito().getIvaUs());
					detalle.setValorTotalConIva(aTarjeta.getArbolito().getPrecioVentaUSConIva());

				}

				detalle.getCamposBD();
				conexion.insertarBD(detalle.getEstructuraTabla().getTabla(), detalle.getEstructuraTabla().getPersistencia());

				// actualiza inventario de cantidades arbolito
				inventario.actualizarCantidadesArbolitos(conexion, aTarjeta.getArbolito(), "cantidad_pendiente_pago", detalle.getCantidadArbolitos(), "+");
				inventario.actualizarCantidadesArbolitos(conexion, aTarjeta.getArbolito(), "cantidad_disponible", detalle.getCantidadArbolitos(), "-");

				// valida mínimo cero
				inventario.actualizarCantidadesArbolitos(conexion, aTarjeta.getArbolito(), "minimo_cero", null, null);

				historico = new HistoricoArbolitoVendido();
				historico.setVenta(venta);
				historico.setArbolito(aTarjeta.getArbolito());
				historico.setEstado(estadosIniciales.get(0)); // estado_inicial_traerlo
				historico.setHistoricoSuperior(null);
				historico.setNombrePersonalizadoArbolito(null);
				historico.setMensajePlaca(null);
				historico.setCorreoReceptorRegalo(null);
				historico.setIndicativoBolsa(IConstantes.NEGACION);
				lotesConsultados = IConsultasDAO.getLotesArbolesDisponibles(conexion, aTarjeta.getArbolito());

				if (lotesConsultados != null && lotesConsultados.size() > 0) {

					historico.setLote(lotesConsultados.get(0));
					historico.setNumeroInterno((lotesConsultados.get(0).getCantidadVendida().intValue() + 1));
					inventario.actualizarLote(conexion, lotesConsultados.get(0), "cantidad_vendida", lotesConsultados.get(0).getCantidadVendida());

					if (lotesConsultados.get(0).getIndicativoInfinito().equals(IConstantes.NEGACION)) { // OJO
						inventario.actualizarLote(conexion, lotesConsultados.get(0), "cantidad_disponible", lotesConsultados.get(0).getCantidadDisponible());
						inventario.actualizarLote(conexion, lotesConsultados.get(0), "minimo_cero", null);
					}

				} else {
					historico.setLote(null);// por ahora
				}

				historico.getCamposBD();
				conexion.insertarBD(historico.getEstructuraTabla().getTabla(), historico.getEstructuraTabla().getPersistencia());

				historico.setId(conexion.getUltimoSerialTransaccion(historico.getEstructuraTabla().getTabla()));

				// guarda el historial del estado
				historicoEstado = new HistoricoEstado();
				historicoEstado.setEstado(historico.getEstado());
				historicoEstado.setHistorico(historico);
				historicoEstado.getCamposBD();
				conexion.insertarBD(historicoEstado.getEstructuraTabla().getTabla(), historicoEstado.getEstructuraTabla().getPersistencia());

				// actualiza inventario de cantidades arbolito de pendientes a vendidos
				inventario.actualizarCantidadesArbolitos(conexion, detalle.getArbolito(), "cantidad_pendiente_pago", detalle.getCantidadArbolitos(), "-");
				inventario.actualizarCantidadesArbolitos(conexion, detalle.getArbolito(), "cantidad_vendida", detalle.getCantidadArbolitos(), "+");

				venta.setEstadoTransaccion(IConstantes.TRANSACCION_APROBADA);
				venta.getCamposBD();

				List<String> excluidos = new ArrayList<String>();
				excluidos.add("idioma_transaccion");
				excluidos.add("id_tarjeta");

				conexion.actualizarBD(venta.getEstructuraTabla().getTabla(), venta.getEstructuraTabla().getPersistencia(), venta.getEstructuraTabla().getLlavePrimaria(), excluidos);

			} else {
				this.mostrarMensajeGlobal("transaccionesDesactivadas", "advertencia");
			}

		} catch (Exception e) {
			throw new Exception(e);

		}

	}

	/**
	 * Consulta las tarjetas por los criterios especificados
	 */
	public void consultarTarjetas() {
		Conexion conexion = new Conexion();
		try {

			this.tarjetas = IConsultasDAO.getTarjetas(conexion, this.tarjetaTransaccion);

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		} finally {
			conexion.cerrarConexion();
		}

	}

	/**
	 * Este método borra el formulario de consulta de una tarjeta
	 */
	public void cancelarTarjetaTransaccion() {

		try {
			this.tarjetaTransaccion = null;
			this.getTarjetaTransaccion();

			this.tarjetas = null;

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}

	}

	/**
	 * Este método borra el formulario de creación de una tarjeta
	 */
	public void cancelarTarjeta() {

		try {
			this.tarjeta = null;
			this.getTarjeta();

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}

	}

	/**
	 * Crea un nuevo registro de convenio
	 */
	public void crearTarjeta() {
		Conexion conexion = new Conexion();
		List<Tarjeta> tarjetasAlgoritmo = null;

		try {
			if (isOkTarjeta()) {
				conexion.setAutoCommitBD(false);

				this.tarjeta.setFechaRegistro(new Date());
				this.tarjeta.setUsada(IConstantes.NEGACION);
				this.tarjeta.setPorcentajeComisionAplicado(this.tarjeta.getConvenio().getComision().getValorIva());
				

				for (int i = 1; i <= this.tarjeta.gettCantidadTarjetas().intValue(); i++) {

					do {
						this.tarjeta.setAlgoritmo(this.getTarjetaAleatoria());
						Tarjeta tarjeta = new Tarjeta();
						tarjeta.setAlgoritmo(this.tarjeta.getAlgoritmo());
						tarjetasAlgoritmo = IConsultasDAO.getTarjetas(conexion, tarjeta);

					} while (tarjetasAlgoritmo != null && tarjetasAlgoritmo.size() > 0);

					this.tarjeta.getCamposBD();
					conexion.insertarBD(this.tarjeta.getEstructuraTabla().getTabla(), this.tarjeta.getEstructuraTabla().getPersistencia());

					// registra la venta, su detalle y su histórico como aprobada
					registrarTransaccionAprobada(conexion, this.tarjeta);

				}
				conexion.commitBD();
				this.mostrarMensajeGlobal("tarjetasCreadasExitosamente", "exito");

			}

		} catch (Exception e) {
			conexion.rollbackBD();
			this.mostrarMensajeGlobal("transaccionFallida", "error");
		} finally {
			conexion.cerrarConexion();
		}

		this.tarjetas = null;

		this.tarjetaTransaccion = null;
		this.getTarjetaTransaccion();

		this.tarjetaTransaccion.setConvenio(this.tarjeta.getConvenio());
		this.tarjetaTransaccion.setArbolito(this.tarjeta.getArbolito());
		this.tarjetaTransaccion.settFechaDesde(this.tarjeta.getFechaRegistro());
		this.tarjetaTransaccion.settFechaHasta(this.tarjeta.getFechaRegistro());
		this.tarjetaTransaccion.gettVenta().setMoneda(this.tarjeta.gettVenta().getMoneda());

		consultarTarjetas();

		// reseteo de variables
		this.tarjeta = null;
		this.getTarjeta();

	}

	/**
	 * Aprueba una venta de forma manual
	 */
	public void aprobarVenta() {

		Conexion conexion = new Conexion();
		AdministrarSesionCliente admin = new AdministrarSesionCliente();
		List<String> listaCorreos = new ArrayList<String>();
		try {

			conexion.setAutoCommitBD(false);

			this.getDetallesVentas();
			if (this.detallesVentas != null && this.detallesVentas.size() > 0) {
				for (DetalleArbolitoVendido detalle : this.detallesVentas) {

					// actualiza inventario de cantidades arbolito
					if (detalle != null && detalle.getNumeroArbolesBolsa() != null) {
						admin.actualizarCantidadesArbolitos(conexion, detalle.getArbolito(), "cantidad_pendiente_pago", detalle.getNumeroArbolesBolsa(), "-");
						admin.actualizarCantidadesArbolitos(conexion, detalle.getArbolito(), "cantidad_vendida", detalle.getNumeroArbolesBolsa(), "+");
					} else {
						admin.actualizarCantidadesArbolitos(conexion, detalle.getArbolito(), "cantidad_pendiente_pago", detalle.getCantidadArbolitos(), "-");
						admin.actualizarCantidadesArbolitos(conexion, detalle.getArbolito(), "cantidad_vendida", detalle.getCantidadArbolitos(), "+");
					}

				}

				this.ventaTransaccion.setEstadoTransaccion(IConstantes.TRANSACCION_APROBADA);
				this.ventaTransaccion.getCamposBD();

				List<String> excluidos = new ArrayList<String>();
				excluidos.add("idioma_transaccion");
				excluidos.add("id_tarjeta");

				conexion.actualizarBD(this.ventaTransaccion.getEstructuraTabla().getTabla(), this.ventaTransaccion.getEstructuraTabla().getPersistencia(), this.ventaTransaccion.getEstructuraTabla().getLlavePrimaria(), excluidos);
				conexion.commitBD();

				this.mostrarMensajeGlobal("edicionExitosa", "exito");

				// correo al comprador
				IEmail.enviarCorreo(this.getMensaje("aprobacionParticular", this.ventaTransaccion.getComprador().getNombreCompleto()), this.getMensaje("asuntoAprobacion"), ventaTransaccion.getComprador().getCorreoElectronico().trim());

				// correo a los agasajados
				HistoricoArbolitoVendido temp = new HistoricoArbolitoVendido();
				temp.getVenta().setId(this.ventaTransaccion.getId());
				temp.setTregalarlo(IConstantes.AFIRMACION);

				List<HistoricoArbolitoVendido> historicosTransaccion = IConsultasDAO.getHistoricoArbolito(temp);
				if (historicosTransaccion != null && historicosTransaccion.size() > 0) {
					for (HistoricoArbolitoVendido h : historicosTransaccion) {
						if (listaCorreos.size() < IConstantes.MAXIMOS_REMITENTES_CORREO.intValue() && !(listaCorreos.stream().anyMatch(p -> h.getCorreoReceptorRegalo().trim().equals(p.trim())))) {
							listaCorreos.add(h.getCorreoReceptorRegalo().trim());
						}
					}
				}

				// correo a los agasajados
				if (listaCorreos != null && listaCorreos.size() > 0) {

					IEmail.enviarCorreoMasivo(this.getMensaje("mensajeCorreoRegalo", this.ventaTransaccion.getComprador().getNombreCompleto()), this.getMensaje("asuntoRegalo"), listaCorreos);

				}

				this.mostrarMensajeGlobal("tambienCorreoAprobacion", "exito");

			} else {

				this.mostrarMensajeGlobal("noSePudoAprobarVenta", "advertencia");

			}

			this.ventas = IConsultasDAO.getVentas(this.venta);

		} catch (Exception e) {
			conexion.rollbackBD();
			this.mostrarMensajeGlobal("transaccionFallida", "error");
			this.mostrarMensajeGlobal("eliminacionFallida", "error");

		} finally {
			conexion.cerrarConexion();
		}

	}

	/**
	 * Elimina la tarjeta
	 */
	public void eliminarTarjeta() {

		Conexion conexion = new Conexion();

		AdministrarSesionCliente cliente = new AdministrarSesionCliente();

		try {

			conexion.setAutoCommitBD(false);
			HistoricoEstado historicoEstado = null;
			FotoArbolito fotoHistorico = null;

			DetalleArbolitoVendido detalle = new DetalleArbolitoVendido();
			detalle.setVenta(this.tarjetaEliminacion.gettVenta());

			List<DetalleArbolitoVendido> detalles = IConsultasDAO.getDetalleVentas(detalle);

			// actualiza los indicadores de los arbolitos
			if (detalles != null && detalles.size() > 0) {
				for (DetalleArbolitoVendido a : detalles) {
					// actualiza inventario de cantidades arbolito

					if (a.getCantidadArbolitos() == null || (a.getCantidadArbolitos() != null && a.getCantidadArbolitos().intValue() < 0)) {
						a.setCantidadArbolitos(0);
					}

					cliente.actualizarCantidadesArbolitos(conexion, a.getArbolito(), "cantidad_vendida", a.getCantidadArbolitos(), "-");
					cliente.actualizarCantidadesArbolitos(conexion, a.getArbolito(), "cantidad_disponible", a.getCantidadArbolitos(), "+");

					// valida mínimo cero
					cliente.actualizarCantidadesArbolitos(conexion, a.getArbolito(), "minimo_cero", null, null);

				}

			}

			// borra los detalles
			detalle.getCamposBD();
			Map<String, Object> llaveForaneaDetalle = new HashMap<String, Object>();
			llaveForaneaDetalle.put("id_venta", this.tarjetaEliminacion.gettVenta().getId());
			conexion.eliminarBD(detalle.getEstructuraTabla().getTabla(), llaveForaneaDetalle);

			// historicos actualiza indicadores, solo disponible xq de vendidos lo
			// vamos a tomar sólo para id de lote

			HistoricoArbolitoVendido historico = new HistoricoArbolitoVendido();
			historico.getVenta().setId(this.tarjetaEliminacion.gettVenta().getId());
			List<HistoricoArbolitoVendido> historicos = IConsultasDAO.getHistoricoVenta(historico);
			if (historicos != null && historicos.size() > 0) {
				for (HistoricoArbolitoVendido h : historicos) {

					if (h.getLote() != null && h.getLote().getIndicativoInfinito() != null && h.getLote().getIndicativoInfinito().equals(IConstantes.NEGACION)) {
						if (h.getLote().getCantidadDisponible() == null || (h.getLote().getCantidadDisponible() != null && h.getLote().getCantidadDisponible().intValue() < 0)) {
							h.getLote().setCantidadDisponible(0);
						}

						cliente.actualizarLote(conexion, h.getLote(), "cantidad_disponible_suma", h.getLote().getCantidadDisponible());
						cliente.actualizarLote(conexion, h.getLote(), "minimo_cero", null);
					}
					// borra los estados historicos
					historicoEstado = new HistoricoEstado();
					Map<String, Object> llaveForaneaEstadoHistorico = new HashMap<String, Object>();
					llaveForaneaEstadoHistorico.put("id_historico", h.getId());
					historicoEstado.getCamposBD();
					conexion.eliminarBD(historicoEstado.getEstructuraTabla().getTabla(), llaveForaneaEstadoHistorico);

					// borra las fotos asociadas
					fotoHistorico = new FotoArbolito();
					Map<String, Object> llaveForaneaFotoHistorico = new HashMap<String, Object>();
					llaveForaneaFotoHistorico.put("id_historico_arbolito", h.getId());
					fotoHistorico.getCamposBD();
					conexion.eliminarBD(fotoHistorico.getEstructuraTabla().getTabla(), llaveForaneaFotoHistorico);

				}
			}

			// borra los historicos
			historico.getCamposBD();
			Map<String, Object> llaveForaneahistorico = new HashMap<String, Object>();
			llaveForaneahistorico.put("id_venta", this.tarjetaEliminacion.gettVenta().getId());
			conexion.eliminarBD(historico.getEstructuraTabla().getTabla(), llaveForaneahistorico);

			this.tarjetaEliminacion.gettVenta().getCamposBD();
			conexion.eliminarBD(this.tarjetaEliminacion.gettVenta().getEstructuraTabla().getTabla(), this.tarjetaEliminacion.gettVenta().getEstructuraTabla().getLlavePrimaria());

			// BORRA LA TARJETA
			this.tarjetaEliminacion.getCamposBD();
			conexion.eliminarBD(this.tarjetaEliminacion.getEstructuraTabla().getTabla(), this.tarjetaEliminacion.getEstructuraTabla().getLlavePrimaria());

			conexion.commitBD();

			this.mostrarMensajeGlobal("tarjetaEliminada", "exito");

			this.tarjetas = null;
			consultarTarjetas();

		} catch (Exception e) {
			conexion.rollbackBD();
			this.mostrarMensajeGlobal("transaccionFallida", "error");
			this.mostrarMensajeGlobal("eliminacionFallida", "error");

		} finally {
			conexion.cerrarConexion();
		}

	}

	/**
	 * Elimina la venta de la cuenta actual
	 */
	public void eliminarVenta() {

		Conexion conexion = new Conexion();

		AdministrarSesionCliente cliente = new AdministrarSesionCliente();

		try {

			conexion.setAutoCommitBD(false);
			HistoricoEstado historicoEstado = null;
			FotoArbolito fotoHistorico = null;
			DetalleArbolitoVendido detalle = new DetalleArbolitoVendido();
			detalle.setVenta(this.ventaTransaccion);
			List<DetalleArbolitoVendido> detalles = IConsultasDAO.getDetalleVentas(detalle);

			// actualiza los indicadores de los arbolitos
			if (detalles != null && detalles.size() > 0) {
				for (DetalleArbolitoVendido a : detalles) {
					// actualiza inventario de cantidades arbolito

					if (a.getCantidadArbolitos() == null || (a.getCantidadArbolitos() != null && a.getCantidadArbolitos().intValue() < 0)) {
						a.setCantidadArbolitos(0);
					}

					if (a.getNumeroArbolesBolsa() != null) {
						cliente.actualizarCantidadesArbolitos(conexion, a.getArbolito(), "cantidad_pendiente_pago", a.getNumeroArbolesBolsa(), "-");
						cliente.actualizarCantidadesArbolitos(conexion, a.getArbolito(), "cantidad_disponible", a.getNumeroArbolesBolsa(), "+");
					} else {
						cliente.actualizarCantidadesArbolitos(conexion, a.getArbolito(), "cantidad_pendiente_pago", a.getCantidadArbolitos(), "-");
						cliente.actualizarCantidadesArbolitos(conexion, a.getArbolito(), "cantidad_disponible", a.getCantidadArbolitos(), "+");
					}

					// valida mínimo cero
					cliente.actualizarCantidadesArbolitos(conexion, a.getArbolito(), "minimo_cero", null, null);

				}

			}

			// borra los detalles
			detalle.getCamposBD();
			Map<String, Object> llaveForaneaDetalle = new HashMap<String, Object>();
			llaveForaneaDetalle.put("id_venta", this.ventaTransaccion.getId());
			conexion.eliminarBD(detalle.getEstructuraTabla().getTabla(), llaveForaneaDetalle);

			// historicos actualiza indicadores, solo disponible xq de vendidos lo
			// vamos a tomar sólo para id de lote

			HistoricoArbolitoVendido historico = new HistoricoArbolitoVendido();
			historico.getVenta().setId(this.ventaTransaccion.getId());
			List<HistoricoArbolitoVendido> historicos = IConsultasDAO.getHistoricoVenta(historico);
			if (historicos != null && historicos.size() > 0) {
				for (HistoricoArbolitoVendido h : historicos) {

					if (h.getLote() != null && h.getLote().getIndicativoInfinito() != null && h.getLote().getIndicativoInfinito().equals(IConstantes.NEGACION)) {
						if (h.getLote().getCantidadDisponible() == null || (h.getLote().getCantidadDisponible() != null && h.getLote().getCantidadDisponible().intValue() < 0)) {
							h.getLote().setCantidadDisponible(0);
						}

						cliente.actualizarLote(conexion, h.getLote(), "cantidad_disponible_suma", h.getLote().getCantidadDisponible());
						cliente.actualizarLote(conexion, h.getLote(), "minimo_cero", null);
					}
					// borra los estados historicos
					historicoEstado = new HistoricoEstado();
					Map<String, Object> llaveForaneaEstadoHistorico = new HashMap<String, Object>();
					llaveForaneaEstadoHistorico.put("id_historico", h.getId());
					historicoEstado.getCamposBD();
					conexion.eliminarBD(historicoEstado.getEstructuraTabla().getTabla(), llaveForaneaEstadoHistorico);

					// borra las fotos asociadas
					fotoHistorico = new FotoArbolito();
					Map<String, Object> llaveForaneaFotoHistorico = new HashMap<String, Object>();
					llaveForaneaFotoHistorico.put("id_historico_arbolito", h.getId());
					fotoHistorico.getCamposBD();
					conexion.eliminarBD(fotoHistorico.getEstructuraTabla().getTabla(), llaveForaneaFotoHistorico);

				}
			}

			// borra los historicos
			historico.getCamposBD();
			Map<String, Object> llaveForaneahistorico = new HashMap<String, Object>();
			llaveForaneahistorico.put("id_venta", this.ventaTransaccion.getId());
			conexion.eliminarBD(historico.getEstructuraTabla().getTabla(), llaveForaneahistorico);

			this.ventaTransaccion.getCamposBD();
			conexion.eliminarBD(this.ventaTransaccion.getEstructuraTabla().getTabla(), this.ventaTransaccion.getEstructuraTabla().getLlavePrimaria());
			conexion.commitBD();

			this.mostrarMensajeGlobal("ventaEliminada", "exito");

			this.ventas = IConsultasDAO.getVentas(this.venta);

		} catch (Exception e) {
			conexion.rollbackBD();
			this.mostrarMensajeGlobal("transaccionFallida", "error");
			this.mostrarMensajeGlobal("eliminacionFallida", "error");

		} finally {
			conexion.cerrarConexion();
		}

	}

	/**
	 * Asigna una tarjeta para ser eliminada
	 * 
	 * @param aTarjeta
	 */
	public void asignarTarjeta(Tarjeta aTarjeta) {

		try {

			this.tarjetaEliminacion = aTarjeta;

			this.abrirModal("panelEliminacionVenta");

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}

	}

	/**
	 * Abre un diálogo de venta
	 * 
	 * @param aVenta
	 * @param aVista
	 */
	public void asignarVenta(Venta aVenta, String aVista) {

		try {

			this.ventaTransaccion = aVenta;

			if (aVista != null && aVista.equals("DETALLE_VENTA")) {

				this.abrirModal("panelDetalleVentas");

			} else if (aVista != null && aVista.equals("ELIMINAR_VENTA")) {

				this.abrirModal("panelEliminacionVenta");

			} else if (aVista != null && aVista.equals("APROBAR_VENTA")) {

				this.abrirModal("panelAprobacionVenta");

			}

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}

	}

	/**
	 * Este método borra el formulario de detalle venta
	 */
	public void cancelarDeatalleVenta() {

		try {

			this.venta = new Venta();

			this.arbolito = new Arbolito();

			this.detallesVentas = null;

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}

	}

	/**
	 * Este método borra el formulario de consulta
	 */
	public void cancelarConsultaVenta() {

		try {

			this.venta = new Venta();

			this.ventas = null;

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}

	}

	/**
	 * Consulta los detalles de una venta
	 */
	public void consultarDetalleVentas() {
		try {

			DetalleArbolitoVendido detalle = new DetalleArbolitoVendido();

			this.venta.setEstadoTransaccion(IConstantes.TRANSACCION_APROBADA);
			detalle.setVenta(this.venta);

			detalle.setArbolito(this.arbolito);

			this.detallesVentas = IConsultasDAO.getDetalleVentas(detalle);

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}

	}

	/**
	 * Realzia la consulta de las ventas de acuerdo a criterios especificados
	 */
	public void consultarVentas() {
		try {
			if (isOkConsultaVenta()) {
				this.ventas = IConsultasDAO.getVentas(this.venta);
			}

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
	}

	// listados

	// get/set

	/**
	 * Sirve para los criterios de consulta
	 * 
	 * @return venta
	 */
	public Venta getVenta() {
		if (this.venta == null) {
			this.venta = new Venta();
		}
		return venta;
	}

	/**
	 * Establece los criterios de consulta
	 * 
	 * @param venta
	 */
	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	/**
	 * Obtiene datos de la tarjeta a eliminar
	 * 
	 * @return tarjetaEliminacion
	 */
	public Tarjeta getTarjetaEliminacion() {
		if (this.tarjetaEliminacion == null) {
			this.tarjetaEliminacion = new Tarjeta();
			this.tarjetaEliminacion.settVenta(new Venta());
		}
		return tarjetaEliminacion;
	}

	/**
	 * Establece datos de la tarjeta a eliminar
	 * 
	 * @param tarjetaEliminacion
	 */
	public void setTarjetaEliminacion(Tarjeta tarjetaEliminacion) {
		this.tarjetaEliminacion = tarjetaEliminacion;
	}

	/**
	 * Obtiene el objeto que realizará la transacción
	 * 
	 * @return ventaTransaccion
	 */
	public Venta getVentaTransaccion() {
		return ventaTransaccion;
	}

	/**
	 * Establece la venta de la transacción
	 * 
	 * @param ventaTransaccion
	 */
	public void setVentaTransaccion(Venta ventaTransaccion) {
		this.ventaTransaccion = ventaTransaccion;
	}

	/**
	 * Obtiene la tarjeta de consulta
	 * 
	 * @return tarjeta
	 */
	public Tarjeta getTarjeta() {
		try {
			if (this.tarjeta == null) {
				this.tarjeta = new Tarjeta();

				// como no se le dió memoria
				this.tarjeta.settVenta(new Venta());

			}
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return tarjeta;
	}

	/**
	 * Establece la tarjeta
	 * 
	 * @param tarjeta
	 */
	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	/**
	 * Obtiene una tarjeta transacción
	 * 
	 * @return tarjetaTransaccion
	 */
	public Tarjeta getTarjetaTransaccion() {
		try {
			if (this.tarjetaTransaccion == null) {
				this.tarjetaTransaccion = new Tarjeta();

				// como no se le dió memoria
				this.tarjetaTransaccion.settVenta(new Venta());

			}
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return tarjetaTransaccion;
	}

	public void setTarjetaTransaccion(Tarjeta tarjetaTransaccion) {
		this.tarjetaTransaccion = tarjetaTransaccion;
	}

	/**
	 * Obtiene un listado de tarjetas
	 * 
	 * @return tarjetas
	 */
	public List<Tarjeta> getTarjetas() {
		return tarjetas;
	}

	/**
	 * Estableece un listado de tarjetas
	 * 
	 * @param tarjetas
	 */
	public void setTarjetas(List<Tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}

	/**
	 * Obtiene un listado de ventas
	 * 
	 * @return ventas
	 */
	public List<Venta> getVentas() {

		return ventas;
	}

	/**
	 * Establece un listado de ventas
	 * 
	 * @param ventas
	 */
	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	/**
	 * Obtiene el detalle de las ventas
	 * 
	 * @return detallesVentas
	 */
	public List<DetalleArbolitoVendido> getDetallesVentas() {
		try {
			if (this.ventaTransaccion != null) {
				DetalleArbolitoVendido detalle = new DetalleArbolitoVendido();
				detalle.getVenta().setId(this.ventaTransaccion.getId());
				this.detallesVentas = IConsultasDAO.getDetalleVentas(detalle);

			}
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return detallesVentas;
	}

	/**
	 * Establece el detalle de las ventas
	 * 
	 * @param detallesVentas
	 */
	public void setDetallesVentas(List<DetalleArbolitoVendido> detallesVentas) {
		this.detallesVentas = detallesVentas;
	}

	/**
	 * Obtiene los totales
	 * 
	 * @return totales
	 */
	public Map<String, Object> getTotales() {
		this.totales = new HashMap<String, Object>();
		this.totales.put("cantidad", new Integer(0));
		this.totales.put("iva", new BigDecimal(0));
		this.totales.put("precioSinIva", new BigDecimal(0));
		this.totales.put("precioConIva", new BigDecimal(0));
		this.totales.put("gananciaConvenio", new BigDecimal(0));

		if (this.ventas != null && this.ventas.size() > 0) {
			for (Venta a : this.ventas) {
				this.totales.put("cantidad", ((Integer) this.totales.get("cantidad")) + a.getCantidadTotalVenta().intValue());
				this.totales.put("iva", this.getValorRedondeado(((BigDecimal) this.totales.get("iva")).add(a.getValorTotalIva()), IConstantes.DECIMALES_REDONDEAR));
				this.totales.put("precioSinIva", this.getValorRedondeado(((BigDecimal) this.totales.get("precioSinIva")).add(a.getValorTotalVenta()), IConstantes.DECIMALES_REDONDEAR));
				this.totales.put("precioConIva", this.getValorRedondeado(((BigDecimal) this.totales.get("precioConIva")).add(a.getValorTotalConIva()), IConstantes.DECIMALES_REDONDEAR));
				this.totales.put("gananciaConvenio", this.getValorRedondeado(((BigDecimal) this.totales.get("gananciaConvenio")).add(a.getGananaciaConvenio()), IConstantes.DECIMALES_REDONDEAR));

			}
		}
		return totales;
	}

	public void setTotales(Map<String, Object> totales) {
		this.totales = totales;
	}

	/**
	 * Obtiene totales de un detalle
	 * 
	 * @return totalesDetalle
	 */

	public Map<String, Object> getTotalesDetalle() {
		this.totalesDetalle = new HashMap<String, Object>();
		this.totalesDetalle.put("cantidad", new Integer(0));
		this.totalesDetalle.put("iva", new BigDecimal(0));
		this.totalesDetalle.put("precioSinIva", new BigDecimal(0));
		this.totalesDetalle.put("precioConIva", new BigDecimal(0));

		if (this.detallesVentas != null && this.detallesVentas.size() > 0) {
			for (DetalleArbolitoVendido a : this.detallesVentas) {
				this.totalesDetalle.put("cantidad", ((Integer) this.totalesDetalle.get("cantidad")) + a.getCantidadArbolitos().intValue());
				this.totalesDetalle.put("iva", this.getValorRedondeado(((BigDecimal) this.totalesDetalle.get("iva")).add(a.getValorIva()), IConstantes.DECIMALES_REDONDEAR));
				this.totalesDetalle.put("precioSinIva", this.getValorRedondeado(((BigDecimal) this.totalesDetalle.get("precioSinIva")).add(a.getValorTotal()), IConstantes.DECIMALES_REDONDEAR));
				this.totalesDetalle.put("precioConIva", this.getValorRedondeado(((BigDecimal) this.totalesDetalle.get("precioConIva")).add(a.getValorTotalConIva()), IConstantes.DECIMALES_REDONDEAR));

			}
		}

		return totalesDetalle;
	}

	public void setTotalesDetalle(Map<String, Object> totalesDetalle) {
		this.totalesDetalle = totalesDetalle;
	}

	/**
	 * Obtiene un arbolito
	 * 
	 * @return arbolito
	 */
	public Arbolito getArbolito() {
		try {
			if (this.arbolito == null) {
				this.arbolito = new Arbolito();
			}

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return arbolito;
	}

	/**
	 * Establece un arbolito
	 * 
	 * @param arbolito
	 */
	public void setArbolito(Arbolito arbolito) {
		this.arbolito = arbolito;
	}

	/**
	 * Obtiene los tems de los arbolitos, todos activos e inactivos para consulta
	 * 
	 * @return itemsArbolitos
	 */
	public List<SelectItem> getItemsArbolitos() {

		try {
			if (this.itemsArbolitos == null) {
				this.itemsArbolitos = new ArrayList<SelectItem>();
				this.itemsArbolitos.add(new SelectItem("", this.getMensaje("comboVacio")));

				Arbolito arbol = new Arbolito();
				List<Arbolito> arbolitosActivos = IConsultasDAO.getArbolitos(arbol);

				if (arbolitosActivos != null && arbolitosActivos.size() > 0) {
					arbolitosActivos.forEach(p -> this.itemsArbolitos.add(new SelectItem(p.getId(), p.getNombre())));
				}

			}
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return itemsArbolitos;
	}

	/**
	 * Establece items de arbolitos activos
	 * 
	 * @param itemsArbolitos
	 */
	public void setItemsArbolitos(List<SelectItem> itemsArbolitos) {
		this.itemsArbolitos = itemsArbolitos;
	}

	/**
	 * Obtiene un listado de arbolitos históricos
	 * 
	 * @return historicos
	 */
	public List<HistoricoArbolitoVendido> getHistoricos() {
		return historicos;
	}

	public void setHistoricos(List<HistoricoArbolitoVendido> historicos) {
		this.historicos = historicos;
	}

}
