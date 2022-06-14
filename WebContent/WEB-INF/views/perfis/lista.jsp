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
				<div class="col-md-9">
					<h4>Cadastro de Perfis de Acesso</h4>
				</div>
				<div class="col-md-3 h4">
					<a class="btn btn-primary" href="${s:mvcUrl('novoPerfilAcessoUrl').build()}" >Novo</a>
				</div>
			</div>
			
			<div class="row">
				<div class="table-responsive col-md-12">
					<table id="tabProdutos" class="table table-striped">
						<thead>
							<tr>
								<th>Nome</th>
								<th>Descrição</th>
								<th>Ações</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listaDePerfis}" var="registro" >
								<tr>
									<td>${registro.authority}</td>
									<td>${registro.descricao}</td>
									<td>
										<a class="btn btn-warning btn-xs" href="${s:mvcUrl('alterarPerfilAcessoUrl').arg(0, registro.authority).build()}">editar</a>
										<a class="btn btn-success btn-xs" href="${s:mvcUrl('detalharPerfilAcessoUrl').arg(0, registro.authority).build()}">detalhes</a>
										<button class="btn btn-danger btn-xs" type="button" data-toggle="modal" data-target="#modalExcluir" data-descr="${registro.descricao}"  >
											Excluir
											<f:form action="${s:mvcUrl('excluirPerfilAcessoUrl').arg(0, registro.authority).build()}" method="post">
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