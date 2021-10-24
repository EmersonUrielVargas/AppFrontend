<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/estilos.css" rel="stylesheet" type="text/css">
<title>Usuarios</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

</head>
<body>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>

	<%
	Object auxRequest = request.getAttribute("resultAddUser");
	if (auxRequest != null) {
		boolean result = (boolean) auxRequest;
		if (result == true) {
	%>
	<div class="alert alert-success d-flex align-items-center" role="alert"
		style="position: absolute; width: 100%">
		<svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img"
			aria-label="Success:">
					<use xlink:href="#check-circle-fill" /></svg>
		<div>Usuario agregado con éxito</div>
	</div>

	<%
	} else {
	%>
	<div class="alert alert-danger d-flex align-items-center" role="alert"
		style="position: absolute; width: 100%">
		<svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img"
			aria-label="Danger:">
				<use xlink:href="#exclamation-triangle-fill" /></svg>
		<div>El usuario ya existe en el sistema</div>
	</div>


	<%
	}
	}
	%>
   <iframe src ="JSP_Menu.jsp" style="width: 100%; height: 70pt"></iframe>


	<div class="text-center" style="background-color: #0b5ed7;">
		<h4 class="h4" style="color: #fff">Creación de Usuarios</h4>
	</div>

	<div style="margin-left: 5%">
		<div class="row">
			<div class="col-9">

				<form method="post" action="./Servlet">
					<table>
						<td><div class="input-group mb-3">
								<span class="input-group-text" id="basic-addon1">Cedula</span> <label><input
									type="number" required="required" name="createU_userId"
									class="form-control" placeholder="" aria-label="cedula"
									aria-describedby="basic-addon1"></label>
							</div></td>
						<td><div class="input-group mb-3">
								<span class="input-group-text" id="basic-addon1">Nombre</span> <label><input
									type="text" required="required" name="createU_userName"
									class="form-control" placeholder="" aria-label="Usuario"
									aria-describedby="basic-addon1"></label>
							</div></td>
						<tr></tr>
						<td><div class="input-group mb-3">
								<span class="input-group-text" id="basic-addon1">Usuario</span>
								<label><input type="text" required="required"
									name="createU_user" class="form-control" placeholder=""
									aria-label="Nombre" aria-describedby="basic-addon1"></label>
							</div></td>
						<td><div class="input-group mb-3">
								<span class="input-group-text" id="basic-addon1">Contraseña</span>
								<label><input type="text" required="required"
									name="createU_password" class="form-control" placeholder=""
									aria-label="Contraseña" aria-describedby="basic-addon1"></label>
							</div></td>
						<tr></tr>
						<td><div class="input-group mb-3">
								<span class="input-group-text" id="basic-addon1">Correo
									electronico</span> <label><input type="email"
									required="required" name="createU_emailUser"
									class="form-control" placeholder="" aria-label="correo"
									aria-describedby="basic-addon1"></label>
							</div></td>
						<tr></tr>

						<td><button type="submit" name="createU_addUser"
								class="btn btn-primary">Agregar Usuario</button></td>
					</table>
				</form>

			</div>
			<div class="col-3" style="background-color: blue"></div>
		</div>
	</div>

</body>
</html>