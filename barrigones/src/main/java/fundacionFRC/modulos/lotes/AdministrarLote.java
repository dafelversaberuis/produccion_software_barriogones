package fundacionFRC.modulos.lotes;

import java.io.Serializable;
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
import fundacionFRC.beans.FotoArbolito;
import fundacionFRC.beans.Lote;
import fundacionFRC.generales.ConsultarFuncionesAPI;
import fundacionFRC.generales.IConstantes;
import fundacionFRC.modulos.IConsultasDAO;
import fundacionFRC.modulos.arbolitos.AdministrarSesionCliente;

@ManagedBean
@ViewScoped
public class AdministrarLote extends ConsultarFuncionesAPI implements Serializable {

	/**
	 * 
	 */
	private static final long		serialVersionUID	= 1127633667645012226L;

	private String							vistaActual;
	private Lote								lote;
	private Lote								loteTransaccion;
	private FotoArbolito				fotoArbolito;
	private FotoArbolito				fotoArbolitoTransaccion;
	private UploadedFile				file;

	private List<Lote>					lotes;
	private List<FotoArbolito>	fotosArbolito;
	private List<SelectItem>		itemsArbolitos;
	private List<SelectItem>		itemsArbolitosDisponibles;
	private Map<String, Object>	totales;

	// privados

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
	 * Valida un lote
	 *
	 * @param aTransaccion
	 * @return ok
	 */
	private boolean isValidoLote(String aTransaccion) {
		boolean ok = true;

		if (aTransaccion.equals("C")) {

			if (this.isVacio(this.lote.getNombreLote())) {
				ok = false;
				this.mostrarMensajeGlobal("nombreVacio", "advertencia");
			}

			if (this.lote != null && this.lote.getNombreLote() != null && !this.lote.getNombreLote().equals("") && this.lotes != null && this.lotes.size() > 0 && this.lotes.stream().anyMatch(i -> i.getNombreLote().trim().toLowerCase().equals(this.lote.getNombreLote().trim().toLowerCase()) && i.getArbolito().getId().intValue() == this.lote.getArbolito().getId().intValue())) {
				ok = false;
				this.mostrarMensajeGlobal("yaExisteLoteArbolito", "advertencia");
			}

		} else {

			if (this.isVacio(this.loteTransaccion.getNombreLote())) {
				ok = false;
				this.mostrarMensajeGlobal("nombreVacio", "advertencia");
			}

			if (this.loteTransaccion != null && this.loteTransaccion.getNombreLote() != null && !this.loteTransaccion.getNombreLote().equals("") && this.lotes != null && this.lotes.size() > 0 && this.lotes.stream().anyMatch(i -> i.getId().intValue() != this.loteTransaccion.getId().intValue() && i.getNombreLote().trim().toLowerCase().equals(this.loteTransaccion.getNombreLote().trim().toLowerCase()) && i.getArbolito().getId().intValue() == this.loteTransaccion.getArbolito().getId().intValue())) {
				ok = false;
				this.mostrarMensajeGlobal("yaExisteLoteArbolito", "advertencia");
			}

		}

		return ok;
	}

	// publicos

