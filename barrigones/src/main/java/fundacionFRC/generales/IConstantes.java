package fundacionFRC.generales;

import org.apache.log4j.Logger;

public interface IConstantes {

	// manejo de logs
	public static final Logger	log															= Logger.getLogger("barrigones");

	// validaciones anotaciones beans

	public static String				NOMBRE_SOFTWARE									= "Software - Adopta un árbol por la vida";
	public static String				VALIDACION_MAXIMA_LONGITUD			= "Máximo {max} caracteres";
	public static String				VALIDACION_MINIMA_LONGITUD			= "Mínimo {min} caracteres";
	public static String				VALIDACION_MAXIMO_ENTERO				= "Máximo {value}";
	public static String				VALIDACION_MINIMO_ENTERO				= "Mínimo {value}";
	public static String				VALIDACION_VACIO								= "No se permite sólo vacío";

	public static String				VALIDACION_ACTIVO_INACTIVO			= "Se debe especificar si está activo o inactivo";
	public static String				VALIDACION_SI_NO								= "Se debe especificar SI ó NO";
	public static String				VALIDACION_MAXIMO_DECIMAL				= "Máximo un número de {integer} digitos enteros y {fraction} decimales";
	public static String				VALIDACION_EMAIL_INCORRECTO			= "El formato del correo electrónico es incorrecto";
	public static String				VALIDACION_MONEDA								= "Sólo pesos colombianos ó dólares";

	public static Integer				NUMERO_CARACTERES_TARJETA				= 5;
	public static Integer				NUMERO_DIGITOS_CLAVE_ALEATORIA	= 6;
	public static String				AFIRMACION											= "S";
	public static String				NEGACION												= "N";
	public static String				ACTIVO													= "A";
	public static String				INACTIVO												= "I";
	public static String				PESO_COLOMBIANO									= "COP";
	public static String				DOLAR														= "US";
	public static String				IDIOMA_ESPANOL									= "ES";
	public static String				TRANSACCION_APROBADA						= "A";
	public static String				TRANSACCION_PENDIENTE						= "P";

	public static Integer				ARBOLITO_POR_DONACION						= 1;
	public static Integer				DECIMALES_REDONDEAR							= 2;
	public static Integer				VISTA_PERSONALIZACION						= 2;
	public static Integer				VISTA_lOGIN											= 1;
	public static Integer				MAXIMOS_REMITENTES_CORREO				= 100;

	public static final String	SMTP_HOST_NAME									= "smtp.gmail.com";
	public static final int			SMTP_HOST_PORT									= 465;
	public static final String	SMTP_AUTH_USER									= "quimerapps@gmail.com";
	public static final String	SMTP_AUTH_PWD										= "mariacamila12";

	public static String				ID_USUARIO_SESION								= "dafelver";

	public static final String	PAQUETE_MODULO_REPORTES					= "/reportes/";
	public static final String	PAQUETE_IMAGENES								= "/imagenes/";

	public static String				ESTADO_INICIAL_TRANSACCION			= "P";
	public static String				PAGINA_DESPUES_TRANSACCION			= "/arbolitos/adopcionCliente/administrarCuenta.xhtml?faces-redirect=true";																																																																																																																																																																																																																																																																																																																																									// "/arbolitos/adopcionCliente/administrarCuenta.xhtml?faces-redirect=true";
	public static String				PAGINA_NO_LOGUEO								= "/index.xhtml?faces-redirect=true";
	public static String				PAGINA_HOME											= "/home.xhtml?faces-redirect=true";

	public static final String	NOMBRE_REPORTE_TARJETAS					= "TARJETAS";
	public static final String	REPORTE_TARJETAS								= "imprimirTarjetas.jasper";

	// unicos correos que no detecta el properties

	public static final String	APROBACION_PARTICULAR_ES				= "<table width='100%' border='0' cellspacing='2' cellpadding='2'><tr><td><b>Software - Adopta un árbol por la Vida</b></td></tr><tr><td><b>Fundación Federico Restrepo Carvajal</b></td></tr><tr><td><br /></td></tr><tr><td>Felicitaciones <b>";
	public static final String	APROBACION_PARTICULAR_ES2				= "</b> !!!,</td></tr><tr><td><br /></td></tr><tr><td>Se ha <b>aprobado</b> una transacción de sus árboles adoptados. Puede ingresar a nuestro software en cualquier momento, adoptar un arbolito, conocer más sobre este detalle, visualizar los ya adoptados, regalar uno, entre otros. Para ingresar diríjase a el link http://barrigones.fundaciondrc.com</td></tr><tr><td><br /></td></tr><tr><td>PD: No responda este mensaje, pues ha sido enviada automáticamente por el software.</td></tr></table>";
	public static final String	ASUNTO_APROBACION_ES						= "Transacción de árboles aprobada";
	public static final String	MENSAJE_CORREO_REGALO_ES				= "<table width='100%' border='0' cellspacing='2' cellpadding='2'><tr><td><b>Software - Adopta un árbol por la Vida</b></td></tr><tr><td><b>Fundación Federico Restrepo Carvajal</b></td></tr><tr><td><br /></td></tr><tr><td>Estimado amigo,</td></tr><tr><td><br /></td></tr><tr><td><b>";
	public static final String	MENSAJE_CORREO_REGALO_ES2				= "</b> adoptó un arbolito y se lo regaló a usted. Puede ingresar a nuestro software en cualquier momento, adoptar un arbolito, conocer más sobre este detalle, visualizar los ya adoptados, regalar uno, entre otros. Para ingresar diríjase a el link http://barrigones.fundaciondrc.com</td></tr><tr><td><br /></td></tr><tr><td>PD: No responda este mensaje, pues ha sido enviada automáticamente por el software.</td></tr></table>";
	public static final String	ASUNTO_REGALO_ES								= "Un amigo le ha regalado un árbol";

	public static final String	APROBACION_PARTICULAR_US				= "[[mensaje en construcción-1]]";
	public static final String	APROBACION_PARTICULAR_US2				= "[[mensaje en construcción-1b]]";
	public static final String	ASUNTO_APROBACION_US						= "[[mensaje en construcción-2]]";
	public static final String	MENSAJE_CORREO_REGALO_US				= "[[mensaje en construcción-3]]";
	public static final String	MENSAJE_CORREO_REGALO_US2				= "[[mensaje en construcción-3b]]";
	public static final String	ASUNTO_REGALO_US								= "[[mensaje en construcción-4]]";

}
