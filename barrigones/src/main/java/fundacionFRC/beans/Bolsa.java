package fundacionFRC.beans;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import fundacionFRC.generales.IConstantes;

public class Bolsa implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 6367623007963827662L;
	private Integer						id;
	private BigDecimal				precioVentaPesos;
	private BigDecimal				precioVentaUS;
	private BigDecimal				ivaPesos;
	private BigDecimal				ivaUs;
	private BigDecimal				precioVentaPesosConIva;
	private BigDecimal				precioVentaUSConIva;
	private String						estadoVigencia;
	private Integer						cantidadDisponible;
	private Integer						cantidadVendida;
	private Arbolito					arbolito;
	private Iva								iva;

	private EstructuraTabla		estructuraTabla;

	// temporal
	private Integer						TcantidadCarrito;

	private BigDecimal				TPrecioTotalPesosSinIva;
	private BigDecimal				TPrecioTotalUSSinIva;
	private BigDecimal				TTotalIvaPesos;
	private BigDecimal				TTotalIvaUS;
	private BigDecimal				TPrecioTotalPesosConIva;
	private BigDecimal				TPrecioTotalUSConIva;

	public Bolsa() {
		this.estructuraTabla = new EstructuraTabla();
		this.iva = new Iva();
		this.arbolito = new Arbolito();

	}

	public void getCamposBD() {

		this.estructuraTabla.setTabla("bolsas");
		this.estructuraTabla.getLlavePrimaria().put("id", this.id);

		this.estructuraTabla.getPersistencia().put("precio_cop_sin_iva", this.precioVentaPesos);
		this.estructuraTabla.getPersistencia().put("precio_us_sin_iva", this.precioVentaUS);

		this.estructuraTabla.getPersistencia().put("valor_iva_cop", this.ivaPesos);
		this.estructuraTabla.getPersistencia().put("valor_iva_us", this.ivaUs);

		this.estructuraTabla.getPersistencia().put("precio_cop_con_iva", this.precioVentaPesosConIva);
		this.estructuraTabla.getPersistencia().put("precio_us_con_iva", this.precioVentaUSConIva);

		this.estructuraTabla.getPersistencia().put("estado_vigencia", this.estadoVigencia);
		this.estructuraTabla.getPersistencia().put("cantidad", this.cantidadDisponible);
		this.estructuraTabla.getPersistencia().put("bolsas_vendidas", this.cantidadVendida);

		if (this.iva != null && this.iva.getId() != null) {
			this.estructuraTabla.getPersistencia().put("id_iva", this.iva.getId());
		} else {
			this.estructuraTabla.getPersistencia().put("id_iva", null);
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

	@Digits(integer = 10, fraction = 2, message = IConstantes.VALIDACION_MAXIMO_DECIMAL)
	@DecimalMin("0.00")
	public BigDecimal getPrecioVentaPesos() {
		return precioVentaPesos;
	}

	public void setPrecioVentaPesos(BigDecimal precioVentaPesos) {
		this.precioVentaPesos = precioVentaPesos;
	}

	@Digits(integer = 11, fraction = 2, message = IConstantes.VALIDACION_MAXIMO_DECIMAL)
	@DecimalMin("0.00")
	public BigDecimal getPrecioVentaUS() {
		return precioVentaUS;
	}

	public void setPrecioVentaUS(BigDecimal precioVentaUS) {
		this.precioVentaUS = precioVentaUS;
	}

	@Digits(integer = 11, fraction = 2, message = IConstantes.VALIDACION_MAXIMO_DECIMAL)
	@DecimalMin("0.00")
	public BigDecimal getPrecioVentaPesosConIva() {
		return precioVentaPesosConIva;
	}

	public void setPrecioVentaPesosConIva(BigDecimal precioVentaPesosConIva) {
		this.precioVentaPesosConIva = precioVentaPesosConIva;
	}

	@Digits(integer = 11, fraction = 2, message = IConstantes.VALIDACION_MAXIMO_DECIMAL)
	@DecimalMin("0.00")
	public BigDecimal getPrecioVentaUSConIva() {
		return precioVentaUSConIva;
	}

	public void setPrecioVentaUSConIva(BigDecimal precioVentaUSConIva) {
		this.precioVentaUSConIva = precioVentaUSConIva;
	}

	@Digits(integer = 11, fraction = 2, message = IConstantes.VALIDACION_MAXIMO_DECIMAL)
	@DecimalMin("0.00")
	public BigDecimal getIvaPesos() {
		return ivaPesos;
	}

	public void setIvaPesos(BigDecimal ivaPesos) {
		this.ivaPesos = ivaPesos;
	}

	@Digits(integer = 11, fraction = 2, message = IConstantes.VALIDACION_MAXIMO_DECIMAL)
	@DecimalMin("0.00")
	public BigDecimal getIvaUs() {
		return ivaUs;
	}

	public void setIvaUs(BigDecimal ivaUs) {
		this.ivaUs = ivaUs;
	}

	@Pattern(regexp = "[AI]", message = IConstantes.VALIDACION_ACTIVO_INACTIVO)
	public String getEstadoVigencia() {
		return estadoVigencia;
	}

	public void setEstadoVigencia(String estadoVigencia) {
		this.estadoVigencia = estadoVigencia;
	}

	@Min(value = 2, message = IConstantes.VALIDACION_MINIMO_ENTERO)
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

	public Iva getIva() {
		return iva;
	}

	public void setIva(Iva iva) {
		this.iva = iva;
	}

	public EstructuraTabla getEstructuraTabla() {
		return estructuraTabla;
	}

	public void setEstructuraTabla(EstructuraTabla estructuraTabla) {
		this.estructuraTabla = estructuraTabla;
	}

	@Min(value = 1, message = IConstantes.VALIDACION_MINIMO_ENTERO)
	public Integer getTcantidadCarrito() {
		return TcantidadCarrito;
	}

	public void setTcantidadCarrito(Integer tcantidadCarrito) {
		TcantidadCarrito = tcantidadCarrito;
	}

	public BigDecimal getTPrecioTotalPesosSinIva() {
		return TPrecioTotalPesosSinIva;
	}

	public void setTPrecioTotalPesosSinIva(BigDecimal tPrecioTotalPesosSinIva) {
		TPrecioTotalPesosSinIva = tPrecioTotalPesosSinIva;
	}

	public BigDecimal getTPrecioTotalUSSinIva() {
		return TPrecioTotalUSSinIva;
	}

	public void setTPrecioTotalUSSinIva(BigDecimal tPrecioTotalUSSinIva) {
		TPrecioTotalUSSinIva = tPrecioTotalUSSinIva;
	}

	public BigDecimal getTTotalIvaPesos() {
		return TTotalIvaPesos;
	}

	public void setTTotalIvaPesos(BigDecimal tTotalIvaPesos) {
		TTotalIvaPesos = tTotalIvaPesos;
	}

	public BigDecimal getTTotalIvaUS() {
		return TTotalIvaUS;
	}

	public void setTTotalIvaUS(BigDecimal tTotalIvaUS) {
		TTotalIvaUS = tTotalIvaUS;
	}

	public BigDecimal getTPrecioTotalPesosConIva() {
		return TPrecioTotalPesosConIva;
	}

	public void setTPrecioTotalPesosConIva(BigDecimal tPrecioTotalPesosConIva) {
		TPrecioTotalPesosConIva = tPrecioTotalPesosConIva;
	}

	public BigDecimal getTPrecioTotalUSConIva() {
		return TPrecioTotalUSConIva;
	}

	public void setTPrecioTotalUSConIva(BigDecimal tPrecioTotalUSConIva) {
		TPrecioTotalUSConIva = tPrecioTotalUSConIva;
	}

	public Arbolito getArbolito() {
		return arbolito;
	}

	public void setArbolito(Arbolito arbolito) {
		this.arbolito = arbolito;
	}

}
