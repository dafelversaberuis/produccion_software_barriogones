package fundacionFRC.modulos.arbolitos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import fundacionFRC.Conexion;
import fundacionFRC.beans.Arbolito;
import fundacionFRC.beans.Bolsa;
import fundacionFRC.beans.Estado;
import fundacionFRC.beans.FotoArbolito;
import fundacionFRC.beans.HistoricoArbolitoVendido;
import fundacionFRC.beans.HistoricoEstado;
import fundacionFRC.beans.Iva;
import fundacionFRC.beans.Lote;
import fundacionFRC.generales.ConsultarFuncionesAPI;
import fundacionFRC.generales.IConstantes;
import fundacionFRC.generales.IEmail;
import fundacionFRC.modulos.IConsultasDAO;

@ManagedBean
@ViewScoped
public class AdministrarArbolito extends ConsultarFuncionesAPI implements Serializable {

	/**
	 * 
	 */
	private static final long								serialVersionUID	= 1127633667645012226L;

	private Integer													numeroSinLote;
	private String													vistaActual;
	private String													tipoAsignacion;
	private Arbolito												arbolito;
	private Arbolito												arbolitoTransaccion;
	private Bolsa														bolsa;
	private Bolsa														bolsaTransaccion;
	private FotoArbolito										fotoArbolito;
	private FotoArbolito										fotoArbolitoTransaccion;
	private FotoArbolito										fotoAdopcion;

	private HistoricoArbolitoVendido				historico;
	private HistoricoArbolitoVendido				historicoTransaccion;
	private UploadedFile										file;

	private List<Arbolito>									arbolitos;
	private List<Bolsa>											bolsas;
	private List<FotoArbolito>							fotosArbolito;
	private List<FotoArbolito>							fotosAdopciones;
	private List<HistoricoArbolitoVendido>	historicos;
	private Map<String, Object>							totales;
	private List<SelectItem>								itemsEstados;
	private List<SelectItem>								itemsEstadosConsulta;
	private List<SelectItem>								itemsLotes;

	// privados

	/**
	 * Valida una foto d eun arbolito adoptado
	 * 
	 * @param aTransaccion
	 * @return
	 */
	private boolean isFotoAdoptadoOK(String aTransaccion) {
		boolean ok = true;
		if (aTransaccion != null && aTransaccion.equals("C")) {
			if (this.isVacio(this.fotoAdopcion.getTitulo())) {
				ok = false;
				this.mostrarMensajeGlobal("debeDiligenciarTituloFoto", "advertencia");
			}
			if (!(this.fotoAdopcion != null && this.fotoAdopcion.getFoto() != null)) {
				ok = false;
				this.mostrarMensajeGlobal("fotoNoCargada", "advertencia");
			}

		} else {
			if (this.isVacio(this.fotoArbolitoTransaccion.getTitulo())) {
				ok = false;
				this.mostrarMensajeGlobal("debeDiligenciarTituloFoto", "advertencia");
			}
		}

		return ok;
	}

	/**
	 * Valida una foto de un arbolito
	 *
	 * @param aTransaccion
	 * @return ok
	 */
	private boolean isFotoOK(String aTransaccion) {
		boolean ok = true;
		if (aTransaccion != null && aTransaccion.equals("C")) {
			if (this.isVacio(this.fotoArbolito.getTitulo())) {
				ok = false;
				this.mostrarMensajeGlobal("debeDiligenciarTituloFoto", "advertencia");
			}
			if (!(this.fotoArbolito != null && this.fotoArbolito.getFoto() != null)) {
				ok = false;
				this.mostrarMensajeGlobal("fotoNoCargada", "advertencia");
			}

		} else {
			if (this.isVacio(this.fotoArbolitoTransaccion.getTitulo())) {
				ok = false;
				this.mostrarMensajeGlobal("debeDiligenciarTituloFoto", "advertencia");
			}
		}

		return ok;
	}

	/**
	 * Valida un administrador
	 *
	 * @param aTransaccion
	 * @return ok
	 */
	private boolean isValidoArbolito(String aTransaccion) {
		boolean ok = true;

		if (aTransaccion.equals("C")) {

			if (this.isVacio(this.arbolito.getNombre())) {
				ok = false;
				this.mostrarMensajeGlobal("nombreEspanol", "advertencia");
			}

			if (this.isVacio(this.arbolito.getNombreUS())) {
				ok = false;
				this.mostrarMensajeGlobal("nombreIngles", "advertencia");
			}

			if (this.isVacio(this.arbolito.getDescripcion())) {
				ok = false;
				this.mostrarMensajeGlobal("descripcionEspanol", "advertencia");
			}

			if (this.isVacio(this.arbolito.getDescripcionUS())) {
				ok = false;
				this.mostrarMensajeGlobal("descripcionIngles", "advertencia");
			}

		} else {

			if (this.isVacio(this.arbolitoTransaccion.getNombre())) {
				ok = false;
				this.mostrarMensajeGlobal("nombreEspanol", "advertencia");
			}

			if (this.isVacio(this.arbolitoTransaccion.getNombreUS())) {
				ok = false;
				this.mostrarMensajeGlobal("nombreIngles", "advertencia");
			}

			if (this.isVacio(this.arbolitoTransaccion.getDescripcion())) {
				ok = false;
				this.mostrarMensajeGlobal("descripcionEspanol", "advertencia");
			}

			if (this.isVacio(this.arbolitoTransaccion.getDescripcionUS())) {
				ok = false;
				this.mostrarMensajeGlobal("descripcionIngles", "advertencia");
			}

		}

		return ok;
	}

	// publicos

	/**
	 * Este método borra el formulario de arbolitoa adoptados
	 */
	public void cancelarArbolitoAdoptado() {

		try {

			this.historico = new HistoricoArbolitoVendido();

			this.historicos = null;

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}

	}

	/**
	 * Consulta los arbolitos adoptados
	 */
	public void consultarArbolitosAdoptados() {
		try {

			this.historico.getVenta().setEstadoTransaccion(IConstantes.TRANSACCION_APROBADA);
			this.historicos = IConsultasDAO.getHistoricoArbolito(this.historico);

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}

	}

	/**
	 * Calcula los precios con y sin iva de las bolsas
	 * 
	 * @param aTransaccion
	 */
	public void calcularPreciosBolsa(String aTransaccion) {

		try {
			List<Iva> ivas = null;
			if (aTransaccion.equals("C")) {

				if (this.bolsa != null && this.bolsa.getIva() != null && this.bolsa.getIva().getId() != null) {

					ivas = IConsultasDAO.getIvas(this.bolsa.getIva());
					this.bolsa.getIva().setValorIva(ivas.get(0).getValorIva());

					if (this.bolsa.getPrecioVentaPesos() != null) {

						this.bolsa.setIvaPesos(this.getValorRedondeado(this.bolsa.getPrecioVentaPesos().multiply(this.bolsa.getIva().getValorIva()).divide(new BigDecimal(100)), IConstantes.DECIMALES_REDONDEAR));
						this.bolsa.setPrecioVentaPesosConIva(this.getValorRedondeado(this.bolsa.getPrecioVentaPesos().add(this.bolsa.getIvaPesos()), IConstantes.DECIMALES_REDONDEAR));

					} else {
						this.bolsa.setIvaPesos(null);
						this.bolsa.setPrecioVentaPesosConIva(null);

					}

					if (this.bolsa.getPrecioVentaUS() != null) {
						this.bolsa.setIvaUs(this.getValorRedondeado(this.bolsa.getPrecioVentaUS().multiply(this.bolsa.getIva().getValorIva()).divide(new BigDecimal(100)), IConstantes.DECIMALES_REDONDEAR));
						this.bolsa.setPrecioVentaUSConIva(this.getValorRedondeado(this.bolsa.getPrecioVentaUS().add(this.bolsa.getIvaUs()), IConstantes.DECIMALES_REDONDEAR));
					} else {
						this.bolsa.setIvaUs(null);
						this.bolsa.setPrecioVentaUSConIva(null);
					}

				} else {

					this.bolsa.setIvaPesos(null);
					this.bolsa.setPrecioVentaPesosConIva(null);
					this.bolsa.setIvaUs(null);
					this.bolsa.setPrecioVentaUSConIva(null);

				}

			} else {

				if (this.bolsaTransaccion != null && this.bolsaTransaccion.getIva() != null && this.bolsaTransaccion.getIva().getId() != null) {

					ivas = IConsultasDAO.getIvas(this.bolsaTransaccion.getIva());
					this.bolsaTransaccion.getIva().setValorIva(ivas.get(0).getValorIva());

					if (this.bolsaTransaccion.getPrecioVentaPesos() != null) {

						this.bolsaTransaccion.setIvaPesos(this.getValorRedondeado(this.bolsaTransaccion.getPrecioVentaPesos().multiply(this.bolsaTransaccion.getIva().getValorIva()).divide(new BigDecimal(100)), IConstantes.DECIMALES_REDONDEAR));
						this.bolsaTransaccion.setPrecioVentaPesosConIva(this.getValorRedondeado(this.bolsaTransaccion.getPrecioVentaPesos().add(this.bolsaTransaccion.getIvaPesos()), IConstantes.DECIMALES_REDONDEAR));

					} else {
						this.bolsaTransaccion.setIvaPesos(null);
						this.bolsaTransaccion.setPrecioVentaPesosConIva(null);

					}

					if (this.bolsaTransaccion.getPrecioVentaUS() != null) {
						this.bolsaTransaccion.setIvaUs(this.getValorRedondeado(this.bolsaTransaccion.getPrecioVentaUS().multiply(this.bolsaTransaccion.getIva().getValorIva()).divide(new BigDecimal(100)), IConstantes.DECIMALES_REDONDEAR));
						this.bolsaTransaccion.setPrecioVentaUSConIva(this.getValorRedondeado(this.bolsaTransaccion.getPrecioVentaUS().add(this.bolsaTransaccion.getIvaUs()), IConstantes.DECIMALES_REDONDEAR));
					} else {
						this.bolsaTransaccion.setIvaUs(null);
						this.bolsaTransaccion.setPrecioVentaUSConIva(null);
					}

				} else {

					this.bolsaTransaccion.setIvaPesos(null);
					this.bolsaTransaccion.setPrecioVentaPesosConIva(null);
					this.bolsaTransaccion.setIvaUs(null);
					this.bolsaTransaccion.setPrecioVentaUSConIva(null);

				}
			}

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}

	}

