package fundacionFRC.modulos.personal;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fundacionFRC.Conexion;
import fundacionFRC.beans.Comprador;
import fundacionFRC.beans.Personal;
import fundacionFRC.generales.ConsultarFuncionesAPI;
import fundacionFRC.generales.IConstantes;
import fundacionFRC.generales.IEmail;
import fundacionFRC.modulos.IConsultasDAO;

@ManagedBean
@ViewScoped
public class AdministrarPersonal extends ConsultarFuncionesAPI implements Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -2221958861238708985L;

	private Personal					personal;
	private Comprador					comprador;
	private Personal					personalTransaccion;
	private List<Personal>		administradores;
	private List<Comprador>		compradores;

	// privados

	/**
	 * Obtiene una clave aleatoria numérica de n dígitos
	 * 
	 * @return clave
	 */
	public String getClaveAleatoria() {
		String clave = "";
		int n = 0;
		try {
			for (int i = 1; i <= IConstantes.NUMERO_DIGITOS_CLAVE_ALEATORIA.intValue(); i++) {
				n = (int) (10.0 * Math.random()) + 0;
				clave = clave + String.valueOf(n);

			}
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return clave;

	}

	/**
	 * Valida un administrador
	 * 
	 * @param aTransaccion
	 * @return ok
	 */
	private boolean isValidoAdministrador(String aTransaccion) {
		boolean ok = true;

		if (aTransaccion.equals("C")) {
			if (this.administradores != null && this.administradores.size() > 0 && this.administradores.stream().anyMatch(i -> i.getCorreoElectronico().trim().toLowerCase().equals(this.personal.getCorreoElectronico().trim().toLowerCase()))) {
				ok = false;
				this.mostrarMensajeGlobal("correoExistenteAdministrador", "advertencia");
			}
			if (this.isVacio(this.personal.getNombres())) {
				ok = false;
				this.mostrarMensajeGlobal("nombresVacios", "advertencia");
			}

			if (this.isVacio(this.personal.getApellidos())) {
				ok = false;
				this.mostrarMensajeGlobal("apellidosVacios", "advertencia");
			}

			if (this.isVacio(this.personal.getCorreoElectronico())) {
				ok = false;
				this.mostrarMensajeGlobal("correoVacio", "advertencia");
			}

		} else {

			if (this.administradores != null && this.administradores.size() > 0 && this.administradores.stream().anyMatch(i -> i.getId() != this.personalTransaccion.getId() && i.getCorreoElectronico().trim().toLowerCase().equals(this.personalTransaccion.getCorreoElectronico().trim().toLowerCase()))) {
				ok = false;
				this.mostrarMensajeGlobal("correoExistenteAdministrador", "advertencia");
			}
			if (this.isVacio(this.personalTransaccion.getNombres())) {
				ok = false;
				this.mostrarMensajeGlobal("nombresVacios", "advertencia");
			}

			if (this.isVacio(this.personalTransaccion.getApellidos())) {
				ok = false;
				this.mostrarMensajeGlobal("apellidosVacios", "advertencia");
			}

			if (this.isVacio(this.getPersonalTransaccion().getCorreoElectronico())) {
				ok = false;
				this.mostrarMensajeGlobal("correoVacio", "advertencia");
			}

		}

		return ok;
	}

	// publicos

	/**
	 * Coloca en blanco la consulta
	 */
	public void resetearConsultaComprador() {
		this.comprador = null;
		this.getComprador();
		this.compradores = null;
	}

	/**
	 * Consulta los compradores por los criterios mencionados
	 */
	public void consultarCompradores() {
		try {

			this.compradores = IConsultasDAO.getCompradoresSarta(this.comprador);

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}

	}

	/**
	 * Crea un nuevo administrador del software
	 */
	public void crearAdministrador() {
		Conexion conexion = new Conexion();

		try {
			if (isValidoAdministrador("C")) {
				conexion.setAutoCommitBD(false);

				this.personal.setEstadoVigencia(IConstantes.ACTIVO);
				this.personal.setNombres(this.getSinEspacios(this.personal.getNombres()));
				this.personal.setApellidos(this.getSinEspacios(this.personal.getApellidos()));
				this.personal.setCorreoElectronico(this.personal.getCorreoElectronico().trim());
				this.personal.setClave(this.getClaveAleatoria());

				this.personal.getCamposBD();

				conexion.insertarBD(this.personal.getEstructuraTabla().getTabla(), this.personal.getEstructuraTabla().getPersistencia());
				conexion.commitBD();

				this.mostrarMensajeGlobal("creacionExitosa", "exito");
				this.mostrarMensajeGlobalPersonalizado(this.getMensaje("claveAleatoria", this.getPersonal().getClave()), "exito");

				IEmail.enviarCorreo(this.getMensaje("mensajeClaveAleatoria", this.personal.getNombres() + " " + this.personal.getApellidos(), this.personal.getClave()), this.getMensaje("asuntoClaveAleatoria"), this.personal.getCorreoElectronico());
				this.mostrarMensajeGlobalPersonalizado(this.getMensaje("claveCorreoExitoso", this.getPersonal().getCorreoElectronico()), "exito");

				// reseteo de variables
				this.personal = null;
				this.getPersonal();
				this.administradores = null;
				this.getAdministradores();
			}

		} catch (Exception e) {
			conexion.rollbackBD();
			this.mostrarMensajeGlobal("transaccionFallida", "error");
		} finally {
			conexion.cerrarConexion();
		}

	}

	/**
	 * Genera una nueva clave aleatoria para el administrador
	 */
	public void generarClaveAdministrador() {

		Conexion conexion = new Conexion();

		try {
			boolean ok = true;
			if (this.personalTransaccion != null && this.personalTransaccion.gettTipoClave() != null && this.personalTransaccion.gettTipoClave().equals("A")) {

				this.personalTransaccion.setClave(this.getClaveAleatoria());

			} else {

				if (this.isVacio(this.personalTransaccion.getClave())) {
					ok = false;
				}

			}
			if (ok) {
				conexion.setAutoCommitBD(false);

				this.personalTransaccion.getCamposBD();

				conexion.actualizarBD(this.personalTransaccion.getEstructuraTabla().getTabla(), this.personalTransaccion.getEstructuraTabla().getPersistencia(), this.personalTransaccion.getEstructuraTabla().getLlavePrimaria(), null);
				conexion.commitBD();

				this.mostrarMensajeGlobalPersonalizado(this.getMensaje("claveAleatoria", this.personalTransaccion.getClave()), "exito");

				IEmail.enviarCorreo(this.getMensaje("mensajeClaveAleatoria", this.personalTransaccion.getNombres() + " " + this.personalTransaccion.getApellidos(), this.personalTransaccion.getClave()), this.getMensaje("asuntoClaveAleatoria"), this.personalTransaccion.getCorreoElectronico());
				this.mostrarMensajeGlobalPersonalizado(this.getMensaje("claveCorreoExitoso", this.personalTransaccion.getCorreoElectronico()), "exito");

				this.cerrarModal("panelClaveAdministrador");

				// reseteo de variables
				this.personalTransaccion = null;
				this.getPersonalTransaccion();
				this.administradores = null;
				this.getAdministradores();

			} else {

				this.mostrarMensajeGlobal("claveEnBlanco", "error");
			}

		} catch (Exception e) {
			conexion.rollbackBD();
			this.mostrarMensajeGlobal("transaccionFallida", "error");
		} finally {
			conexion.cerrarConexion();
		}

	}

	/**
	 * Edita un registro de administrador de software
	 */
	public void editarAdministrador() {
		Conexion conexion = new Conexion();

		try {
			if (isValidoAdministrador("E")) {
				conexion.setAutoCommitBD(false);

				this.personalTransaccion.setNombres(this.getSinEspacios(this.personalTransaccion.getNombres()));
				this.personalTransaccion.setApellidos(this.getSinEspacios(this.personalTransaccion.getApellidos()));

				this.personalTransaccion.getCamposBD();
				conexion.actualizarBD(this.personalTransaccion.getEstructuraTabla().getTabla(), this.personalTransaccion.getEstructuraTabla().getPersistencia(), this.personalTransaccion.getEstructuraTabla().getLlavePrimaria(), null);
				conexion.commitBD();
				this.mostrarMensajeGlobal("edicionExitosa", "exito");
				this.mostrarMensajeGlobal("algunosCambios", "advertencia");
				this.cerrarModal("panelEdicionAdministrador");

				// reseteo de variables
				this.personalTransaccion = null;
				this.getPersonalTransaccion();
				this.administradores = null;
				this.getAdministradores();
			}

		} catch (Exception e) {
			conexion.rollbackBD();
			this.mostrarMensajeGlobal("transaccionFallida", "error");
		} finally {
			conexion.cerrarConexion();
		}

	}

	/**
	 * Elimina un registro de adminiistador
	 */
	public void eliminarAdministrador() {

		Conexion conexion = new Conexion();
		try {

			conexion.setAutoCommitBD(false);
			this.personalTransaccion.getCamposBD();
			conexion.eliminarBD(this.personalTransaccion.getEstructuraTabla().getTabla(), this.personalTransaccion.getEstructuraTabla().getLlavePrimaria());
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
		this.personalTransaccion = null;
		this.administradores = null;
		this.getAdministradores();

	}

	/**
	 * Este método borra el formulario de creación de un administrador
	 */
	public void cancelarAdministrador() {

		try {
			this.personal = new Personal();

			this.administradores = null;
			this.getAdministradores();
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}

	}

	/**
	 * Este método borra el formulario de edición de un administrador en
	 * transacción
	 */
	public void cancelarAdministradorTransaccion(String aVista) {
		try {

			this.personalTransaccion = new Personal();
			this.administradores = null;
			this.getAdministradores();

			if (aVista != null && aVista.equals("MODAL_EDITAR_ADMINISTRADOR")) {
				this.cerrarModal("panelEdicionAdministrador");

			} else if (aVista != null && aVista.equals("MODAL_CLAVE_ADMINISTRADOR")) {
				this.cerrarModal("panelClaveAdministrador");

			} else if (aVista != null && aVista.equals("MODAL_ELIMINAR_ADMINISTRADOR")) {
				this.cerrarModal("panelEliminacionAdministrador");

			}

		} catch (Exception e) {

			IConstantes.log.error(e, e);

		}

	}

	/**
	 * Asigna un administrador para realizar una acción
	 * 
	 * @param aAgrupador
	 * @param aVista
	 */
	public void asignarAdministrador(Personal aPersonal, String aVista) {

		try {

			this.personalTransaccion = aPersonal;

			if (aVista != null && aVista.equals("MODAL_EDITAR_ADMINISTRADOR")) {
				this.abrirModal("panelEdicionAdministrador");

			} else if (aVista != null && aVista.equals("MODAL_CLAVE_ADMINISTRADOR")) {
				this.abrirModal("panelClaveAdministrador");

			} else {

				this.abrirModal("panelEliminacionAdministrador");

			}

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}

	}

	/**
	 * Obtiene un listado de administradores
	 * 
	 * @return administradores
	 */
	public List<Personal> getAdministradores() {
		try {
			if (this.administradores == null) {

				this.administradores = IConsultasDAO.getAdministradores(null);

			}
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return administradores;
	}

	// get/sets

	public Personal getPersonal() {
		try {
			if (this.personal == null) {
				this.personal = new Personal();
			}
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

	public Personal getPersonalTransaccion() {
		return personalTransaccion;
	}

	public void setPersonalTransaccion(Personal personalTransaccion) {
		this.personalTransaccion = personalTransaccion;
	}

	public void setAdministradores(List<Personal> administradores) {
		this.administradores = administradores;
	}

	public Comprador getComprador() {
		try {
			if (this.comprador == null) {
				this.comprador = new Comprador();
			}
		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}
		return comprador;
	}

	public void setComprador(Comprador comprador) {
		this.comprador = comprador;
	}

	public List<Comprador> getCompradores() {
		return compradores;
	}

	public void setCompradores(List<Comprador> compradores) {
		this.compradores = compradores;
	}

}
