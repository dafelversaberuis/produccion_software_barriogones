<%@page import="fundacionFRC.modulos.arbolitos.AdministrarSesionCliente"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:p="http://primefaces.org/ui">

<h:head>

	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport"
		content="width=device-width, initial-scale=1, maximum-scale=1" />
	<link rel="shortcut icon" href="/barrigones/plantillas/images/favicon.png" />
	<link rel="apple-touch-icon"
		href="/barrigones/plantillas/images/apple-touch-icon.png" />
	<link rel="apple-touch-icon" sizes="72x72"   
		href="/barrigones/plantillas/images/apple-touch-icon-72x72.png" />
	<link rel="apple-touch-icon" sizes="114x114"
		href="/barrigones/plantillas/images/apple-touch-icon-114x114.png" />
	<meta name="author" content="Quimerapps, adopta un árbol por la vida" />
	<title>Fundación Federico Restrepo Carvajal</title>
	<meta name="description"
		content="Somos una organización que aporta a la preservación del medioambiente, crea espacios de sano esparcimiento para los niños y jóvenes de Santander e impulsa y promueve la investigación científica en el campo de la Ortopedia y Traumatología." />
	<meta name="keywords"
		content="Fundación Federico Restrepo Carvajal, tenis de mesa, tenis, medioambiente, niños y jóvenes, deporte, vereda Llanadas, Mesa de los Santos, donación, ortopedia, traumatología, investigación, innovemos, vida sana, vida, ambiental, árbol, siembra." />
	<link
		href='http://fonts.googleapis.com/css?family=Roboto:100,300,300italic,400,700|Julius+Sans+One|Roboto+Condensed:300,400'
		rel='stylesheet' type='text/css' />
	<link rel="stylesheet" href="/barrigones/plantillas/css/style.css" />
	<link rel="stylesheet" href="/barrigones/plantillas/css/grid.css" />
	<link rel="stylesheet" href="/barrigones/plantillas/css/layout.css" />
	<link rel="stylesheet" href="/barrigones/plantillas/css/fontello.css" />
	<link rel="stylesheet" href="/barrigones/plantillas/css/animation.css" />
	<link rel="stylesheet"
		href="/barrigones/plantillas/js/fancybox/jquery.fancybox.css" />
	<script src="/barrigones/plantillas/js/jquery.modernizr.js"></script>
	<style type="text/css">
.ui-growl-title {
	font: 14px "Lucida Console", Monaco, monospace;
}

.ui-growl-message p {
	font: 16px "Lucida Console", Monaco, monospace;
}
</style>
</h:head>

