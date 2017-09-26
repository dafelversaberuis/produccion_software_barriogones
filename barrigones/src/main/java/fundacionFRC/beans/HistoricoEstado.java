package fundacionFRC.beans;

import java.io.Serializable;

public class HistoricoEstado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2861840198978073729L;
	private Integer										id;
	private Estado										estado;
	private HistoricoArbolitoVendido	historico;

	private EstructuraTabla						estructuraTabla;

	public HistoricoEstado() {
		this.estructuraTabla = new EstructuraTabla();
		this.estado = new Estado();
		this.historico = new HistoricoArbolitoVendido();

	}

	public void getCamposBD() {

		this.estructuraTabla.setTabla("historico_estados");
		this.estructuraTabla.getLlavePrimaria().put("id", this.id);

		if (this.estado != null && this.estado.getId() != null) {
			this.estructuraTabla.getPersistencia().put("id_estado", this.estado.getId());
		} else {
			this.estructuraTabla.getPersistencia().put("id_estado", null);
		}

		if (this.historico != null && this.historico.getId() != null) {
			this.estructuraTabla.getPersistencia().put("id_historico", this.historico.getId());
		} else {
			this.estructuraTabla.getPersistencia().put("id_historico", null);
		}

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public HistoricoArbolitoVendido getHistorico() {
		return historico;
	}

	public void setHistorico(HistoricoArbolitoVendido historico) {
		this.historico = historico;
	}

	public EstructuraTabla getEstructuraTabla() {
		return estructuraTabla;
	}

	public void setEstructuraTabla(EstructuraTabla estructuraTabla) {
		this.estructuraTabla = estructuraTabla;
	}

}
