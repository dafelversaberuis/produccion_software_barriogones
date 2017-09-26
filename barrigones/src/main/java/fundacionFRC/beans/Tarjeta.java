package fundacionFRC.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import fundacionFRC.generales.IConstantes;

public class Tarjeta implements Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 4766319664670000650L;
	private Integer						id;
	private String						algoritmo;
	private String						usada;
	private BigDecimal				porcentajeComisionAplicado;
	private String						idiomaTarjeta;

	private Date							fechaRegistro;
	private Convenio					convenio;
	private Arbolito					arbolito;

	private Integer						tCantidadTarjetas;
	private Venta							tVenta;

	private EstructuraTabla		estructuraTabla;

	private Date							tFechaDesde;
	private Date							tFechaHasta;

	public Tarjeta() {

		this.estructuraTabla = new EstructuraTabla();
		this.convenio = new Convenio();
		this.arbolito = new Arbolito();

	}

	public void getCamposBD() {

		this.estructuraTabla.setTabla("tarjetas");
		this.estructuraTabla.getLlavePrimaria().put("id", this.id);

		this.estructuraTabla.getPersistencia().put("algoritmo", this.algoritmo);
		this.estructuraTabla.getPersistencia().put("fecha_registro", this.fechaRegistro);
		this.estructuraTabla.getPersistencia().put("usada", this.usada);
		this.estructuraTabla.getPersistencia().put("idioma_tarjeta", this.idiomaTarjeta);

		this.estructuraTabla.getPersistencia().put("porcentaje_comision_aplicado", this.porcentajeComisionAplicado);

		if (this.getConvenio() != null && this.convenio.getId() != null) {
			this.estructuraTabla.getPersistencia().put("id_convenio", this.convenio.getId());
		} else {
			this.estructuraTabla.getPersistencia().put("id_convenio", null);
		}

		if (this.convenio != null && this.convenio.getId() != null) {
			this.estructuraTabla.getPersistencia().put("id_convenio", this.convenio.getId());
		} else {
			this.estructuraTabla.getPersistencia().put("id_convenio", null);
		}

		if (this.arbolito != null && this.arbolito.getId() != null) {
			this.estructuraTabla.getPersistencia().put("id_arbolito", this.arbolito.getId());
		} else {
			this.estructuraTabla.getPersistencia().put("id_arbolito", null);
		}

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Size(max = 10, message = IConstantes.VALIDACION_MAXIMA_LONGITUD)
	public String getAlgoritmo() {
		return algoritmo;
	}

	public void setAlgoritmo(String algoritmo) {
		this.algoritmo = algoritmo;
	}

	@Pattern(regexp = "[SN]", message = IConstantes.VALIDACION_SI_NO)
	public String getUsada() {
		return usada;
	}

	public void setUsada(String usada) {
		this.usada = usada;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Convenio getConvenio() {
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
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

	@Min(value = 1, message = IConstantes.VALIDACION_MINIMO_ENTERO)
	public Integer gettCantidadTarjetas() {
		return tCantidadTarjetas;
	}

	public void settCantidadTarjetas(Integer tCantidadTarjetas) {
		this.tCantidadTarjetas = tCantidadTarjetas;
	}

	public Venta gettVenta() {
		return tVenta;
	}

	public void settVenta(Venta tVenta) {
		this.tVenta = tVenta;
	}

	@Digits(integer = 2, fraction = 2, message = IConstantes.VALIDACION_MAXIMO_DECIMAL)
	public BigDecimal getPorcentajeComisionAplicado() {
		return porcentajeComisionAplicado;
	}

	public void setPorcentajeComisionAplicado(BigDecimal porcentajeComisionAplicado) {
		this.porcentajeComisionAplicado = porcentajeComisionAplicado;
	}

	public Date gettFechaDesde() {
		return tFechaDesde;
	}

	public void settFechaDesde(Date tFechaDesde) {
		this.tFechaDesde = tFechaDesde;
	}

	public Date gettFechaHasta() {
		return tFechaHasta;
	}

	public void settFechaHasta(Date tFechaHasta) {
		this.tFechaHasta = tFechaHasta;
	}

	public String getIdiomaTarjeta() {
		return idiomaTarjeta;
	}

	public void setIdiomaTarjeta(String idiomaTarjeta) {
		this.idiomaTarjeta = idiomaTarjeta;
	}
	
	
	

}