<body data-spy="scroll" data-target="#navigation" class="page-template">
	<%
		String idioma = "ES";
		String idTransaccion = request.getParameter("transaction_id");
		String idReferencia = request.getParameter("req_reference_number");
		AdministrarSesionCliente registrar = new AdministrarSesionCliente();

		if (idReferencia != null && !idReferencia.trim().equals("")) {

			

			String[] partesTransaccion = idReferencia.split("barrigon");
			if (partesTransaccion != null && partesTransaccion.length > 1) {
				
				idioma= registrar.getIdiomaVenta(partesTransaccion[1]);
				
				
	%>
	<form id="formCliente">
		<header id="header">

		<div class="header-in">

			<h1 id="logo" style="font-size: 0 !important;">
				<a href="http://www.fundacionfrc.com" target="_blank"><img
					src="/barrigones/plantillas/images/logo.svg" alt="" width="210px" /></a>
			</h1>

			<a id="responsive-nav-button" class="responsive-nav-button" href="#"></a>

			<nav id="navigation" class="navigation">

			<ul>








			</ul>

			</nav>
		</div>
		</header>
		<div id="wrapper" align="center">

			<div style="width: 90%;" align="center">
				<br /> <br /> <br /> <br />

				<table>
					<tr>
						<td style="vertical-align: top"><div class="col-xs-12">
								<div class="project-page-header">
									<h1 class="project-title"><%if(idioma==null || (idioma!=null && idioma.equals("ES"))){ %>Felicitaciones...<%}else{ %>
Congratulations...<%} %></h1>
									<h1 class="project-title">
										<%if(idioma==null || (idioma!=null && idioma.equals("ES"))){ %>TU HA ADOPCIÓN SE HA PROCESADO EXITOSAMENTE <%}else{ %>
YOUR ADOPTION HAS BEEN SUCCESSFULLY PROCESSED<%} %><b><span
											style="color: #008000; font-size: 100px"> :)<br />
										</span><%="Id: " + idTransaccion%></b>
									</h1>


								</div>

								<br />

								<p class="input-block">
									<a class="button turquoise submit"
										href="arbolitos/adopcionCliente/administrarCuenta.jsf"
										style="width: 300px; height: 120px; font-size: 20px; vertical-align: bottom;"><%if(idioma==null || (idioma!=null && idioma.equals("ES"))){ %>Ir
										a tu cuenta<br /> y ver tus adopciones (CLIC AQUÍ)<%}else{ %>
Go to your account<br/> and see your adoptions ( CLICK HERE)<%} %></i>
									</a>
								</p>
							</div></td>
						<td><img src="/barrigones/imagenes/home.jpg" /></td>
					</tr>

				</table>




				<br /> <br /> <br />

			</div>
			<footer id="footer"> <section
				class="section parallax parallax-bg-4">

			<div class="full-bg-image"></div>
			<div class="container">
				<div class="row">
					<div align="left">
						<div class="col-md-6 opacity">
							<div class="widget widget_text opacity">
								<p><%if(idioma==null || (idioma!=null && idioma.equals("ES"))){ %>La Fundación Federico Restrepo Carvajal aporta a la
									preservación del medioambiente, crea espacios de sano
									esparcimiento para los niños y jóvenes de Santander e impulsa y
									promueve la investigación científica en el campo de la
									Ortopedia y Traumatología<%}else{ %>
La Fundación Federico Restrepo Carvajal contributes to the preservation of the environment, creates spaces for healthy recreation for children and young people from Santander and encourages and promotes scientific research in the field of Orthopedics and Traumatology<%} %></p>
							</div>
							<div class="widget widget_contacts opacity">
								<ul class="contact-details">
									<li><%if(idioma==null || (idioma!=null && idioma.equals("ES"))){ %>Dirección:Calle 47 # 29-69, oficina
										902,Bucaramanga,Colombia,680003<%}else{ %>Address: Calle 47 # 29-69 , office 902 , Bucaramanga, Colombia , 680003<%} %></li>
									<li><%if(idioma==null || (idioma!=null && idioma.equals("ES"))){ %>Teléfono: +57 318 209 91 30<%}else{ %>Phone: +57 318 209 91 30<%} %></li>
									<li>Email: contacto@fundacionfrc.com</li>
								</ul>


								<div class="copyright">
									<br /> <a target="_blank"><%if(idioma==null || (idioma!=null && idioma.equals("ES"))){ %>Software: Adopta un árbol por la
										vida - Diseñado por: quimerapps.com (dannypipe@gmail.com)<%}else{ %>Software: Adopt a tree by the life - Designed by : quimerapps.com ( dannypipe@gmail.com )<%} %></a>
								</div>
							</div>

						</div>
					</div>
					<div class="col-md-6">

						<div class="widget widget_social opacity">
							<ul class="social-icons">
								<li class="twitter"><a
									href="https://twitter.com/FundacionFRC" target="_blank"><i
										class="icon-twitter"></i>Twitter</a></li>
								<li class="facebook"><a
									href="https://www.facebook.com/fundacionfrc" target="_blank"><i
										class="icon-facebook"></i>Facebook</a></li>
								<li class="youtube"><a
									href="https://www.youtube.com/channel/UCJq5MDiLWLg8ZFD2dE3WgYQ"
									target="_blank"><i class="icon-youtube"></i>Youtube</a></li>
								<li class="instagram"><a href="http://www.fundacionfrc.com"
									target="_blank"><i class="icon-chrome"></i>Web</a></li>
							</ul>
						</div>


					</div>
				</div>

			</div>

			</section> </footer>
		</div>

	</form>

	<%
		}else{
			
			//significa que no es de barrigones sino de la página
			response.sendRedirect("http://www.fundacionfrc.com?t="+idTransaccion+"&r="+idReferencia);
		}
	%>


	<script src="/barrigones/plantillas/js/jquery.queryloader2.js"></script>
	<script src="/barrigones/plantillas/js/jquery.easing.1.3.min.js"></script>
	<script src="/barrigones/plantillas/js/jquery.cycle.all.min.js"></script>
	<script src="/barrigones/plantillas/js/jquery.smoothscroll.js"></script>
	<script src="/barrigones/plantillas/js/waypoints.min.js"></script>


	<script src="/barrigones/plantillas/js/fancybox/jquery.fancybox.pack.js"></script>
	<script src="/barrigones/plantillas/js/config.js"></script>
	<script src="/barrigones/plantillas/js/custom.js"></script>

	<%
		} else {
			response.sendRedirect("http://barrigones.fundacionfrc.com");
		}
	%>

</body>
</html>