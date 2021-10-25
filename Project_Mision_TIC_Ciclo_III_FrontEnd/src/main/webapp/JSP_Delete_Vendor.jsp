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
<body style="background-image: url(img/F_Cupcake.jpg); background-size: cover;">
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>

	<%
	Object auxRequest = request.getAttribute("resultDeleteVendor");
	if (auxRequest != null) {
		boolean result = (boolean) auxRequest;
		if (result == true) {
	%>
	<div class="alert alert-success d-flex align-items-center" role="alert"
		style="position: absolute; width: 100%">
		<svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img"
			aria-label="Success:">
					<use xlink:href="#check-circle-fill" /></svg>
		<div>Los datos del cliente se eliminaron exitosamente</div>
	</div>

	<%
	} else {
	%>
	<div class="alert alert-danger d-flex align-items-center" role="alert"
		style="position: absolute; width: 100%">
		<svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img"
			aria-label="Danger:">
				<use xlink:href="#exclamation-triangle-fill" /></svg>
		<div>Los datos del cliente no pudieron ser eliminados</div>
	</div>


	<%
	}
	}
	%>
	<div style =" width: 100%; height: 71pt; position: fixed; background-color: #0d6efd;  "  >
	<div class="text-center" style =" width: 20%; float: left; background-color: transparent" >
		<img src="img/Logo_Bakery.png" width="300">
	</div>

	<nav class=" nav justify-content-center bg-primary" style =" width: 80%; margin-left:0; padding: 2% 0 1% 0;">
		<li class="nav-item "  style="padding: 0 1% 0 1%;">
		<img src="img/Icon_Home.png" >
		<a class="nav-link active" href="JSP_Principal_Menu_Admin.jsp" 
		role="button" aria-expanded="true" style="color: #fff;float: right; ">Home</a></li>


		<li class="nav-item dropdown" style="padding:0 1% 0 1%;">
		<img src="img/Icon_user.png">
		<a class="nav-link dropdown-toggle"
			data-bs-toggle="dropdown" href="#" role="button"
			aria-expanded="true" style="color: #fff; float: right;">Usuarios</a>

			<ul class="dropdown-menu bg-primary">
				<li><a class="dropdown-item" style="color: #fff" href="JSP_Create_User.jsp">Agregar</a></li>
				<li><a class="dropdown-item" style="color: #fff" href="JSP_Update_User.jsp"">Actualizar</a></li>
				<li><a class="dropdown-item" style="color: #fff" href="JSP_Show_User.jsp">Consultar</a></li>
				<li><a class="dropdown-item" style="color: #fff" href="JSP_Delete_User.jsp">Eliminar</a></li>
			</ul></li>

		<li class="nav-item dropdown "  style="padding: 0 1% 0 1%;">
		<img src="img/Icon_vendor.png">
		<a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#"
			role="button" aria-expanded="false" style="color: #fff;float: right;">Proveedores</a>
			<ul class="dropdown-menu bg-primary">
				<li><a class="dropdown-item" style="color: #fff" href="JSP_Create_Vendor.jsp">Agregar</a></li>
				<li><a class="dropdown-item" style="color: #fff" href="JSP_Update_Vendor.jsp">Actualizar</a></li>
				<li><a class="dropdown-item" style="color: #fff" href="JSP_Show_Vendor.jsp">Consultar</a></li>
				<li><a class="dropdown-item" style="color: #fff" href="JSP_Delete_Vendor.jsp">Eliminar</a></li>
			</ul></li>
		<li class="nav-item dropdown "  style="padding: 0 1% 0 1%;">
		<img src="img/Icon_client.png"><a
			class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#"
			role="button" aria-expanded="false" style="color: #fff; float: right;">Clientes</a>
			<ul class="dropdown-menu bg-primary">
				<li><a class="dropdown-item" style="color: #fff"href="JSP_Create_Client.jsp">Agregar</a></li>
				<li><a class="dropdown-item" style="color: #fff" href="JSP_Update_Client.jsp">Actualizar</a></li>
				<li><a class="dropdown-item" style="color: #fff" href="JSP_Show_Client.jsp">Consultar</a></li>
				<li><a class="dropdown-item" style="color: #fff" href="JSP_Delete_Client.jsp">Eliminar</a></li>
			</ul></li>
			
			
		<li class="nav-item "  style="padding: 0 1% 0 1%;">
		<img src="img/Icon_products.png"><a class="nav-link active"
			 href="JSP_Products.jsp" role="button"
			aria-expanded="false" style="color: #fff; float: right;">Productos</a></li>
			
			
		<li class="nav-item "  style="padding: 0 1% 0 1%;">
		<img src="img/Icon_sales.png"><a class="nav-link active"
			 href="JSP_Sales.jsp" role="button"
			aria-expanded="false" style="color: #fff; float: right;">Ventas</a></li>
			
			
		<li class="nav-item dropdown"  style="padding: 0 1% 0 1%;">
		<img src="img/Icon_report.png"><a class="nav-link dropdown-toggle"
			data-bs-toggle="dropdown" href="#" role="button"
			aria-expanded="false" style="color: #fff; float: right;">Reportes</a>
			<ul class="dropdown-menu bg-primary">
				<li><a class="dropdown-item" style="color: #fff" href="JSP_Report_Users.jsp">Listado de Usuarios</a></li>
				<li><a class="dropdown-item" style="color: #fff" href="JSP_Report_Clients.jsp">Listado de Clientes</a></li>
				<li><a class="dropdown-item" style="color: #fff" href="JSP_Report_Sales.jsp">Ventas por Usuarios</a></li>
			</ul></li>

		<li class="nav-item "  style="padding: 0 1% 0 1%;">
		<img src="img/Icon_logout.png"><a class="nav-link active"
			 href="index.jsp" role="button"
			aria-expanded="false" style="color: #fff; float: right;" href="index.jsp">Cerrar sesión</a></li>
	</nav>
	</div>
	<div style="padding-top: 70pt; background-color: #0d6efd"></div>


	<div class="text-center" style="background-color: #0b5ed7;">
		<h4 class="h4" style="color: #fff">Eliminación de Proveedor</h4>
	</div>
	
			<div style="margin-left: 10%; background-color: #fff; box-shadow: 6px 20px 40px black; width: 80%; margin-top: 5%">
		<div class="row">
		
			<div class="col-3" align="left" style=" width: 600px">
				<img src="img/Vendors.png" width=100%></div>
			
			<div class="col-6" style="float: right; width:55%">
				<form method="post" action="./Servlet"  style=" margin-left: 5%; margin-top:10%; float: right;width:100%">
					<table style="  width: 100%">
						<td><div class="input-group mb-3">
								<span class="input-group-text" id="basic-addon1">Nit</span> <label><input
									type="number" required="required" name="deleteV_vendorNit"
									class="form-control" placeholder="" aria-label="cedula"
									aria-describedby="basic-addon1"></label>
							</div></td>
						
						<tr></tr>

						<td><button type="submit" name="deleteV_deleteVendor"
								class="btn btn-primary">Eliminar Provedor</button></td>
					</table>
				</form>

			</div>
		</div>
	</div>
</body>
</html>