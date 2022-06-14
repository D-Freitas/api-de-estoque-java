<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
	<%@ include file="../base/header.jsp" %>

<body>
	<%@ include file="../base/navbar.jsp" %>
	<div class="container">
		<div>
			<h4>Dados do Usuário</h4>
		</div>
		<div>
			<ul>
				<li>Login: ${usuario.username}</li>
				<li>Nome: ${usuario.name}</li>
			</ul>
		</div>
		<div>
			<a class="btn btn-warning" href="${s:mvcUrl('listarUsuarioUrl').build()}">voltar</a>
		</div>
	</div>
	<%@ include file="../base/scripts.jsp" %>
</body>
</html>