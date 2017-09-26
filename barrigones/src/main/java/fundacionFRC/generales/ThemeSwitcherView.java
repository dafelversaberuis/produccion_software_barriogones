package fundacionFRC.generales;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ThemeSwitcherView  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8722051874073244241L;
	private Integer	id		= 6;
	private String	tema;

	public String getTema() {
		if(tema==null){
			tema	= "afternoon";
		}
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
