<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login- Tienda Generica</title>
<link rel="stylesheet" href="css/style.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>

	<form method="get" action="./Servlet">
		<table>
			<tr>
				<div class="login-box">
					<img class="avatar" src="img/fondopasteleria.jpg"
						alt="Logo de FAzt">
					<h1>BIENVENIDO</h1>
					<!-- USERNAME INPUT -->
					<label for="username">Usuario</label> <input type="text"
						name="userName" required="required" placeholder="Enter Username">

					<!-- PASSWORD INPUT -->
					<label for="Contraseña">Contraseña</label> <input type="contraseña"
						name="passwordUser" required="required" placeholder="Enter Password"> <input
						type="submit" value="INGRESAR" name="Ingresar"> <a
						href="#">Olvido su Contraseña?</a><br> <a href="#">No
						tienes una cuenta?</a>
				</div>
			</tr>
			<%
			Object auxRequest = request.getAttribute("resultValidateUser");
			if (auxRequest != null) {
				boolean result = (boolean) auxRequest;
				if (result != true) {
			%>

			<tr>
				<div class="alert alert-danger d-flex align-items-center"
					role="alert">
					<svg class="bi flex-shrink-0 me-2" width="24" height="24"
						role="img" aria-label="Danger:">
						<use xlink:href="#exclamation-triangle-fill" /></svg>
					<div>Usuario y/o contraseña incorrectos</div>
				</div>
			</tr>
			<%
			}
			}
			%>

		</table>
	</form>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>