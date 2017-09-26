package fundacionFRC.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;

import fundacionFRC.generales.IConstantes;

public class Venta implements Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 9160683718319239342L;

	private Integer						id;

	private Integer						cantidadTotalVenta;
	private BigDecimal				valorTotalVenta;
	private BigDecimal				valorTotalIva;
	private BigDecimal				valorTotalConIva;
	private BigDecimal				gananaciaConvenio;
	private Date							fechaTransaccion;
	private Date							horaTransaccion;
	private String						moneda;
	private String						estadoTransaccion;
	private String						idiomaTransaccion;
	private String						idTransaccion;

	private Comprador					comprador;
	private Tarjeta						tarjeta;

	private Date							tFechaDesde;
	private Date							tFechaHasta;
	private String						tOperadorConsulta;
	private String						tOperadorVentas;

	private EstructuraTabla		estructuraTabla;

	public Venta() {
		this.estructuraTabla = new EstructuraTabla();

		this.comprador = new Comprador();

		this.tarjeta = new Tarjeta();
	}

	public void getCamposBD() {

		this.estructuraTabla.setTabla("ventas");
		this.estructuraTabla.getLlavePrimaria().put("id", this.id);

		this.estructuraTabla.getPersistencia().put("cantidad_total_venta", this.cantidadTotalVenta);
		this.estructuraTabla.getPersistencia().put("valor_total_venta", this.valorTotalVenta);
		this.estructuraTabla.getPersistencia().put("valor_total_iva", this.valorTotalIva);
		this.estructuraTabla.getPersistencia().put("valor_total_con_iva", this.valorTotalConIva);
		this.estructuraTabla.getPersistencia().put("ganancia_convenio", this.gananaciaConvenio);
		this.estructuraTabla.getPersistencia().put("id_transaccion", this.idTransaccion);

		this.estructuraTabla.getPersistencia().put("fecha_transaccion", this.fechaTransaccion);
		this.estructuraTabla.getPersistencia().put("hora_transaccion", this.horaTransaccion);
		this.estructuraTabla.getPersistencia().put("moneda", this.moneda);
		this.estructuraTabla.getPersistencia().put("estado_transaccion", this.estadoTransaccion);
		this.estructuraTabla.getPersistencia().put("idioma_transaccion", this.idiomaTransaccion);

		if (this.comprador != null && this.comprador.getId() != null) {
			this.estructuraTabla.getPersistencia().put("id_comprador", this.comprador.getId());
		} else {
			this.estructuraTabla.getPersistencia().put("id_comprador", null);
		}

		if (this.tarjeta != null && this.tarjeta.getId() != null) {
			this.estructuraTabla.getPersistencia().put("id_tarjeta", this.tarjeta.getId());
		} else {
			this.estructuraTabla.getPersistencia().put("id_tarjeta", null);
		}

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Comprador getComprador() {
		return comprador;
	}

	public void setComprador(Comprador comprador) {
		this.comprador = comprador;
	}

	@Min(value = 0, message = IConstantes.VALIDACION_MINIMO_ENTERO)
	public Integer getCantidadTotalVenta() {
		return cantidadTotalVenta;
	}

	public void setCantidadTotalVenta(Integer cantidadTotalVenta) {
		this.cantidadTotalVenta = cantidadTotalVenta;
	}

	@Digits(integer = 16, fraction = 2, message = IConstantes.VALIDACION_MAXIMO_DECIMAL)
	public BigDecimal getValorTotalVenta() {
		return valorTotalVenta;
	}

	public void setValorTotalVenta(BigDecimal valorTotalVenta) {
		this.valorTotalVenta = valorTotalVenta;
	}

	@Digits(integer = 16, fraction = 2, message = IConstantes.VALIDACION_MAXIMO_DECIMAL)
	public BigDecimal getValorTotalIva() {
		return valorTotalIva;
	}

	public void setValorTotalIva(BigDecimal valorTotalIva) {
		this.valorTotalIva = valorTotalIva;
	}

	@Digits(integer = 16, fraction = 2, message = IConstantes.VALIDACION_MAXIMO_DECIMAL)
	public BigDecimal getValorTotalConIva() {
		return valorTotalConIva;
	}

	public void setValorTotalConIva(BigDecimal valorTotalConIva) {
		this.valorTotalConIva = valorTotalConIva;
	}

	@Digits(integer = 16, fraction = 2, message = IConstantes.VALIDACION_MAXIMO_DECIMAL)
	public BigDecimal getGananaciaConvenio() {
		return gananaciaConvenio;
	}

	public void setGananaciaConvenio(BigDecimal gananaciaConvenio) {
		this.gananaciaConvenio = gananaciaConvenio;
	}

	public Date getFechaTransaccion() {
		return fechaTransaccion;
	}

	public void setFechaTransaccion(Date fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}

	public Date getHoraTransaccion() {
		return horaTransaccion;
	}

	public void setHoraTransaccion(Date horaTransaccion) {
		this.horaTransaccion = horaTransaccion;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public String getEstadoTransaccion() {
		return estadoTransaccion;
	}

	public void setEstadoTransaccion(String estadoTransaccion) {
		this.estadoTransaccion = estadoTransaccion;
	}

	public EstructuraTabla getEstructuraTabla() {
		return estructuraTabla;
	}

	public void setEstructuraTabla(EstructuraTabla estructuraTabla) {
		this.estructuraTabla = estructuraTabla;
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

	public String gettOperadorConsulta() {
		return tOperadorConsulta;
	}

	public void settOperadorConsulta(String tOperadorConsulta) {
		this.tOperadorConsulta = tOperadorConsulta;
	}

	public String gettOperadorVentas() {
		return tOperadorVentas;
	}

	public void settOperadorVentas(String tOperadorVentas) {
		this.tOperadorVentas = tOperadorVentas;
	}

	public String getIdiomaTransaccion() {
		return idiomaTransaccion;
	}

	public void setIdiomaTransaccion(String idiomaTransaccion) {
		this.idiomaTransaccion = idiomaTransaccion;
	}

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	public String getIdTransaccion() {
		return idTransaccion;
	}

	public void setIdTransaccion(String idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

}
