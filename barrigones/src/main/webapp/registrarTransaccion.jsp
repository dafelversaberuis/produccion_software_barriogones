<%@page import="fundacionFRC.modulos.arbolitos.AdministrarSesionCliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fundación Federico Restrepo Carvajal</title>
</head>
<body>

	<%

String idTransaccion = request.getParameter("transaction_id");
String idReferencia = request.getParameter("req_reference_number");
String idEstadoTransaccion = request.getParameter("reason_code");

AdministrarSesionCliente registrar = new AdministrarSesionCliente();

if(idReferencia!=null && idTransaccion!=null && idEstadoTransaccion!=null && (idEstadoTransaccion.equals("100") || idEstadoTransaccion.equals("110"))){
	
	String [] partesTransaccion = idReferencia.split("barrigon");
	if(partesTransaccion!=null && partesTransaccion.length>1){
		registrar.aprobarVentaSileciosa(partesTransaccion[1], idTransaccion, idEstadoTransaccion);
		
	}

}




%>
</body>
</html>