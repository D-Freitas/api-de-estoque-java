<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
	<%@ include file="../base/header.jsp" %>
	<body>
		<%@ include file="../base/navbar.jsp" %>
	
		<div class="container">
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<h2>Dados do Perfil de Acesso</h2>
				</div>
			</div>
			
			<f:form action="${s:mvcUrl('salvarPerfilAcessoUrl').build()}" method="post" modelAttribute="perfilAcesso">
								
				<div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<label for="authority">Nome</label>
							<f:input path="authority" cssClass="form-control" />
							<f:errors path="authority" />
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="col-md-12" >
						<div class="form-group" >
							<label for="descricao">Descrição</label>
							<f:input path="descricao" cssClass="form-control" />
							<f:errors path="descricao"  />
						</div>		
					</div>
				</div>		
				
				<div class="row">
					<div class="col-md-12">
						<input class="btn btn-success" type="submit" value="Salvar">
					</div>
				</div>
						
			</f:form>
		</div>
	</body>
	
	<%@ include file="../base/scripts.jsp" %>
</html>