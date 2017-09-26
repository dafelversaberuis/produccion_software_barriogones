package fundacionFRC.beans;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import fundacionFRC.generales.IConstantes;

public class Comprador implements Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -5046382594252331349L;
	private Integer						id;
	private String						nombreCompleto;
	private String						correoElectronico;
	private String						clave;
	private Integer						codigoPais;
	private Integer						celular;
	private Integer						idCompradorDonador;

	private String						TnumeroCorroborar;
	private String						TnumeroEscrito;
	private String						tCorreoConsulta;

	private EstructuraTabla		estructuraTabla;

	public Comprador() {
		this.estructuraTabla = new EstructuraTabla();

		// this.compradorDonador = new Comprador();

	}

	public void getCamposBD() {

		this.estructuraTabla.setTabla("compradores");
		this.estructuraTabla.getLlavePrimaria().put("id", this.id);

		this.estructuraTabla.getPersistencia().put("nombre_completo", this.nombreCompleto);
		this.estructuraTabla.getPersistencia().put("correo_electronico", this.correoElectronico);
		this.estructuraTabla.getPersistencia().put("clave", this.clave);
		this.estructuraTabla.getPersistencia().put("codigo_pais", this.codigoPais);
		this.estructuraTabla.getPersistencia().put("celular", this.celular);

		this.estructuraTabla.getPersistencia().put("id_comprador_donador", this.getId());

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Size(max = 250, message = IConstantes.VALIDACION_MAXIMA_LONGITUD)
	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = IConstantes.VALIDACION_EMAIL_INCORRECTO)
	@Size(max = 250, message = IConstantes.VALIDACION_MAXIMA_LONGITUD)
	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	@Size(max = 250, message = IConstantes.VALIDACION_MAXIMA_LONGITUD)
	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Min(value = 0, message = IConstantes.VALIDACION_MINIMO_ENTERO)
	public Integer getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(Integer codigoPais) {
		this.codigoPais = codigoPais;
	}

	@Max(value = 0, message = IConstantes.VALIDACION_MAXIMO_ENTERO)
	public Integer getCelular() {
		return celular;
	}

	public void setCelular(Integer celular) {
		this.celular = celular;
	}

	public Integer getIdCompradorDonador() {
		return idCompradorDonador;
	}

	public void setIdCompradorDonador(Integer idCompradorDonador) {
		this.idCompradorDonador = idCompradorDonador;
	}

	public EstructuraTabla getEstructuraTabla() {
		return estructuraTabla;
	}

	public void setEstructuraTabla(EstructuraTabla estructuraTabla) {
		this.estructuraTabla = estructuraTabla;
	}

	public String getTnumeroCorroborar() {
		return TnumeroCorroborar;
	}

	public void setTnumeroCorroborar(String tnumeroCorroborar) {
		TnumeroCorroborar = tnumeroCorroborar;
	}

	public String getTnumeroEscrito() {
		return TnumeroEscrito;
	}

	public void setTnumeroEscrito(String tnumeroEscrito) {
		TnumeroEscrito = tnumeroEscrito;
	}

	public String gettCorreoConsulta() {
		return tCorreoConsulta;
	}

	public void settCorreoConsulta(String tCorreoConsulta) {
		this.tCorreoConsulta = tCorreoConsulta;
	}

}
