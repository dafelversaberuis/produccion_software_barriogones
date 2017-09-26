package fundacionFRC.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import fundacionFRC.generales.ConsultarFuncionesAPI;
import fundacionFRC.generales.IConstantes;

public class Arbolito extends ConsultarFuncionesAPI implements Serializable {

	/**
	 * 
	 */
	private static final long		serialVersionUID	= -5329428856209605564L;
	private Integer							id;
	private String							nombre;
	private String							nombreUS;
	private String							descripcion;
	private String							descripcionUS;
	private BigDecimal					precioVentaPesos;
	private BigDecimal					precioVentaUS;
	private BigDecimal					ivaPesos;
	private BigDecimal					ivaUs;
	private BigDecimal					precioVentaPesosConIva;
	private BigDecimal					precioVentaUSConIva;
	private String							estadoVigencia;
	private Integer							cantidadDisponible;
	private Integer							cantidadVendida;
	private Integer							cantidadUsadaReemplazos;
	private Integer							cantidadPendientePago;

	private Iva									iva;

	private EstructuraTabla			estructuraTabla;

	// temporal
	private Integer							TcantidadCarrito;
	private Bolsa								TBolsa;

	private BigDecimal					TPrecioTotalPesosSinIva;
	private BigDecimal					TPrecioTotalUSSinIva;
	private BigDecimal					TTotalIvaPesos;
	private BigDecimal					TTotalIvaUS;
	private BigDecimal					TPrecioTotalPesosConIva;
	private BigDecimal					TPrecioTotalUSConIva;

	private List<String>				TNombresFotos;
	private List<FotoArbolito>	Tfotos;

	public Arbolito() {
		this.estructuraTabla = new EstructuraTabla();
		this.iva = new Iva();
		// la bolsa como es temp y esta es 1-1 no lo instanciamos para que no quede
		// cíclico.

	}

	public void getCamposBD() {

		this.estructuraTabla.setTabla("arbolitos");
		this.estructuraTabla.getLlavePrimaria().put("id", this.id);

		this.estructuraTabla.getPersistencia().put("nombre", this.nombre);
		this.estructuraTabla.getPersistencia().put("nombre_us", this.nombreUS);
		this.estructuraTabla.getPersistencia().put("descripcion", this.descripcion);
		this.estructuraTabla.getPersistencia().put("descripcion_us", this.descripcionUS);
		this.estructuraTabla.getPersistencia().put("precio_cop_sin_iva", this.precioVentaPesos);
		this.estructuraTabla.getPersistencia().put("precio_us_sin_iva", this.precioVentaUS);

		this.estructuraTabla.getPersistencia().put("valor_iva_cop", this.ivaPesos);
		this.estructuraTabla.getPersistencia().put("valor_iva_us", this.ivaUs);

		this.estructuraTabla.getPersistencia().put("precio_cop_con_iva", this.precioVentaPesosConIva);
		this.estructuraTabla.getPersistencia().put("precio_us_con_iva", this.precioVentaUSConIva);

		this.estructuraTabla.getPersistencia().put("estado_vigencia", this.estadoVigencia);
		this.estructuraTabla.getPersistencia().put("cantidad_disponible", this.cantidadDisponible);
		this.estructuraTabla.getPersistencia().put("cantidad_vendida", this.cantidadVendida);
		this.estructuraTabla.getPersistencia().put("cantidad_usada_reemplazos", this.cantidadUsadaReemplazos);
		this.estructuraTabla.getPersistencia().put("cantidad_pendiente_pago", this.cantidadPendientePago);

		if (this.iva != null && this.iva.getId() != null) {
			this.estructuraTabla.getPersistencia().put("id_iva", this.iva.getId());
		} else {
			this.estructuraTabla.getPersistencia().put("id_iva", null);
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

	@Size(max = 250, message = IConstantes.VALIDACION_MAXIMA_LONGITUD)
	public String getNombreUS() {
		return nombreUS;
	}

	public void setNombreUS(String nombreUS) {
		this.nombreUS = nombreUS;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcionUS() {
		return descripcionUS;
	}

	public void setDescripcionUS(String descripcionUS) {
		this.descripcionUS = descripcionUS;
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

	@Min(value = 0, message = IConstantes.VALIDACION_MINIMO_ENTERO)
	public Integer getCantidadPendientePago() {
		return cantidadPendientePago;
	}

	public void setCantidadPendientePago(Integer cantidadPendientePago) {
		this.cantidadPendientePago = cantidadPendientePago;
	}

	@Min(value = 0, message = IConstantes.VALIDACION_MINIMO_ENTERO)
	public Integer getCantidadUsadaReemplazos() {
		return cantidadUsadaReemplazos;
	}

	public void setCantidadUsadaReemplazos(Integer cantidadUsadaReemplazos) {
		this.cantidadUsadaReemplazos = cantidadUsadaReemplazos;
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

	public List<FotoArbolito> getTfotos() {
		return Tfotos;
	}

	public void setTfotos(List<FotoArbolito> tfotos) {
		Tfotos = tfotos;
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

	public Bolsa getTBolsa() {
		return TBolsa;
	}

	public void setTBolsa(Bolsa tBolsa) {
		TBolsa = tBolsa;
	}

	public BigDecimal getTPrecioTotalUSConIva() {
		return TPrecioTotalUSConIva;
	}

	public void setTPrecioTotalUSConIva(BigDecimal tPrecioTotalUSConIva) {
		TPrecioTotalUSConIva = tPrecioTotalUSConIva;
	}

	public List<String> getTNombresFotos() {
		return TNombresFotos;
	}

	public void setTNombresFotos(List<String> tNombresFotos) {
		TNombresFotos = tNombresFotos;
	}

}
