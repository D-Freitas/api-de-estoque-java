<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
	<%@ include file="../base/header.jsp" %>

<body>
	<%@ include file="../base/navbar.jsp" %>
	
	<div class="container">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Dados do Perfil</h3>
			</div>
			
			<div class="panel-body">
				<div class="row">
					<ul>
						<li>Login: ${usuario.username}</li>
						<li>Nome: ${usuario.name}</li>
					</ul>
				</div>
				<div class="row">
					<div class="col-md-12">
						<img src="${pageContext.request.contextPath}/${usuario.caminhoFoto}" width="300px"  />
					</div>
				</div>
			</div>
			
			<div class="panel-footer">
				<div class="row">
					<div class="col-md-12">
						<f:form action="${s:mvcUrl('alterFotoPerfilUrl').build()}" method="POST" enctype="multipart/form-data">
							<div class="form-group">
								<input name="foto" type="file" />
							</div>
							<div class="form-group">
								<input class="btn btn-success" type="submit" value="Aterar Foto" />							
							</div>
						</f:form>					
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../base/scripts.jsp" %>
</body>
</html>