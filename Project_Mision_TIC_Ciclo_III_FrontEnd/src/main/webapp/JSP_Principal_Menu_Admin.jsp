<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tienda Generica - Menu Principal</title>
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
	<div class="text-center">
		<img src="img/Icon_Bakery.png" width="150">
	</div>

	<nav class=" nav justify-content-center bg-primary">
		<li class="nav-item "><a class="nav-link active"
			data-bs-toggle="dropdown" href="#" role="button"
			aria-expanded="false" style="color: #fff">Home</a></li>


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
					href="Usuarios.jsp">Agregar</a></li>
				<li><a class="dropdown-item" style="color: #fff" href="#">Actualizar</a></li>
				<li><a class="dropdown-item" style="color: #fff" href="#">Consultar</a></li>
				<li><a class="dropdown-item" style="color: #fff" href="#">Eliminar</a></li>
			</ul></li>
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			data-bs-toggle="dropdown" href="#" role="button"
			aria-expanded="false" style="color: #fff">Productos</a>
			<ul class="dropdown-menu bg-primary">
				<li><a class="dropdown-item" style="color: #fff"
					href="Usuarios.jsp">Agregar</a></li>
				<li><a class="dropdown-item" style="color: #fff" href="#">Actualizar</a></li>
				<li><a class="dropdown-item" style="color: #fff" href="#">Consultar</a></li>
				<li><a class="dropdown-item" style="color: #fff" href="#">Eliminar</a></li>
			</ul></li>
	</nav>
</body>
</html>