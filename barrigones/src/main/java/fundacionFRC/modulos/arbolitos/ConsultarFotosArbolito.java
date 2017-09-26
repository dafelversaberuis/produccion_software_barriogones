package fundacionFRC.modulos.arbolitos;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import fundacionFRC.beans.Arbolito;
import fundacionFRC.beans.FotoArbolito;
import fundacionFRC.generales.IConstantes;
import fundacionFRC.modulos.IConsultasDAO;

@ManagedBean
@ApplicationScoped
public class ConsultarFotosArbolito implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2663492572120860722L;

	/**
	 * Obtiene las fotos de un arbolito pero no las carga en sesión
	 * 
	 * @param aArbolito
	 * @return fotos
	 */
	public List<FotoArbolito> getFotosArbolito(Arbolito aArbolito) {
		List<FotoArbolito> fotos = null;
		try {
			FotoArbolito foto = new FotoArbolito();

			foto.setArbolito(aArbolito);
			fotos = IConsultasDAO.getFotosArbolitos(foto);

		} catch (Exception e) {
			IConstantes.log.error(e, e);
		}

		return fotos;

	}

}
