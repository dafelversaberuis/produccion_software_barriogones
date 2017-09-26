package fundacionFRC.beans;

import java.io.Serializable;

import javax.validation.constraints.Size;

import fundacionFRC.generales.IConstantes;

public class FotoArbolito implements Serializable {

	/**
	 * 
	 */
	private static final long					serialVersionUID	= 2807601402746059357L;
	private Integer										id;
	private String										titulo;
	private byte[]										foto;
	private String										fotoDecofificada;

	private Arbolito									arbolito;
	private HistoricoArbolitoVendido	historicoArbolitoVendido;
	private Lote											lote;

	private EstructuraTabla						estructuraTabla;

	public FotoArbolito() {
		this.estructuraTabla = new EstructuraTabla();
		this.arbolito = new Arbolito();
		this.historicoArbolitoVendido = new HistoricoArbolitoVendido();
		this.lote = new Lote();
	}

	public void getCamposBD() {

		this.estructuraTabla.setTabla("fotos_arbolitos");
		this.estructuraTabla.getLlavePrimaria().put("id", this.id);

		this.estructuraTabla.getPersistencia().put("titulo", this.titulo);
		this.estructuraTabla.getPersistencia().put("foto", this.foto);

		if (this.arbolito != null && this.arbolito.getId() != null) {
			this.estructuraTabla.getPersistencia().put("id_arbolito", this.arbolito.getId());
		} else {
			this.estructuraTabla.getPersistencia().put("id_arbolito", null);
		}

		if (this.historicoArbolitoVendido != null && this.historicoArbolitoVendido.getId() != null) {
			this.estructuraTabla.getPersistencia().put("id_historico_arbolito", this.historicoArbolitoVendido.getId());
		} else {
			this.estructuraTabla.getPersistencia().put("id_historico_arbolito", null);
		}

		if (this.lote != null && this.lote.getId() != null) {
			this.estructuraTabla.getPersistencia().put("id_lote", this.lote.getId());
		} else {
			this.estructuraTabla.getPersistencia().put("id_lote", null);
		}

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Size(max = 250, message = IConstantes.VALIDACION_MAXIMA_LONGITUD)
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Arbolito getArbolito() {
		return arbolito;
	}

	public void setArbolito(Arbolito arbolito) {
		this.arbolito = arbolito;
	}

	public HistoricoArbolitoVendido getHistoricoArbolitoVendido() {
		return historicoArbolitoVendido;
	}

	public void setHistoricoArbolitoVendido(HistoricoArbolitoVendido historicoArbolitoVendido) {
		this.historicoArbolitoVendido = historicoArbolitoVendido;
	}

	public Lote getLote() {
		return lote;
	}

	public void setLote(Lote lote) {
		this.lote = lote;
	}

	public EstructuraTabla getEstructuraTabla() {
		return estructuraTabla;
	}

	public void setEstructuraTabla(EstructuraTabla estructuraTabla) {
		this.estructuraTabla = estructuraTabla;
	}

	public String getFotoDecofificada() {
		return fotoDecofificada;
	}

	public void setFotoDecofificada(String fotoDecofificada) {
		this.fotoDecofificada = fotoDecofificada;
	}

}
