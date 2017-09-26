package fundacionFRC.modulos.arbolitos;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;

import org.primefaces.context.RequestContext;
import org.primefaces.event.TabChangeEvent;

import fundacionFRC.Conexion;
import fundacionFRC.beans.Arbolito;
import fundacionFRC.beans.Bolsa;
import fundacionFRC.beans.Comprador;
import fundacionFRC.beans.DetalleArbolitoVendido;
import fundacionFRC.beans.Estado;
import fundacionFRC.beans.FotoArbolito;
import fundacionFRC.beans.HistoricoArbolitoVendido;
import fundacionFRC.beans.HistoricoEstado;
import fundacionFRC.beans.Lote;
import fundacionFRC.beans.Personal;
import fundacionFRC.beans.Tarjeta;
import fundacionFRC.beans.Venta;
import fundacionFRC.generales.ConsultarFuncionesAPI;
import fundacionFRC.generales.IConstantes;
import fundacionFRC.generales.IEmail;
import fundacionFRC.modulos.IConsultasDAO;
import fundacionFRC.modulos.personal.AdministrarPersonal;

@ManagedBean
@SessionScoped
public class AdministrarSesionCliente extends ConsultarFuncionesAPI implements Serializable {

	/**
	 * 
	 */
	private static final long								serialVersionUID	= -3601661232170970958L;

	private String													moneda;
	private String													idioma;
	private Integer													vistaActual;
	private Integer													vistaLogueado;
	private String													vistaDetalleResumido;
	private String													vistaNuevaCuenta;
	private String													tipoPersonalizacion;
	private String													algoritmoTarjeta;

	private String													claveCambio;
	private String													claveCambioRepite;

	private Comprador												compradorSesion;
	private Comprador												compradorAcceso;

	private Personal												administrador;
	private Personal												administradorSesion;

	private Arbolito												arbolitoTransaccion;
	private HistoricoArbolitoVendido				arbolitoPersonalizado;
	private HistoricoArbolitoVendido				historicoPapa;
	private HistoricoArbolitoVendido				historicoTransaccion;
	private Venta														ventaTransaccion;

	private List<Arbolito>									arbolitosActivos;
	private List<Arbolito>									arbolitosCarrito;
	private List<Bolsa>											bolsasActivas;
	private List<HistoricoArbolitoVendido>	arbolitosPersonalizados;
	private List<HistoricoArbolitoVendido>	historicosComprador;
	private List<HistoricoArbolitoVendido>	historicosBolsas;
	private List<HistoricoArbolitoVendido>	historicosRecibidos;
	private List<HistoricoArbolitoVendido>	historicosRegalados;
	private List<HistoricoArbolitoVendido>	historicosHijos;
	private List<DetalleArbolitoVendido>		detallesVentas;
	private List<Venta>											ventasActivas;
	private List<Venta>											ventasPendientes;

	private Map<String, Object>							totales;
	private Map<String, Integer>						resumenPersonalizacion;

	private Locale													locale;

	@PostConstruct
	public void init() {

		// if (this.idioma != null &&
		// this.idioma.equals(IConstantes.IDIOMA_ESPANOL)) {
		//
		// } else if (this.idioma == null) {
		//
		// } else {
		//
		// }
		// obtiene el local actual
		locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
	}

	// privados

	/**
	 * Arma los parámetros para pagos
	 * 
	 * @return parametros
	 */
	private String getValoresPago(Venta aVenta) {

		String parametros = "";

		SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat hora = new SimpleDateFormat("HH:mm:ss");

		parametros += "<input type='hidden' name='profile_id' value='1C8C6927-F903-4EF2-8031-1417555BF83A' />";
		parametros += "<input type='hidden' name='reference_number' value='barrigon" + aVenta.getId() + "' />"; // 8899665544

		parametros += "<input type='hidden' name='amount'	value='" + aVenta.getValorTotalConIva() + "' />";

		parametros += "<input type='hidden' name='merchant_defined_data6' value='" + aVenta.getValorTotalVenta() + "' />";
		parametros += "<input type='hidden' name='merchant_defined_data5' value='" + aVenta.getValorTotalIva() + "' /> ";

		if (aVenta != null && aVenta.getMoneda().equals(IConstantes.PESO_COLOMBIANO)) {
			parametros += "<input	type='hidden' name='currency' value='COP' />";
		} else {
			parametros += "<input	type='hidden' name='currency' value='USD' />";
		}

		if (aVenta != null && aVenta.getIdiomaTransaccion() != null && aVenta.getIdiomaTransaccion().equals(IConstantes.IDIOMA_ESPANOL)) {
			parametros += "<input type='hidden' name='locale' value='en-US' />";
		} else {
			parametros += "<input type='hidden' name='locale' value='en-US' />";
		}

		parametros += "<input type='hidden' name='transaction_uuid'	value='fcfc212e92d23be881d1299ef3c3b314' />";

		parametros += "<input type='hidden'	name='signed_date_time' value='" + fecha.format(new Date()) + "T" + hora.format(new Date()) + "Z' />";

		parametros += "<input	type='hidden' name='signed_field_names'	value='comma separated list of signed fields' /> ";

		parametros += "<input	type='hidden' name='unsigned_field_names' value='comma separated list of unsigned fields' />";

		parametros += "<input type='hidden' name='signature' value='d37871d56b2a3487a4401a27f54e8728' />";

		parametros += "<input type='hidden'	name='bill_to_email' value='" + this.compradorSesion.getCorreoElectronico() + "' />";

		// parametros += "<input type='hidden' name='backoffice_post_url'
		// value='https://barrigones.fundacionfrc.com/arbolitosFRC/arbolitos/adopcionCliente/administrarCuenta.jsf'
		// />";

		// parametros += "<input type='hidden' name='custom_cancel_page'
		// value='https://barrigones.fundacionfrc.com/arbolitosFRC/index.jsf' />";

		return parametros;

	}

	/**
	 * Obtiene el idioma de la transacción
	 * 
	 * @param aReferencia
	 * @return idioma
	 */
	public String getIdiomaVenta(String aReferencia) {
		String idioma = IConstantes.IDIOMA_ESPANOL;
		Conexion conexion = new Conexion();
		try {

			conexion.setAutoCommitBD(false);
			Venta venta = new Venta();
			venta.setEstadoTransaccion(IConstantes.TRANSACCION_PENDIENTE);
			venta.setId(Integer.parseInt(aReferencia));
			List<Venta> ventas = IConsultasDAO.getVentas(venta);
			if (ventas != null && ventas.size() > 0) {
				idioma = ventas.get(0).getIdiomaTransaccion();
			}

		} catch (Exception e) {
			conexion.rollbackBD();
			this.mostrarMensajeGlobal("transaccionFallida", "error");

		} finally {
			conexion.cerrarConexion();
		}

		return idioma;

	}

