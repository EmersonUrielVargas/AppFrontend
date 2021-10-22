<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/estilos.css" rel="stylesheet" type="text/css">
<title>Productos</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

</head>
<body>
	<nav class="navbar navbar-light bg-primary">
		<a class="navbar-brand mb-0 h1" href="Index.jsp">Tienda Generica</a>
		<div class="container-fluid">
		</div>
	</nav>

	<p align="center">CREACION DE USUARIOS</p>
	<form method="post" action="./DemoServlet">
		<table>
			<tr>
				<td><label>Cedula:</label></td>
				<td><input type="text" name="cedula"></td>
				<td><label>Nombre:</label></td>
				<td><input type="text" name="nombre"></td>
			</tr>
			<tr>
				<td><label>Correo Electronico:</label></td>
				<td><input type="text" name="email"></td>
				<td><label>Usuario:</label></td>
				<td><input type="text" name="usuario"></td>
			</tr>
			<tr>
				<td><label>Password:</label></td>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>
			<tr>
			<tr>
			<tr>
			<tr>
			<tr>
			<tr>
			<tr>
			<tr>
			<tr>
			<tr>
			<tr>
			<tr>
			<tr>
			<tr>
			<tr>
			<tr>
			<tr>
				<td><button type="submit" name="Listar">Consultar</button></td>

				<td><input type="submit" value="Agregar" name="Agregar"></td>

				<td><input type="submit" value="actualizar" name="actualizar"></td>

				<td><input type="submit" value="eliminar" name="eliminar"></td>

			</tr>
		</table>
	</form>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>