	/**
	 * Calcula los precios con iva para mostrarlos en pantalla
	 * 
	 * @param aTransaccion
	 */
	public void calcularPrecios(String aTransaccion) {

		try {
			List<Iva> ivas = null;
			if (aTransaccion.equals("C")) {

				if (this.arbolito != null && this.arbolito.getIva() != null && this.arbolito.getIva().getId() != null) {

					ivas = IConsultasDAO.getIvas(this.arbolito.getIva());
					this.arbolito.getIva().setValorIva(ivas.get(0).getValorIva());

					if (this.arbolito.getPrecioVentaPesos() != null) {

						this.arbolito.setIvaPesos(this.getValorRedondeado(this.arbolito.getPrecioVentaPesos().multiply(this.arbolito.getIva().getValorIva()).divide(new BigDecimal(100)), IConstantes.DECIMALES_REDONDEAR));
						this.arbolito.setPrecioVentaPesosConIva(this.getValorRedondeado(this.arbolito.getPrecioVentaPesos().add(this.arbolito.getIvaPesos()), IConstantes.DECIMALES_REDONDEAR));

					} else {
						this.arbolito.setIvaPesos(null);
						this.arbolito.setPrecioVentaPesosConIva(null);

					}

					if (this.arbolito.getPrecioVentaUS() != null) {
						this.arbolito.setIvaUs(this.getValorRedondeado(this.arbolito.getPrecioVentaUS().multiply(this.arbolito.getIva().getValorIva()).divide(new BigDecimal(100)), IConstantes.DECIMALES_REDONDEAR));
						this.arbolito.setPrecioVentaUSConIva(this.getValorRedondeado(this.arbolito.getPrecioVentaUS().add(this.arbolito.getIvaUs()), IConstantes.DECIMALES_REDONDEAR));
					} else {
						this.arbolito.setIvaUs(null);
						this.arbolito.setPrecioVentaUSConIva(null);
					}

				} else {

					this.arbolito.setIvaPesos(null);
					this.arbolito.setPrecioVentaPesosConIva(null);
					this.arbolito.setIvaUs(null);
					this.arbolito.setPrecioVentaUSConIva(null);

				}

			} else {

				if (this.arbolitoTransaccion != null && this.arbolitoTransaccion.getIva() != null && this.arbolitoTransaccion.getIva().getId() != null) {

					ivas = IConsultasDAO.getIvas(this.arbolitoTransaccion.getIva());
					this.arbolitoTransaccion.getIva().setValorIva(ivas.get(0).getValorIva());

					if (this.arbolitoTransaccion.getPrecioVentaPesos() != null) {

						this.arbolitoTransaccion.setIvaPesos(this.getValorRedondeado(this.arbolitoTransaccion.getPrecioVentaPesos().multiply(this.arbolitoTransaccion.getIva().getValorIva()).divide(new BigDecimal(100)), IConstantes.DECIMALES_REDONDEAR));
						this.arbolitoTransaccion.setPrecioVentaPesosConIva(this.getValorRedondeado(this.arbolitoTransaccion.getPrecioVentaPesos().add(this.arbolitoTransaccion.getIvaPesos()), IConstantes.DECIMALES_REDONDEAR));

					} else {
						this.arbolitoTransaccion.setIvaPesos(null);
						this.arbolitoTransaccion.setPrecioVentaPesosConIva(null);

					}

					if (this.arbolitoTransaccion.getPrecioVentaUS() != null) {
						this.arbolitoTransaccion.setIvaUs(this.getValorRedondeado(this.arbolitoTransaccion.getPrecioVentaUS().multiply(this.arbolitoTransaccion.getIva().getValorIva()).divide(new BigDecimal(100)), IConstantes.DECIMALES_REDONDEAR));
						this.arbolitoTransaccion.setPrecioVentaUSConIva(this.getValorRedondeado(this.arbolitoTransaccion.getPrecioVentaUS().add(this.arbolitoTransaccion.getIvaUs()), IConstantes.DECIMALES_REDONDEAR));
					} else {
						this.arbolitoTransaccion.setIvaUs(null);
						this.arbolitoTransaccion.setPrecioVentaUSConIva(null);
					}

				} else {

					this.arbolitoTransaccion.setIvaPesos(null);
					this.arbolitoTransaccion.setPrecioVentaPesosConIva(null);
					this.arbolitoTransaccion.setIvaUs(null);
					this.arbolitoTransaccion.setPrecioVentaUSConIva(null);

				}
			}

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}

	}

	/**
	 * Limpia el archivo cargado para volver a ingresar otro (arbol adoptado)
	 */
	public void limpiarAdopcion() {
		this.file = null;
		this.fotoAdopcion.setFoto(null);
	}

	/**
	 * Limpia el archivo cargado para volver a ingresar otro
	 */
	public void limpiarArchivoCargado() {
		this.file = null;
		this.fotoArbolito.setFoto(null);
	}

	/**
	 * Recibir el archivo adoptado y asignarlo al arbolito
	 * 
	 * @param event
	 */
	public void recibirFotoAdoptado(FileUploadEvent event) {

		try {
			this.file = event.getFile();
			this.fotoAdopcion.setFoto(event.getFile().getContents());
			this.mostrarMensajeGlobal("archivoRecibido", "advertencia");
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}

	}

	/**
	 * Recibir el archivo y asignarlo al arbolito
	 * 
	 * @param event
	 */
	public void recibirFotoArbolito(FileUploadEvent event) {

		try {
			this.file = event.getFile();
			this.fotoArbolito.setFoto(event.getFile().getContents());
			this.mostrarMensajeGlobal("archivoRecibido", "advertencia");
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}

	}

	/**
	 * Crea una bolsa de arbolito
	 */
	public void crearBolsa() {
		Conexion conexion = new Conexion();

		try {

			List<Iva> ivas = IConsultasDAO.getIvas(this.bolsa.getIva());
			if (ivas != null && ivas.size() > 0) {

				Bolsa bolsaExistente = new Bolsa();
				bolsaExistente.setCantidadDisponible(this.bolsa.getCantidadDisponible());
				bolsaExistente.getArbolito().setId(this.bolsa.getId());
				List<Bolsa> bolsasExistentes = IConsultasDAO.getBolsas(bolsaExistente);
				if (!(bolsasExistentes != null && bolsasExistentes.size() > 0)) {

					conexion.setAutoCommitBD(false);

					this.bolsa.setCantidadVendida(0);

					// CÁLCULOS CON IVA INCLUIDO

					this.bolsa.getIva().setValorIva(ivas.get(0).getValorIva());

					this.bolsa.setIvaPesos(this.getValorRedondeado(this.bolsa.getPrecioVentaPesos().multiply(this.bolsa.getIva().getValorIva()).divide(new BigDecimal(100)), IConstantes.DECIMALES_REDONDEAR));
					this.bolsa.setIvaUs(this.getValorRedondeado(this.bolsa.getPrecioVentaUS().multiply(this.bolsa.getIva().getValorIva()).divide(new BigDecimal(100)), IConstantes.DECIMALES_REDONDEAR));
					this.bolsa.setPrecioVentaPesosConIva(this.getValorRedondeado(this.bolsa.getPrecioVentaPesos().add(this.bolsa.getIvaPesos()), IConstantes.DECIMALES_REDONDEAR));
					this.bolsa.setPrecioVentaUSConIva(this.getValorRedondeado(this.bolsa.getPrecioVentaUS().add(this.bolsa.getIvaUs()), IConstantes.DECIMALES_REDONDEAR));

					this.bolsa.getCamposBD();

					conexion.insertarBD(this.bolsa.getEstructuraTabla().getTabla(), this.bolsa.getEstructuraTabla().getPersistencia());
					conexion.commitBD();

					this.mostrarMensajeGlobal("creacionExitosa", "exito");

					// reseteo de variables
					this.bolsa = null;
					this.getBolsa();
					this.bolsas = null;
					this.getBolsas();

				} else {

					this.mostrarMensajeGlobal("combinacionBolsaErrada", "advertencia");

				}

			} else {
				this.mostrarMensajeGlobal("transaccionFallida", "error");

			}

		} catch (Exception e) {
			conexion.rollbackBD();
			this.mostrarMensajeGlobal("transaccionFallida", "error");
		} finally {
			conexion.cerrarConexion();
		}

	}