	/**
	 * Limpia el archivo cargado para volver a ingresar otro
	 */
	public void limpiarArchivoCargado() {
		this.file = null;
		this.fotoArbolito.setFoto(null);
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
	 * Crea un nuevo lote del software
	 */
	public void crearLote() {
		Conexion conexion = new Conexion();

		try {
			if (isValidoLote("C")) {
				conexion.setAutoCommitBD(false);

				this.lote.setNombreLote(this.getSinEspacios(this.lote.getNombreLote()));
				if (this.lote.getDescripcionLote() != null) {
					this.lote.setDescripcionLote(this.getSinEspacios(this.lote.getDescripcionLote()));
				}

				if (this.lote != null && this.lote.getIndicativoInfinito() != null && this.lote.getIndicativoInfinito().equals(IConstantes.AFIRMACION)) {
					this.lote.setCantidadDisponible(0);
				}

				this.lote.setCantidadVendida(0);

				this.lote.getCamposBD();

				conexion.insertarBD(this.lote.getEstructuraTabla().getTabla(), this.lote.getEstructuraTabla().getPersistencia());
				conexion.commitBD();

				this.mostrarMensajeGlobal("creacionExitosa", "exito");

				// reseteo de variables
				this.lote = null;
				this.getLote();
				this.lotes = null;
				this.getLotes();
			}

		} catch (Exception e) {
			conexion.rollbackBD();
			this.mostrarMensajeGlobal("transaccionFallida", "error");
		} finally {
			conexion.cerrarConexion();
		}

	}

	/**
	 * Edita un registro de lote
	 */
	public void editarLote() {
		Conexion conexion = new Conexion();
		List<String> camposExceptuados = null;
		try {
			if (isValidoLote("E")) {
				conexion.setAutoCommitBD(false);

				this.loteTransaccion.setNombreLote(this.getSinEspacios(this.loteTransaccion.getNombreLote()));
				if (this.loteTransaccion.getDescripcionLote() != null) {
					this.loteTransaccion.setDescripcionLote(this.getSinEspacios(this.loteTransaccion.getDescripcionLote()));
				}

				if (this.loteTransaccion != null && this.loteTransaccion.getIndicativoInfinito() != null && this.loteTransaccion.getIndicativoInfinito().equals(IConstantes.AFIRMACION)) {
					this.loteTransaccion.setCantidadDisponible(0);
				}

				this.loteTransaccion.getCamposBD();

				// No deseo update de este campo ya que los determina las compras y
				// puede ser que en transacción exista una en el momento
				camposExceptuados = Arrays.asList("cantidad_vendida");

				conexion.actualizarBD(this.loteTransaccion.getEstructuraTabla().getTabla(), this.loteTransaccion.getEstructuraTabla().getPersistencia(), this.loteTransaccion.getEstructuraTabla().getLlavePrimaria(), camposExceptuados);
				conexion.commitBD();
				this.mostrarMensajeGlobal("edicionExitosa", "exito");
				this.cerrarModal("panelEdicionLote");

				// reseteo de variables
				this.loteTransaccion = null;
				this.getLoteTransaccion();
				this.lotes = null;
				this.getLotes();
			}

		} catch (Exception e) {
			conexion.rollbackBD();
			this.mostrarMensajeGlobal("transaccionFallida", "error");
		} finally {
			conexion.cerrarConexion();
		}

	}

	/**
	 * Elimina un registro de lote
	 */
	public void eliminarLote() {

		Conexion conexion = new Conexion();
		try {

			conexion.setAutoCommitBD(false);
			this.loteTransaccion.getCamposBD();
			conexion.eliminarBD(this.loteTransaccion.getEstructuraTabla().getTabla(), this.loteTransaccion.getEstructuraTabla().getLlavePrimaria());
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
		this.loteTransaccion = null;
		this.lotes = null;
		this.getLotes();

	}

	/**
	 * Elimina un registro de foto para arbolito
	 */
	public void eliminarFotoArbolito() {
		Conexion conexion = new Conexion();

		try {

			if (isFotoOK("E")) {

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
	 * Este método borra el formulario de creación de un lote
	 */
	public void cancelarLote() {

		try {
			this.lote = new Lote();

			this.lotes = null;
			this.getLotes();
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
	 * Este método borra el formulario de edición de un lote en transacción
	 */
	public void cancelarLoteTransaccion(String aVista) {
		try {

			this.loteTransaccion = new Lote();
			this.lotes = null;
			this.fotosArbolito = null;
			this.getLotes();
			this.file = null;

			if (aVista != null && aVista.equals("MODAL_EDITAR_LOTE")) {
				this.cerrarModal("panelEdicionLote");

			} else if (aVista != null && aVista.equals("MODAL_ELIMINAR_LOTE")) {
				this.cerrarModal("panelEliminacionLote");

			} else {
				this.vistaActual = null;

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
	 * Asigna un lote para realizar una acción
	 * 
	 * @param aArbolito
	 * @param aVista
	 */
	public void asignarLote(Lote aLote, String aVista) {

		try {

			this.loteTransaccion = aLote;
			this.fotoArbolito = null;
			this.fotoArbolitoTransaccion = null;
			this.fotosArbolito = null;

			if (aVista != null && aVista.equals("VISTA_FOTOS")) {
				this.vistaActual = aVista;

			} else if (aVista != null && aVista.equals("MODAL_EDITAR_LOTE")) {
				this.abrirModal("panelEdicionLote");

			} else {

				this.abrirModal("panelEliminacionLote");

			}

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}

	}

	/**
	 * Obtine un listado de lotes
	 * 
	 * @return lotes
	 */
	public List<Lote> getLotes() {
		try {
			if (this.lotes == null) {

				this.lotes = IConsultasDAO.getLotes(null);
				this.totales = new HashMap<String, Object>();

				this.totales.put("cantidadDisponible", new Integer(0));
				this.totales.put("arbolitosVendidos", new Integer(0));

				if (this.lotes != null && this.lotes.size() > 0) {
					for (Lote a : this.lotes) {
						this.totales.put("cantidadDisponible", ((Integer) this.totales.get("cantidadDisponible")) + a.getCantidadDisponible().intValue());
						this.totales.put("arbolitosVendidos", ((Integer) this.totales.get("arbolitosVendidos")) + a.getCantidadVendida().intValue());

					}
				}

			}
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return lotes;
	}

	public void setLotes(List<Lote> lotes) {
		this.lotes = lotes;
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
				foto.setLote(this.loteTransaccion);
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
	 * Obtiene el listado de arbolitos activos uno si se encuentar en estado
	 * inactivo
	 */
	public List<SelectItem> getArbolitosConInactivo() {
		List<SelectItem> arboles = new ArrayList<SelectItem>();
		arboles.addAll(this.getItemsArbolitos());
		if (this.loteTransaccion != null && this.loteTransaccion.getArbolito() != null && this.loteTransaccion.getArbolito().getEstadoVigencia() != null && this.loteTransaccion.getArbolito().getEstadoVigencia().equals(IConstantes.INACTIVO) && arboles != null && arboles.size() > 0) {
			arboles.add(new SelectItem(this.loteTransaccion.getArbolito().getId(), this.loteTransaccion.getArbolito().getNombre()));
		}

		return arboles;
	}

	/**
	 * Obtiene los ietms de los arbolitos activos
	 * 
	 * @return itemsArbolitos
	 */
	public List<SelectItem> getItemsArbolitos() {

		try {
			if (this.itemsArbolitos == null) {
				this.itemsArbolitos = new ArrayList<SelectItem>();
				this.itemsArbolitos.add(new SelectItem("", this.getMensaje("comboVacio")));

				Arbolito arbol = new Arbolito();
				arbol.setEstadoVigencia(IConstantes.ACTIVO);
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
	 * Obtiene los items de los arbolitos disponibles
	 * 
	 * @return itemsArbolitosDisponibles
	 */
	public List<SelectItem> getItemsArbolitosDisponibles() {
		try {
			//if (this.itemsArbolitosDisponibles == null) {
				this.itemsArbolitosDisponibles = new ArrayList<SelectItem>();
				this.itemsArbolitosDisponibles.add(new SelectItem("", this.getMensaje("comboVacio")));

				Arbolito arbol = new Arbolito();
				arbol.setEstadoVigencia(IConstantes.ACTIVO);
				List<Arbolito> arbolitosActivos = IConsultasDAO.getArbolitos(arbol);

				if (arbolitosActivos != null && arbolitosActivos.size() > 0) {
					arbolitosActivos.forEach(p -> this.itemsArbolitosDisponibles.add(new SelectItem(p.getId(), p.getNombre() + " " + this.getMensaje("arbolesDisponibles", "" + p.getCantidadDisponible()))));
				}

		//}
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return itemsArbolitosDisponibles;
	}

	/**
	 * Establece los items de los arbolitos disponibles
	 * 
	 * @param itemsArbolitosDisponibles
	 */
	public void setItemsArbolitosDisponibles(List<SelectItem> itemsArbolitosDisponibles) {
		this.itemsArbolitosDisponibles = itemsArbolitosDisponibles;
	}

	// get/sets

	public Lote getLote() {
		try {
			if (this.lote == null) {
				this.lote = new Lote();
			}
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return lote;
	}

	public void setLote(Lote lote) {
		this.lote = lote;
	}

	public Lote getLoteTransaccion() {
		try {
			if (this.loteTransaccion == null) {
				this.loteTransaccion = new Lote();
			}
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return loteTransaccion;
	}

	public void setLoteTransaccion(Lote loteTransaccion) {
		this.loteTransaccion = loteTransaccion;
	}

	public FotoArbolito getFotoArbolito() {
		try {
			if (this.fotoArbolito == null) {
				this.fotoArbolito = new FotoArbolito();
				this.fotoArbolito.setLote(this.loteTransaccion);
			}
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return fotoArbolito;
	}

	public void setFotoArbolito(FotoArbolito fotoArbolito) {
		this.fotoArbolito = fotoArbolito;
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

}
