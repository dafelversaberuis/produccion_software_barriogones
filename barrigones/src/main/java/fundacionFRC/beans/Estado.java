package fundacionFRC.beans;

import java.io.Serializable;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import fundacionFRC.generales.IConstantes;

public class Estado implements Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -7605466680166728470L;
	private Integer						id;
	private String						tituloEstado;
	private String						estadoVigencia;
	private String						estadoInicial;
	private String						permitePersonalizacion;

	private EstructuraTabla		estructuraTabla;

	public Estado() {
		this.estructuraTabla = new EstructuraTabla();

	}

	public void getCamposBD() {

		this.estructuraTabla.setTabla("estados");
		this.estructuraTabla.getLlavePrimaria().put("id", this.id);

		this.estructuraTabla.getPersistencia().put("titulo_estado", this.tituloEstado);
		this.estructuraTabla.getPersistencia().put("estado_vigencia", this.estadoVigencia);
		this.estructuraTabla.getPersistencia().put("estado_inicial", this.estadoInicial);
		this.estructuraTabla.getPersistencia().put("permite_personalizacion", this.permitePersonalizacion);

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Size(max = 250, message = IConstantes.VALIDACION_MAXIMA_LONGITUD)
	public String getTituloEstado() {
		return tituloEstado;
	}

	public void setTituloEstado(String tituloEstado) {
		this.tituloEstado = tituloEstado;
	}

	@Pattern(regexp = "[AI]", message = IConstantes.VALIDACION_ACTIVO_INACTIVO)
	public String getEstadoVigencia() {
		return estadoVigencia;
	}

	public void setEstadoVigencia(String estadoVigencia) {
		this.estadoVigencia = estadoVigencia;
	}

	@Pattern(regexp = "[SN]", message = IConstantes.VALIDACION_SI_NO)
	public String getEstadoInicial() {
		return estadoInicial;
	}

	public void setEstadoInicial(String estadoInicial) {
		this.estadoInicial = estadoInicial;
	}

	public EstructuraTabla getEstructuraTabla() {
		return estructuraTabla;
	}

	public void setEstructuraTabla(EstructuraTabla estructuraTabla) {
		this.estructuraTabla = estructuraTabla;
	}

	@Pattern(regexp = "[SN]", message = IConstantes.VALIDACION_SI_NO)
	public String getPermitePersonalizacion() {
		return permitePersonalizacion;
	}

	public void setPermitePersonalizacion(String permitePersonalizacion) {
		this.permitePersonalizacion = permitePersonalizacion;
	}

}
