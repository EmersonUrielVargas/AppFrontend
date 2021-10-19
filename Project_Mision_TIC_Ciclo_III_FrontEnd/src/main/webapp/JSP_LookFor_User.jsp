<%@page import="jsons.Users"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/estilos.css" rel="stylesheet" type="text/css">
<title>Consulta Usuarios</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

</head>
<body>
		
		<div class="text-center" >
			<img src="img/Icon_Bakery.png" width="150">
		</div>

		<nav class=" nav justify-content-center bg-primary" >
			<li class="nav-item "><a class="nav-link active"
				data-bs-toggle="dropdown" href="JSP_Principal_Menu_Admin"
				role="button" aria-expanded="false" style="color: #fff">Home</a></li>


			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#"
				role="button" aria-expanded="false" style="color: #fff">Usuarios</a>
				<ul class="dropdown-menu bg-primary">
					<li><a class="dropdown-item" style="color: #fff"
						href="JSP_Create_User.jsp">Agregar</a></li>
					<li><a class="dropdown-item" style="color: #fff"
						href="JSP_Update_User.jsp"">Actualizar</a></li>
					<li><a class="dropdown-item" style="color: #fff"
						href="JSP_List_User.jsp">Consultar</a></li>
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
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#"
				role="button" aria-expanded="false" style="color: #fff">Productos</a>
				<ul class="dropdown-menu bg-primary">
					<li><a class="dropdown-item" style="color: #fff"
						href="Usuarios.jsp">Agregar</a></li>
					<li><a class="dropdown-item" style="color: #fff" href="#">Actualizar</a></li>
					<li><a class="dropdown-item" style="color: #fff" href="#">Consultar</a></li>
					<li><a class="dropdown-item" style="color: #fff" href="#">Eliminar</a></li>
				</ul></li>
		</nav>

		<div class="text-center" style="background-color: #0b5ed7; ">
			<h4 class="h4" style="color: #fff">Consulta de Usuarios</h4>
		</div>
	<form method="get" action="./Servlet" >
		<table>
			<td><div class="input-group mb-3">
					<span class="input-group-text" id="basic-addon1">Cedula</span> <label><input
						type="text" name="createU_userId" class="form-control"
						placeholder="" aria-label="cedula" aria-describedby="basic-addon1"></label>
				</div></td>

		<td><button type="submit" name="searchUser"
				class="btn btn-primary">consultar Usuario</button></td>
		</table>
	</form>	
	<%
		Object auxRequest = request.getAttribute("resultAddUser");
		if (auxRequest != null) {
		Users usuario = (Users)request.getAttribute("usuario");
	%>
	 <table>
        <tr>
            <td><label>Cedula</label></td>
            <td><label>Nombre</label></td>
            <td><label>Correo</label></td>
            <td><label>Usuario</label></td>
            <td><label>Password</label></td>
        </tr>
        <tr>
            <td><%=usuario.getUser_id()%></td>
            <td><%=usuario.getUser_name()%></td>
            <td><%=usuario.getUser_email()%></td>
            <td><%=usuario.getUser()%></td>
            <td><%=usuario.getPassword()%></td>
        </tr>
      </table>
      <%
      }
      %>
      
      <script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script> 
</body>
</html>