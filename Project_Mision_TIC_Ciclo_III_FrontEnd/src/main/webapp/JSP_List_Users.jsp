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
	<nav class="navbar navbar-light bg-primary">
		<a class="navbar-brand mb-0 h1" href="Index.jsp">Tienda Generica</a>
		<div class="container-fluid"></div>
	</nav>

	<p align="center">CREACION DE USUARIOS</p>
	<form method="post" action="./DemoServlet">
		<table>

			<td><div class="input-group mb-3">
					<span class="input-group-text" id="basic-addon1">Cedula</span> <label><input
						type="text" class="form-control" placeholder=""
						aria-label="cedula" aria-describedby="basic-addon1"></label>
				</div></td>
			<td><div class="input-group mb-3">
					<span class="input-group-text" id="basic-addon1">Usuario</span> <label><input
						type="text" class="form-control" placeholder=""
						aria-label="Usuario" aria-describedby="basic-addon1"></label>
				</div></td>
			<tr></tr>
			<td><div class="input-group mb-3">
					<span class="input-group-text" id="basic-addon1">Nombre</span> <label><input
						type="text" class="form-control" placeholder=""
						aria-label="Nombre" aria-describedby="basic-addon1"></label>
				</div></td>
			<td><div class="input-group mb-3">
					<span class="input-group-text" id="basic-addon1">Contraseña</span>
					<label><input type="text" class="form-control"
						placeholder="" aria-label="Contraseña"
						aria-describedby="basic-addon1"></label>
				</div></td>
			<tr></tr>
			<td><div class="input-group mb-3">
					<span class="input-group-text" id="basic-addon1">Correo
						electronico</span> <label><input type="text" class="form-control"
						placeholder="" aria-label="correo" aria-describedby="basic-addon1"></label>
				</div></td>
		</table>
		<tr></tr>
		<button type="submit" class="btn btn-outline-info">Consultar</button>

		<input type="submit" value="Agregar" class="btn btn-outline-info">

		<input type="submit" value="actualizar" class="btn btn-outline-info">

		<input type="submit" value="eliminar" class="btn btn-outline-info">


	</form>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>