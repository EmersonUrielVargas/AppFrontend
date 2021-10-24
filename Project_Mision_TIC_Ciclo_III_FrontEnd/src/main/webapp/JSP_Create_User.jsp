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
	<div class="text-center">
		<img src="img/Logo_Bakery.png" width="300">
	</div>

	<nav class=" nav justify-content-center bg-primary">
		<li class="nav-item "><a class="nav-link active"
			data-bs-toggle="dropdown" href="JSP_Principal_Menu_Admin.jsp"
			role="button" aria-expanded="false" style="color: #fff">Home</a></li>


		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			data-bs-toggle="dropdown" href="#" role="button"
			aria-expanded="false" style="color: #fff">Usuarios</a>

			<ul class="dropdown-menu bg-primary">
				<li><a class="dropdown-item" style="color: #fff"
					href="JSP_Create_User.jsp">Agregar</a></li>
				<li><a class="dropdown-item" style="color: #fff"
					href="JSP_Update_User.jsp"">Actualizar</a></li>
				<li><a class="dropdown-item" style="color: #fff"
					href="JSP_Show_User.jsp">Consultar</a></li>
				<li><a class="dropdown-item" style="color: #fff"
					href="JSP_Delete_User.jsp">Eliminar</a></li>
			</ul></li>

		<li class="nav-item dropdown "><a
			class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#"
			role="button" aria-expanded="false" style="color: #fff">Proveedores</a>
			<ul class="dropdown-menu bg-primary">
				<li><a class="dropdown-item" style="color: #fff"
					href="Usuarios.jsp">Agregar</a></li>
				<li><a class="dropdown-item" style="color: #fff" href="#">Actualizar</a></li>
				<li><a class="dropdown-item" style="color: #fff" href="#">Consultar</a></li>
				<li><a class="dropdown-item" style="color: #fff" href="#">Eliminar</a></li>
			</ul></li>
		<li class="nav-item dropdown "><a
			class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#"
			role="button" aria-expanded="false" style="color: #fff">Clientes</a>
			<ul class="dropdown-menu bg-primary">
				<li><a class="dropdown-item" style="color: #fff"
					href="JSP_Create_Client.jsp">Agregar</a></li>
				<li><a class="dropdown-item" style="color: #fff"
					href="JSP_Update_Client.jsp">Actualizar</a></li>
				<li><a class="dropdown-item" style="color: #fff"
					href="JSP_Show_Client.jsp">Consultar</a></li>
				<li><a class="dropdown-item" style="color: #fff"
					href="JSP_Delete_Client.jsp">Eliminar</a></li>
			</ul></li>
		<li class="nav-item "><a class="nav-link active"
			data-bs-toggle="dropdown" href="#" role="button"
			aria-expanded="false" style="color: #fff">Productos</a></li>
		<li class="nav-item "><a class="nav-link active"
			data-bs-toggle="dropdown" href="#" role="button"
			aria-expanded="false" style="color: #fff">Ventas</a></li>
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			data-bs-toggle="dropdown" href="#" role="button"
			aria-expanded="false" style="color: #fff">Reportes</a>
			<ul class="dropdown-menu bg-primary">
				<li><a class="dropdown-item" style="color: #fff"
					href="Usuarios.jsp">Agregar</a></li>
				<li><a class="dropdown-item" style="color: #fff" href="#">Actualizar</a></li>
				<li><a class="dropdown-item" style="color: #fff" href="#">Consultar</a></li>
				<li><a class="dropdown-item" style="color: #fff" href="#">Eliminar</a></li>
			</ul></li>

		<li class="nav-item "><a class="nav-link active"
			data-bs-toggle="dropdown" href="index.jsp" role="button"
			aria-expanded="false" style="color: #fff">Cerrar sesión</a></li>
	</nav>

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
			
		</div>
	</div>

</body>
</html>