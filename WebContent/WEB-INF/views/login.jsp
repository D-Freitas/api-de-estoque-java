<!DOCTYPE html>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
	<head>
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Gestão de Estoque</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/login.css" />
	</head>

	<body class="text-center">
		<f:form class="form-signin" action="${s:mvcUrl('loginUrl').build()}" method="POST" >
			<h1 class="h3 mb-3 font-weight-normal">Entrar no sistema</h1>
			
			<label for="inputUsername" class="sr-only">Login</label>
			<input id="inputUsername" name="username" class="form-control" placeholder="login" required autofocus>
			
			<label for="inputPassword" class="sr-only">Password</label>
			<input type="password" name="password" id="inputPassword" class="form-control" placeholder="senha" required>
			
	  		<button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
		</f:form>
	</body>	
	<%@ include file="base/scripts.jsp" %>
</html>