	/**
	 * Crea un nuevo administrador del software
	 */
	public void crearArbolito() {
		Conexion conexion = new Conexion();

		try {
			if (isValidoArbolito("C")) {

				List<Iva> ivas = IConsultasDAO.getIvas(this.arbolito.getIva());
				if (ivas != null && ivas.size() > 0) {

					conexion.setAutoCommitBD(false);

					this.arbolito.setNombre(this.getSinEspacios(this.arbolito.getNombre()));
					this.arbolito.setNombreUS(this.getSinEspacios(this.arbolito.getNombreUS()));
					this.arbolito.setDescripcion(this.getSinEspacios(this.arbolito.getDescripcion()));
					this.arbolito.setDescripcionUS(this.getSinEspacios(this.arbolito.getDescripcionUS()));

					this.arbolito.setCantidadUsadaReemplazos(0);
					this.arbolito.setCantidadVendida(0);
					this.arbolito.setCantidadPendientePago(0);

					// CÁLCULOS CON IVA INCLUIDO

					this.arbolito.getIva().setValorIva(ivas.get(0).getValorIva());

					this.arbolito.setIvaPesos(this.getValorRedondeado(this.arbolito.getPrecioVentaPesos().multiply(this.arbolito.getIva().getValorIva()).divide(new BigDecimal(100)), IConstantes.DECIMALES_REDONDEAR));
					this.arbolito.setIvaUs(this.getValorRedondeado(this.arbolito.getPrecioVentaUS().multiply(this.arbolito.getIva().getValorIva()).divide(new BigDecimal(100)), IConstantes.DECIMALES_REDONDEAR));
					this.arbolito.setPrecioVentaPesosConIva(this.getValorRedondeado(this.arbolito.getPrecioVentaPesos().add(this.arbolito.getIvaPesos()), IConstantes.DECIMALES_REDONDEAR));
					this.arbolito.setPrecioVentaUSConIva(this.getValorRedondeado(this.arbolito.getPrecioVentaUS().add(this.arbolito.getIvaUs()), IConstantes.DECIMALES_REDONDEAR));

					this.arbolito.getCamposBD();

					conexion.insertarBD(this.arbolito.getEstructuraTabla().getTabla(), this.arbolito.getEstructuraTabla().getPersistencia());
					conexion.commitBD();

					this.mostrarMensajeGlobal("creacionExitosa", "exito");

					// reseteo de variables
					this.arbolito = null;
					this.getArbolito();
					this.arbolitos = null;
					this.getArbolitos();

				} else {
					this.mostrarMensajeGlobal("transaccionFallida", "error");

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
	 * Asigna un lote masivamente de forma manual o automática
	 */
	public void asignarLoteMasivo() {
		Conexion conexion = new Conexion();
		List<Lote> lotesConsultados = null;
		AdministrarSesionCliente admin = new AdministrarSesionCliente();
		int asignado = 0;

		List<String> listaCorreos = new ArrayList<String>();
		try {

			conexion.setAutoCommitBD(false);

			if (this.historicos != null && this.historicos.size() > 0) {
				this.numeroSinLote = 0;
				for (HistoricoArbolitoVendido h : this.historicos) {
					if (!(h.getLote() != null && h.getLote().getId() != null)) {
						this.numeroSinLote++;
						break;

					}
				}

				if (this.numeroSinLote.intValue() > 0) {

					for (HistoricoArbolitoVendido h : this.historicos) {
						// automatica
						if (this.tipoAsignacion != null && this.tipoAsignacion.equals("A") && (h.getLote() == null || h.getLote().getId() == null)) {
							lotesConsultados = IConsultasDAO.getLotesArbolesDisponibles(conexion, h.getArbolito());
							if (lotesConsultados != null && lotesConsultados.size() > 0) {

								h.setLote(lotesConsultados.get(0));
								h.setNumeroInterno((lotesConsultados.get(0).getCantidadVendida().intValue() + 1));
								admin.actualizarLote(conexion, lotesConsultados.get(0), "cantidad_vendida", lotesConsultados.get(0).getCantidadVendida());

								if (lotesConsultados.get(0).getIndicativoInfinito().equals(IConstantes.NEGACION)) {
									admin.actualizarLote(conexion, lotesConsultados.get(0), "cantidad_disponible", lotesConsultados.get(0).getCantidadDisponible());
									admin.actualizarLote(conexion, lotesConsultados.get(0), "minimo_cero", null);
								}

								h.getCamposBD();
								conexion.actualizarBD(h.getEstructuraTabla().getTabla(), h.getEstructuraTabla().getPersistencia(), h.getEstructuraTabla().getLlavePrimaria(), null);

								asignado++;

								if (h.getCorreoReceptorRegalo() != null && !h.getCorreoReceptorRegalo().trim().equals("")) {

									if (listaCorreos.size() < IConstantes.MAXIMOS_REMITENTES_CORREO.intValue() && !(listaCorreos.stream().anyMatch(p -> h.getCorreoReceptorRegalo().trim().equals(p.trim())))) {
										listaCorreos.add(h.getCorreoReceptorRegalo().trim());
									}

								} else {

									if (listaCorreos.size() < IConstantes.MAXIMOS_REMITENTES_CORREO.intValue() && !(listaCorreos.stream().anyMatch(p -> h.getVenta().getComprador().getCorreoElectronico().trim().equals(p.trim())))) {
										listaCorreos.add(h.getVenta().getComprador().getCorreoElectronico().trim());
									}

								}

							}

						} else {

							if (h.getLote() == null || h.getLote().getId() == null) {

								Lote lote = new Lote();
								lote.setNombreLote(this.historicoTransaccion.getLote().getNombreLote().trim());
								lote.getArbolito().setId(h.getArbolito().getId());
								lotesConsultados = IConsultasDAO.getLotes(lote, conexion);

								if (lotesConsultados != null && lotesConsultados.size() > 0 && ((lotesConsultados.get(0).getIndicativoInfinito().equals(IConstantes.AFIRMACION)) || (lotesConsultados.get(0).getCantidadDisponible().intValue() > 0 && lotesConsultados.get(0).getIndicativoInfinito().equals(IConstantes.NEGACION)))) {

									h.setLote(lotesConsultados.get(0));
									h.setNumeroInterno((lotesConsultados.get(0).getCantidadVendida().intValue() + 1));
									admin.actualizarLote(conexion, lotesConsultados.get(0), "cantidad_vendida", lotesConsultados.get(0).getCantidadVendida());

									if (lotesConsultados.get(0).getIndicativoInfinito().equals(IConstantes.NEGACION)) {
										admin.actualizarLote(conexion, lotesConsultados.get(0), "cantidad_disponible", lotesConsultados.get(0).getCantidadDisponible());
										admin.actualizarLote(conexion, lotesConsultados.get(0), "minimo_cero", null);
									}

									h.getCamposBD();
									conexion.actualizarBD(h.getEstructuraTabla().getTabla(), h.getEstructuraTabla().getPersistencia(), h.getEstructuraTabla().getLlavePrimaria(), null);

									asignado++;
									if (h.getCorreoReceptorRegalo() != null && !h.getCorreoReceptorRegalo().trim().equals("")) {

										if (listaCorreos.size() < IConstantes.MAXIMOS_REMITENTES_CORREO.intValue() && !(listaCorreos.stream().anyMatch(p -> h.getCorreoReceptorRegalo().trim().equals(p.trim())))) {
											listaCorreos.add(h.getCorreoReceptorRegalo().trim());
										}

									} else {

										if (listaCorreos.size() < IConstantes.MAXIMOS_REMITENTES_CORREO.intValue() && !(listaCorreos.stream().anyMatch(p -> h.getVenta().getComprador().getCorreoElectronico().trim().equals(p.trim())))) {
											listaCorreos.add(h.getVenta().getComprador().getCorreoElectronico().trim());
										}

									}

								}

							}

						}
					}

					if (asignado > 0) {
						conexion.commitBD();
						this.mostrarMensajeGlobalPersonalizado(this.getMensaje("asigancionExitosaMasiva", "" + asignado), "exito");
						this.cerrarModal("panelAsignarLoteMasivo");
					} else {

						this.mostrarMensajeGlobal("noAsignadoLotes", "advertencia");

					}

					if (listaCorreos != null && listaCorreos.size() > 0) {

						IEmail.enviarCorreoMasivo(this.getMensaje("loteParticularComprador", this.getMensaje("amigo")), this.getMensaje("asuntoLote"), listaCorreos);
						this.mostrarMensajeGlobal("tambienCorreoLoteMasivo", "exito");
					}

					this.historicos = null;
					consultarArbolitosAdoptados();

				} else {
					this.mostrarMensajeGlobal("consultaSinLote", "advertencia");
					this.cerrarModal("panelAsignarLoteMasivo");
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
	 * Cambia masivamente los arbolitos de estado
	 */
	public void cambiarEstadoMasivamente() {
		Conexion conexion = new Conexion();
		List<String> listaCorreos = new ArrayList<String>();
		HistoricoEstado historicoEstado = null;

		try {

			conexion.setAutoCommitBD(false);

			for (HistoricoArbolitoVendido h : this.historicos) {

				h.getEstado().setId(this.historicoTransaccion.getEstado().getId());
				h.getCamposBD();
				conexion.actualizarBD(h.getEstructuraTabla().getTabla(), h.getEstructuraTabla().getPersistencia(), h.getEstructuraTabla().getLlavePrimaria(), null);

				// guarda el historial del estado
				historicoEstado = new HistoricoEstado();
				historicoEstado.setEstado(this.historicoTransaccion.getEstado());
				historicoEstado.setHistorico(h);
				historicoEstado.getCamposBD();
				conexion.insertarBD(historicoEstado.getEstructuraTabla().getTabla(), historicoEstado.getEstructuraTabla().getPersistencia());

				if (h.getCorreoReceptorRegalo() != null && !h.getCorreoReceptorRegalo().trim().equals("")) {

					if (listaCorreos.size() < IConstantes.MAXIMOS_REMITENTES_CORREO.intValue() && !(listaCorreos.stream().anyMatch(p -> h.getCorreoReceptorRegalo().trim().equals(p.trim())))) {
						listaCorreos.add(h.getCorreoReceptorRegalo().trim());
					}

				} else {

					if (listaCorreos.size() < IConstantes.MAXIMOS_REMITENTES_CORREO.intValue() && !(listaCorreos.stream().anyMatch(p -> h.getVenta().getComprador().getCorreoElectronico().trim().equals(p.trim())))) {
						listaCorreos.add(h.getVenta().getComprador().getCorreoElectronico().trim());
					}

				}

			}

			conexion.commitBD();

			this.mostrarMensajeGlobal("cambioEstadoExitoso", "exito");

			if (listaCorreos != null && listaCorreos.size() > 0) {

				IEmail.enviarCorreoMasivo(this.getMensaje("cambioParticularComprador", this.getMensaje("amigo")), this.getMensaje("asuntoCambioEstado"), listaCorreos);
				this.mostrarMensajeGlobal("tambienCorreoCambio", "exito");
			}

			this.cerrarModal("panelCambiarEstadoMasivo");

			this.historicos = null;
			consultarArbolitosAdoptados();

		} catch (Exception e) {
			conexion.rollbackBD();
			this.mostrarMensajeGlobal("transaccionFallida", "error");
		} finally {
			conexion.cerrarConexion();
		}

	}

	/**
	 * Reemplazar arbolito por otro
	 */
	public void reemplazarArbolito() {
		Conexion conexion = new Conexion();

		try {
			AdministrarSesionCliente admin = new AdministrarSesionCliente();

			if (this.historicoTransaccion.getArbolito().getCantidadDisponible() != null && this.historicoTransaccion.getArbolito().getCantidadDisponible().intValue() > 0) {

				conexion.setAutoCommitBD(false);

				// blanco o el mismo lote

				if (this.historicoTransaccion.getLote() != null && this.historicoTransaccion.getLote().getId() != null) {
					this.historicoTransaccion.setHistoricoSuperior(this.historicoTransaccion.getLote().getNombreLote().trim() + "-" + this.historicoTransaccion.getNumeroInterno());
					if (this.tipoAsignacion != null && this.tipoAsignacion.equals("B")) {
						this.historicoTransaccion.getLote().setId(null);
						this.historicoTransaccion.setNumeroInterno(null);

					} else {
						this.historicoTransaccion.setHistoricoSuperior("EL_MISMO_LOTE");
					}
				} else {
					this.historicoTransaccion.setHistoricoSuperior("ANTES_SIN_LOTE_ASIGNADO");
				}

				this.historicoTransaccion.getCamposBD();
				conexion.actualizarBD(this.historicoTransaccion.getEstructuraTabla().getTabla(), this.historicoTransaccion.getEstructuraTabla().getPersistencia(), this.historicoTransaccion.getEstructuraTabla().getLlavePrimaria(), null);

				// actualiza_indicadores_en_arbolitos se va a usar uno

				// actualiza inventario de cantidades arbolito(1:porque es 1 arbolito)
				admin.actualizarCantidadesArbolitos(conexion, this.historicoTransaccion.getArbolito(), "cantidad_usada_reemplazos", 1, "+");
				admin.actualizarCantidadesArbolitos(conexion, this.historicoTransaccion.getArbolito(), "cantidad_disponible", 1, "-");
				admin.actualizarCantidadesArbolitos(conexion, this.historicoTransaccion.getArbolito(), "minimo_cero", null, null);

				conexion.commitBD();

				this.mostrarMensajeGlobal("reemplazoExitoso", "exito");

				this.cerrarModal("panelReemplazarArbolito");
				this.historicos = null;
				consultarArbolitosAdoptados();

			} else {
				this.mostrarMensajeGlobal("arbolitosNoDisponibles", "advertencia");
			}

		} catch (Exception e) {
			conexion.rollbackBD();
			this.mostrarMensajeGlobal("transaccionFallida", "error");
		} finally {
			conexion.cerrarConexion();
		}

	}

	/**
	 * Cambia un arbolito de estado.
	 */
	public void cambiarEstado() {
		Conexion conexion = new Conexion();
		HistoricoEstado historicoEstado = null;
		try {

			conexion.setAutoCommitBD(false);

			this.historicoTransaccion.getCamposBD();
			conexion.actualizarBD(this.historicoTransaccion.getEstructuraTabla().getTabla(), this.historicoTransaccion.getEstructuraTabla().getPersistencia(), this.historicoTransaccion.getEstructuraTabla().getLlavePrimaria(), null);

			// guarda el historial del estado
			historicoEstado = new HistoricoEstado();
			historicoEstado.setEstado(this.historicoTransaccion.getEstado());
			historicoEstado.setHistorico(this.historicoTransaccion);
			historicoEstado.getCamposBD();
			conexion.insertarBD(historicoEstado.getEstructuraTabla().getTabla(), historicoEstado.getEstructuraTabla().getPersistencia());

			conexion.commitBD();

			this.mostrarMensajeGlobal("cambioEstadoExitoso", "exito");

			// se envía correo electrónico

			if (this.historicoTransaccion != null && this.historicoTransaccion.getCorreoReceptorRegalo() != null && !this.historicoTransaccion.getCorreoReceptorRegalo().trim().equals("")) {
				IEmail.enviarCorreo(this.getMensaje("cambioRegalado", this.historicoTransaccion.getVenta().getComprador().getNombreCompleto()), this.getMensaje("asuntoCambioEstado"), this.historicoTransaccion.getCorreoReceptorRegalo().trim());
			} else {
				IEmail.enviarCorreo(this.getMensaje("cambioParticularComprador", this.historicoTransaccion.getVenta().getComprador().getNombreCompleto()), this.getMensaje("asuntoCambioEstado"), this.historicoTransaccion.getVenta().getComprador().getCorreoElectronico().trim());
			}
			this.mostrarMensajeGlobal("tambienCorreoCambio", "exito");
			this.cerrarModal("panelCambiarEstado");
			this.historicos = null;
			consultarArbolitosAdoptados();

		} catch (Exception e) {
			conexion.rollbackBD();
			this.mostrarMensajeGlobal("transaccionFallida", "error");
		} finally {
			conexion.cerrarConexion();
		}

	}

	/**
	 * Asigna un lote de forma manual o automática
	 */
	public void asignarLote() {
		Conexion conexion = new Conexion();
		List<Lote> lotesConsultados = null;
		AdministrarSesionCliente admin = new AdministrarSesionCliente();
		try {

			conexion.setAutoCommitBD(false);

			// automatica
			if (this.tipoAsignacion != null && this.tipoAsignacion.equals("A")) {
				lotesConsultados = IConsultasDAO.getLotesArbolesDisponibles(conexion, this.historicoTransaccion.getArbolito());
				if (lotesConsultados != null && lotesConsultados.size() > 0) {

					this.historicoTransaccion.setLote(lotesConsultados.get(0));
					this.historicoTransaccion.setNumeroInterno((lotesConsultados.get(0).getCantidadVendida().intValue() + 1));
					admin.actualizarLote(conexion, lotesConsultados.get(0), "cantidad_vendida", lotesConsultados.get(0).getCantidadVendida());

					if (lotesConsultados.get(0).getIndicativoInfinito().equals(IConstantes.NEGACION)) {
						admin.actualizarLote(conexion, lotesConsultados.get(0), "cantidad_disponible", lotesConsultados.get(0).getCantidadDisponible());
						admin.actualizarLote(conexion, lotesConsultados.get(0), "minimo_cero", null);
					}

					this.historicoTransaccion.getCamposBD();
					conexion.actualizarBD(this.historicoTransaccion.getEstructuraTabla().getTabla(), this.historicoTransaccion.getEstructuraTabla().getPersistencia(), this.historicoTransaccion.getEstructuraTabla().getLlavePrimaria(), null);
					conexion.commitBD();

					this.mostrarMensajeGlobal("asigancionExitosa", "exito");

					// se envía correo electrónico

					if (this.historicoTransaccion != null && this.historicoTransaccion.getCorreoReceptorRegalo() != null && !this.historicoTransaccion.getCorreoReceptorRegalo().trim().equals("")) {
						IEmail.enviarCorreo(this.getMensaje("loteRegalado", this.historicoTransaccion.getVenta().getComprador().getNombreCompleto()), this.getMensaje("asuntoLote"), this.historicoTransaccion.getCorreoReceptorRegalo().trim());
					} else {
						IEmail.enviarCorreo(this.getMensaje("loteParticularComprador", this.historicoTransaccion.getVenta().getComprador().getNombreCompleto()), this.getMensaje("asuntoLote"), this.historicoTransaccion.getVenta().getComprador().getCorreoElectronico().trim());
					}

					this.mostrarMensajeGlobal("tambienCorreoLote", "exito");

					this.cerrarModal("panelAsignarLote");

				} else {

					this.historicoTransaccion.getLote().setId(null);
					this.mostrarMensajeGlobal("noExisteDisponibilidad", "advertencia");

				}

			} else {

				Lote lote = new Lote();
				lote.setId(this.historicoTransaccion.getLote().getId());
				lote.getArbolito().setId(this.historicoTransaccion.getLote().getId());
				lotesConsultados = IConsultasDAO.getLotes(lote, conexion);

				if (lotesConsultados != null && lotesConsultados.size() > 0 && ((lotesConsultados.get(0).getIndicativoInfinito().equals(IConstantes.AFIRMACION)) || (lotesConsultados.get(0).getCantidadDisponible().intValue() > 0 && lotesConsultados.get(0).getIndicativoInfinito().equals(IConstantes.NEGACION)))) {

					this.historicoTransaccion.setLote(lotesConsultados.get(0));
					this.historicoTransaccion.setNumeroInterno((lotesConsultados.get(0).getCantidadVendida().intValue() + 1));
					admin.actualizarLote(conexion, lotesConsultados.get(0), "cantidad_vendida", lotesConsultados.get(0).getCantidadVendida());

					if (lotesConsultados.get(0).getIndicativoInfinito().equals(IConstantes.NEGACION)) {
						admin.actualizarLote(conexion, lotesConsultados.get(0), "cantidad_disponible", lotesConsultados.get(0).getCantidadDisponible());
						admin.actualizarLote(conexion, lotesConsultados.get(0), "minimo_cero", null);
					}

					this.historicoTransaccion.getCamposBD();
					conexion.actualizarBD(this.historicoTransaccion.getEstructuraTabla().getTabla(), this.historicoTransaccion.getEstructuraTabla().getPersistencia(), this.historicoTransaccion.getEstructuraTabla().getLlavePrimaria(), null);
					conexion.commitBD();

					this.mostrarMensajeGlobal("asigancionExitosa", "exito");

					// se envía correo electrónico

					if (this.historicoTransaccion != null && this.historicoTransaccion.getCorreoReceptorRegalo() != null && !this.historicoTransaccion.getCorreoReceptorRegalo().trim().equals("")) {
						IEmail.enviarCorreo(this.getMensaje("loteRegalado", this.historicoTransaccion.getVenta().getComprador().getNombreCompleto()), this.getMensaje("asuntoLote"), this.historicoTransaccion.getCorreoReceptorRegalo().trim());
					} else {
						IEmail.enviarCorreo(this.getMensaje("loteParticularComprador", this.historicoTransaccion.getVenta().getComprador().getNombreCompleto()), this.getMensaje("asuntoLote"), this.historicoTransaccion.getVenta().getComprador().getCorreoElectronico().trim());
					}

					this.mostrarMensajeGlobal("tambienCorreoLote", "exito");

					this.cerrarModal("panelAsignarLote");

				} else {

					this.historicoTransaccion.getLote().setId(null);
					this.mostrarMensajeGlobal("noExisteDisponibilidad", "advertencia");

				}

			}

			this.historicos = null;
			consultarArbolitosAdoptados();

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
	public void regalarArbolito() {
		Conexion conexion = new Conexion();

		try {

			conexion.setAutoCommitBD(false);

			this.historicoTransaccion.getCamposBD();

			conexion.actualizarBD(this.historicoTransaccion.getEstructuraTabla().getTabla(), this.historicoTransaccion.getEstructuraTabla().getPersistencia(), this.historicoTransaccion.getEstructuraTabla().getLlavePrimaria(), null);
			conexion.commitBD();
			this.mostrarMensajeGlobal("regaloExitoso", "exito");

			// se envía correo electrónico de la personalización

			IEmail.enviarCorreo(this.getMensaje("mensajeCorreoRegalo", this.historicoTransaccion.getVenta().getComprador().getNombreCompleto()), this.getMensaje("asuntoRegalo"), this.historicoTransaccion.getCorreoReceptorRegalo().trim());

			this.mostrarMensajeGlobal("tambienCorreoRegalo", "exito");

			this.cerrarModal("panelRegalarArbolito");
			this.historicos = null;
			consultarArbolitosAdoptados();

		} catch (Exception e) {
			conexion.rollbackBD();
			this.mostrarMensajeGlobal("transaccionFallida", "error");
		} finally {
			conexion.cerrarConexion();
		}

	}

	/**
	 * Actualiza un arbolito, o lo personaliza
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

			this.historicos = null;
			consultarArbolitosAdoptados();

		} catch (Exception e) {
			conexion.rollbackBD();
			this.mostrarMensajeGlobal("transaccionFallida", "error");
		} finally {
			conexion.cerrarConexion();
		}

	}

	/**
	 * Edita una bolsa de arbolitos
	 */
	public void editarBolsa() {
		Conexion conexion = new Conexion();
		List<String> camposExceptuados = null;
		try {

			List<Iva> ivas = IConsultasDAO.getIvas(this.bolsaTransaccion.getIva());
			if (ivas != null && ivas.size() > 0) {
				conexion.setAutoCommitBD(false);

				this.bolsaTransaccion.getIva().setValorIva(ivas.get(0).getValorIva());

				this.bolsaTransaccion.setIvaPesos(this.getValorRedondeado(this.bolsaTransaccion.getPrecioVentaPesos().multiply(this.bolsaTransaccion.getIva().getValorIva()).divide(new BigDecimal(100)), IConstantes.DECIMALES_REDONDEAR));
				this.bolsaTransaccion.setIvaUs(this.getValorRedondeado(this.bolsaTransaccion.getPrecioVentaUS().multiply(this.bolsaTransaccion.getIva().getValorIva()).divide(new BigDecimal(100)), IConstantes.DECIMALES_REDONDEAR));
				this.bolsaTransaccion.setPrecioVentaPesosConIva(this.getValorRedondeado(this.bolsaTransaccion.getPrecioVentaPesos().add(this.bolsaTransaccion.getIvaPesos()), IConstantes.DECIMALES_REDONDEAR));
				this.bolsaTransaccion.setPrecioVentaUSConIva(this.getValorRedondeado(this.bolsaTransaccion.getPrecioVentaUS().add(this.bolsaTransaccion.getIvaUs()), IConstantes.DECIMALES_REDONDEAR));

				this.bolsaTransaccion.getCamposBD();

				// No deseo update de estos campos
				camposExceptuados = Arrays.asList("bolsas_vendidas");

				conexion.actualizarBD(this.bolsaTransaccion.getEstructuraTabla().getTabla(), this.bolsaTransaccion.getEstructuraTabla().getPersistencia(), this.bolsaTransaccion.getEstructuraTabla().getLlavePrimaria(), camposExceptuados);
				conexion.commitBD();
				this.mostrarMensajeGlobal("edicionExitosa", "exito");
				this.cerrarModal("panelEdicionArbolito");

				// reseteo de variables
				this.bolsaTransaccion = null;
				this.getBolsaTransaccion();
				this.bolsas = null;
				this.getBolsas();

			} else {
				this.mostrarMensajeGlobal("transaccionFallida", "error");
			}

		} catch (Exception e) {
			conexion.rollbackBD();
			this.mostrarMensajeGlobal("transaccionFallida", "error");
		} finally {
			conexion.cerrarConexion();
		}

	}

	/**
	 * Edita un registro de arbolito
	 */
	public void editarArbolito() {
		Conexion conexion = new Conexion();
		List<String> camposExceptuados = null;
		try {
			if (isValidoArbolito("E")) {

				List<Iva> ivas = IConsultasDAO.getIvas(this.arbolitoTransaccion.getIva());
				if (ivas != null && ivas.size() > 0) {
					conexion.setAutoCommitBD(false);

					this.arbolitoTransaccion.setNombre(this.getSinEspacios(this.arbolitoTransaccion.getNombre()));
					this.arbolitoTransaccion.setNombreUS(this.getSinEspacios(this.arbolitoTransaccion.getNombreUS()));
					this.arbolitoTransaccion.setDescripcion(this.getSinEspacios(this.arbolitoTransaccion.getDescripcion()));
					this.arbolitoTransaccion.setDescripcionUS(this.getSinEspacios(this.arbolitoTransaccion.getDescripcionUS()));

					this.arbolitoTransaccion.getIva().setValorIva(ivas.get(0).getValorIva());

					this.arbolitoTransaccion.setIvaPesos(this.getValorRedondeado(this.arbolitoTransaccion.getPrecioVentaPesos().multiply(this.arbolitoTransaccion.getIva().getValorIva()).divide(new BigDecimal(100)), IConstantes.DECIMALES_REDONDEAR));
					this.arbolitoTransaccion.setIvaUs(this.getValorRedondeado(this.arbolitoTransaccion.getPrecioVentaUS().multiply(this.arbolitoTransaccion.getIva().getValorIva()).divide(new BigDecimal(100)), IConstantes.DECIMALES_REDONDEAR));
					this.arbolitoTransaccion.setPrecioVentaPesosConIva(this.getValorRedondeado(this.arbolitoTransaccion.getPrecioVentaPesos().add(this.arbolitoTransaccion.getIvaPesos()), IConstantes.DECIMALES_REDONDEAR));
					this.arbolitoTransaccion.setPrecioVentaUSConIva(this.getValorRedondeado(this.arbolitoTransaccion.getPrecioVentaUS().add(this.arbolitoTransaccion.getIvaUs()), IConstantes.DECIMALES_REDONDEAR));

					this.arbolitoTransaccion.getCamposBD();

					// No deseo update de estos campos ya que los determina las compras y
					// puede ser que en transacción exista una en el momento
					camposExceptuados = Arrays.asList("cantidad_vendida", "cantidad_usada_reemplazos", "cantidad_pendiente_pago");

					conexion.actualizarBD(this.arbolitoTransaccion.getEstructuraTabla().getTabla(), this.arbolitoTransaccion.getEstructuraTabla().getPersistencia(), this.arbolitoTransaccion.getEstructuraTabla().getLlavePrimaria(), camposExceptuados);
					conexion.commitBD();
					this.mostrarMensajeGlobal("edicionExitosa", "exito");
					this.cerrarModal("panelEdicionArbolito");

					// reseteo de variables
					this.arbolitoTransaccion = null;
					this.getArbolitoTransaccion();
					this.arbolitos = null;
					this.getArbolitos();

				} else {
					this.mostrarMensajeGlobal("transaccionFallida", "error");
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
	 * Elimina un registro de bolsa
	 */
	public void eliminarBolsa() {

		Conexion conexion = new Conexion();
		try {

			conexion.setAutoCommitBD(false);
			this.bolsaTransaccion.getCamposBD();
			conexion.eliminarBD(this.bolsaTransaccion.getEstructuraTabla().getTabla(), this.bolsaTransaccion.getEstructuraTabla().getLlavePrimaria());
			conexion.commitBD();
			this.mostrarMensajeGlobal("eliminacionExitosa", "exito");

		} catch (Exception e) {
			conexion.rollbackBD();
			this.mostrarMensajeGlobal("transaccionFallida", "error");
			this.mostrarMensajeGlobal("eliminacionFallida", "error");

		} finally {
			conexion.cerrarConexion();
		}

		// reseteo de variables
		this.bolsaTransaccion = null;
		this.bolsas = null;
		this.getBolsas();

	}

	/**
	 * Elimina un registro de arbolito
	 */
	public void eliminarArbolito() {

		Conexion conexion = new Conexion();
		try {

			conexion.setAutoCommitBD(false);
			this.arbolitoTransaccion.getCamposBD();
			conexion.eliminarBD(this.arbolitoTransaccion.getEstructuraTabla().getTabla(), this.arbolitoTransaccion.getEstructuraTabla().getLlavePrimaria());
			conexion.commitBD();
			this.mostrarMensajeGlobal("eliminacionExitosa", "exito");

		} catch (Exception e) {
			conexion.rollbackBD();
			this.mostrarMensajeGlobal("transaccionFallida", "error");
			this.mostrarMensajeGlobal("eliminacionFallida", "error");

		} finally {
			conexion.cerrarConexion();
		}

		// reseteo de variables
		this.arbolitoTransaccion = null;
		this.arbolitos = null;
		this.getArbolitos();

	}

	/**
	 * Elimina un registro de foto de un arbolito adoptado
	 */
	public void eliminarFotoAdoptado() {
		Conexion conexion = new Conexion();

		try {

			conexion.setAutoCommitBD(false);
			this.fotoArbolitoTransaccion.getCamposBD();
			conexion.eliminarBD(this.fotoArbolitoTransaccion.getEstructuraTabla().getTabla(), this.fotoArbolitoTransaccion.getEstructuraTabla().getLlavePrimaria());
			conexion.commitBD();

			this.mostrarMensajeGlobal("eliminacionExitosa", "exito");

			this.cerrarModal("panelEliminacionFoto");

			this.fotoArbolitoTransaccion = null;
			this.getFotoArbolitoTransaccion();
			this.fotosAdopciones = null;
			this.getFotosAdopciones();

		} catch (Exception e) {
			conexion.rollbackBD();

			this.mostrarMensajeGlobal("transaccionFallida", "error");
		} finally {

			conexion.cerrarConexion();
		}
	}

	/**
	 * Elimina un registro de foto para arbolito
	 */
	public void eliminarFotoArbolito() {
		Conexion conexion = new Conexion();

		try {

			conexion.setAutoCommitBD(false);
			this.fotoArbolitoTransaccion.getCamposBD();
			conexion.eliminarBD(this.fotoArbolitoTransaccion.getEstructuraTabla().getTabla(), this.fotoArbolitoTransaccion.getEstructuraTabla().getLlavePrimaria());
			conexion.commitBD();

			this.mostrarMensajeGlobal("eliminacionExitosa", "exito");

			this.cerrarModal("panelEliminacionFoto");

			this.fotoArbolitoTransaccion = null;
			this.getFotoArbolitoTransaccion();
			this.fotosArbolito = null;
			this.getFotosArbolito();

		} catch (Exception e) {
			conexion.rollbackBD();

			this.mostrarMensajeGlobal("transaccionFallida", "error");
		} finally {

			conexion.cerrarConexion();
		}
	}

	/**
	 * Edita un registro de foto de un arbolito adoptado
	 */
	public void editarFotoAdopcion() {
		Conexion conexion = new Conexion();

		try {

			if (isFotoAdoptadoOK("E")) {

				conexion.setAutoCommitBD(false);

				this.fotoArbolitoTransaccion.setTitulo(this.getSinEspacios(this.fotoArbolitoTransaccion.getTitulo()));

				// sólo me interesa actualizar el título

				Map<String, Object> camposActualizar = new HashMap<String, Object>();
				camposActualizar.put("titulo", this.fotoArbolitoTransaccion.getTitulo());
				this.fotoArbolitoTransaccion.getCamposBD();
				conexion.actualizarBD(this.fotoArbolitoTransaccion.getEstructuraTabla().getTabla(), camposActualizar, this.fotoArbolitoTransaccion.getEstructuraTabla().getLlavePrimaria(), null);
				conexion.commitBD();

				this.mostrarMensajeGlobal("edicionExitosa", "exito");

				this.cerrarModal("panelEdicionFoto");

				// reseteo de variables
				this.fotoArbolitoTransaccion = null;
				this.getFotoArbolitoTransaccion();
				this.fotosAdopciones = null;
				this.getFotosAdopciones();

			}

		} catch (Exception e) {
			conexion.rollbackBD();

			this.mostrarMensajeGlobal("transaccionFallida", "error");
		} finally {

			conexion.cerrarConexion();
		}
	}

	/**
	 * Edita un registro de foto para arbolito
	 */
	public void editarFotoArbolito() {
		Conexion conexion = new Conexion();

		try {

			if (isFotoOK("E")) {

				conexion.setAutoCommitBD(false);

				this.fotoArbolitoTransaccion.setTitulo(this.getSinEspacios(this.fotoArbolitoTransaccion.getTitulo()));

				// sólo me interesa actualizar el título

				Map<String, Object> camposActualizar = new HashMap<String, Object>();
				camposActualizar.put("titulo", this.fotoArbolitoTransaccion.getTitulo());
				this.fotoArbolitoTransaccion.getCamposBD();
				conexion.actualizarBD(this.fotoArbolitoTransaccion.getEstructuraTabla().getTabla(), camposActualizar, this.fotoArbolitoTransaccion.getEstructuraTabla().getLlavePrimaria(), null);
				conexion.commitBD();

				this.mostrarMensajeGlobal("edicionExitosa", "exito");

				this.cerrarModal("panelEdicionFoto");

				// reseteo de variables
				this.fotoArbolitoTransaccion = null;
				this.getFotoArbolitoTransaccion();
				this.fotosArbolito = null;
				this.getFotosArbolito();

			}

		} catch (Exception e) {
			conexion.rollbackBD();

			this.mostrarMensajeGlobal("transaccionFallida", "error");
		} finally {

			conexion.cerrarConexion();
		}
	}

	/**
	 * Crea un registro de foto del arbolito adoptado
	 */
	public void crearFotoArbolitoAdoptado() {
		Conexion conexion = new Conexion();

		try {

			if (isFotoAdoptadoOK("C")) {

				conexion.setAutoCommitBD(false);

				this.fotoAdopcion.setTitulo(this.getSinEspacios(this.fotoAdopcion.getTitulo()));
				this.fotoAdopcion.getCamposBD();

				conexion.insertarBD(this.fotoAdopcion.getEstructuraTabla().getTabla(), this.fotoAdopcion.getEstructuraTabla().getPersistencia());
				conexion.commitBD();

				this.mostrarMensajeGlobal("creacionExitosa", "exito");

				// reseteo de variables
				this.file = null;
				this.fotoAdopcion = null;
				this.getFotoAdopcion();
				this.fotosAdopciones = null;
				this.getFotosAdopciones();

				// se envía correo electrónico

				if (this.historicoTransaccion != null && this.historicoTransaccion.getCorreoReceptorRegalo() != null && !this.historicoTransaccion.getCorreoReceptorRegalo().trim().equals("")) {
					IEmail.enviarCorreo(this.getMensaje("fotoRegalado", this.historicoTransaccion.getVenta().getComprador().getNombreCompleto()), this.getMensaje("asuntoAdopcion"), this.historicoTransaccion.getCorreoReceptorRegalo().trim());
				} else {
					IEmail.enviarCorreo(this.getMensaje("fotoComprador", this.historicoTransaccion.getVenta().getComprador().getNombreCompleto()), this.getMensaje("asuntoAdopcion"), this.historicoTransaccion.getVenta().getComprador().getCorreoElectronico().trim());
				}
				this.mostrarMensajeGlobal("tambienCorreoFoto", "exito");

			}

		} catch (Exception e) {
			conexion.rollbackBD();

			this.mostrarMensajeGlobal("transaccionFallida", "error");
		} finally {

			conexion.cerrarConexion();
		}
	}

	/**
	 * Crea un registro de foto para arbolito
	 */
	public void crearFotoArbolito() {
		Conexion conexion = new Conexion();

		try {

			if (isFotoOK("C")) {

				conexion.setAutoCommitBD(false);

				this.fotoArbolito.setTitulo(this.getSinEspacios(this.fotoArbolito.getTitulo()));
				this.fotoArbolito.getCamposBD();
				conexion.insertarBD(this.fotoArbolito.getEstructuraTabla().getTabla(), this.fotoArbolito.getEstructuraTabla().getPersistencia());
				conexion.commitBD();

				this.mostrarMensajeGlobal("creacionExitosa", "exito");

				// reseteo de variables
				this.file = null;
				this.fotoArbolito = null;
				this.getFotoArbolito();
				this.fotosArbolito = null;
				this.getFotosArbolito();

			}

		} catch (Exception e) {
			conexion.rollbackBD();

			this.mostrarMensajeGlobal("transaccionFallida", "error");
		} finally {

			conexion.cerrarConexion();
		}
	}

	/**
	 * Cancela la bolsa de arbolitos
	 */
	public void cancelarBolsa() {

		try {

			this.bolsa = new Bolsa();
			this.bolsas = null;
			this.getBolsas();
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}

	}

	/**
	 * Este método borra el formulario de creación de un arbolito
	 */
	public void cancelarArbolito() {

		try {
			this.arbolito = new Arbolito();

			this.arbolitos = null;
			this.getArbolitos();
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}

	}

	/**
	 * Este método borra el formulario de edición de una foto en transacción de un
	 * arbolito particular
	 */
	public void cancelarFotoAdopcionTransaccion(String aVista) {
		try {

			this.fotoArbolitoTransaccion = new FotoArbolito();
			this.fotosAdopciones = null;
			this.getFotosAdopciones();

			if (aVista != null && aVista.equals("MODAL_EDITAR_FOTO")) {
				this.cerrarModal("panelEdicionFoto");

			} else if (aVista != null && aVista.equals("MODAL_ELIMINAR_FOTO")) {
				this.cerrarModal("panelEliminacionFoto");

			}

		} catch (Exception e) {

			IConstantes.log.error(e, e);

		}

	}

	/**
	 * Este método borra el formulario de edición de una foto en transacción
	 */
	public void cancelarFotoArbolitoTransaccion(String aVista) {
		try {

			this.fotoArbolitoTransaccion = new FotoArbolito();
			this.fotosArbolito = null;
			this.getFotosArbolito();

			if (aVista != null && aVista.equals("MODAL_EDITAR_FOTO")) {
				this.cerrarModal("panelEdicionFoto");

			} else if (aVista != null && aVista.equals("MODAL_ELIMINAR_FOTO")) {
				this.cerrarModal("panelEliminacionFoto");

			}

		} catch (Exception e) {

			IConstantes.log.error(e, e);

		}

	}

	/**
	 * Este método borra el formulario de edición de un arbolito en transacción
	 */
	public void cancelarFotoAdopcion() {
		try {

			this.historicoTransaccion = new HistoricoArbolitoVendido();
			this.historicos = null;
			this.fotosAdopciones = null;
			consultarArbolitosAdoptados();
			this.file = null;
			this.vistaActual = null;

		} catch (Exception e) {

			IConstantes.log.error(e, e);

		}

	}

	
	/**
	 * Cancela la transacción de una bolsa
	 * @param aVista
	 */
	public void cancelarBolsaTransaccion(String aVista) {
		try {

			this.bolsaTransaccion = new Bolsa();
			this.bolsas = null;
			this.getBolsas();

			if (aVista != null && aVista.equals("MODAL_EDITAR_BOLSA")) {
				this.cerrarModal("panelEdicionArbolito");

			} else if (aVista != null && aVista.equals("MODAL_ELIMINAR_BOLSA")) {
				this.cerrarModal("panelEliminacionArbolito");

			} else {
				this.vistaActual = null;

			}

		} catch (Exception e) {

			IConstantes.log.error(e, e);

		}

	}

	/**
	 * Este método borra el formulario de edición de un arbolito en transacción
	 */
	public void cancelarArbolitoTransaccion(String aVista) {
		try {

			this.arbolitoTransaccion = new Arbolito();
			this.arbolitos = null;
			this.fotosArbolito = null;
			this.getArbolitos();
			this.file = null;

			if (aVista != null && aVista.equals("MODAL_EDITAR_ARBOLITO")) {
				this.cerrarModal("panelEdicionArbolito");

			} else if (aVista != null && aVista.equals("MODAL_ELIMINAR_ARBOLITO")) {
				this.cerrarModal("panelEliminacionArbolito");

			} else {
				this.vistaActual = null;

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

			this.tipoAsignacion = null;

			this.fotoAdopcion = null;
			this.fotoArbolitoTransaccion = null;
			this.fotosAdopciones = null;

			if (aVista != null && aVista.equals("PERSONALIZAR_ARBOLITO")) {
				this.historicoTransaccion = aPersonalizado;
				this.abrirModal("panelPersonalizacionArbolito");

			} else if (aVista != null && aVista.equals("REGALAR_ARBOLITO")) {
				this.historicoTransaccion = aPersonalizado;
				this.abrirModal("panelRegalarArbolito");

			} else if (aVista != null && aVista.equals("ASIGNAR_LOTE")) {
				this.historicoTransaccion = aPersonalizado;
				this.abrirModal("panelAsignarLote");

			} else if (aVista != null && aVista.equals("CAMBIAR_ESTADO")) {
				this.historicoTransaccion = aPersonalizado;
				this.abrirModal("panelCambiarEstado");

			} else if (aVista != null && aVista.equals("REEMPLAZAR_ARBOLITO")) {
				this.historicoTransaccion = aPersonalizado;
				this.abrirModal("panelReemplazarArbolito");

			} else if (aVista != null && aVista.equals("CAMBIAR_ESTADO_MASIVO")) {
				this.historicoTransaccion = new HistoricoArbolitoVendido();
				this.abrirModal("panelCambiarEstadoMasivo");

			} else if (aVista != null && aVista.equals("ASIGNAR_LOTE_MASIVO")) {
				this.historicoTransaccion = new HistoricoArbolitoVendido();
				this.abrirModal("panelAsignarLoteMasivo");

			} else if (aVista != null && aVista.equals("VISTA_FOTOS")) {
				this.historicoTransaccion = aPersonalizado;
				this.vistaActual = aVista;

			}

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}

	}

	/**
	 * Asigna una foto de arbolito para realizar una acción
	 * 
	 * @param aArbolito
	 * @param aVista
	 */
	public void asignarFotoArbolito(FotoArbolito aFoto, String aVista) {

		try {

			this.fotoArbolitoTransaccion = aFoto;

			if (aVista != null && aVista.equals("MODAL_EDITAR_FOTO")) {
				this.abrirModal("panelEdicionFoto");

			} else {

				this.abrirModal("panelEliminacionFoto");

			}

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}

	}

	/**
	 * Asigna una bolsa para ser editada o eliminada
	 * 
	 * @param aBolsa
	 * @param aVista
	 */
	public void asignarBolsa(Bolsa aBolsa, String aVista) {

		try {

			this.bolsaTransaccion = aBolsa;

			if (aVista != null && aVista.equals("MODAL_EDITAR_BOLSA")) {
				this.abrirModal("panelEdicionArbolito");

			} else {

				this.abrirModal("panelEliminacionArbolito");

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
	public void asignarArbolito(Arbolito aArbolito, String aVista) {

		try {

			this.arbolitoTransaccion = aArbolito;
			this.fotoArbolito = null;
			this.fotoArbolitoTransaccion = null;
			this.fotosArbolito = null;

			if (aVista != null && aVista.equals("VISTA_FOTOS")) {
				this.vistaActual = aVista;

			} else if (aVista != null && aVista.equals("MODAL_EDITAR_ARBOLITO")) {
				this.abrirModal("panelEdicionArbolito");

			} else {

				this.abrirModal("panelEliminacionArbolito");

			}

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}

	}

	/**
	 * Obtiene un listado de arbolitos
	 * 
	 * @return arbolitos
	 */
	public List<Arbolito> getArbolitos() {
		try {
			if (this.arbolitos == null) {

				this.arbolitos = IConsultasDAO.getArbolitos(null);
				this.totales = new HashMap<String, Object>();

				this.totales.put("cantidadDisponible", new Integer(0));
				this.totales.put("cantidadReemplazada", new Integer(0));
				this.totales.put("arbolitosVendidos", new Integer(0));
				this.totales.put("pendientePago", new Integer(0));
				this.totales.put("precioCOP", new BigDecimal(0));
				this.totales.put("precioUS", new BigDecimal(0));

				if (this.arbolitos != null && this.arbolitos.size() > 0) {
					for (Arbolito a : this.arbolitos) {
						this.totales.put("cantidadDisponible", ((Integer) this.totales.get("cantidadDisponible")) + a.getCantidadDisponible().intValue());
						this.totales.put("cantidadReemplazada", ((Integer) this.totales.get("cantidadReemplazada")) + a.getCantidadUsadaReemplazos().intValue());
						this.totales.put("arbolitosVendidos", ((Integer) this.totales.get("arbolitosVendidos")) + a.getCantidadVendida().intValue());
						this.totales.put("pendientePago", ((Integer) this.totales.get("pendientePago")) + a.getCantidadPendientePago().intValue());
						this.totales.put("precioCOP", ((BigDecimal) this.totales.get("precioCOP")).add(a.getPrecioVentaPesosConIva()));
						this.totales.put("precioUS", ((BigDecimal) this.totales.get("precioUS")).add(a.getPrecioVentaUSConIva()));
					}
				}

			}
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return arbolitos;
	}

	/**
	 * Establece un listado de arbolitos
	 * 
	 * @param arbolitos
	 */
	public void setArbolitos(List<Arbolito> arbolitos) {
		this.arbolitos = arbolitos;
	}

	/**
	 * Obtiene un listado de bolsas de arbolitos
	 * 
	 * @return bolsas
	 */
	public List<Bolsa> getBolsas() {
		try {
			if (this.bolsas == null) {

				this.bolsas = IConsultasDAO.getBolsas(null);
				this.totales = new HashMap<String, Object>();

				this.totales.put("cantidad", new Integer(0));
				this.totales.put("bolsasUsadas", new Integer(0));

				if (this.bolsas != null && this.bolsas.size() > 0) {
					for (Bolsa a : this.bolsas) {
						this.totales.put("cantidad", ((Integer) this.totales.get("cantidad")) + a.getCantidadDisponible().intValue());
						this.totales.put("bolsasUsadas", ((Integer) this.totales.get("bolsasUsadas")) + a.getCantidadVendida().intValue());

					}
				}

			}
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return bolsas;
	}

	/**
	 * Establece un listado de bolsas de arbolitos
	 * 
	 * @param bolsas
	 */
	public void setBolsas(List<Bolsa> bolsas) {
		this.bolsas = bolsas;
	}

	/**
	 * Obtiene las fotos de un arbolito
	 * 
	 * @return fotosArbolito
	 */
	public List<FotoArbolito> getFotosArbolito() {
		try {
			AdministrarSesionCliente sesion = new AdministrarSesionCliente();

			if (this.fotosArbolito == null) {
				FotoArbolito foto = new FotoArbolito();
				foto.setArbolito(this.arbolitoTransaccion);
				this.fotosArbolito = IConsultasDAO.getFotosArbolitos(foto);

				if (this.fotoArbolito != null && this.fotosArbolito.size() > 0) {
					for (FotoArbolito f : this.fotosArbolito) {
						sesion.guardarImagenEnDisco(f.getId(), f.getFotoDecofificada());
						f.setFotoDecofificada("arbolito" + f.getId() + ".png");

					}
				}

			}
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return fotosArbolito;
	}

	/**
	 * Establece las fotos de un arbolito
	 * 
	 * @param fotosArbolito
	 */
	public void setFotosArbolito(List<FotoArbolito> fotosArbolito) {
		this.fotosArbolito = fotosArbolito;
	}

	/**
	 * Obtiene fotos de las adopciones hechas a los arbolitos
	 * 
	 * @return fotosArbolito
	 */
	public List<FotoArbolito> getFotosAdopciones() {
		try {
			AdministrarSesionCliente sesion = new AdministrarSesionCliente();
			if (this.fotosAdopciones == null) {
				FotoArbolito foto = new FotoArbolito();
				foto.setHistoricoArbolitoVendido(this.historicoTransaccion);
				this.fotosAdopciones = IConsultasDAO.getFotosArbolitos(foto);
				if (this.fotosAdopciones != null && this.fotosAdopciones.size() > 0) {
					for (FotoArbolito f : this.fotosAdopciones) {
						sesion.guardarImagenEnDisco(f.getId(), f.getFotoDecofificada());
						f.setFotoDecofificada("arbolito" + f.getId() + ".png");

					}
				}

			}
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return fotosAdopciones;
	}

	public void setFotosAdopciones(List<FotoArbolito> fotosAdopciones) {
		this.fotosAdopciones = fotosAdopciones;
	}

	/**
	 * Obtiene los lotes a asignar disponibles
	 * 
	 * @return itemsLotes
	 */
	public List<SelectItem> getItemsLotesManualesMasivo() {
		List<SelectItem> itemsDisponibles = null;
		try {

			itemsDisponibles = new ArrayList<SelectItem>();
			itemsDisponibles.add(new SelectItem("", this.getMensaje("comboVacio")));

			List<Lote> lotes = IConsultasDAO.getLotesDiscriminados(null);

			if (lotes != null && lotes.size() > 0) {
				for (Lote p : lotes) {
					if (p.getIndicativoInfinito() != null && p.getIndicativoInfinito().equals(IConstantes.AFIRMACION)) {
						itemsDisponibles.add(new SelectItem(p.getNombreLote(), p.getNombreLote()));
					} else {
						itemsDisponibles.add(new SelectItem(p.getNombreLote(), p.getNombreLote()));
					}
				}
			}

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return itemsDisponibles;
	}

	/**
	 * Obtiene los lotes a asignar disponibles
	 * 
	 * @return itemsLotes
	 */
	public List<SelectItem> getItemsLotesManuales() {
		List<SelectItem> itemsDisponibles = null;
		try {

			itemsDisponibles = new ArrayList<SelectItem>();
			itemsDisponibles.add(new SelectItem("", this.getMensaje("comboVacio")));
			Lote lote = new Lote();
			lote.getArbolito().setId(this.historicoTransaccion.getArbolito().getId());
			List<Lote> lotes = IConsultasDAO.getLotes(lote);

			if (lotes != null && lotes.size() > 0) {
				for (Lote p : lotes) {
					if (p.getIndicativoInfinito() != null && p.getIndicativoInfinito().equals(IConstantes.AFIRMACION)) {
						itemsDisponibles.add(new SelectItem(p.getId(), p.getNombreLote() + " " + this.getMensaje("disponibilidadInfinita", "" + p.getCantidadDisponible())));
					} else {
						itemsDisponibles.add(new SelectItem(p.getId(), p.getNombreLote() + " " + this.getMensaje("arbolesDisponibles", "" + p.getCantidadDisponible())));
					}
				}
			}

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return itemsDisponibles;
	}

	/**
	 * Obtiene items de estados vigentes
	 */
	public List<SelectItem> getItemsEstados() {
		try {

			this.itemsEstados = new ArrayList<SelectItem>();
			this.itemsEstados.add(new SelectItem("", this.getMensaje("comboVacio")));

			Estado estado = new Estado();
			estado.setEstadoVigencia(IConstantes.ACTIVO);
			List<Estado> estados = IConsultasDAO.getEstados(estado);

			if (estados != null && estados.size() > 0) {
				estados.forEach(p -> this.itemsEstados.add(new SelectItem(p.getId(), p.getTituloEstado())));
			}

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return itemsEstados;
	}

	public void setItemsEstados(List<SelectItem> itemsEstados) {
		this.itemsEstados = itemsEstados;
	}

	/**
	 * Obtiene los items de cambio de estado para uno en particular
	 * 
	 * @return items
	 */
	public List<SelectItem> getItemsEstadosCambio() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		try {

			items.add(new SelectItem("", this.getMensaje("comboVacio")));

			Estado estado = new Estado();
			estado.setEstadoVigencia(IConstantes.ACTIVO);
			List<Estado> estados = IConsultasDAO.getEstados(estado);

			if (estados != null && estados.size() > 0) {
				for (Estado p : estados) {

					items.add(new SelectItem(p.getId(), p.getTituloEstado()));
				}
			}

			if (this.historicoTransaccion != null && this.historicoTransaccion.getEstado() != null && this.historicoTransaccion.getEstado().getEstadoVigencia() != null && this.historicoTransaccion.getEstado().getEstadoVigencia().equals(IConstantes.INACTIVO)) {
				items.add(new SelectItem(this.historicoTransaccion.getEstado().getId(), this.historicoTransaccion.getEstado().getTituloEstado()));
			}

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return items;
	}

	/**
	 * Obtiene los items de los estados de un arbolito
	 * 
	 * @return itemsEstadosConsulta
	 */
	public List<SelectItem> getItemsEstadosConsulta() {
		try {

			this.itemsEstadosConsulta = new ArrayList<SelectItem>();
			this.itemsEstadosConsulta.add(new SelectItem("", this.getMensaje("comboVacio")));

			List<Estado> estados = IConsultasDAO.getEstados(null);

			if (estados != null && estados.size() > 0) {
				estados.forEach(p -> this.itemsEstadosConsulta.add(new SelectItem(p.getId(), p.getTituloEstado())));
			}

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return itemsEstadosConsulta;
	}

	public void setItemsEstadosConsulta(List<SelectItem> itemsEstadosConsulta) {
		this.itemsEstadosConsulta = itemsEstadosConsulta;
	}

	/**
	 * Obtiene los lotes por items
	 * 
	 * @return itemsLotes
	 */
	public List<SelectItem> getItemsLotes() {
		try {

			this.itemsLotes = new ArrayList<SelectItem>();
			this.itemsLotes.add(new SelectItem("", this.getMensaje("comboVacio")));
			this.itemsLotes.add(new SelectItem("-1", this.getMensaje("sinLoteAsignado")));

			List<Lote> lotes = IConsultasDAO.getLotesDiscriminados(null);

			if (lotes != null && lotes.size() > 0) {
				lotes.forEach(p -> this.itemsLotes.add(new SelectItem(p.getNombreLote(), p.getNombreLote())));
			}

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return itemsLotes;
	}

	public void setItemsLotes(List<SelectItem> itemsLotes) {
		this.itemsLotes = itemsLotes;
	}

	// get/sets

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

	public void setArbolito(Arbolito arbolito) {
		this.arbolito = arbolito;
	}

	public Arbolito getArbolitoTransaccion() {
		try {
			if (this.arbolitoTransaccion == null) {
				this.arbolitoTransaccion = new Arbolito();
			}
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return arbolitoTransaccion;
	}

	public void setArbolitoTransaccion(Arbolito arbolitoTransaccion) {
		this.arbolitoTransaccion = arbolitoTransaccion;
	}

	public FotoArbolito getFotoArbolito() {
		try {
			if (this.fotoArbolito == null) {
				this.fotoArbolito = new FotoArbolito();
				this.fotoArbolito.setArbolito(this.arbolitoTransaccion);
			}
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return fotoArbolito;
	}

	public void setFotoArbolito(FotoArbolito fotoArbolito) {
		this.fotoArbolito = fotoArbolito;
	}

	public FotoArbolito getFotoAdopcion() {
		try {
			if (this.fotoAdopcion == null) {
				this.fotoAdopcion = new FotoArbolito();
				this.fotoAdopcion.setHistoricoArbolitoVendido(this.historicoTransaccion);
			}
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return fotoAdopcion;
	}

	public void setFotoAdopcion(FotoArbolito fotoAdopcion) {
		this.fotoAdopcion = fotoAdopcion;
	}

	public FotoArbolito getFotoArbolitoTransaccion() {
		try {
			if (this.fotoArbolitoTransaccion == null) {
				this.fotoArbolitoTransaccion = new FotoArbolito();
			}
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return fotoArbolitoTransaccion;
	}

	public void setFotoArbolitoTransaccion(FotoArbolito fotoArbolitoTransaccion) {
		this.fotoArbolitoTransaccion = fotoArbolitoTransaccion;
	}

	public String getVistaActual() {
		return vistaActual;
	}

	public void setVistaActual(String vistaActual) {
		this.vistaActual = vistaActual;
	}

	public Map<String, Object> getTotales() {
		return totales;
	}

	public void setTotales(Map<String, Object> totales) {
		this.totales = totales;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public HistoricoArbolitoVendido getHistorico() {
		try {
			if (this.historico == null) {
				this.historico = new HistoricoArbolitoVendido();
			}
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return historico;
	}

	public void setHistorico(HistoricoArbolitoVendido historico) {
		this.historico = historico;
	}

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

	public void setHistoricoTransaccion(HistoricoArbolitoVendido historicoTransaccion) {
		this.historicoTransaccion = historicoTransaccion;
	}

	public List<HistoricoArbolitoVendido> getHistoricos() {
		return historicos;
	}

	public void setHistoricos(List<HistoricoArbolitoVendido> historicos) {
		this.historicos = historicos;
	}

	public String getTipoAsignacion() {
		return tipoAsignacion;
	}

	public void setTipoAsignacion(String tipoAsignacion) {
		this.tipoAsignacion = tipoAsignacion;
	}

	public Integer getNumeroSinLote() {
		return numeroSinLote;
	}

	public void setNumeroSinLote(Integer numeroSinLote) {
		this.numeroSinLote = numeroSinLote;
	}

	public Bolsa getBolsa() {
		try {
			if (this.bolsa == null) {
				this.bolsa = new Bolsa();
			}
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return bolsa;
	}

	public void setBolsa(Bolsa bolsa) {
		this.bolsa = bolsa;
	}

	public Bolsa getBolsaTransaccion() {
		try {
			if (this.bolsaTransaccion == null) {
				this.bolsaTransaccion = new Bolsa();
			}
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return bolsaTransaccion;
	}

	public void setBolsaTransaccion(Bolsa bolsaTransaccion) {
		this.bolsaTransaccion = bolsaTransaccion;
	}

}
