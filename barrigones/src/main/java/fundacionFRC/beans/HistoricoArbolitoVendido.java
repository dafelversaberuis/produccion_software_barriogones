package fundacionFRC.beans;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import fundacionFRC.generales.IConstantes;

public class HistoricoArbolitoVendido implements Serializable {

	/**
	 * 
	 */
	private static final long			serialVersionUID	= -5695119060664450430L;

	private Integer								id;

	private String								nombrePersonalizadoArbolito;
	private String								mensajePlaca;
	private String								correoReceptorRegalo;
	private Integer								numeroInterno;
	private String								indicativoBolsa;

	private Venta									venta;
	private Lote									lote;
	private Arbolito							arbolito;
	private Estado								estado;
	private String								historicoSuperior;

	private String								Tregalarlo;
	private String								TPlacaNombreParticular;
	private String								TReemplazado;

	private EstructuraTabla				estructuraTabla;

	private List<FotoArbolito>		tFotos;
	private List<HistoricoEstado>	tEstadosHistoricos;

	public HistoricoArbolitoVendido() {
		this.estructuraTabla = new EstructuraTabla();

		this.venta = new Venta();
		this.lote = new Lote();
		this.arbolito = new Arbolito();
		this.estado = new Estado();
		// this.historicoSuperior = new HistoricoArbolitoVendido();

	}

	public void getCamposBD() {

		this.estructuraTabla.setTabla("historico_arbolito_vendido");
		this.estructuraTabla.getLlavePrimaria().put("id", this.id);

		this.estructuraTabla.getPersistencia().put("nombre_arbolito", this.nombrePersonalizadoArbolito);
		this.estructuraTabla.getPersistencia().put("mensaje_placa", this.mensajePlaca);

		this.estructuraTabla.getPersistencia().put("correo_electronico_regalo", this.correoReceptorRegalo);

		this.estructuraTabla.getPersistencia().put("numero_interno", this.numeroInterno);
		
		this.estructuraTabla.getPersistencia().put("indicativo_bolsa", this.indicativoBolsa);

		if (this.venta != null && this.venta.getId() != null) {
			this.estructuraTabla.getPersistencia().put("id_venta", this.venta.getId());
		} else {
			this.estructuraTabla.getPersistencia().put("id_venta", null);
		}

		if (this.lote != null && this.lote.getId() != null) {
			this.estructuraTabla.getPersistencia().put("id_lote", this.lote.getId());
		} else {
			this.estructuraTabla.getPersistencia().put("id_lote", null);
		}

		if (this.arbolito != null && this.arbolito.getId() != null) {
			this.estructuraTabla.getPersistencia().put("id_arbolito", this.arbolito.getId());
		} else {
			this.estructuraTabla.getPersistencia().put("id_arbolito", null);
		}

		if (this.estado != null && this.estado.getId() != null) {
			this.estructuraTabla.getPersistencia().put("id_estado", this.estado.getId());
		} else {
			this.estructuraTabla.getPersistencia().put("id_estado", null);
		}

		this.estructuraTabla.getPersistencia().put("id_historico_sup", this.historicoSuperior);

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Size(max = 100, message = IConstantes.VALIDACION_MAXIMA_LONGITUD)
	public String getNombrePersonalizadoArbolito() {
		return nombrePersonalizadoArbolito;
	}

	public void setNombrePersonalizadoArbolito(String nombrePersonalizadoArbolito) {
		this.nombrePersonalizadoArbolito = nombrePersonalizadoArbolito;
	}

	@Size(max = 250, message = IConstantes.VALIDACION_MAXIMA_LONGITUD)
	public String getMensajePlaca() {
		return mensajePlaca;
	}

	public void setMensajePlaca(String mensajePlaca) {
		this.mensajePlaca = mensajePlaca;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Lote getLote() {
		return lote;
	}

	public void setLote(Lote lote) {
		this.lote = lote;
	}

	public Arbolito getArbolito() {
		return arbolito;
	}

	public void setArbolito(Arbolito arbolito) {
		this.arbolito = arbolito;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Size(max = 250, message = IConstantes.VALIDACION_MAXIMA_LONGITUD)
	public String getHistoricoSuperior() {
		return historicoSuperior;
	}

	public void setHistoricoSuperior(String historicoSuperior) {
		this.historicoSuperior = historicoSuperior;
	}

	public EstructuraTabla getEstructuraTabla() {
		return estructuraTabla;
	}

	public void setEstructuraTabla(EstructuraTabla estructuraTabla) {
		this.estructuraTabla = estructuraTabla;
	}

	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = IConstantes.VALIDACION_EMAIL_INCORRECTO)
	public String getCorreoReceptorRegalo() {
		return correoReceptorRegalo;
	}

	public void setCorreoReceptorRegalo(String correoReceptorRegalo) {
		this.correoReceptorRegalo = correoReceptorRegalo;
	}

	public String getTregalarlo() {
		return Tregalarlo;
	}

	public void setTregalarlo(String tregalarlo) {
		Tregalarlo = tregalarlo;
	}

	public Integer getNumeroInterno() {
		return numeroInterno;
	}

	public void setNumeroInterno(Integer numeroInterno) {
		this.numeroInterno = numeroInterno;
	}

	public String getTPlacaNombreParticular() {
		return TPlacaNombreParticular;
	}

	public void setTPlacaNombreParticular(String tPlacaNombreParticular) {
		TPlacaNombreParticular = tPlacaNombreParticular;
	}

	public String getTReemplazado() {
		return TReemplazado;
	}

	public void setTReemplazado(String tReemplazado) {
		TReemplazado = tReemplazado;
	}

	public List<FotoArbolito> gettFotos() {
		return tFotos;
	}

	public void settFotos(List<FotoArbolito> tFotos) {
		this.tFotos = tFotos;
	}

	public List<HistoricoEstado> gettEstadosHistoricos() {
		return tEstadosHistoricos;
	}

	public void settEstadosHistoricos(List<HistoricoEstado> tEstadosHistoricos) {
		this.tEstadosHistoricos = tEstadosHistoricos;
	}

	public String getIndicativoBolsa() {
		return indicativoBolsa;
	}

	public void setIndicativoBolsa(String indicativoBolsa) {
		this.indicativoBolsa = indicativoBolsa;
	}

}
