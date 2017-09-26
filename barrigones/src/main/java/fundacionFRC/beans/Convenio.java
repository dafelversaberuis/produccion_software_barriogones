package fundacionFRC.beans;

import java.io.Serializable;

import javax.validation.constraints.Size;

import fundacionFRC.generales.IConstantes;

public class Convenio implements Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 4449263811026661544L;
	private Integer						id;
	private String						nombre;
	private String						telefonos;
	private String						encargado;

	private EstructuraTabla		estructuraTabla;

	private Iva								comision;

	public Convenio() {
		this.estructuraTabla = new EstructuraTabla();

		this.comision = new Iva();

	}

	public void getCamposBD() {

		this.estructuraTabla.setTabla("convenios");
		this.estructuraTabla.getLlavePrimaria().put("id", this.id);

		this.estructuraTabla.getPersistencia().put("nombre", this.nombre);
		this.estructuraTabla.getPersistencia().put("telefonos", this.telefonos);
		this.estructuraTabla.getPersistencia().put("encargado", this.encargado);

		if (this.comision != null && this.comision.getId() != null) {
			this.estructuraTabla.getPersistencia().put("id_comision", this.comision.getId());
		} else {
			this.estructuraTabla.getPersistencia().put("id_comision", this.comision.getId());

		}

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Size(max = 250, message = IConstantes.VALIDACION_MAXIMA_LONGITUD)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public EstructuraTabla getEstructuraTabla() {
		return estructuraTabla;
	}

	public void setEstructuraTabla(EstructuraTabla estructuraTabla) {
		this.estructuraTabla = estructuraTabla;
	}

	@Size(max = 250, message = IConstantes.VALIDACION_MAXIMA_LONGITUD)
	public String getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(String telefonos) {
		this.telefonos = telefonos;
	}

	@Size(max = 250, message = IConstantes.VALIDACION_MAXIMA_LONGITUD)
	public String getEncargado() {
		return encargado;
	}

	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}

	public Iva getComision() {
		return comision;
	}

	public void setComision(Iva comision) {
		this.comision = comision;
	}

}
