package fundacionFRC.beans;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;

import fundacionFRC.generales.IConstantes;

public class DetalleArbolitoVendido implements Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 2232060983493162101L;
	private Integer						id;
	private Integer						cantidadArbolitos;
	private Integer						numeroArbolesBolsa;
	private BigDecimal				valorTotal;
	private BigDecimal				valorIva;
	private BigDecimal				valorTotalConIva;
	private Venta							venta;
	private Arbolito					arbolito;
	private BigDecimal				porcentajeIvaAplicado;
	private EstructuraTabla		estructuraTabla;

	public DetalleArbolitoVendido() {
		this.estructuraTabla = new EstructuraTabla();
		this.venta = new Venta();
		this.arbolito = new Arbolito();

	}

	public void getCamposBD() {

		this.estructuraTabla.setTabla("detalle_arbolito_vendido");
		this.estructuraTabla.getLlavePrimaria().put("id", this.id);
		this.estructuraTabla.getPersistencia().put("numero_arboles_bolsa", this.numeroArbolesBolsa);

		this.estructuraTabla.getPersistencia().put("porcentaje_iva_aplicado", this.porcentajeIvaAplicado);
		this.estructuraTabla.getPersistencia().put("cantidad_arbolitos", this.cantidadArbolitos);
		this.estructuraTabla.getPersistencia().put("valor_total", this.valorTotal);
		this.estructuraTabla.getPersistencia().put("valor_iva", this.valorIva);
		this.estructuraTabla.getPersistencia().put("valor_total_con_iva", this.valorTotalConIva);

		if (this.venta != null && this.venta.getId() != null) {
			this.estructuraTabla.getPersistencia().put("id_venta", this.venta.getId());
		} else {
			this.estructuraTabla.getPersistencia().put("id_venta", null);
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

	@Min(value = 0, message = IConstantes.VALIDACION_MINIMO_ENTERO)
	public Integer getCantidadArbolitos() {
		return cantidadArbolitos;
	}

	public void setCantidadArbolitos(Integer cantidadArbolitos) {
		this.cantidadArbolitos = cantidadArbolitos;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	@Digits(integer = 11, fraction = 2, message = IConstantes.VALIDACION_MAXIMO_DECIMAL)
	public BigDecimal getValorIva() {
		return valorIva;
	}

	public void setValorIva(BigDecimal valorIva) {
		this.valorIva = valorIva;
	}

	@Digits(integer = 11, fraction = 2, message = IConstantes.VALIDACION_MAXIMO_DECIMAL)
	public BigDecimal getValorTotalConIva() {
		return valorTotalConIva;
	}

	public void setValorTotalConIva(BigDecimal valorTotalConIva) {
		this.valorTotalConIva = valorTotalConIva;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
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

	@Digits(integer = 2, fraction = 2, message = IConstantes.VALIDACION_MAXIMO_DECIMAL)
	public BigDecimal getPorcentajeIvaAplicado() {
		return porcentajeIvaAplicado;
	}

	public void setPorcentajeIvaAplicado(BigDecimal porcentajeIvaAplicado) {
		this.porcentajeIvaAplicado = porcentajeIvaAplicado;
	}
	
	public Integer getNumeroArbolesBolsa() {
		return numeroArbolesBolsa;
	}

	public void setNumeroArbolesBolsa(Integer numeroArbolesBolsa) {
		this.numeroArbolesBolsa = numeroArbolesBolsa;
	}


}
