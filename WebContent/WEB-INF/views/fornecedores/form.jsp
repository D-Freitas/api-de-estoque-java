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
					<h2>Dados do Fornecedor</h2>
				</div>
			</div>
			
			<f:form action="${s:mvcUrl('salvarFornecedorUrl').build()}" method="post" modelAttribute="fornecedor">
				<f:hidden path="id"/>
				
				<div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<label for="razaoSocial">Razão Social</label>
							<f:input path="razaoSocial" cssClass="form-control" />
							<f:errors path="razaoSocial" />
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="col-md-12" >
						<div class="form-group" >
							<label for="nomeFantasia">Nome Fantasia</label>
							<f:input path="nomeFantasia" cssClass="form-control" />
							<f:errors path="nomeFantasia"  />
						</div>		
					</div>
				</div>				
				
				<div class="row">
					<div class="col-md-12" >
						<div class="form-group" >
							<label for="cnpj">CNPJ</label>
							<f:input path="cnpj" cssClass="form-control" maxlength="14" />
							<f:errors path="cnpj"  />
						</div>		
					</div>
				</div>		

				<div class="row">
					<div class="col-md-12" >
						<div class="form-group" >
							<label for="email">Email</label>
							<f:input path="email" cssClass="form-control" />
							<f:errors path="email"  />
						</div>		
					</div>
				</div>

				<div class="row">
					<div class="col-md-12" >
						<div class="form-group" >
							<label for="telefone">Telefone</label>
							<f:input path="telefone" cssClass="form-control" />
							<f:errors path="telefone"  />
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