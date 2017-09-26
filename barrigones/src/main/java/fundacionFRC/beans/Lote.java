package fundacionFRC.beans;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import fundacionFRC.generales.IConstantes;

public class Lote implements Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -153800201981004452L;
	private Integer						id;
	private String						nombreLote;
	private String						descripcionLote;
	private String						indicativoInfinito;
	private Integer						cantidadDisponible;
	private Integer						cantidadVendida;

	private Arbolito					arbolito;

	private EstructuraTabla		estructuraTabla;

	public Lote() {
		this.estructuraTabla = new EstructuraTabla();

		this.arbolito = new Arbolito();

	}

	public void getCamposBD() {

		this.estructuraTabla.setTabla("lotes");
		this.estructuraTabla.getLlavePrimaria().put("id", this.id);

		this.estructuraTabla.getPersistencia().put("nombre_lote", this.nombreLote);
		this.estructuraTabla.getPersistencia().put("descripcion_lote", this.descripcionLote);
		this.estructuraTabla.getPersistencia().put("indicativo_infinito", this.indicativoInfinito);
		this.estructuraTabla.getPersistencia().put("cantidad_disponible", this.cantidadDisponible);
		this.estructuraTabla.getPersistencia().put("cantidad_vendida", this.cantidadVendida);

		if (this.arbolito != null && this.arbolito.getId() != null) {
			this.estructuraTabla.getPersistencia().put("id_arbolito", this.arbolito.getId());
		} else {
			this.estructuraTabla.getPersistencia().put("id_arbolito", this.arbolito.getId());
		}

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Size(max = 100, message = IConstantes.VALIDACION_MAXIMA_LONGITUD)
	public String getNombreLote() {
		return nombreLote;
	}

	public void setNombreLote(String nombreLote) {
		this.nombreLote = nombreLote;
	}

	public String getDescripcionLote() {
		return descripcionLote;
	}

	public void setDescripcionLote(String descripcionLote) {
		this.descripcionLote = descripcionLote;
	}

	@Pattern(regexp = "[SN]", message = IConstantes.VALIDACION_SI_NO)
	public String getIndicativoInfinito() {
		return indicativoInfinito;
	}

	public void setIndicativoInfinito(String indicativoInfinito) {
		this.indicativoInfinito = indicativoInfinito;
	}

	@Min(value = 0, message = IConstantes.VALIDACION_MINIMO_ENTERO)
	public Integer getCantidadDisponible() {
		return cantidadDisponible;
	}

	public void setCantidadDisponible(Integer cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}

	@Min(value = 0, message = IConstantes.VALIDACION_MINIMO_ENTERO)
	public Integer getCantidadVendida() {
		return cantidadVendida;
	}

	public void setCantidadVendida(Integer cantidadVendida) {
		this.cantidadVendida = cantidadVendida;
	}

	public Arbolito getArbolito() {
		return arbolito;
	}

	public void setArbolito(Arbolito arbolito) {
		this.arbolito = arbolito;
	}

	public EstructuraTabla getEstructuraTabla() {
		return estructuraTabla;
	}

	public void setEstructuraTabla(EstructuraTabla estructuraTabla) {
		this.estructuraTabla = estructuraTabla;
	}

}