	/**
	 * Aprueba de manera silecionsa los registros de la venta
	 * 
	 * @param aReferencia
	 * @param aTransaccion
	 * @param aEstado
	 */
	public void aprobarVentaSileciosa(String aReferencia, String aTransaccion, String aEstado) {

		Conexion conexion = new Conexion();
		AdministrarSesionCliente admin = new AdministrarSesionCliente();
		List<String> listaCorreos = new ArrayList<String>();
		try {

			conexion.setAutoCommitBD(false);
			Venta venta = new Venta();
			venta.setEstadoTransaccion(IConstantes.TRANSACCION_PENDIENTE);
			venta.setId(Integer.parseInt(aReferencia));
			List<Venta> ventas = IConsultasDAO.getVentas(venta);
			if (ventas != null && ventas.size() > 0) {

				DetalleArbolitoVendido detalleTemp = new DetalleArbolitoVendido();
				detalleTemp.setVenta(ventas.get(0));
				List<DetalleArbolitoVendido> detallesVentas = IConsultasDAO.getDetalleVentas(detalleTemp);

				if (detallesVentas != null && detallesVentas.size() > 0) {
					for (DetalleArbolitoVendido detalle : detallesVentas) {

						// actualiza inventario de cantidades arbolito
						if (detalle != null && detalle.getNumeroArbolesBolsa() != null) {
							admin.actualizarCantidadesArbolitos(conexion, detalle.getArbolito(), "cantidad_pendiente_pago", detalle.getNumeroArbolesBolsa(), "-");
							admin.actualizarCantidadesArbolitos(conexion, detalle.getArbolito(), "cantidad_vendida", detalle.getNumeroArbolesBolsa(), "+");
						} else {
							admin.actualizarCantidadesArbolitos(conexion, detalle.getArbolito(), "cantidad_pendiente_pago", detalle.getCantidadArbolitos(), "-");
							admin.actualizarCantidadesArbolitos(conexion, detalle.getArbolito(), "cantidad_vendida", detalle.getCantidadArbolitos(), "+");
						}

					}

					ventas.get(0).setEstadoTransaccion(IConstantes.TRANSACCION_APROBADA);
					ventas.get(0).setFechaTransaccion(new Date());// se actualiza la fecha
																												// en q fue aprobada
					ventas.get(0).setIdTransaccion(aTransaccion);
					ventas.get(0).getCamposBD();

					List<String> excluidos = new ArrayList<String>();
					excluidos.add("idioma_transaccion");
					excluidos.add("id_tarjeta");

					conexion.actualizarBD(ventas.get(0).getEstructuraTabla().getTabla(), ventas.get(0).getEstructuraTabla().getPersistencia(), ventas.get(0).getEstructuraTabla().getLlavePrimaria(), excluidos);
					conexion.commitBD();

					// correo al comprador

					if (ventas.get(0).getIdiomaTransaccion() != null && ventas.get(0).getIdiomaTransaccion().equals(IConstantes.IDIOMA_ESPANOL)) {

						IEmail.enviarCorreo(IConstantes.APROBACION_PARTICULAR_ES + ventas.get(0).getComprador().getNombreCompleto() + IConstantes.APROBACION_PARTICULAR_ES2, IConstantes.ASUNTO_APROBACION_ES, ventas.get(0).getComprador().getCorreoElectronico().trim());

					} else {

						IEmail.enviarCorreo(IConstantes.APROBACION_PARTICULAR_US + ventas.get(0).getComprador().getNombreCompleto() + IConstantes.APROBACION_PARTICULAR_US2, IConstantes.ASUNTO_APROBACION_US, ventas.get(0).getComprador().getCorreoElectronico().trim());

					}

					// correo a los agasajados
					HistoricoArbolitoVendido temp = new HistoricoArbolitoVendido();
					temp.getVenta().setId(ventas.get(0).getId());
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
						if (ventas.get(0).getIdiomaTransaccion() != null && ventas.get(0).getIdiomaTransaccion().equals(IConstantes.IDIOMA_ESPANOL)) {

							IEmail.enviarCorreoMasivo(IConstantes.MENSAJE_CORREO_REGALO_ES + ventas.get(0).getComprador().getNombreCompleto() + IConstantes.MENSAJE_CORREO_REGALO_ES2, IConstantes.ASUNTO_REGALO_ES, listaCorreos);

						} else {
							IEmail.enviarCorreoMasivo(IConstantes.MENSAJE_CORREO_REGALO_US + ventas.get(0).getComprador().getNombreCompleto() + IConstantes.MENSAJE_CORREO_REGALO_US2, IConstantes.ASUNTO_REGALO_US, listaCorreos);

						}
					}

				}
			}

		} catch (Exception e) {
			conexion.rollbackBD();

		} finally {
			conexion.cerrarConexion();
		}

	}

	/**
	 * Guarda la imagen en disco para luego ser leída
	 * 
	 * @param aNombre
	 * @param aSartaBase64
	 */
	public void guardarImagenEnDisco(Integer aIdFoto, String aSartaBase64) {

		try {
			File outputfile = new File(this.getPath(IConstantes.PAQUETE_IMAGENES) + "/arbolitosApp/arbolito" + aIdFoto + ".png");
			if (!outputfile.exists()) {
				byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(aSartaBase64);
				BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageBytes));
				ImageIO.write(img, "png", outputfile);
			}

		} catch (Exception e) {
			IConstantes.log.error(e, e);

		}

	}

	/**
	 * Redime la tarjeta y registra el comprador
	 */
	public void redimirTarjeta() {
		Conexion conexion = new Conexion();
		List<Tarjeta> tarjetasAlgoritmo = null;
		Venta venta = new Venta();

		try {

			Tarjeta tarjeta = new Tarjeta();
			tarjeta.setAlgoritmo(this.algoritmoTarjeta);
			tarjeta.setUsada(IConstantes.NEGACION);
			tarjetasAlgoritmo = IConsultasDAO.getTarjetas(conexion, tarjeta);
			if (tarjetasAlgoritmo != null && tarjetasAlgoritmo.size() == 1) {

				conexion.setAutoCommitBD(false);
				for (Tarjeta t : tarjetasAlgoritmo) {
					t.setUsada(IConstantes.AFIRMACION);
					t.getCamposBD();
					conexion.actualizarBD(t.getEstructuraTabla().getTabla(), t.getEstructuraTabla().getPersistencia(), t.getEstructuraTabla().getLlavePrimaria(), null);

					Map<String, Object> llaveForanea = new HashMap<String, Object>();
					llaveForanea.put("id_tarjeta", t.getId());

					Map<String, Object> camposActualizar = new HashMap<String, Object>();
					camposActualizar.put("id_comprador", this.compradorSesion.getId());

					venta.getCamposBD();
					conexion.actualizarBD(venta.getEstructuraTabla().getTabla(), camposActualizar, llaveForanea, null);

				}

				conexion.commitBD();

				// correo al comprador
				IEmail.enviarCorreo(this.getMensaje("aprobacionParticular", this.compradorSesion.getNombreCompleto()), this.getMensaje("asuntoAprobacion"), this.compradorSesion.getCorreoElectronico().trim());

				this.mostrarMensajeGlobal("tarjetaRedimida", "exito");
				this.vistaLogueado = 0;
				this.algoritmoTarjeta = null;

			} else {

				this.mostrarMensajeGlobal("tarjetaNoValida", "exito");

			}

		} catch (Exception e) {
			conexion.rollbackBD();
			this.mostrarMensajeGlobal("transaccionFallida", "error");
		} finally {
			conexion.cerrarConexion();
		}

	}

	/**
	 * Obtiene validación de rol no admitido
	 * 
	 * @return pagina
	 */
	public String getNoRolAdmitido() {
		String pagina = null;
		if (this.administradorSesion != null && this.administradorSesion.getTipoAdministracion().trim().equals("V")) {
			pagina = IConstantes.PAGINA_HOME;

			this.mostrarMensajeGlobal("soloPosePrivlegiosVentas", "advertencia");
			// Guarda el mensaje antes de redireccionar y lo muestra
			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().getFlash().setKeepMessages(true);
		}
		return pagina;
	}

	/**
	 * Determina si un administrador esta en sesión y lo deja o no acceder
	 * 
	 * @return pagina
	 */
	public String getNologueoAdministrador() {
		String pagina = null;
		if (!(this.administradorSesion != null && this.administradorSesion.getId() != null)) {

			pagina = IConstantes.PAGINA_NO_LOGUEO;

			this.mostrarMensajeGlobal("noPoseePrivilegios", "advertencia");
			// Guarda el mensaje antes de redireccionar y lo muestra
			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().getFlash().setKeepMessages(true);

		}

		return pagina;
	}

	/**
	 * Valida que una página del cliente que esté logueado o no se pueda
	 * visualizar
	 * 
	 * @return pagina
	 */
	public String getNologueoCliente() {
		String pagina = null;
		if (!(this.compradorSesion != null && this.compradorSesion.getId() != null)) {

			pagina = IConstantes.PAGINA_NO_LOGUEO;

			this.mostrarMensajeGlobal("debeIngresarConLogin", "advertencia");
			// Guarda el mensaje antes de redireccionar y lo muestra
			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().getFlash().setKeepMessages(true);

		}

		return pagina;
	}

	/**
	 * Obtiene el destino modal combinación administrador y login normal
	 * 
	 * @param aDestino
	 */
	public void cerrarAbrirLoginAdministrador(String aDestino) {

		if (aDestino != null && aDestino.equals("LOGIN")) {
			this.cerrarModal("panelLogueoAdministrador");
			this.abrirModal("panelLogueoGeneral");
		} else {
			this.cerrarModal("panelLogueoGeneral");
			this.abrirModal("panelLogueoAdministrador");

		}

	}

	/**
	 * Este método se encarga de cerrar y abrir los respectivos modales
	 * 
	 * @param aDestino
	 */
	public void cerrarAbrirLoginRegistro(String aDestino) {

		if (aDestino != null && aDestino.equals("LOGIN")) {
			this.cerrarModal("panelRegistroGeneral");
			this.abrirModal("panelLogueoGeneral");
		} else {
			this.cerrarModal("panelLogueoGeneral");
			this.abrirModal("panelRegistroGeneral");

		}

	}

	/**
	 * Actualiza el lote de acuerdo al elegido
	 * 
	 * @param aConexion
	 * @param aLote
	 * @param aCampo
	 * @param aCantidad
	 * @throws Exception
	 */
	public void actualizarLote(Conexion aConexion, Lote aLote, String aCampo, Integer aCantidad) throws Exception {

		try {
			StringBuilder sql = new StringBuilder();

			sql.append("  UPDATE lotes ");
			if (aCampo.equals("cantidad_vendida")) {

				sql.append("  SET  " + aCampo + "=" + (aCantidad.intValue() + 1) + " WHERE id=" + aLote.getId());

			} else if (aCampo.equals("cantidad_disponible")) {

				sql.append("  SET  " + aCampo + "=" + (aCantidad.intValue() - 1) + " WHERE id=" + aLote.getId());

			} else if (aCampo.equals("minimo_cero")) {

				sql.append("  SET cantidad_disponible=0 WHERE id= " + aLote.getId());

			} else if (aCampo.equals("cantidad_disponible_suma")) {

				sql.append("  SET  cantidad_disponible =" + (aCantidad.intValue() + 1) + " WHERE id=" + aLote.getId());

			}

			if (aCampo.equals("minimo_cero")) {

				sql.append("  AND cantidad_disponible < 0");
			}

			boolean resultado = aConexion.ejecutarQueryBD(sql.toString());
			if (!resultado) {
				throw new Exception();
			}

		} catch (Exception e) {
			IConstantes.log.error(e, e);
			throw new Exception(e);
		}

	}

	/**
	 * Actualiza las cantidades de los arbolitos
	 */
	public void actualizarCantidadesArbolitos(Conexion aConexion, Arbolito aArbolito, String aCampo, Integer aCantidad, String aSignoOperacion) throws Exception {

		try {
			StringBuilder sql = new StringBuilder();

			sql.append("  UPDATE arbolitos ");
			if (aCampo.equals("cantidad_pendiente_pago")) {

				sql.append("  SET  " + aCampo + "=(SELECT MAX(" + aCampo + ")" + aSignoOperacion + "" + aCantidad + " FROM arbolitos WHERE id=" + aArbolito.getId() + ")");

			} else if (aCampo.equals("cantidad_disponible")) {

				sql.append("  SET  " + aCampo + "=(SELECT MAX(" + aCampo + ")" + aSignoOperacion + "" + aCantidad + " FROM arbolitos WHERE id=" + aArbolito.getId() + ")");

			} else if (aCampo.equals("minimo_cero")) {

				sql.append("  SET cantidad_disponible=0");

			} else if (aCampo.equals("cantidad_vendida")) {

				sql.append("  SET  " + aCampo + "=(SELECT MAX(" + aCampo + ")" + aSignoOperacion + "" + aCantidad + " FROM arbolitos WHERE id=" + aArbolito.getId() + ")");

			} else if (aCampo.equals("cantidad_usada_reemplazos")) {

				sql.append("  SET  " + aCampo + "=(SELECT MAX(" + aCampo + ")" + aSignoOperacion + "" + aCantidad + " FROM arbolitos WHERE id=" + aArbolito.getId() + ")");

			}

			sql.append("  WHERE id= " + aArbolito.getId());

			if (aCampo.equals("minimo_cero")) {

				sql.append("  AND cantidad_disponible < 0");
			}

			boolean resultado = aConexion.ejecutarQueryBD(sql.toString());
			if (!resultado) {
				throw new Exception();
			}

		} catch (Exception e) {
			IConstantes.log.error(e, e);
			throw new Exception(e);
		}

	}

	/**
	 * Determina si un comprador es válido
	 * 
	 * @return ok
	 */
	private boolean isValidoComprador() {
		boolean ok = false;
		if (this.compradorSesion.getTnumeroCorroborar() != null && this.compradorSesion.getTnumeroEscrito().trim() != null && this.compradorSesion.getTnumeroCorroborar().equals(this.compradorSesion.getTnumeroEscrito().trim())) {
			ok = true;
		} else {
			this.vistaNuevaCuenta = "CUENTA_APTA";
			this.mostrarMensajeGlobal("noCoincideCodigo", "advertencia");
		}

		return ok;

	}

	// publicos

	/**
	 * Este método cambia el idioma dl software de forma manual
	 */
	public void cambiarIdioma() {

		if (this.idioma != null && this.idioma.equals(IConstantes.IDIOMA_ESPANOL)) {

			locale = new Locale("es");
			FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);

			// FacesContext.getCurrentInstance().getViewRoot().setLocale(new
			// Locale("es"));

			this.mostrarMensajeGlobal("ahoraEspanol", "exito");
		} else {

			locale = new Locale("en");
			FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);

			// FacesContext.getCurrentInstance().getViewRoot().setLocale(new
			// Locale("en_us"));

			this.mostrarMensajeGlobal("ahoraIngles", "exito");

		}

		this.cerrarModal("panelCambiarIdioma");
	}

	/**
	 * Prepara la transacción para ser registrada en su fase inicial
	 * 
	 * @return pagina
	 */
	public String getRegistrarTransaccion() {
		String pagina = "";
		Venta venta = null;
		DetalleArbolitoVendido detalle = null;
		HistoricoArbolitoVendido historico = null;
		List<Estado> estadosIniciales = null;
		List<Lote> lotesConsultados = null;
		Conexion conexion = new Conexion();
		int cantidadFinal = 0;
		HistoricoEstado historicoEstado = null;
		String esBolsa = null;

		try {

			conexion.setAutoCommitBD(false);

			Estado estado = new Estado();
			estado.setEstadoInicial(IConstantes.AFIRMACION);
			estadosIniciales = IConsultasDAO.getEstados(estado);
			if (estadosIniciales != null && estadosIniciales.size() > 0) {

				// 1-registro de la venta
				venta = new Venta();
				venta.setComprador(this.compradorSesion);

				venta.setEstadoTransaccion(IConstantes.ESTADO_INICIAL_TRANSACCION);
				venta.setFechaTransaccion(new Date());
				venta.setHoraTransaccion(new Date());

				venta.setIdiomaTransaccion(this.idioma);
				venta.setMoneda(this.moneda);
				venta.setCantidadTotalVenta(((Integer) this.totales.get("cantidadCarrito")).intValue());

				if (venta.getMoneda().equals(IConstantes.PESO_COLOMBIANO)) {

					venta.setValorTotalVenta((BigDecimal) this.totales.get("precioPesosSinIva"));
					venta.setValorTotalIva((BigDecimal) this.totales.get("ivaPesos"));
					venta.setValorTotalConIva((BigDecimal) this.totales.get("precioPesosConIva"));
				} else {

					venta.setValorTotalVenta((BigDecimal) this.totales.get("precioUsSinIva"));
					venta.setValorTotalIva((BigDecimal) this.totales.get("ivaDolares"));
					venta.setValorTotalConIva((BigDecimal) this.totales.get("precioUsConIva"));

				}

				venta.setGananaciaConvenio(new BigDecimal(0));

				venta.getCamposBD();
				conexion.insertarBD(venta.getEstructuraTabla().getTabla(), venta.getEstructuraTabla().getPersistencia());

				venta.setId(conexion.getUltimoSerialTransaccion(venta.getEstructuraTabla().getTabla()));

				// 2-guarda los detalles de la venta
				for (Arbolito a : this.arbolitosCarrito) {

					detalle = new DetalleArbolitoVendido();
					detalle.setVenta(venta);
					detalle.setArbolito(a);

					detalle.setCantidadArbolitos(a.getTcantidadCarrito());

					if (a.getTBolsa() != null && a.getTBolsa().getId() != null) {
						detalle.setPorcentajeIvaAplicado(a.getTBolsa().getIva().getValorIva());
					} else {
						detalle.setPorcentajeIvaAplicado(a.getIva().getValorIva());
					}

					if (a.getTBolsa() != null && a.getTBolsa().getId() != null) {

						detalle.setNumeroArbolesBolsa(a.getTBolsa().getCantidadDisponible() * a.getTcantidadCarrito());
					} else {

						detalle.setNumeroArbolesBolsa(null);
					}

					if (venta.getMoneda().equals(IConstantes.PESO_COLOMBIANO)) {

						detalle.setValorTotal(a.getTPrecioTotalPesosSinIva());
						detalle.setValorIva(a.getTTotalIvaPesos());
						detalle.setValorTotalConIva(a.getTPrecioTotalPesosConIva());

					} else {

						detalle.setValorTotal(a.getTPrecioTotalUSSinIva());
						detalle.setValorIva(a.getTTotalIvaUS());
						detalle.setValorTotalConIva(a.getTPrecioTotalUSConIva());

					}

					detalle.getCamposBD();
					conexion.insertarBD(detalle.getEstructuraTabla().getTabla(), detalle.getEstructuraTabla().getPersistencia());

					// actualiza inventario de cantidades arbolito
					if (a.getTBolsa() != null && a.getTBolsa().getId() != null) {
						actualizarCantidadesArbolitos(conexion, a, "cantidad_pendiente_pago", a.getTBolsa().getCantidadDisponible() * detalle.getCantidadArbolitos(), "+");
						actualizarCantidadesArbolitos(conexion, a, "cantidad_disponible", a.getTBolsa().getCantidadDisponible() * detalle.getCantidadArbolitos(), "-");
					} else {

						actualizarCantidadesArbolitos(conexion, a, "cantidad_pendiente_pago", detalle.getCantidadArbolitos(), "+");
						actualizarCantidadesArbolitos(conexion, a, "cantidad_disponible", detalle.getCantidadArbolitos(), "-");

					}

					// valida mínimo cero
					actualizarCantidadesArbolitos(conexion, a, "minimo_cero", null, null);

				}

				// 3-guarda el histórico con sus personalizaciones
				if (this.tipoPersonalizacion != null && !this.tipoPersonalizacion.equals("L")) {

					// si hay arboles personalizados sólo son de arbolitos solos
					if (this.arbolitosPersonalizados != null && this.arbolitosPersonalizados.size() > 0) {

						// por clase de arbolitos
						for (HistoricoArbolitoVendido a : this.arbolitosPersonalizados) {

							if (this.tipoPersonalizacion.equals("U")) {
								cantidadFinal = 1;
							} else if (this.tipoPersonalizacion.equals("C")) {
								cantidadFinal = a.getArbolito().getTcantidadCarrito();
							}

							if (!this.tipoPersonalizacion.equals("T")) {
								for (int i = 1; i <= cantidadFinal; i++) {

									historico = new HistoricoArbolitoVendido();
									historico.setVenta(venta);

									historico.setArbolito(a.getArbolito());
									historico.setEstado(estadosIniciales.get(0)); // estado_inicial_traerlo
									historico.setHistoricoSuperior(null);// se_usa_para_reemplazos
									historico.setNombrePersonalizadoArbolito(a.getNombrePersonalizadoArbolito());
									historico.setMensajePlaca(a.getMensajePlaca());
									historico.setCorreoReceptorRegalo(a.getCorreoReceptorRegalo());
									historico.setIndicativoBolsa(IConstantes.NEGACION);

									lotesConsultados = IConsultasDAO.getLotesArbolesDisponibles(conexion, a.getArbolito());
									if (lotesConsultados != null && lotesConsultados.size() > 0) {

										historico.setLote(lotesConsultados.get(0));
										historico.setNumeroInterno((lotesConsultados.get(0).getCantidadVendida().intValue() + 1));
										actualizarLote(conexion, lotesConsultados.get(0), "cantidad_vendida", lotesConsultados.get(0).getCantidadVendida());

										if (lotesConsultados.get(0).getIndicativoInfinito().equals(IConstantes.NEGACION)) { // OJO
											actualizarLote(conexion, lotesConsultados.get(0), "cantidad_disponible", lotesConsultados.get(0).getCantidadDisponible());
											actualizarLote(conexion, lotesConsultados.get(0), "minimo_cero", null);
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

								}
							} else {

								for (Arbolito ar : this.arbolitosCarrito) {

									for (int i = 1; i <= ar.getTcantidadCarrito(); i++) {

										historico = new HistoricoArbolitoVendido();
										historico.setVenta(venta);
										historico.setArbolito(ar);
										historico.setEstado(estadosIniciales.get(0)); // estado_inicial_traerlo
										historico.setHistoricoSuperior(null);
										historico.setNombrePersonalizadoArbolito(a.getNombrePersonalizadoArbolito());
										historico.setMensajePlaca(a.getMensajePlaca());
										historico.setCorreoReceptorRegalo(a.getCorreoReceptorRegalo());
										historico.setIndicativoBolsa(IConstantes.NEGACION);
										lotesConsultados = IConsultasDAO.getLotesArbolesDisponibles(conexion, ar);
										if (lotesConsultados != null && lotesConsultados.size() > 0) {

											historico.setLote(lotesConsultados.get(0));
											historico.setNumeroInterno((lotesConsultados.get(0).getCantidadVendida().intValue() + 1));
											actualizarLote(conexion, lotesConsultados.get(0), "cantidad_vendida", lotesConsultados.get(0).getCantidadVendida());

											if (lotesConsultados.get(0).getIndicativoInfinito().equals(IConstantes.NEGACION)) { // OJO
												actualizarLote(conexion, lotesConsultados.get(0), "cantidad_disponible", lotesConsultados.get(0).getCantidadDisponible());
												actualizarLote(conexion, lotesConsultados.get(0), "minimo_cero", null);
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

									}

								}

							}

						}

					}

					// se deben guardar tambien los arbolitos que son de bolsas y que son
					// imposible de personalizar
					for (Arbolito a : this.arbolitosCarrito) {
						if (a.getTBolsa() != null && a.getTBolsa().getId() != null) {

							for (int i = 1; i <= (a.getTBolsa().getCantidadDisponible() * a.getTcantidadCarrito()); i++) {

								historico = new HistoricoArbolitoVendido();
								historico.setVenta(venta);
								historico.setArbolito(a);
								historico.setEstado(estadosIniciales.get(0)); // estado_inicial_traerlo
								historico.setHistoricoSuperior(null);
								historico.setNombrePersonalizadoArbolito(null);
								historico.setMensajePlaca(null);
								historico.setCorreoReceptorRegalo(null);
								historico.setIndicativoBolsa(IConstantes.AFIRMACION);

								lotesConsultados = IConsultasDAO.getLotesArbolesDisponibles(conexion, a);

								if (lotesConsultados != null && lotesConsultados.size() > 0) {

									historico.setLote(lotesConsultados.get(0));
									historico.setNumeroInterno((lotesConsultados.get(0).getCantidadVendida().intValue() + 1));
									actualizarLote(conexion, lotesConsultados.get(0), "cantidad_vendida", lotesConsultados.get(0).getCantidadVendida());

									if (lotesConsultados.get(0).getIndicativoInfinito().equals(IConstantes.NEGACION)) { // OJO
										actualizarLote(conexion, lotesConsultados.get(0), "cantidad_disponible", lotesConsultados.get(0).getCantidadDisponible());
										actualizarLote(conexion, lotesConsultados.get(0), "minimo_cero", null);
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

							}
						}
					}

				} else {

					for (Arbolito a : this.arbolitosCarrito) {
						if (a.getTBolsa() != null && a.getTBolsa().getId() != null) {
							cantidadFinal = a.getTBolsa().getCantidadDisponible() * a.getTcantidadCarrito();
							esBolsa = IConstantes.AFIRMACION;
						} else {
							esBolsa = IConstantes.NEGACION;
							cantidadFinal = a.getTcantidadCarrito();
						}
						for (int i = 1; i <= cantidadFinal; i++) {

							historico = new HistoricoArbolitoVendido();
							historico.setVenta(venta);
							historico.setArbolito(a);
							historico.setEstado(estadosIniciales.get(0)); // estado_inicial_traerlo
							historico.setHistoricoSuperior(null);
							historico.setNombrePersonalizadoArbolito(null);
							historico.setMensajePlaca(null);
							historico.setCorreoReceptorRegalo(null);
							historico.setIndicativoBolsa(esBolsa);

							lotesConsultados = IConsultasDAO.getLotesArbolesDisponibles(conexion, a);

							if (lotesConsultados != null && lotesConsultados.size() > 0) {

								historico.setLote(lotesConsultados.get(0));
								historico.setNumeroInterno((lotesConsultados.get(0).getCantidadVendida().intValue() + 1));
								actualizarLote(conexion, lotesConsultados.get(0), "cantidad_vendida", lotesConsultados.get(0).getCantidadVendida());

								if (lotesConsultados.get(0).getIndicativoInfinito().equals(IConstantes.NEGACION)) { // OJO
									actualizarLote(conexion, lotesConsultados.get(0), "cantidad_disponible", lotesConsultados.get(0).getCantidadDisponible());
									actualizarLote(conexion, lotesConsultados.get(0), "minimo_cero", null);
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

						}

					}

				}

				conexion.commitBD();

				this.mostrarMensajeGlobal("transaccionPreparada", "exito");

				this.abrirModal("pnlMostrarAntesPagar");

				// asigna los valores al formulario
				RequestContext.getCurrentInstance().execute("document.getElementById('payment_form').innerHTML=\"" + this.getValoresPago(venta) + "\"");

				// envía el formulario por POST

				this.arbolitosCarrito = new ArrayList<Arbolito>();
				this.vistaActual = 0;

				RequestContext.getCurrentInstance().execute("document.getElementById('payment_form').submit()");

				// pagina = IConstantes.PAGINA_DESPUES_TRANSACCION;

				// Guarda el mensaje antes de redireccionar y lo muestra
				// FacesContext context = FacesContext.getCurrentInstance();
				// context.getExternalContext().getFlash().setKeepMessages(true);

				// redireccionar
				// ExternalContext externalContext =
				// FacesContext.getCurrentInstance().getExternalContext();
				// externalContext.redirect("http://localhost:8080/arbolitosFRC/arbolitos/adopcionCliente/ePasarelaPagos.jsp");
				// externalContext.

				// // reseteo de variables
				// this.arbolito = null;
				// this.getArbolito();
				// this.arbolitos = null;
				// this.getArbolitos();

			} else {
				this.mostrarMensajeGlobal("transaccionesDesactivadas", "advertencia");
			}

		} catch (Exception e) {
			conexion.rollbackBD();
			this.mostrarMensajeGlobal("transaccionFallida", "error");
		} finally {
			conexion.cerrarConexion();
		}

		return pagina;
	}

	/**
	 * Cambia la personalización seleccionada y mouestra en pantalla ditintas
	 * opciones según lo escogido
	 */
	public void cambiarPersonalizacion() {

		HistoricoArbolitoVendido personalizado = null;

		if (this.arbolitosPersonalizados != null && this.arbolitosPersonalizados.size() > 0 && this.arbolitosPersonalizados.stream().anyMatch(p -> (p.getMensajePlaca() != null && !p.getMensajePlaca().trim().equals("")) || (p.getNombrePersonalizadoArbolito() != null && !p.getNombrePersonalizadoArbolito().trim().equals("")) || (p.getCorreoReceptorRegalo() != null && !p.getCorreoReceptorRegalo().trim().equals("")))) {
			this.mostrarMensajeGlobal("arbolesPersonalizadosBorrados", "advertencia");

			// Vista mayor a personalización
			if (this.vistaActual != null && this.vistaActual.intValue() > IConstantes.VISTA_PERSONALIZACION.intValue()) {
				this.vistaActual = IConstantes.VISTA_PERSONALIZACION.intValue();
			}

		}

		this.arbolitosPersonalizados = new ArrayList<HistoricoArbolitoVendido>();

		// PERSONALIZACIÓN
		if (this.tipoPersonalizacion != null && this.tipoPersonalizacion.equals("C")) {
			// por clase de arbolitos
			for (Arbolito a : arbolitosCarrito) {
				if (!(a.getTBolsa() != null && a.getTBolsa().getId() != null)) {
					personalizado = new HistoricoArbolitoVendido();
					personalizado.setArbolito(a);
					this.arbolitosPersonalizados.add(personalizado);
				}

			}
		} else if (this.tipoPersonalizacion != null && this.tipoPersonalizacion.equals("T")) {

			// para todos los arbolitos de forma

			if (isArbolitosSolos()) {
				personalizado = new HistoricoArbolitoVendido();
				this.arbolitosPersonalizados.add(personalizado);
			}

		} else if (this.tipoPersonalizacion != null && this.tipoPersonalizacion.equals("U")) {
			// uno por uno

			for (Arbolito a : this.arbolitosCarrito) {
				if (!(a.getTBolsa() != null && a.getTBolsa().getId() != null)) {
					for (int i = 1; i <= a.getTcantidadCarrito(); i++) {
						personalizado = new HistoricoArbolitoVendido();
						personalizado.setArbolito(a);
						this.arbolitosPersonalizados.add(personalizado);
					}
				}

			}

		}

	}

	/**
	 * Obtiene el número de árboles adoptados
	 * 
	 * @return numero
	 */
	public long getNumeroArbolesConBolsa() {
		long numero = 0;
		if (this.arbolitosCarrito != null && this.arbolitosCarrito.size() > 0) {
			for (Arbolito p : this.arbolitosCarrito) {
				if (p.getTBolsa() != null && p.getTBolsa().getId() != null) {
					numero += p.getTBolsa().getCantidadDisponible() * p.getTcantidadCarrito();
				}
			}

		}

		return numero;
	}

	/**
	 * Obtiene el número de bolsas
	 * 
	 * @return numero
	 */
	public long getNumeroBolsas() {
		long numero = 0;
		if (this.arbolitosCarrito != null && this.arbolitosCarrito.size() > 0) {
			numero = this.arbolitosCarrito.stream().filter(p -> p.getTBolsa() != null && p.getTBolsa().getId() != null).count();
		}
		return numero;
	}

	/**
	 * Obtiene el número de arbolitos que no poseen lote
	 * 
	 * @return numero
	 */
	public long getNumeroArbolitosSolos() {
		long numero = 0;
		if (this.arbolitosCarrito != null && this.arbolitosCarrito.size() > 0) {
			for (Arbolito p : this.arbolitosCarrito) {
				if (!(p.getTBolsa() != null && p.getTBolsa().getId() != null)) {
					numero += p.getTcantidadCarrito();
				}
			}

		}
		return numero;
	}

	/**
	 * Detremina si agregó solo arbolitos
	 * 
	 * @return ok
	 */
	public boolean isArbolitosSolos() {
		boolean ok = false;
		if (this.arbolitosCarrito != null && this.arbolitosCarrito.size() > 0 && this.arbolitosCarrito.stream().anyMatch(p -> !(p.getTBolsa() != null && p.getTBolsa().getId() != null))) {
			ok = true;
		}

		return ok;
	}

	/**
	 * Recuerda la clave de un comprador a acceder
	 */
	public void recordarClave() {

		try {

			List<Comprador> copradores = null;

			if (this.compradorAcceso != null && this.compradorAcceso.getCorreoElectronico() != null && !this.compradorAcceso.getCorreoElectronico().trim().equals("")) {

				// como solo se mira el correo se crea este objeto
				Comprador comprador = new Comprador();
				comprador.setCorreoElectronico(this.compradorAcceso.getCorreoElectronico());

				copradores = IConsultasDAO.getCompradores(comprador);

				if (copradores != null && copradores.size() > 0 && copradores.get(0) != null && copradores.get(0).getId() != null) {

					IEmail.enviarCorreo(this.getMensaje("recordarClave", copradores.get(0).getNombreCompleto(), copradores.get(0).getClave()), this.getMensaje("asuntoRecordarClave"), copradores.get(0).getCorreoElectronico());
					this.mostrarMensajeGlobal("correoRecuerdoEnviado", "exito");

				} else {

					this.mostrarMensajeGlobal("noCoincideCorreo", "advertencia");
				}

			} else {

				this.mostrarMensajeGlobal("noCorreoDigitado", "advertencia");
			}

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}

	}

	/**
	 * Crea el comprador desde la tarjeta de redención
	 */
	public String crearCompradorTarjeta() {
		String pagina = "";
		Conexion conexion = new Conexion();
		int serialComprador = 0;
		try {
			if (isValidoComprador()) {
				conexion.setAutoCommitBD(false);

				this.compradorSesion.getCamposBD();

				conexion.insertarBD(this.compradorSesion.getEstructuraTabla().getTabla(), this.compradorSesion.getEstructuraTabla().getPersistencia());

				serialComprador = conexion.getUltimoSerialTransaccion("compradores");
				conexion.commitBD();

				this.vistaNuevaCuenta = null;

				this.mostrarMensajeGlobalPersonalizado(this.getMensaje("nuevaCuentaCompradorExito"), "exito");

				// reseteo de variables
				this.compradorSesion.setId(serialComprador);
				this.vistaNuevaCuenta = null;
				this.compradorSesion.setTnumeroCorroborar(null);
				this.compradorSesion.setTnumeroEscrito(null);
				this.administradorSesion = null;

				IEmail.enviarCorreo(this.getMensaje("mensajeCuentaNuevaComprador", this.compradorSesion.getNombreCompleto(), this.compradorSesion.getCorreoElectronico(), this.compradorSesion.getClave()), this.getMensaje("asuntoNuevaCuenta"), this.compradorSesion.getCorreoElectronico());

				List<Comprador> compradores = IConsultasDAO.getCompradores(this.compradorSesion);
				if (compradores != null && compradores.size() > 0 && compradores.get(0) != null && compradores.get(0).getId() != null) {

					this.compradorSesion = compradores.get(0);
					this.mostrarMensajeGlobal("ingresoCorrectoComprador", "advertencia");
					this.compradorAcceso = null;

					this.administradorSesion = null;

					this.vistaLogueado = 2;// interfaz de reimir tarjeta

					pagina = IConstantes.PAGINA_DESPUES_TRANSACCION;

				}

			}

		} catch (Exception e) {
			conexion.rollbackBD();
			this.mostrarMensajeGlobal("transaccionFallida", "error");
		} finally {
			conexion.cerrarConexion();
		}
		return pagina;

	}

	/**
	 * Crea un nuevo comprador del software
	 */
	public void crearComprador() {

		Conexion conexion = new Conexion();
		int serialComprador = 0;
		try {
			if (isValidoComprador()) {
				conexion.setAutoCommitBD(false);

				this.compradorSesion.getCamposBD();

				conexion.insertarBD(this.compradorSesion.getEstructuraTabla().getTabla(), this.compradorSesion.getEstructuraTabla().getPersistencia());

				serialComprador = conexion.getUltimoSerialTransaccion("compradores");
				conexion.commitBD();

				this.vistaNuevaCuenta = null;

				this.mostrarMensajeGlobalPersonalizado(this.getMensaje("nuevaCuentaCompradorExito"), "exito");

				// reseteo de variables
				this.compradorSesion.setId(serialComprador);
				this.vistaNuevaCuenta = null;
				this.compradorSesion.setTnumeroCorroborar(null);
				this.compradorSesion.setTnumeroEscrito(null);
				this.administradorSesion = null;

				IEmail.enviarCorreo(this.getMensaje("mensajeCuentaNuevaComprador", this.compradorSesion.getNombreCompleto(), this.compradorSesion.getCorreoElectronico(), this.compradorSesion.getClave()), this.getMensaje("asuntoNuevaCuenta"), this.compradorSesion.getCorreoElectronico());

				List<Comprador> compradores = IConsultasDAO.getCompradores(this.compradorSesion);
				if (compradores != null && compradores.size() > 0 && compradores.get(0) != null && compradores.get(0).getId() != null) {

					this.compradorSesion = compradores.get(0);
					this.mostrarMensajeGlobal("ingresoCorrectoComprador", "advertencia");
					this.compradorAcceso = null;

					this.administradorSesion = null;

					// nuevo
					this.vistaLogueado = 0;

					this.cerrarModal("panelRegistroGeneral");

				}

			}

		} catch (Exception e) {
			conexion.rollbackBD();
			this.mostrarMensajeGlobal("transaccionFallida", "error");
		} finally {
			conexion.cerrarConexion();
		}

	}

	/**
	 * Sale de la cuenta a nivel global
	 */
	public void logoutCuenta() {
		usarOtraCuenta();
		if (this.vistaActual != null && this.vistaActual.intValue() > IConstantes.VISTA_lOGIN) {
			this.vistaActual = IConstantes.VISTA_lOGIN;
		}

		this.mostrarMensajeGlobal("cierreSesionCorrecto", "exito");

		this.cerrarModal("panelSalirCuenta");

	}

	/**
	 * usa otra cuenta para los arbolitos
	 */
	public void usarOtraCuenta() {
		this.compradorSesion = null;

		regresarCrearNueva();
	}

	/**
	 * Regresa a la opción de crear una nueva cuenta
	 */
	public void regresarCrearNueva() {

		this.vistaNuevaCuenta = null;
	}

	/**
	 * Envia el código al correo
	 */
	public void enviarCaptchaCriolla() {
		try {
			this.vistaNuevaCuenta = "CUENTA_APTA";

			// genera una clave y la envía al correo
			AdministrarPersonal ap = new AdministrarPersonal();
			this.compradorSesion.setTnumeroCorroborar(ap.getClaveAleatoria());

			IEmail.enviarCorreo(this.getMensaje("mensajeClaveVerificacion", this.compradorSesion.getNombreCompleto(), this.compradorSesion.getTnumeroCorroborar()), this.getMensaje("asuntoNumeroVerificar"), this.compradorSesion.getCorreoElectronico());

			this.mostrarMensajeGlobal("verifiqueCorreoNumero", "exito");

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}

	}

	/**
	 * Cierra la sesión del administrador
	 */
	public String getCerrarSesion() {
		String pagina = IConstantes.PAGINA_NO_LOGUEO;
		this.administradorSesion = null;

		this.vistaDetalleResumido = null;
		this.vistaLogueado = 0;

		this.mostrarMensajeGlobal("cierreSesionCorrecto", "exito");

		// Guarda el mensaje antes de redireccionar y lo muestra
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);

		return pagina;

	}

	/**
	 * Permite el acceso del administrador
	 */
	public String accederAdministrador() {
		String pagina = null;
		List<Personal> administradores = null;
		try {

			if (this.administrador != null && this.administrador.getCorreoElectronico() != null && !this.administrador.getCorreoElectronico().trim().equals("") && this.administrador.getClave() != null && !this.administrador.getClave().trim().equals("")) {
				this.administrador.setEstadoVigencia(IConstantes.ACTIVO);
				administradores = IConsultasDAO.getAdministradores(this.administrador);
				if (administradores != null && administradores.size() > 0 && administradores.get(0) != null && administradores.get(0).getId() != null) {

					this.administradorSesion = administradores.get(0);
					this.mostrarMensajeGlobal("ingresoCorrectoComprador", "advertencia");
					this.administrador = null;

					this.cerrarModal("panelLogueoAdministrador");

					this.compradorSesion = null;

					pagina = IConstantes.PAGINA_HOME;

					// Guarda el mensaje antes de redireccionar y lo muestra
					FacesContext context = FacesContext.getCurrentInstance();
					context.getExternalContext().getFlash().setKeepMessages(true);

				} else {
					this.mostrarMensajeGlobal("noCoincideCredenciales", "advertencia");
				}

			} else {

				this.mostrarMensajeGlobal("noCoincideCredenciales", "advertencia");

			}

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}

		return pagina;
	}

	/**
	 * Accede desde la interfaz de redimir tarjeta
	 */
	public String accederDesdeRedimirTarjeta() {
		String pagina = "";
		List<Comprador> compradores = null;
		try {

			if (this.compradorAcceso != null && this.compradorAcceso.getCorreoElectronico() != null && !this.compradorAcceso.getCorreoElectronico().trim().equals("") && this.compradorAcceso.getClave() != null && !this.compradorAcceso.getClave().trim().equals("")) {

				compradores = IConsultasDAO.getCompradores(this.compradorAcceso);
				if (compradores != null && compradores.size() > 0 && compradores.get(0) != null && compradores.get(0).getId() != null) {

					this.compradorSesion = compradores.get(0);
					this.mostrarMensajeGlobal("ingresoCorrectoComprador", "advertencia");
					this.compradorAcceso = null;

					this.cerrarModal("panelLogueoGeneral");

					this.administradorSesion = null;

					this.vistaLogueado = 2;// interfaz de reimir tarjeta

					pagina = IConstantes.PAGINA_DESPUES_TRANSACCION;

				} else {
					this.mostrarMensajeGlobal("noCoincideCredenciales", "advertencia");
				}

			} else {

				this.mostrarMensajeGlobal("noCoincideCredenciales", "advertencia");

			}

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}

		return pagina;
	}

	/**
	 * Verifica la nueva cuenta de un comprador desde logueo general
	 */
	public void accederCompradorGeneral() {
		List<Comprador> compradores = null;
		try {

			if (this.compradorAcceso != null && this.compradorAcceso.getCorreoElectronico() != null && !this.compradorAcceso.getCorreoElectronico().trim().equals("") && this.compradorAcceso.getClave() != null && !this.compradorAcceso.getClave().trim().equals("")) {

				compradores = IConsultasDAO.getCompradores(this.compradorAcceso);
				if (compradores != null && compradores.size() > 0 && compradores.get(0) != null && compradores.get(0).getId() != null) {

					this.compradorSesion = compradores.get(0);
					this.mostrarMensajeGlobal("ingresoCorrectoComprador", "advertencia");
					this.compradorAcceso = null;

					this.cerrarModal("panelLogueoGeneral");

					this.administradorSesion = null;
					// nuevo
					this.vistaLogueado = 0;

				} else {
					this.mostrarMensajeGlobal("noCoincideCredenciales", "advertencia");
				}

			} else {

				this.mostrarMensajeGlobal("noCoincideCredenciales", "advertencia");

			}

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
	}

	/**
	 * Verifica la nueva cuenta de un comprador
	 */
	public void accederComprador() {
		List<Comprador> compradores = null;
		try {

			if (this.compradorAcceso != null && this.compradorAcceso.getCorreoElectronico() != null && !this.compradorAcceso.getCorreoElectronico().trim().equals("") && this.compradorAcceso.getClave() != null && !this.compradorAcceso.getClave().trim().equals("")) {

				compradores = IConsultasDAO.getCompradores(this.compradorAcceso);
				if (compradores != null && compradores.size() > 0 && compradores.get(0) != null && compradores.get(0).getId() != null) {

					this.compradorSesion = compradores.get(0);
					this.mostrarMensajeGlobal("ingresoCorrectoComprador", "advertencia");
					this.compradorAcceso = null;

					this.administradorSesion = null;
					// nuevo
					this.vistaLogueado = 0;

				} else {
					this.mostrarMensajeGlobal("noCoincideCredenciales", "advertencia");
				}

			} else {

				this.mostrarMensajeGlobal("noCoincideCredenciales", "advertencia");

			}

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
	}

	/**
	 * Verifica la nueva cuenta de un comprador
	 */
	public void verificarCuentaComprador() {

		try {

			Comprador comprador = new Comprador();
			comprador.setCorreoElectronico(this.compradorSesion.getCorreoElectronico());

			List<Comprador> compradores = IConsultasDAO.getCompradores(comprador);
			if (compradores != null && compradores.size() > 0 && compradores.get(0) != null && compradores.get(0).getId() != null) {
				this.mostrarMensajeGlobal("cuentaYaExistente", "advertencia");
				this.vistaNuevaCuenta = null;

			} else {
				enviarCaptchaCriolla();
			}

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
	}

	/**
	 * Calcula el total por bolsa
	 * 
	 * @param aArbolito
	 */
	public void calcularTotalTipoBolsa(Arbolito aArbolito) {

		// precio sin iva = cantidad*precio_unitario_sin_iva
		aArbolito.setTPrecioTotalPesosSinIva(this.getValorRedondeado(aArbolito.getTBolsa().getPrecioVentaPesos().multiply(new BigDecimal(aArbolito.getTcantidadCarrito())), IConstantes.DECIMALES_REDONDEAR));
		aArbolito.setTPrecioTotalUSSinIva(this.getValorRedondeado(aArbolito.getTBolsa().getPrecioVentaUS().multiply(new BigDecimal(aArbolito.getTcantidadCarrito())), IConstantes.DECIMALES_REDONDEAR));

		// total precio: cantidad*precio_unitario_con_iva
		aArbolito.setTPrecioTotalPesosConIva(this.getValorRedondeado(aArbolito.getTBolsa().getPrecioVentaPesosConIva().multiply(new BigDecimal(aArbolito.getTcantidadCarrito())), IConstantes.DECIMALES_REDONDEAR));
		aArbolito.setTPrecioTotalUSConIva(this.getValorRedondeado(aArbolito.getTBolsa().getPrecioVentaUSConIva().multiply(new BigDecimal(aArbolito.getTcantidadCarrito())), IConstantes.DECIMALES_REDONDEAR));

		/// total_iva = cantidad*iva_unitario_tipo_producto
		aArbolito.setTTotalIvaPesos(this.getValorRedondeado(aArbolito.getTBolsa().getIvaPesos().multiply(new BigDecimal(aArbolito.getTcantidadCarrito())), IConstantes.DECIMALES_REDONDEAR));
		aArbolito.setTTotalIvaUS(this.getValorRedondeado(aArbolito.getTBolsa().getIvaUs().multiply(new BigDecimal(aArbolito.getTcantidadCarrito())), IConstantes.DECIMALES_REDONDEAR));

		cambiarPersonalizacion();
	}

	/**
	 * Calcula los totales de cada item por tipo
	 * 
	 * @param aArbolito
	 */
	public void calcularTotalTipo(Arbolito aArbolito) {

		// precio sin iva = cantidad*precio_unitario_sin_iva
		aArbolito.setTPrecioTotalPesosSinIva(this.getValorRedondeado(aArbolito.getPrecioVentaPesos().multiply(new BigDecimal(aArbolito.getTcantidadCarrito())), IConstantes.DECIMALES_REDONDEAR));
		aArbolito.setTPrecioTotalUSSinIva(this.getValorRedondeado(aArbolito.getPrecioVentaUS().multiply(new BigDecimal(aArbolito.getTcantidadCarrito())), IConstantes.DECIMALES_REDONDEAR));

		// total precio: cantidad*precio_unitario_con_iva
		aArbolito.setTPrecioTotalPesosConIva(this.getValorRedondeado(aArbolito.getPrecioVentaPesosConIva().multiply(new BigDecimal(aArbolito.getTcantidadCarrito())), IConstantes.DECIMALES_REDONDEAR));
		aArbolito.setTPrecioTotalUSConIva(this.getValorRedondeado(aArbolito.getPrecioVentaUSConIva().multiply(new BigDecimal(aArbolito.getTcantidadCarrito())), IConstantes.DECIMALES_REDONDEAR));

		/// total_iva = cantidad*iva_unitario_tipo_producto
		aArbolito.setTTotalIvaPesos(this.getValorRedondeado(aArbolito.getIvaPesos().multiply(new BigDecimal(aArbolito.getTcantidadCarrito())), IConstantes.DECIMALES_REDONDEAR));
		aArbolito.setTTotalIvaUS(this.getValorRedondeado(aArbolito.getIvaUs().multiply(new BigDecimal(aArbolito.getTcantidadCarrito())), IConstantes.DECIMALES_REDONDEAR));

		cambiarPersonalizacion();
	}

	/**
	 * Vacía todo el carrito de adopción
	 */
	public void vaciarCarrito() {

		try {
			this.arbolitosCarrito = null;
			this.mostrarMensajeGlobal("vacioExitosoCarrito", "exito");

			this.cerrarModal("panelVaciarArbolitoCarrito");

		} catch (Exception e) {

			this.mostrarMensajeGlobal("transaccionFallida", "error");
		}
	}

	/**
	 * Modifica arbolito a regalar en curso o sesion
	 */
	public void regalarArbolitoCurso() {
		try {

			if (!(this.arbolitoPersonalizado != null && this.arbolitoPersonalizado.getTregalarlo() != null && this.arbolitoPersonalizado.getTregalarlo().equals(IConstantes.AFIRMACION))) {
				this.arbolitoPersonalizado.setCorreoReceptorRegalo(null);
			}

			this.mostrarMensajeGlobal("correoAgasajadoExitoso", "exito");

			this.cerrarModal("panelRegalarAmigoArbolito");

		} catch (Exception e) {

			this.mostrarMensajeGlobal("transaccionFallida", "error");
		}
	}

	/**
	 * Personaliza el arbolito en transacción
	 */
	public void personalizarArbolito() {
		try {

			this.mostrarMensajeGlobal("personalizacionExitosa", "exito");

			this.cerrarModal("panelPersonalizacionArbolito");

		} catch (Exception e) {

			this.mostrarMensajeGlobal("transaccionFallida", "error");
		}
	}

	/**
	 * Elimina la venta de la cuenta actual
	 */
	public void eliminarVenta() {

		Conexion conexion = new Conexion();
		FotoArbolito fotoHistorico = null;

		try {

			conexion.setAutoCommitBD(false);
			HistoricoEstado historicoEstado = null;
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
						actualizarCantidadesArbolitos(conexion, a.getArbolito(), "cantidad_pendiente_pago", a.getNumeroArbolesBolsa(), "-");
						actualizarCantidadesArbolitos(conexion, a.getArbolito(), "cantidad_disponible", a.getNumeroArbolesBolsa(), "+");
					} else {
						actualizarCantidadesArbolitos(conexion, a.getArbolito(), "cantidad_pendiente_pago", a.getCantidadArbolitos(), "-");
						actualizarCantidadesArbolitos(conexion, a.getArbolito(), "cantidad_disponible", a.getCantidadArbolitos(), "+");

					}

					// valida mínimo cero
					actualizarCantidadesArbolitos(conexion, a.getArbolito(), "minimo_cero", null, null);

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

					// actualiza solo los de lote asignado
					if (h.getLote() != null && h.getLote().getIndicativoInfinito() != null && h.getLote().getIndicativoInfinito().equals(IConstantes.NEGACION)) {
						if (h.getLote().getCantidadDisponible() == null || (h.getLote().getCantidadDisponible() != null && h.getLote().getCantidadDisponible().intValue() < 0)) {
							h.getLote().setCantidadDisponible(0);
						}

						actualizarLote(conexion, h.getLote(), "cantidad_disponible_suma", h.getLote().getCantidadDisponible());
						actualizarLote(conexion, h.getLote(), "minimo_cero", null);
					}

					// borra las fotos asociadas
					fotoHistorico = new FotoArbolito();
					Map<String, Object> llaveForaneaFotoHistorico = new HashMap<String, Object>();
					llaveForaneaFotoHistorico.put("id_historico_arbolito", h.getId());
					fotoHistorico.getCamposBD();
					conexion.eliminarBD(fotoHistorico.getEstructuraTabla().getTabla(), llaveForaneaFotoHistorico);

					// borra los estados hsitoricos
					historicoEstado = new HistoricoEstado();
					Map<String, Object> llaveForaneaEstadoHistorico = new HashMap<String, Object>();
					llaveForaneaEstadoHistorico.put("id_historico", h.getId());
					historicoEstado.getCamposBD();
					conexion.eliminarBD(historicoEstado.getEstructuraTabla().getTabla(), llaveForaneaEstadoHistorico);

				}
			}

			// borra los hsitoricos
			historico.getCamposBD();
			Map<String, Object> llaveForaneahistorico = new HashMap<String, Object>();
			llaveForaneahistorico.put("id_venta", this.ventaTransaccion.getId());
			conexion.eliminarBD(historico.getEstructuraTabla().getTabla(), llaveForaneahistorico);

			this.ventaTransaccion.getCamposBD();
			conexion.eliminarBD(this.ventaTransaccion.getEstructuraTabla().getTabla(), this.ventaTransaccion.getEstructuraTabla().getLlavePrimaria());
			conexion.commitBD();

			this.mostrarMensajeGlobal("ventaEliminada", "exito");

			this.ventasActivas = null;
			this.getVentasActivas();

		} catch (Exception e) {
			conexion.rollbackBD();
			this.mostrarMensajeGlobal("transaccionFallida", "error");
			this.mostrarMensajeGlobal("eliminacionFallida", "error");

		} finally {
			conexion.cerrarConexion();
		}

	}

	/**
	 * Elimina un arbolito del carrito de compras
	 */
	public void eliminarArbolitoCarrito() {

		try {
			this.arbolitosCarrito.remove(this.arbolitoTransaccion);
			this.mostrarMensajeGlobal("eliminacionExitosaCarrito", "exito");

			this.cerrarModal("panelEliminacionArbolitoCarrito");

		} catch (Exception e) {

			this.mostrarMensajeGlobal("transaccionFallida", "error");
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

			}

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}

	}

	/**
	 * Obtiene el evento generado con el tab
	 * 
	 * @param event
	 */
	public void onTabChange(TabChangeEvent event) {

		if (event.getTab() != null && event.getTab().getId() != null && event.getTab().getId().equals("TARJETA_IMPRESA")) {
			this.vistaLogueado = 2;
		} else if (event.getTab() != null && event.getTab().getId() != null && event.getTab().getId().equals("MI_CUENTA")) {
			this.vistaLogueado = 3;
		} else if (event.getTab() != null && event.getTab().getId() != null && event.getTab().getId().equals("MIS_ARBOLITOS")) {
			this.vistaLogueado = 1;
			this.asignarArbolitoResumido(null, "HISTORICO_PAPA");

		} else {

			if (event.getTab() == null) {
				// bug q hace que se pifee el tab
				this.asignarArbolitoResumido(null, "HISTORICO_PAPA");

			} else {

				this.vistaLogueado = 0;

			}

		}

	}

	/**
	 * Abre un diálogo de personalización de arbolito desde interfaz resumida
	 * 
	 * @param aPersonalizado
	 * @param aVista
	 */
	public void asignarArbolitoHijo(HistoricoArbolitoVendido aPersonalizado, String aVista) {
		try {

			if (aVista != null && aVista.equals("PERSONALIZAR_ARBOLITO")) {
				this.historicoTransaccion = aPersonalizado;
				this.abrirModal("panelPersonalizacionArbolito");

			} else if (aVista != null && aVista.equals("REGALAR_ARBOLITO")) {
				this.historicoTransaccion = aPersonalizado;
				this.abrirModal("panelRegalarArbolito");

			} else if (aVista != null && aVista.equals("ESTADOS")) {
				this.historicoTransaccion = aPersonalizado;
				this.historicoTransaccion.settEstadosHistoricos(new ArrayList<HistoricoEstado>());

				HistoricoEstado estado = new HistoricoEstado();
				estado.getHistorico().setId(this.historicoTransaccion.getId());
				this.historicoTransaccion.settEstadosHistoricos(IConsultasDAO.getHistoricoEstados(estado));

				this.abrirModal("panelDetalleEstados");

			}

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}

	}

	/**
	 * Actualiza la clave del comprador
	 */
	public void actualizarClave() {
		Conexion conexion = new Conexion();

		try {

			if (this.claveCambio != null && this.claveCambioRepite != null && !this.claveCambio.trim().equals("") && this.claveCambioRepite.trim().equals(this.claveCambio.trim())) {

				conexion.setAutoCommitBD(false);

				Comprador comprador = new Comprador();
				comprador.setId(this.compradorSesion.getId());

				Map<String, Object> cambios = new HashMap<String, Object>();
				cambios.put("clave", this.claveCambio.trim());

				comprador.getCamposBD();

				conexion.actualizarBD(comprador.getEstructuraTabla().getTabla(), cambios, comprador.getEstructuraTabla().getLlavePrimaria(), null);
				conexion.commitBD();
				this.mostrarMensajeGlobal("claveActualizadaExitosamente", "exito");

				this.claveCambio = null;
				this.claveCambioRepite = null;

			} else {

				this.mostrarMensajeGlobal("noCoincideClave", "advertencia");
			}

		} catch (Exception e) {
			conexion.rollbackBD();
			this.mostrarMensajeGlobal("transaccionFallida", "error");
		} finally {
			conexion.cerrarConexion();
		}

	}

	/**
	 * Actualiza un arbolito, o lo personaliza mientras pueda
	 */
	public void actualizarPersonalizacion() {
		Conexion conexion = new Conexion();

		try {

			conexion.setAutoCommitBD(false);
			if (this.historicoTransaccion.getNombrePersonalizadoArbolito() != null && this.historicoTransaccion.getNombrePersonalizadoArbolito().trim().equals("")) {
				this.historicoTransaccion.setNombrePersonalizadoArbolito(null);
			}

			if (this.historicoTransaccion.getMensajePlaca() != null && this.historicoTransaccion.getMensajePlaca().trim().equals("")) {
				this.historicoTransaccion.setMensajePlaca(null);
			}

			this.historicoTransaccion.getCamposBD();

			conexion.actualizarBD(this.historicoTransaccion.getEstructuraTabla().getTabla(), this.historicoTransaccion.getEstructuraTabla().getPersistencia(), this.historicoTransaccion.getEstructuraTabla().getLlavePrimaria(), null);
			conexion.commitBD();
			this.mostrarMensajeGlobal("personalizacionExitosa", "exito");

			// se envía correo electrónico de la personalización
			if (!(this.historicoTransaccion.getNombrePersonalizadoArbolito() == null && this.historicoTransaccion.getMensajePlaca() == null)) {

				if (this.historicoTransaccion.getCorreoReceptorRegalo() != null && !this.historicoTransaccion.getCorreoReceptorRegalo().trim().equals("")) {
					IEmail.enviarCorreo(this.getMensaje("personalizacionRegalado", this.historicoTransaccion.getVenta().getComprador().getNombreCompleto()), this.getMensaje("asuntoPersonalizacion"), this.historicoTransaccion.getCorreoReceptorRegalo().trim());
				} else {
					IEmail.enviarCorreo(this.getMensaje("personalizacionParticularComprador", this.historicoTransaccion.getVenta().getComprador().getNombreCompleto()), this.getMensaje("asuntoPersonalizacion"), this.historicoTransaccion.getVenta().getComprador().getCorreoElectronico().trim());

				}
				this.mostrarMensajeGlobal("tambienCorreoPersonalizacion", "exito");
			}
			this.cerrarModal("panelPersonalizacionArbolito");

		} catch (Exception e) {
			conexion.rollbackBD();
			this.mostrarMensajeGlobal("transaccionFallida", "error");
		} finally {
			conexion.cerrarConexion();
		}

	}

	/**
	 * Regala un arbolito
	 */
	public void regalarArbolitoCuentaCliente() {
		Conexion conexion = new Conexion();

		try {

			conexion.setAutoCommitBD(false);

			this.historicoTransaccion.getCamposBD();

			conexion.actualizarBD(this.historicoTransaccion.getEstructuraTabla().getTabla(), this.historicoTransaccion.getEstructuraTabla().getPersistencia(), this.historicoTransaccion.getEstructuraTabla().getLlavePrimaria(), null);
			conexion.commitBD();
			this.mostrarMensajeGlobal("regaloExitosoCliente", "exito");

			// se envía correo electrónico de la personalización

			IEmail.enviarCorreo(this.getMensaje("mensajeCorreoRegalo", this.historicoTransaccion.getVenta().getComprador().getNombreCompleto()), this.getMensaje("asuntoRegalo"), this.historicoTransaccion.getCorreoReceptorRegalo().trim());

			this.mostrarMensajeGlobal("tambienCorreoRegalo", "exito");

			this.cerrarModal("panelRegalarArbolito");

		} catch (Exception e) {
			conexion.rollbackBD();
			this.mostrarMensajeGlobal("transaccionFallida", "error");
		} finally {
			conexion.cerrarConexion();
		}

	}

	/**
	 * Asigna arbolito resumido
	 * 
	 * @param aPersonalizado
	 * @param aVista
	 */
	public void asignarArbolitoResumido(HistoricoArbolitoVendido aHistorico, String aVista) {

		try {

			this.historicoPapa = aHistorico;
			this.vistaDetalleResumido = aVista;

			FotoArbolito foto = null;
			List<FotoArbolito> fotos = null;

			HistoricoArbolitoVendido historico = new HistoricoArbolitoVendido();

			this.historicosHijos = null;

			if (aVista != null && aVista.equals("HISTORICO_HIJOS")) {

				historico.getVenta().setEstadoTransaccion(IConstantes.TRANSACCION_APROBADA);
				historico.getVenta().getComprador().setId(this.compradorSesion.getId());
				historico.getArbolito().setId(this.historicoPapa.getArbolito().getId());
				historico.setTregalarlo(IConstantes.NEGACION);
				historico.setIndicativoBolsa(IConstantes.NEGACION);
				this.historicosHijos = IConsultasDAO.getHistoricoArbolito(historico);

			} else if (aVista != null && aVista.equals("HISTORICO_HIJOS_RECIBIDOS")) {

				// vuelvo y la convierto para mostrar en la interfaz
				this.vistaDetalleResumido = "HISTORICO_HIJOS";
				historico.getVenta().setEstadoTransaccion(IConstantes.TRANSACCION_APROBADA);
				historico.setCorreoReceptorRegalo(this.compradorSesion.getCorreoElectronico().trim());
				historico.getArbolito().setId(this.historicoPapa.getArbolito().getId());
				historico.setTregalarlo(IConstantes.AFIRMACION); // busca el si regalado

				this.historicosHijos = IConsultasDAO.getHistoricoArbolito(historico);

			}

			else {

				this.historicoPapa = null;
			}

			if (this.historicosHijos != null && this.historicosHijos.size() > 0) {
				for (HistoricoArbolitoVendido h : this.historicosHijos) {

					// fotos asociadas al arbolito
					h.settFotos(new ArrayList<FotoArbolito>());
					foto = new FotoArbolito();
					foto.getHistoricoArbolitoVendido().setId(h.getId());

					fotos = IConsultasDAO.getFotosArbolitos(foto);

					if (fotos != null && fotos.size() > 0) {
						h.settFotos(new ArrayList<FotoArbolito>());
						for (FotoArbolito f : fotos) {
							guardarImagenEnDisco(f.getId(), f.getFotoDecofificada());
							f.setFotoDecofificada("arbolito" + f.getId() + ".png");
							h.gettFotos().add(f);
						}
					}

					// en caso que no haya por historico busca las del lote
					if (!(fotos != null && fotos.size() > 0)) {
						if (h.getLote() != null && h.getLote().getId() != null) {
							foto = new FotoArbolito();
							foto.getLote().setId(h.getLote().getId());
							fotos = IConsultasDAO.getFotosArbolitos(foto);
							if (fotos != null && fotos.size() > 0) {
								h.settFotos(new ArrayList<FotoArbolito>());
								for (FotoArbolito f : fotos) {
									guardarImagenEnDisco(f.getId(), f.getFotoDecofificada());
									f.setFotoDecofificada("arbolito" + f.getId() + ".png");
									h.gettFotos().add(f);
								}
							}
						}
					}

					// en caso que no haya por lote busca por clase de arbolito
					if (!(fotos != null && fotos.size() > 0)) {

						foto = new FotoArbolito();
						foto.getArbolito().setId(h.getArbolito().getId());
						fotos = IConsultasDAO.getFotosArbolitos(foto);
						if (fotos != null && fotos.size() > 0) {
							h.settFotos(new ArrayList<FotoArbolito>());
							for (FotoArbolito f : fotos) {
								guardarImagenEnDisco(f.getId(), f.getFotoDecofificada());
								f.setFotoDecofificada("arbolito" + f.getId() + ".png");
								h.gettFotos().add(f);
							}
						}

					}

					// si definitavemente no hay seteamos nulo
					if (!(fotos != null && fotos.size() > 0)) {
						h.getArbolito().setTNombresFotos(null);
					}

				}

			}

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}

	}

	/**
	 * Abre un diálogo de personalización de arbolito
	 * 
	 * @param aPersonalizado
	 * @param aVista
	 */
	public void asignarArbolitoPersonalizacion(HistoricoArbolitoVendido aPersonalizado, String aVista) {

		try {

			this.arbolitoPersonalizado = aPersonalizado;
			if (this.arbolitoPersonalizado.getTregalarlo() == null || (this.arbolitoPersonalizado.getTregalarlo() != null && this.arbolitoPersonalizado.getTregalarlo().equals(IConstantes.NEGACION))) {
				this.arbolitoPersonalizado.setCorreoReceptorRegalo(null);
			}

			if (aVista != null && aVista.equals("PERSONALIZAR_ARBOLITO")) {

				this.abrirModal("panelPersonalizacionArbolito");

			} else if (aVista != null && aVista.equals("REGALAR_ARBOLITO")) {

				this.abrirModal("panelRegalarAmigoArbolito");

			}

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}

	}

	/**
	 * Asigna un arbolito para realizar una acción
	 * 
	 * @param aArbolito
	 * @param aVista
	 */
	public void asignarArbolitoCarrito(Arbolito aArbolito, String aVista) {

		try {

			this.arbolitoTransaccion = aArbolito;

			if (aVista != null && aVista.equals("ELIMINAR_ARBOL_CARRITO")) {

				this.abrirModal("panelEliminacionArbolitoCarrito");

			} else if (aVista != null && aVista.equals("VACIAR_CARRITO")) {

				this.abrirModal("panelVaciarArbolitoCarrito");

			}

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}

	}

	/**
	 * Cambia una moneda a otra
	 */
	public void cambiarMoneda() {
		if (this.moneda != null && this.moneda.equals(IConstantes.PESO_COLOMBIANO)) {
			this.mostrarMensajeGlobal("usaraCOP", "exito");
		} else {

			this.mostrarMensajeGlobal("usaraUS", "exito");

		}

		this.cerrarModal("panelCambiarMoneda");
	}

	/**
	 * Agrega al carrito de compras
	 */
	public void agregarCarrito(Arbolito aArbolito) {
		boolean existeSoloArbol = false;
		boolean existeComoBolsa = false;
		int numeroActualMismaClase = 0;

		if (this.arbolitosCarrito == null) {
			this.arbolitosCarrito = new ArrayList<Arbolito>();
		}
		if (this.arbolitosCarrito != null && this.arbolitosCarrito.size() > 0) {
			// si es una bolsa miro a ver si esa bolsa ya está
			if (aArbolito.getTBolsa() != null && aArbolito.getTBolsa().getId() != null) {

				for (Arbolito a : this.arbolitosCarrito) {
					if (a.getTBolsa() != null && a.getTBolsa().getId() != null && a.getTBolsa().getId().intValue() == aArbolito.getTBolsa().getId()) {
						if (a.getId().intValue() == aArbolito.getId().intValue()) {
							a.setTcantidadCarrito(a.getTcantidadCarrito().intValue() + aArbolito.getTcantidadCarrito().intValue());
							a.setTBolsa(new Bolsa());
							a.setTBolsa(aArbolito.getTBolsa());
							this.calcularTotalTipoBolsa(a);
							numeroActualMismaClase = a.getTcantidadCarrito();
							existeComoBolsa = true;
							aArbolito.setTcantidadCarrito(1);
							break;
						}

					}

				}

			} else {
				// si lo que agrego no es una bolsa pero el carrito tiene registros
				for (Arbolito a : this.arbolitosCarrito) {
					if (!(a.getTBolsa() != null && a.getTBolsa().getId() != null)) {
						if (a.getId().intValue() == aArbolito.getId().intValue()) {
							a.setTcantidadCarrito(a.getTcantidadCarrito().intValue() + aArbolito.getTcantidadCarrito().intValue());
							this.calcularTotalTipo(a);
							numeroActualMismaClase = a.getTcantidadCarrito();
							existeSoloArbol = true;
							aArbolito.setTcantidadCarrito(1);
							break;
						}

					}

				}
			}
		}

		// si no existe el arbolito solo y no es bolsa hay que agregarlo
		if (!existeSoloArbol && !(aArbolito.getTBolsa() != null && aArbolito.getTBolsa().getId() != null)) {
			aArbolito.setTcantidadCarrito(aArbolito.getTcantidadCarrito());
			this.calcularTotalTipo(aArbolito);
			numeroActualMismaClase = aArbolito.getTcantidadCarrito();
			this.arbolitosCarrito.add(aArbolito);

		}

		// si no existe como bolsa sola
		if (!existeComoBolsa && aArbolito.getTBolsa() != null && aArbolito.getTBolsa().getId() != null) {
			aArbolito.setTcantidadCarrito(aArbolito.getTcantidadCarrito());
			this.calcularTotalTipoBolsa(aArbolito);
			numeroActualMismaClase = aArbolito.getTcantidadCarrito();
			this.arbolitosCarrito.add(aArbolito);

		}

		// recalcula valores
		this.getArbolitosCarrito();

		if (aArbolito.getTBolsa() != null && aArbolito.getTBolsa().getId() != null) {
			this.mostrarMensajeGlobalPersonalizado(this.getMensaje("bolsaAgregada", "" + numeroActualMismaClase), "exito");
		} else {
			this.mostrarMensajeGlobalPersonalizado(this.getMensaje("arbolitoAgregado", "" + numeroActualMismaClase), "exito");
		}

		cambiarPersonalizacion();

	}

	// listas/estructuras
	/**
	 * Obtiene los arbolitos activos para venderlos u ofrecerlos al público
	 * 
	 * @return arbolitosActivos
	 */
	public List<Arbolito> getArbolitosActivos() {

		try {
			// por ahora para ver el cambio
			// if (this.arbolitosActivos == null) {
			List<FotoArbolito> fotos = null;
			Arbolito arbol = new Arbolito();
			arbol.setEstadoVigencia(IConstantes.ACTIVO);
			this.arbolitosActivos = IConsultasDAO.getArbolitos(arbol);

			if (this.arbolitosActivos != null && this.arbolitosActivos.size() > 0) {

				this.arbolitosActivos.forEach(p -> p.setTcantidadCarrito(IConstantes.ARBOLITO_POR_DONACION));

				for (Arbolito p : this.arbolitosActivos) {
					p.setTfotos(new ArrayList<FotoArbolito>());
					FotoArbolito foto = new FotoArbolito();
					foto.setArbolito(p);

					fotos = IConsultasDAO.getFotosArbolitos(foto);
					if (fotos != null && fotos.size() > 0) {
						p.setTNombresFotos(new ArrayList<String>());
						for (FotoArbolito f : fotos) {
							guardarImagenEnDisco(f.getId(), f.getFotoDecofificada());
							p.getTNombresFotos().add("arbolito" + f.getId() + ".png");
						}
					}

					p.setTcantidadCarrito(IConstantes.ARBOLITO_POR_DONACION);
				}

			}

			// }//***
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}

		return arbolitosActivos;
	}

	public void setArbolitosActivos(List<Arbolito> arbolitosActivos) {
		this.arbolitosActivos = arbolitosActivos;
	}

	/**
	 * Obtiene las bolsas activas
	 * 
	 * @return bolsasActivas
	 */
	public List<Bolsa> getBolsasActivas() {
		try {
			Bolsa bolsa = new Bolsa();
			bolsa.setEstadoVigencia(IConstantes.ACTIVO);
			this.bolsasActivas = IConsultasDAO.getBolsas(bolsa);
			if (this.bolsasActivas != null && this.bolsasActivas.size() > 0) {
				for (Bolsa b : this.bolsasActivas) {
					b.getArbolito().setTBolsa(new Bolsa());
					b.getArbolito().setTBolsa(b);
					b.getArbolito().setTcantidadCarrito(IConstantes.ARBOLITO_POR_DONACION);
				}
			}

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return bolsasActivas;
	}

	public void setBolsasActivas(List<Bolsa> bolsasActivas) {
		this.bolsasActivas = bolsasActivas;
	}

	/**
	 * Obtiene los arbolitos del carrito de compras que la persona ha elegido
	 * 
	 * @return arbolitosCarrito
	 */
	public List<Arbolito> getArbolitosCarrito() {
		if (this.arbolitosCarrito == null) {
			this.arbolitosCarrito = new ArrayList<Arbolito>();
		}

		return arbolitosCarrito;
	}

	public void setArbolitosCarrito(List<Arbolito> arbolitosCarrito) {
		this.arbolitosCarrito = arbolitosCarrito;
	}

	/**
	 * Obtiene la moneda por defecto a trabjar
	 * 
	 * @return moneda
	 */
	public String getMoneda() {
		if (this.moneda == null) {
			this.moneda = IConstantes.PESO_COLOMBIANO;
		}
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	/**
	 * Obtiene el idioma actual
	 * 
	 * @return idioma
	 */
	public String getIdioma() {
		if (this.idioma == null) {
			this.idioma = IConstantes.IDIOMA_ESPANOL;
		}
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public Integer getVistaActual() {
		if (this.vistaActual == null) {
			this.vistaActual = 0;
		}
		return vistaActual;
	}

	public void setVistaActual(Integer vistaActual) {
		this.vistaActual = vistaActual;
	}

	/**
	 * Obtiene los totales del carrito de compras
	 * 
	 * @return totales
	 */
	public Map<String, Object> getTotales() {
		this.totales = new HashMap<String, Object>();
		this.totales.put("cantidadCarrito", new Integer(0));
		this.totales.put("ivaDolares", new BigDecimal(0));
		this.totales.put("ivaPesos", new BigDecimal(0));
		this.totales.put("precioPesosSinIva", new BigDecimal(0));
		this.totales.put("precioUsSinIva", new BigDecimal(0));
		this.totales.put("precioPesosConIva", new BigDecimal(0));
		this.totales.put("precioUsConIva", new BigDecimal(0));

		if (this.arbolitosCarrito != null && this.arbolitosCarrito.size() > 0) {
			for (Arbolito a : this.arbolitosCarrito) {
				this.totales.put("cantidadCarrito", ((Integer) this.totales.get("cantidadCarrito")) + a.getTcantidadCarrito().intValue());
				this.totales.put("ivaDolares", this.getValorRedondeado(((BigDecimal) this.totales.get("ivaDolares")).add(a.getTTotalIvaUS()), IConstantes.DECIMALES_REDONDEAR));
				this.totales.put("ivaPesos", this.getValorRedondeado(((BigDecimal) this.totales.get("ivaPesos")).add(a.getTTotalIvaPesos()), IConstantes.DECIMALES_REDONDEAR));
				this.totales.put("precioPesosSinIva", this.getValorRedondeado(((BigDecimal) this.totales.get("precioPesosSinIva")).add(a.getTPrecioTotalPesosSinIva()), IConstantes.DECIMALES_REDONDEAR));
				this.totales.put("precioUsSinIva", this.getValorRedondeado(((BigDecimal) this.totales.get("precioUsSinIva")).add(a.getTPrecioTotalUSSinIva()), IConstantes.DECIMALES_REDONDEAR));
				this.totales.put("precioPesosConIva", this.getValorRedondeado(((BigDecimal) this.totales.get("precioPesosConIva")).add(a.getTPrecioTotalPesosConIva()), IConstantes.DECIMALES_REDONDEAR));
				this.totales.put("precioUsConIva", this.getValorRedondeado(((BigDecimal) this.totales.get("precioUsConIva")).add(a.getTPrecioTotalUSConIva()), IConstantes.DECIMALES_REDONDEAR));

			}
		}
		return totales;
	}

	public void setTotales(Map<String, Object> totales) {
		this.totales = totales;
	}

	/**
	 * Obtiene datos del comprador actual
	 * 
	 * @return compradorSesion
	 */
	public Comprador getCompradorSesion() {
		if (this.compradorSesion == null) {
			this.compradorSesion = new Comprador();
		}
		return compradorSesion;
	}

	/**
	 * Establece los datos del comprador actual
	 * 
	 * @param compradorSesion
	 */
	public void setCompradorSesion(Comprador compradorSesion) {
		this.compradorSesion = compradorSesion;
	}

	/**
	 * Verifica la vista de crear una nueva cuenta
	 * 
	 * @return vistaNuevaCuenta
	 */
	public String getVistaNuevaCuenta() {
		return vistaNuevaCuenta;
	}

	public void setVistaNuevaCuenta(String vistaNuevaCuenta) {
		this.vistaNuevaCuenta = vistaNuevaCuenta;
	}

	/**
	 * Obtiene el tipo de personalización deseada
	 * 
	 * @return tipoPersonalizacion
	 */
	public String getTipoPersonalizacion() {
		return tipoPersonalizacion;
	}

	/**
	 * Establece el tipo de personalización deseada
	 * 
	 * @param tipoPersonalizacion
	 */
	public void setTipoPersonalizacion(String tipoPersonalizacion) {
		this.tipoPersonalizacion = tipoPersonalizacion;
	}

	/**
	 * Obtiene el arbolito en transaccion a usar
	 * 
	 * @return arbolitoTransaccion
	 */
	public Arbolito getArbolitoTransaccion() {
		return arbolitoTransaccion;
	}

	public void setArbolitoTransaccion(Arbolito arbolitoTransaccion) {
		this.arbolitoTransaccion = arbolitoTransaccion;
	}

	/**
	 * Obtiene el objeto hsitorico papá seleccionado
	 * 
	 * @return historicoPapa
	 */
	public HistoricoArbolitoVendido getHistoricoPapa() {
		if (this.historicoPapa == null) {
			this.historicoPapa = new HistoricoArbolitoVendido();
		}
		return historicoPapa;
	}

	/**
	 * Establece el histórico seleccionado papá
	 * 
	 * @param historicoPapa
	 */
	public void setHistoricoPapa(HistoricoArbolitoVendido historicoPapa) {
		this.historicoPapa = historicoPapa;
	}

	/**
	 * Obtiene el acceso de un comprador
	 * 
	 * @return compradorAcceso
	 */
	public Comprador getCompradorAcceso() {
		if (this.compradorAcceso == null) {
			this.compradorAcceso = new Comprador();
		}
		return compradorAcceso;
	}

	/**
	 * Establece el acceso de un comprador
	 * 
	 * @param compradorAcceso
	 */
	public void setCompradorAcceso(Comprador compradorAcceso) {
		this.compradorAcceso = compradorAcceso;
	}

	/**
	 * Obtiene un arbolito personalizado
	 * 
	 * @return arbolitoPersonalizado
	 */
	public HistoricoArbolitoVendido getArbolitoPersonalizado() {
		if (this.arbolitoPersonalizado == null) {
			this.arbolitoPersonalizado = new HistoricoArbolitoVendido();
		}
		return arbolitoPersonalizado;
	}

	/**
	 * Establece un arbolito personalizado
	 * 
	 * @param arbolitoPersonalizado
	 */
	public void setArbolitoPersonalizado(HistoricoArbolitoVendido arbolitoPersonalizado) {
		this.arbolitoPersonalizado = arbolitoPersonalizado;
	}

	/**
	 * Obtiene un listado de los arbolitos personalizados
	 * 
	 * @return arbolitosPersonalizados
	 */
	public List<HistoricoArbolitoVendido> getArbolitosPersonalizados() {
		return arbolitosPersonalizados;
	}

	public void setArbolitosPersonalizados(List<HistoricoArbolitoVendido> arbolitosPersonalizados) {
		this.arbolitosPersonalizados = arbolitosPersonalizados;
	}

	/**
	 * Obtiene resumen de personalizaciones realizadas
	 * 
	 * @return resumenPersonalizacion
	 */
	public Map<String, Integer> getResumenPersonalizacion() {

		this.resumenPersonalizacion = new HashMap<String, Integer>();
		this.resumenPersonalizacion.put("arbolitosPersonalizados", 0);
		this.resumenPersonalizacion.put("arbolitosRegalados", 0);

		if (this.arbolitosPersonalizados != null && this.arbolitosPersonalizados.size() > 0) {
			this.arbolitosPersonalizados.forEach(p -> {

				if ((p.getMensajePlaca() != null && !p.getMensajePlaca().trim().equals("")) || (p.getNombrePersonalizadoArbolito() != null && !p.getNombrePersonalizadoArbolito().trim().equals(""))) {
					if (this.tipoPersonalizacion != null && this.tipoPersonalizacion.equals("C")) {
						this.resumenPersonalizacion.put("arbolitosPersonalizados", this.resumenPersonalizacion.get("arbolitosPersonalizados").intValue() + p.getArbolito().getTcantidadCarrito().intValue());
					} else if (this.tipoPersonalizacion != null && this.tipoPersonalizacion.equals("U")) {
						this.resumenPersonalizacion.put("arbolitosPersonalizados", this.resumenPersonalizacion.get("arbolitosPersonalizados").intValue() + 1);
					} else if (this.tipoPersonalizacion != null && this.tipoPersonalizacion.equals("T")) {
						this.resumenPersonalizacion.put("arbolitosPersonalizados", this.resumenPersonalizacion.get("arbolitosPersonalizados").intValue() + ((Integer) this.totales.get("cantidadCarrito")).intValue());
					} else {
						this.resumenPersonalizacion.put("arbolitosPersonalizados", 0);
					}
				}

				if ((p.getCorreoReceptorRegalo() != null && !p.getCorreoReceptorRegalo().trim().equals(""))) {
					if (this.tipoPersonalizacion != null && this.tipoPersonalizacion.equals("C")) {
						this.resumenPersonalizacion.put("arbolitosRegalados", this.resumenPersonalizacion.get("arbolitosRegalados").intValue() + p.getArbolito().getTcantidadCarrito().intValue());
					} else if (this.tipoPersonalizacion != null && this.tipoPersonalizacion.equals("U")) {
						this.resumenPersonalizacion.put("arbolitosRegalados", this.resumenPersonalizacion.get("arbolitosRegalados").intValue() + 1);
					} else if (this.tipoPersonalizacion != null && this.tipoPersonalizacion.equals("T")) {
						this.resumenPersonalizacion.put("arbolitosRegalados", this.resumenPersonalizacion.get("arbolitosRegalados").intValue() + ((Integer) this.totales.get("cantidadCarrito")).intValue());
					} else {
						this.resumenPersonalizacion.put("arbolitosRegalados", 0);
					}
				}

			});

		}

		return resumenPersonalizacion;
	}

	public void setResumenPersonalizacion(Map<String, Integer> resumenPersonalizacion) {
		this.resumenPersonalizacion = resumenPersonalizacion;
	}

	/**
	 * Obtiene las ventas activas del momento
	 * 
	 * @return ventasActivas
	 */
	public List<Venta> getVentasActivas() {
		try {

			Venta venta = new Venta();
			venta.getComprador().setId(this.compradorSesion.getId());
			// VAMOS A USAR TODAS
			// venta.setEstadoTransaccion(IConstantes.TRANSACCION_APROBADA);

			this.ventasActivas = IConsultasDAO.getVentas(venta);

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}

		return ventasActivas;
	}

	/**
	 * Establece las ventas activas
	 * 
	 * @param ventasActivas
	 */
	public void setVentasActivas(List<Venta> ventasActivas) {
		this.ventasActivas = ventasActivas;
	}

	/**
	 * Obtiene las ventas pendientes de aprobación
	 * 
	 * @return ventasPendientes
	 */
	public List<Venta> getVentasPendientes() {
		try {

			Venta venta = new Venta();
			venta.getComprador().setId(this.compradorSesion.getId());
			venta.setEstadoTransaccion(IConstantes.TRANSACCION_PENDIENTE);

			this.ventasPendientes = IConsultasDAO.getVentas(venta);

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return ventasPendientes;
	}

	/**
	 * Establece las vetas pendientes
	 * 
	 * @param ventasPendientes
	 */
	public void setVentasPendientes(List<Venta> ventasPendientes) {
		this.ventasPendientes = ventasPendientes;
	}

	/**
	 * Obtiene un objeto de venta
	 * 
	 * @return ventaTransaccion
	 */
	public Venta getVentaTransaccion() {
		try {
			if (this.ventaTransaccion == null) {
				this.ventaTransaccion = new Venta();
			}
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return ventaTransaccion;
	}

	/**
	 * Establece un objeto de venta
	 * 
	 * @param ventaTransaccion
	 */
	public void setVentaTransaccion(Venta ventaTransaccion) {
		this.ventaTransaccion = ventaTransaccion;
	}

	/**
	 * Obtiene una vista actual logueada
	 * 
	 * @return vistaLogueado
	 */
	public Integer getVistaLogueado() {
		if (this.vistaLogueado == null) {
			this.vistaLogueado = 0;
		}
		return vistaLogueado;
	}

	/**
	 * Establece vista actual logueada
	 * 
	 * @param vistaLogueado
	 */
	public void setVistaLogueado(Integer vistaLogueado) {
		this.vistaLogueado = vistaLogueado;
	}

	/**
	 * Obtiene el detalle resumido de un arbolito
	 * 
	 * @return vistaDetalleResumido
	 */
	public String getVistaDetalleResumido() {
		return vistaDetalleResumido;
	}

	/**
	 * Establece el detalle resumido de un arbolito
	 * 
	 * @param vistaDetalleResumido
	 */
	public void setVistaDetalleResumido(String vistaDetalleResumido) {
		this.vistaDetalleResumido = vistaDetalleResumido;
	}

	/**
	 * Obtiene el administrador del sistema
	 * 
	 * @return administrador
	 */
	public Personal getAdministrador() {
		if (this.administrador == null) {
			this.administrador = new Personal();
		}
		return administrador;
	}

	/**
	 * Establece el administrador
	 * 
	 * @param administrador
	 */
	public void setAdministrador(Personal administrador) {
		this.administrador = administrador;
	}

	/**
	 * Obtiene los datos de administrador de sesión
	 * 
	 * @return administradorSesion
	 */
	public Personal getAdministradorSesion() {
		return administradorSesion;
	}

	/**
	 * Establece los datos de administrador de sesión
	 * 
	 * @param administradorSesion
	 */
	public void setAdministradorSesion(Personal administradorSesion) {
		this.administradorSesion = administradorSesion;
	}

	/**
	 * Obtiene la clave a cambiar
	 * 
	 * @return claveCambio
	 */
	public String getClaveCambio() {
		return claveCambio;
	}

	/**
	 * Establece la clave a cambiar
	 * 
	 * @param claveCambio
	 */
	public void setClaveCambio(String claveCambio) {
		this.claveCambio = claveCambio;
	}

	/**
	 * Establece la clave a cambiar, la que se repite
	 * 
	 * @return claveCambioRepite
	 */
	public String getClaveCambioRepite() {
		return claveCambioRepite;
	}

	public void setClaveCambioRepite(String claveCambioRepite) {
		this.claveCambioRepite = claveCambioRepite;
	}

	/**
	 * Obtiene un listado de detalle de ventas
	 * 
	 * @return detallesVentas
	 */
	public List<DetalleArbolitoVendido> getDetallesVentas() {
		try {
			if (this.ventaTransaccion != null) {
				DetalleArbolitoVendido detalle = new DetalleArbolitoVendido();
				detalle.setVenta(this.ventaTransaccion);
				this.detallesVentas = IConsultasDAO.getDetalleVentas(detalle);

			}
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return detallesVentas;
	}

	/**
	 * Establece un listado de detalle de ventas
	 * 
	 * @param detallesVentas
	 */
	public void setDetallesVentas(List<DetalleArbolitoVendido> detallesVentas) {
		this.detallesVentas = detallesVentas;
	}

	/**
	 * Obtiene los historicos de un comprador
	 * 
	 * @return historicosComprador
	 */
	public List<HistoricoArbolitoVendido> getHistoricosComprador() {
		try {

			HistoricoArbolitoVendido historico = new HistoricoArbolitoVendido();
			historico.getVenta().setEstadoTransaccion(IConstantes.TRANSACCION_APROBADA);
			historico.getVenta().getComprador().setId(this.compradorSesion.getId());
			historico.setTregalarlo(IConstantes.NEGACION);
			historico.setIndicativoBolsa(IConstantes.NEGACION);

			this.historicosComprador = IConsultasDAO.getHistoricoResumidoUsuario(historico);

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return historicosComprador;
	}

	/**
	 * Establece los históricos de un comprador
	 * 
	 * @param historicosComprador
	 */
	public void setHistoricosComprador(List<HistoricoArbolitoVendido> historicosComprador) {
		this.historicosComprador = historicosComprador;
	}

	/**
	 * Obtiene los históricos adquiridos por medio de bolsas
	 * 
	 * @return historicosBolsas
	 */
	public List<HistoricoArbolitoVendido> getHistoricosBolsas() {
		try {

			HistoricoArbolitoVendido historico = new HistoricoArbolitoVendido();
			historico.getVenta().setEstadoTransaccion(IConstantes.TRANSACCION_APROBADA);
			historico.getVenta().getComprador().setId(this.compradorSesion.getId());

			historico.setIndicativoBolsa(IConstantes.AFIRMACION);

			this.historicosBolsas = IConsultasDAO.getHistoricoResumidoUsuario(historico);

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return historicosBolsas;
	}

	/**
	 * Establece los históricos adquiridos por medio de bolsas
	 * 
	 * @param historicosBolsas
	 */
	public void setHistoricosBolsas(List<HistoricoArbolitoVendido> historicosBolsas) {
		this.historicosBolsas = historicosBolsas;
	}

	/**
	 * Obtiene los historicos que ha recibido
	 * 
	 * @return historicosRecibidos
	 */
	public List<HistoricoArbolitoVendido> getHistoricosRecibidos() {
		try {

			HistoricoArbolitoVendido historico = new HistoricoArbolitoVendido();
			historico.getVenta().setEstadoTransaccion(IConstantes.TRANSACCION_APROBADA);
			historico.setCorreoReceptorRegalo(this.compradorSesion.getCorreoElectronico());

			// QUE EN REALIDAD ES QUE BUSQUE LOS DE CORREO
			historico.setTregalarlo(IConstantes.AFIRMACION);

			this.historicosRecibidos = IConsultasDAO.getHistoricoResumidoUsuario(historico);

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return historicosRecibidos;
	}

	public void setHistoricosRecibidos(List<HistoricoArbolitoVendido> historicosRecibidos) {
		this.historicosRecibidos = historicosRecibidos;
	}

	/**
	 * Obtiene los arbolitos hijos de acuerdo al resumido seleccionado
	 * 
	 * @return historicosHijos
	 */
	public List<HistoricoArbolitoVendido> getHistoricosHijos() {
		return historicosHijos;
	}

	/**
	 * Establece los arbolitos hijos
	 * 
	 * @param historicosHijos
	 */
	public void setHistoricosHijos(List<HistoricoArbolitoVendido> historicosHijos) {
		this.historicosHijos = historicosHijos;
	}

	/**
	 * Obtiene el arbolito en transacción seleccionado
	 * 
	 * @return historicoTransaccion
	 */
	public HistoricoArbolitoVendido getHistoricoTransaccion() {
		try {
			if (this.historicoTransaccion == null) {
				this.historicoTransaccion = new HistoricoArbolitoVendido();
			}
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return historicoTransaccion;
	}

	/**
	 * Establece el arbolito en transacción
	 * 
	 * @param historicoTransaccion
	 */
	public void setHistoricoTransaccion(HistoricoArbolitoVendido historicoTransaccion) {
		this.historicoTransaccion = historicoTransaccion;
	}

	/**
	 * Obtiene los arbolitos que haz regalado
	 * 
	 * @return historicosRegalados
	 */
	public List<HistoricoArbolitoVendido> getHistoricosRegalados() {
		try {

			HistoricoArbolitoVendido historico = new HistoricoArbolitoVendido();
			historico.getVenta().setEstadoTransaccion(IConstantes.TRANSACCION_APROBADA);
			historico.getVenta().getComprador().setId(this.compradorSesion.getId());

			// que afirmativamente se haya regalado
			historico.setTregalarlo(IConstantes.AFIRMACION);

			this.historicosRegalados = IConsultasDAO.getHistoricoArbolito(historico);

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return historicosRegalados;
	}

	/**
	 * Establece los arbolitos que haz regalado
	 * 
	 * @param historicosRegalados
	 */
	public void setHistoricosRegalados(List<HistoricoArbolitoVendido> historicosRegalados) {
		this.historicosRegalados = historicosRegalados;
	}

	/**
	 * Obtiene el algoritmo de una tarjeta prepagada
	 * 
	 * @return algoritmoTarjeta
	 */
	public String getAlgoritmoTarjeta() {
		return algoritmoTarjeta;
	}

	/**
	 * Establece el algoritmo de una tarjeta prepagada
	 * 
	 * @param algoritmoTarjeta
	 */
	public void setAlgoritmoTarjeta(String algoritmoTarjeta) {
		this.algoritmoTarjeta = algoritmoTarjeta;
	}

	/**
	 * Obtiene el idioma actual
	 * 
	 * @return locale
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * Establece el idiomaactual
	 * 
	 * @param locale
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

}
