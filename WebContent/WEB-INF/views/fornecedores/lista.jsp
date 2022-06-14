<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
	<%@ include file="../base/header.jsp" %>
	
	<body>
		<%@ include file="../base/navbar.jsp" %>
		
		<div class="container">

			<div>
				<p>${status}</p>
			</div>
		
			<div class="row">
				<div class="col-md-6">
					<h4>Cadastro de Fornecedor</h4>
				</div>
				<div class="col-md-3 h4">
					<a class="btn btn-primary" href="${s:mvcUrl('novoFornecedorUrl').build()}" >Novo Fornecedor</a>
				</div>
				<div class="col-md-3 h4">
					<a class="btn btn-primary" href="${s:mvcUrl('novoFornecedorJsUrl').build()}" >Novo Fornecedor JS</a>
				</div>
			</div>
			
			<div class="row">
				<div class="table-responsive col-md-12">
					<table id="tabProdutos" class="table table-striped">
						<thead>
							<tr>
								<th>Id</th>
								<th>Razão Social</th>
								<th>Nome Fantasia</th>
								<th>CNPJ</th>
								<th>Ações</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listaDeFornecedores}" var="registro" >
								<tr>
									<td>${registro.id}</td>
									<td>${registro.razaoSocial}</td>
									<td>${registro.nomeFantasia}</td>
									<td>${registro.cnpj}</td>
									<td>
										<a class="btn btn-warning btn-xs" href="${s:mvcUrl('alterarFornecedorUrl').arg(0, registro.id).build()}">editar</a>
										<a class="btn btn-success btn-xs" href="${s:mvcUrl('detalharFornecedorUrl').arg(0, registro.id).build()}">detalhes</a>
										<button class="btn btn-danger btn-xs" type="button" data-toggle="modal" data-target="#modalExcluir" data-descr="${registro.razaoSocial}"  >
											Excluir
											<f:form action="${s:mvcUrl('excluirFornecedorUrl').arg(0, registro.id).build()}" method="post">
											</f:form>
										</button>
									</td>
								</tr>			
							</c:forEach>		
						</tbody>	
					</table>
				</div>
			</div>
		
		</div>
		<%@ include file="../base/modalExcluir.jsp" %>	
	</body>
	<%@ include file="../base/scripts.jsp" %>
</html>