<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import='jsons.Clients'%>
<html>

<head>

<meta charset="ISO-8859-1">

<title>Usuarios</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

</head>

<body>
	<%
	Clients client= (Clients) request.getAttribute("resultShowClient");
	if (client != null) {
		if (client.getClient_id() == 0) {
	%>
	<div class="alert alert-danger d-flex align-items-center" role="alert"
		style="position: absolute; width: 100%">
		<svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img"
			aria-label="Success:">
					<use xlink:href="#check-circle-fill" /></svg>
		<div>El cliente con la cedula ingresada no existe en el sistema</div>
	</div>

	<%
	}
	}
	%>

	<iframe src ="JSP_Menu.jsp" style="width: 100%; height: 70pt"></iframe>

	<div class="text-center" style="background-color: #0b5ed7;">
		<h4 class="h4" style="color: #fff">Consultar Cliente</h4>
	</div>
	<form method="post" action="./Servlet">
		<table>
			<tr>
				<td><div class="input-group mb-3">
						<span class="input-group-text" id="basic-addon1">Cedula</span> <label><input
							type="number" name="showC_clientId" class="form-control"
							placeholder="" aria-label="cedula"
							aria-describedby="basic-addon1"></label>
					</div></td>
				<tr></tr>
			<tr>
				<td><button type="submit" name="showC_showClient"
						class="btn btn-primary">Consultar Usuario</button></td>
			</tr>
		</table>
	</form>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>

	<%
	if (client != null) {
		if (client.getClient_id() == 0) {
	%>

				<%
				} else {
				%>
	<br>
	<table class="table">
		<thead>
			<tr>
				<th scope="col" class="bg-primary" style="color: white">Cedula</th>
				<th scope="col" class="bg-primary" style="color: white">Nombre</th>
				<th scope="col" class="bg-primary" style="color: white">Dirección</th>
				<th scope="col" class="bg-primary" style="color: white">Teléfono</th>
				<th scope="col" class="bg-primary" style="color: white">Correo</th>

			</tr>
		</thead>
		<tbody>
			<tr>
				<th class="table-light" scope="row"><%=client.getClient_id()%></th>
				<td class="table-light"><%=client.getClient_name()%></td>
				<td class="table-light"><%=client.getClient_address()%></td>
				<td class="table-light"><%=client.getClient_phone()%></td>
				<td class="table-light"><%=client.getClient_email()%></td>

			</tr>

		</tbody>
	</table>

	<%
	}
	} else {
	%>

	<%
	}
	%>

			</body>
</html>