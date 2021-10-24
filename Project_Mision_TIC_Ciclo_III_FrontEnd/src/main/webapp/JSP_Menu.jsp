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
		
	<div style =" width: 100%; height: 71pt; position: fixed; background-color: #0d6efd;  "  >
	<div class="text-center" style =" width: 20%; float: left; background-color: #fff" >
		<img src="img/Logo_Bakery.png" width="300">
	</div>

	<nav class=" nav justify-content-center bg-primary" style =" width: 80%; margin-left:0; padding: 2% 0 1% 0;">
		<li class="nav-item "  style="padding: 0 1% 0 1%;">
		<img src="img/home.png" >
		<a class="nav-link active"data-bs-toggle="dropdown" href="JSP_Principal_Menu_Admin.jsp" 
		role="button" aria-expanded="true" style="color: #fff;float: right; ">Home</a></li>


		<li class="nav-item dropdown" style="padding:0 1% 0 1%;">
		<img src="img/home.png">
		<a class="nav-link dropdown-toggle"
			data-bs-toggle="dropdown" href="#" role="button"
			aria-expanded="true" style="color: #fff; float: right;">Usuarios</a>

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

		<li class="nav-item dropdown "  style="padding: 0 1% 0 1%;">
		<img src="img/home.png">
		<a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#"
			role="button" aria-expanded="false" style="color: #fff;float: right;">Proveedores</a>
			<ul class="dropdown-menu bg-primary">
				<li><a class="dropdown-item" style="color: #fff" href="JSP_Create_Vendor.jsp">Agregar</a></li>
				<li><a class="dropdown-item" style="color: #fff" href="JSP_Update_Vendor.jsp">Actualizar</a></li>
				<li><a class="dropdown-item" style="color: #fff" href="JSP_Show_Vendor.jsp">Consultar</a></li>
				<li><a class="dropdown-item" style="color: #fff" href="JSP_Delete_Vendor.jsp">Eliminar</a></li>
			</ul></li>
		<li class="nav-item dropdown "  style="padding: 0 1% 0 1%;"><a
			class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#"
			role="button" aria-expanded="false" style="color: #fff; float: right;">Clientes</a>
			<ul class="dropdown-menu bg-primary">
				<li><a class="dropdown-item" style="color: #fff"href="JSP_Create_Client.jsp">Agregar</a></li>
				<li><a class="dropdown-item" style="color: #fff" href="JSP_Update_Client.jsp">Actualizar</a></li>
				<li><a class="dropdown-item" style="color: #fff" href="JSP_Show_Client.jsp">Consultar</a></li>
				<li><a class="dropdown-item" style="color: #fff" href="JSP_Delete_Client.jsp">Eliminar</a></li>
			</ul></li>
		<li class="nav-item "  style="padding: 0 1% 0 1%;"><a class="nav-link active"
			data-bs-toggle="dropdown" href="#" role="button"
			aria-expanded="false" style="color: #fff; float: right;">Productos</a></li>
		<li class="nav-item "  style="padding: 0 1% 0 1%;"><a class="nav-link active"
			data-bs-toggle="dropdown" href="#" role="button"
			aria-expanded="false" style="color: #fff; float: right;">Ventas</a></li>
		<li class="nav-item dropdown"  style="padding: 0 1% 0 1%;"><a class="nav-link dropdown-toggle"
			data-bs-toggle="dropdown" href="#" role="button"
			aria-expanded="false" style="color: #fff; float: right;">Reportes</a>
			<ul class="dropdown-menu bg-primary">
				<li><a class="dropdown-item" style="color: #fff"
					href="Usuarios.jsp">Agregar</a></li>
				<li><a class="dropdown-item" style="color: #fff" href="#">Actualizar</a></li>
				<li><a class="dropdown-item" style="color: #fff" href="#">Consultar</a></li>
				<li><a class="dropdown-item" style="color: #fff" href="#">Eliminar</a></li>
			</ul></li>

		<li class="nav-item "  style="padding: 0 1% 0 1%;"><a class="nav-link active"
			data-bs-toggle="dropdown" href="index.jsp" role="button"
			aria-expanded="false" style="color: #fff; float: right;" href="index.jsp">Cerrar sesión</a></li>
	</nav>
	</div>
	<div style="padding-top: 70pt; background-color: #0d6efd"></div>
</body>
</html>