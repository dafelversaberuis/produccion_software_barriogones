package fundacionFRC.modulos.tablasSoporte;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import fundacionFRC.Conexion;
import fundacionFRC.beans.Arbolito;
import fundacionFRC.beans.Bolsa;
import fundacionFRC.beans.Convenio;
import fundacionFRC.beans.Estado;
import fundacionFRC.beans.Iva;
import fundacionFRC.generales.ConsultarFuncionesAPI;
import fundacionFRC.generales.IConstantes;
import fundacionFRC.modulos.IConsultasDAO;

@ManagedBean
@ViewScoped
public class HacerMantenimiento extends ConsultarFuncionesAPI implements Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -1584716337727865469L;

	private Iva								iva;
	private Iva								ivaTransaccion;
	private Convenio					convenio;
	private Convenio					convenioTransaccion;

	private Estado						estado;
	private Estado						estadoTransaccion;

	private List<Iva>					ivas;
	private List<Convenio>		convenios;
	private List<SelectItem>	itemsIva;
	private List<SelectItem>	itemsConvenios;
	private List<SelectItem>	itemsConveniosVenta;
	private List<Estado>			estados;

	// privados

	/**
	 * Valida un estado
	 * 
	 * @param aTransaccion
	 * @return
	 */
	private boolean isValidoEstado(String aTransaccion) {
		boolean ok = true;

		if (aTransaccion.equals("C")) {
			if (this.estados != null && this.estados.size() > 0 && this.estados.stream().anyMatch(i -> this.estado.getEstadoInicial().equals(IConstantes.AFIRMACION) && i.getEstadoInicial().equals(IConstantes.AFIRMACION))) {
				ok = false;
				this.mostrarMensajeGlobal("estadoInicialExistente", "advertencia");
			}

			if (this.isVacio(this.estado.getTituloEstado())) {
				ok = false;
				this.mostrarMensajeGlobal("nombreVacio", "advertencia");
			}

		} else {
			if (this.estados != null && this.estados.size() > 0 && this.estados.stream().anyMatch(i -> this.estadoTransaccion.getEstadoInicial().equals(IConstantes.AFIRMACION) && i.getId() != this.estadoTransaccion.getId() && i.getEstadoInicial().equals(IConstantes.AFIRMACION))) {
				ok = false;
				this.mostrarMensajeGlobal("estadoInicialExistente", "advertencia");
			}

			if (this.isVacio(this.estadoTransaccion.getTituloEstado())) {
				ok = false;
				this.mostrarMensajeGlobal("nombreVacio", "advertencia");
			}
		}

		return ok;
	}

	/**
	 * Validaciones de iva
	 * 
	 * @param aTransaccion
	 * @return ok
	 */
	private boolean isValidoIva(String aTransaccion) {
		boolean ok = true;

		if (aTransaccion.equals("C")) {
			if (this.ivas != null && this.ivas.size() > 0 && this.ivas.stream().anyMatch(i -> i.getValorIva().equals(this.iva.getValorIva()))) {
				ok = false;
				this.mostrarMensajeGlobal("valorIvaExistente", "advertencia");
			}
			if (this.isVacio(this.iva.getNombre())) {
				ok = false;
				this.mostrarMensajeGlobal("nombreVacio", "advertencia");
			}
		} else {
			if (this.ivas != null && this.ivas.size() > 0 && this.ivas.stream().anyMatch(i -> i.getId() != this.ivaTransaccion.getId() && i.getValorIva().equals(this.ivaTransaccion.getValorIva()))) {
				ok = false;
				this.mostrarMensajeGlobal("valorIvaExistente", "advertencia");
			}
			if (this.isVacio(this.ivaTransaccion.getNombre())) {
				ok = false;
				this.mostrarMensajeGlobal("nombreVacio", "advertencia");
			}
		}

		return ok;
	}

	/**
	 * Determina si es válido un convenio
	 * 
	 * @param aTransaccion
	 * @return ok
	 */
	private boolean isValidoConvenio(String aTransaccion) {
		boolean ok = true;

		if (aTransaccion.equals("C")) {

			if (this.isVacio(this.convenio.getNombre())) {
				ok = false;
				this.mostrarMensajeGlobal("nombreVacio", "advertencia");
			}

			if (this.isVacio(this.convenio.getTelefonos())) {
				ok = false;
				this.mostrarMensajeGlobal("telefonosVacio", "advertencia");
			}

			if (this.isVacio(this.convenio.getEncargado())) {
				ok = false;
				this.mostrarMensajeGlobal("encargadoVacio", "advertencia");
			}

		} else {

			if (this.isVacio(this.convenioTransaccion.getNombre())) {
				ok = false;
				this.mostrarMensajeGlobal("nombreVacio", "advertencia");
			}

			if (this.isVacio(this.convenioTransaccion.getTelefonos())) {
				ok = false;
				this.mostrarMensajeGlobal("telefonosVacio", "advertencia");
			}

			if (this.isVacio(this.convenioTransaccion.getEncargado())) {
				ok = false;
				this.mostrarMensajeGlobal("encargadoVacio", "advertencia");
			}
		}

		return ok;
	}

	// publicos

	/**
	 * Crea un estado para los arbolitos
	 */
	public void crearEstado() {
		Conexion conexion = new Conexion();

		try {
			if (isValidoEstado("C")) {
				conexion.setAutoCommitBD(false);

				this.estado.setEstadoVigencia(IConstantes.ACTIVO);
				this.estado.setTituloEstado(this.getSinEspacios(this.estado.getTituloEstado()));
				this.estado.getCamposBD();
				conexion.insertarBD(this.estado.getEstructuraTabla().getTabla(), this.estado.getEstructuraTabla().getPersistencia());
				conexion.commitBD();
				this.mostrarMensajeGlobal("creacionExitosa", "exito");

				// reseteo de variables
				this.estado = null;
				this.getEstado();
				this.estados = null;
				this.getEstados();
			}

		} catch (Exception e) {
			conexion.rollbackBD();
			this.mostrarMensajeGlobal("transaccionFallida", "error");
		} finally {
			conexion.cerrarConexion();
		}

	}

	/**
	 * Edita un registro de estado
	 */
	public void editarEstado() {
		Conexion conexion = new Conexion();

		try {
			if (isValidoEstado("E")) {
				conexion.setAutoCommitBD(false);

				this.estadoTransaccion.setTituloEstado(this.getSinEspacios(this.estadoTransaccion.getTituloEstado()));

				this.estadoTransaccion.getCamposBD();
				conexion.actualizarBD(this.estadoTransaccion.getEstructuraTabla().getTabla(), this.estadoTransaccion.getEstructuraTabla().getPersistencia(), this.estadoTransaccion.getEstructuraTabla().getLlavePrimaria(), null);
				conexion.commitBD();
				this.mostrarMensajeGlobal("edicionExitosa", "exito");
				this.cerrarModal("panelEdicionEstado");

				// reseteo de variables
				this.estadoTransaccion = null;
				this.getEstadoTransaccion();
				this.estados = null;
				this.getEstados();
			}

		} catch (Exception e) {
			conexion.rollbackBD();
			this.mostrarMensajeGlobal("transaccionFallida", "error");
		} finally {
			conexion.cerrarConexion();
		}

	}

	/**
	 * Elimina un registro de estado
	 */
	public void eliminarEstado() {

		Conexion conexion = new Conexion();
		try {

			conexion.setAutoCommitBD(false);
			this.estadoTransaccion.getCamposBD();
			conexion.eliminarBD(this.estadoTransaccion.getEstructuraTabla().getTabla(), this.estadoTransaccion.getEstructuraTabla().getLlavePrimaria());
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
		this.estadoTransaccion = null;
		this.estados = null;
		this.getEstados();

	}

	/**
	 * Crea un nuevo registro de convenio
	 */
	public void crearConvenio() {
		Conexion conexion = new Conexion();

		try {
			if (isValidoConvenio("C")) {
				conexion.setAutoCommitBD(false);

				this.convenio.setNombre(this.getSinEspacios(this.convenio.getNombre()));
				this.convenio.setTelefonos(this.getSinEspacios(this.convenio.getTelefonos()));
				this.convenio.setEncargado(this.getSinEspacios(this.convenio.getEncargado()));

				this.convenio.getCamposBD();
				conexion.insertarBD(this.convenio.getEstructuraTabla().getTabla(), this.convenio.getEstructuraTabla().getPersistencia());
				conexion.commitBD();
				this.mostrarMensajeGlobal("creacionExitosa", "exito");

				// reseteo de variables
				this.convenio = null;
				this.getConvenio();
				this.convenios = null;
				this.getConvenios();
			}

		} catch (Exception e) {
			conexion.rollbackBD();
			this.mostrarMensajeGlobal("transaccionFallida", "error");
		} finally {
			conexion.cerrarConexion();
		}

	}

	/**
	 * Crea un nuevo registro de iva
	 */
	public void crearIva() {
		Conexion conexion = new Conexion();

		try {
			if (isValidoIva("C")) {
				conexion.setAutoCommitBD(false);

				this.iva.setNombre(this.getSinEspacios(this.iva.getNombre()));

				this.iva.getCamposBD();
				conexion.insertarBD(this.iva.getEstructuraTabla().getTabla(), this.iva.getEstructuraTabla().getPersistencia());
				conexion.commitBD();
				this.mostrarMensajeGlobal("creacionExitosa", "exito");

				// reseteo de variables
				this.iva = null;
				this.getIva();
				this.ivas = null;
				this.getIvas();
			}

		} catch (Exception e) {
			conexion.rollbackBD();
			this.mostrarMensajeGlobal("transaccionFallida", "error");
		} finally {
			conexion.cerrarConexion();
		}

	}

	/**
	 * Edita un registro de convenio
	 */
	public void editarConvenio() {
		Conexion conexion = new Conexion();

		try {
			if (isValidoConvenio("E")) {
				conexion.setAutoCommitBD(false);
				this.convenioTransaccion.setNombre(this.getSinEspacios(this.convenioTransaccion.getNombre()));
				this.convenioTransaccion.setTelefonos(this.getSinEspacios(this.convenioTransaccion.getTelefonos()));
				this.convenioTransaccion.setEncargado(this.getSinEspacios(this.convenioTransaccion.getEncargado()));

				this.convenioTransaccion.getCamposBD();
				conexion.actualizarBD(this.convenioTransaccion.getEstructuraTabla().getTabla(), this.convenioTransaccion.getEstructuraTabla().getPersistencia(), this.convenioTransaccion.getEstructuraTabla().getLlavePrimaria(), null);

				conexion.commitBD();
				this.mostrarMensajeGlobal("edicionExitosa", "exito");
				this.cerrarModal("panelEdicionConvenio");

				// reseteo de variables
				this.convenioTransaccion = null;
				this.getConvenioTransaccion();
				this.convenios = null;
				this.getConvenios();
			}

		} catch (Exception e) {
			conexion.rollbackBD();
			this.mostrarMensajeGlobal("transaccionFallida", "error");
		} finally {
			conexion.cerrarConexion();
		}

	}

	/**
	 * Edita un registro de iva
	 */
	public void editarIva() {
		Conexion conexion = new Conexion();
		Arbolito arbolito = null;
		Bolsa bolsa = null;
		List<Arbolito> arbolitos = null;
		List<Bolsa> bolsas = null;
		try {
			if (isValidoIva("E")) {
				conexion.setAutoCommitBD(false);
				this.ivaTransaccion.setNombre(this.getSinEspacios(this.ivaTransaccion.getNombre()));

				this.ivaTransaccion.getCamposBD();
				conexion.actualizarBD(this.ivaTransaccion.getEstructuraTabla().getTabla(), this.ivaTransaccion.getEstructuraTabla().getPersistencia(), this.ivaTransaccion.getEstructuraTabla().getLlavePrimaria(), null);

				// actualiza los precios de los arbolitos existentes, pues
				arbolito = new Arbolito();
				arbolito.setIva(this.ivaTransaccion);
				arbolitos = IConsultasDAO.getArbolitos(arbolito);

				if (arbolitos != null && arbolitos.size() > 0) {
					for (Arbolito a : arbolitos) {

						// puede ser que se cambió el valor del iva
						a.getIva().setValorIva(this.ivaTransaccion.getValorIva());

						a.setIvaPesos(this.getValorRedondeado(a.getPrecioVentaPesos().multiply(a.getIva().getValorIva()).divide(new BigDecimal(100)), IConstantes.DECIMALES_REDONDEAR));
						a.setIvaUs(this.getValorRedondeado(a.getPrecioVentaUS().multiply(a.getIva().getValorIva()).divide(new BigDecimal(100)), IConstantes.DECIMALES_REDONDEAR));
						a.setPrecioVentaPesosConIva(this.getValorRedondeado(a.getPrecioVentaPesos().add(a.getIvaPesos()), IConstantes.DECIMALES_REDONDEAR));
						a.setPrecioVentaUSConIva(this.getValorRedondeado(a.getPrecioVentaUS().add(a.getIvaUs()), IConstantes.DECIMALES_REDONDEAR));

						Map<String, Object> camposActualizar = new HashMap<String, Object>();
						camposActualizar.put("valor_iva_cop", a.getIvaPesos());
						camposActualizar.put("valor_iva_us", a.getIvaUs());
						camposActualizar.put("precio_cop_con_iva", a.getPrecioVentaPesosConIva());
						camposActualizar.put("precio_us_con_iva", a.getPrecioVentaUSConIva());
						a.getCamposBD();
						conexion.actualizarBD(a.getEstructuraTabla().getTabla(), camposActualizar, a.getEstructuraTabla().getLlavePrimaria(), null);

					}
				}
				
				
			// actualiza los precios de las bolsas disponibles
				bolsa = new Bolsa();
				bolsa.setIva(this.ivaTransaccion);
				bolsas = IConsultasDAO.getBolsas(bolsa);

				if (bolsas != null && bolsas.size() > 0) {
					for (Bolsa a : bolsas) {

						// puede ser que se cambió el valor del iva
						a.getIva().setValorIva(this.ivaTransaccion.getValorIva());

						a.setIvaPesos(this.getValorRedondeado(a.getPrecioVentaPesos().multiply(a.getIva().getValorIva()).divide(new BigDecimal(100)), IConstantes.DECIMALES_REDONDEAR));
						a.setIvaUs(this.getValorRedondeado(a.getPrecioVentaUS().multiply(a.getIva().getValorIva()).divide(new BigDecimal(100)), IConstantes.DECIMALES_REDONDEAR));
						a.setPrecioVentaPesosConIva(this.getValorRedondeado(a.getPrecioVentaPesos().add(a.getIvaPesos()), IConstantes.DECIMALES_REDONDEAR));
						a.setPrecioVentaUSConIva(this.getValorRedondeado(a.getPrecioVentaUS().add(a.getIvaUs()), IConstantes.DECIMALES_REDONDEAR));

						Map<String, Object> camposActualizar = new HashMap<String, Object>();
						camposActualizar.put("valor_iva_cop", a.getIvaPesos());
						camposActualizar.put("valor_iva_us", a.getIvaUs());
						camposActualizar.put("precio_cop_con_iva", a.getPrecioVentaPesosConIva());
						camposActualizar.put("precio_us_con_iva", a.getPrecioVentaUSConIva());
						a.getCamposBD();
						conexion.actualizarBD(a.getEstructuraTabla().getTabla(), camposActualizar, a.getEstructuraTabla().getLlavePrimaria(), null);

					}
				}
				
				

				conexion.commitBD();
				this.mostrarMensajeGlobal("edicionExitosa", "exito");
				this.cerrarModal("panelEdicionIva");

				// reseteo de variables
				this.ivaTransaccion = null;
				this.getIvaTransaccion();
				this.ivas = null;
				this.getIvas();
			}

		} catch (Exception e) {
			conexion.rollbackBD();
			this.mostrarMensajeGlobal("transaccionFallida", "error");
		} finally {
			conexion.cerrarConexion();
		}

	}

	/**
	 * Elimina un registro de convenio
	 */
	public void eliminarConvenio() {

		Conexion conexion = new Conexion();
		try {

			conexion.setAutoCommitBD(false);
			this.convenioTransaccion.getCamposBD();
			conexion.eliminarBD(this.convenioTransaccion.getEstructuraTabla().getTabla(), this.convenioTransaccion.getEstructuraTabla().getLlavePrimaria());
			conexion.commitBD();
			this.mostrarMensajeGlobal("eliminacionExitosa", "exito");

			this.convenios = null;
			this.getConvenios();

		} catch (Exception e) {
			conexion.rollbackBD();
			this.mostrarMensajeGlobal("transaccionFallida", "error");
			this.mostrarMensajeGlobal("eliminacionFallida", "error");

		} finally {
			conexion.cerrarConexion();
		}

		// reseteo de variables
		this.ivaTransaccion = null;
		this.ivas = null;
		this.getIvas();

	}

	/**
	 * Elimina un registro de iva
	 */
	public void eliminarIva() {

		Conexion conexion = new Conexion();
		try {

			conexion.setAutoCommitBD(false);
			this.ivaTransaccion.getCamposBD();
			conexion.eliminarBD(this.ivaTransaccion.getEstructuraTabla().getTabla(), this.ivaTransaccion.getEstructuraTabla().getLlavePrimaria());
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
		this.ivaTransaccion = null;
		this.ivas = null;
		this.getIvas();

	}

	/**
	 * Este método borra el formulario de creación de un convenio
	 */
	public void cancelarConvenio() {

		try {
			this.convenio = new Convenio();

			this.convenios = null;
			this.getConvenios();
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}

	}

	/**
	 * Este método borra el formulario de creación de un iva
	 */
	public void cancelarIva() {

		try {
			this.iva = new Iva();

			this.ivas = null;
			this.getIvas();
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}

	}

	/**
	 * Este método borra el formulario de edición de un iva en transacción
	 */
	public void cancelarIvaTransaccion(String aVista) {
		try {

			this.ivaTransaccion = new Iva();
			this.ivas = null;
			this.getIvas();

			if (aVista != null && aVista.equals("MODAL_EDITAR_IVA")) {
				this.cerrarModal("panelEdicionIva");

			} else if (aVista != null && aVista.equals("MODAL_ELIMINAR_IVA")) {
				this.cerrarModal("panelEliminacionIva");

			}

		} catch (Exception e) {

			IConstantes.log.error(e, e);

		}

	}

	/**
	 * Este método borra el formulario de edición de un convenio en transacción
	 */
	public void cancelarConvenioTransaccion(String aVista) {
		try {

			this.convenioTransaccion = new Convenio();
			this.convenios = null;
			this.getConvenios();

			if (aVista != null && aVista.equals("MODAL_EDITAR_CONVENIO")) {
				this.cerrarModal("panelEdicionConvenio");

			} else if (aVista != null && aVista.equals("MODAL_ELIMINAR_CONVENIO")) {
				this.cerrarModal("panelEliminacionConvenio");

			}

		} catch (Exception e) {

			IConstantes.log.error(e, e);

		}

	}

	/**
	 * Asigna un con convenio para una acción
	 * 
	 * @param aConvenio
	 * @param aVista
	 */
	public void asignarConvenio(Convenio aConvenio, String aVista) {

		try {

			this.convenioTransaccion = aConvenio;

			if (aVista != null && aVista.equals("MODAL_EDITAR_CONVENIO")) {
				this.abrirModal("panelEdicionConvenio");

			} else {

				this.abrirModal("panelEliminacionConvenio");

			}

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}

	}

	/**
	 * Asigna un iva para realizar una acción
	 * 
	 * @param aAgrupador
	 * @param aVista
	 */
	public void asignarIva(Iva aIva, String aVista) {

		try {

			this.ivaTransaccion = aIva;

			if (aVista != null && aVista.equals("MODAL_EDITAR_IVA")) {
				this.abrirModal("panelEdicionIva");

			} else {

				this.abrirModal("panelEliminacionIva");

			}

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}

	}

	/**
	 * Este método borra el formulario de creación de un estado
	 */
	public void cancelarEstado() {

		try {
			this.estado = new Estado();

			this.estados = null;
			this.getEstados();
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}

	}

	/**
	 * Este método borra el formulario de edición de un estado en transacción
	 */
	public void cancelarEstadoTransaccion(String aVista) {
		try {

			this.estadoTransaccion = null;
			this.estados = null;
			this.getEstados();

			if (aVista != null && aVista.equals("MODAL_EDITAR_ESTADO")) {
				this.cerrarModal("panelEdicionEstado");

			} else if (aVista != null && aVista.equals("MODAL_ELIMINAR_ESTADO")) {
				this.cerrarModal("panelEliminacionEstado");

			}

		} catch (Exception e) {

			IConstantes.log.error(e, e);

		}

	}

	/**
	 * Asigna un estado para realizar una acción
	 * 
	 * @param aEstado
	 * @param aVista
	 */
	public void asignarEstado(Estado aEstado, String aVista) {

		try {

			this.estadoTransaccion = aEstado;

			if (aVista != null && aVista.equals("MODAL_EDITAR_ESTADO")) {
				this.abrirModal("panelEdicionEstado");

			} else {

				this.abrirModal("panelEliminacionEstado");

			}

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}

	}

	/**
	 * Obtiene un listado de estados creados
	 * 
	 * @return estados
	 */
	public List<Estado> getEstados() {
		try {
			if (this.estados == null) {

				this.estados = IConsultasDAO.getEstados(null);

			}
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	/**
	 * Obtiene un listado de ivas creados
	 * 
	 * @return ivas
	 */
	public List<Iva> getIvas() {
		try {
			if (this.ivas == null) {

				this.ivas = IConsultasDAO.getIvas(null);

			}
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return ivas;
	}

	/**
	 * Establece los ivas creados
	 * 
	 * @param ivas
	 */
	public void setIvas(List<Iva> ivas) {
		this.ivas = ivas;
	}

	/**
	 * Obtiene items de iva
	 * 
	 * @return itemsIva
	 */
	public List<SelectItem> getItemsIva() {
		try {

			this.itemsIva = new ArrayList<SelectItem>();
			this.itemsIva.add(new SelectItem("", this.getMensaje("comboVacio")));

			this.ivas = null;
			this.getIvas();
			if (this.ivas != null && this.ivas.size() > 0) {
				this.ivas.forEach(p -> this.itemsIva.add(new SelectItem(p.getId(), p.getNombre() + "(" + p.getValorIva() + "%)")));
			}

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return itemsIva;
	}

	/**
	 * Establece item de iva
	 * 
	 * @param itemsIva
	 */
	public void setItemsIva(List<SelectItem> itemsIva) {
		this.itemsIva = itemsIva;
	}

	// get/sets

	public Iva getIva() {
		try {
			if (this.iva == null) {
				this.iva = new Iva();
			}
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return iva;
	}

	public void setIva(Iva iva) {
		this.iva = iva;
	}

	public Iva getIvaTransaccion() {
		return ivaTransaccion;
	}

	public void setIvaTransaccion(Iva ivaTransaccion) {
		this.ivaTransaccion = ivaTransaccion;
	}

	public Estado getEstado() {
		try {
			if (this.estado == null) {
				this.estado = new Estado();
			}
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Estado getEstadoTransaccion() {
		return estadoTransaccion;
	}

	public void setEstadoTransaccion(Estado estadoTransaccion) {
		this.estadoTransaccion = estadoTransaccion;
	}

	public Convenio getConvenio() {
		try {
			if (this.convenio == null) {
				this.convenio = new Convenio();
			}
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}

	public Convenio getConvenioTransaccion() {
		try {
			if (this.convenioTransaccion == null) {
				this.convenioTransaccion = new Convenio();
			}
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return convenioTransaccion;
	}

	public void setConvenioTransaccion(Convenio convenioTransaccion) {
		this.convenioTransaccion = convenioTransaccion;
	}

	/**
	 * Obtiene los convenios que se han hecho con las distintas entidades
	 * 
	 * @return convenios
	 */
	public List<Convenio> getConvenios() {
		try {
			if (this.convenios == null) {

				this.convenios = IConsultasDAO.getConvenios(null);

			}
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}

		return convenios;

	}

	public void setConvenios(List<Convenio> convenios) {
		this.convenios = convenios;
	}

	/**
	 * Obtiene los items de los convenios
	 * 
	 * @return itemsConvenios
	 */
	public List<SelectItem> getItemsConvenios() {
		try {

			this.itemsConvenios = new ArrayList<SelectItem>();
			this.itemsConvenios.add(new SelectItem("", this.getMensaje("comboVacio")));

			this.convenios = null;
			this.getConvenios();
			if (this.convenios != null && this.convenios.size() > 0) {
				this.convenios.forEach(p -> this.itemsConvenios.add(new SelectItem(p.getId(), p.getNombre() + "(" + p.getComision().getValorIva() + "%)")));
			}

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return itemsConvenios;
	}

	/**
	 * Establece los items de los convenios
	 * 
	 * @param itemsConvenios
	 */
	public void setItemsConvenios(List<SelectItem> itemsConvenios) {
		this.itemsConvenios = itemsConvenios;
	}

	/**
	 * Obtiene los itemns convenios de venta
	 * 
	 * @return itemsConveniosVenta
	 */
	public List<SelectItem> getItemsConveniosVenta() {
		try {

			this.itemsConveniosVenta = new ArrayList<SelectItem>();
			this.itemsConveniosVenta.add(new SelectItem("", this.getMensaje("comboVacio")));

			this.convenios = null;
			this.getConvenios();
			if (this.convenios != null && this.convenios.size() > 0) {
				this.convenios.forEach(p -> this.itemsConveniosVenta.add(new SelectItem(p.getId(), p.getNombre())));
			}

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return itemsConveniosVenta;
	}

	/**
	 * Establece los items convenios
	 * 
	 * @param itemsConveniosVenta
	 */
	public void setItemsConveniosVenta(List<SelectItem> itemsConveniosVenta) {
		this.itemsConveniosVenta = itemsConveniosVenta;
	}

}
