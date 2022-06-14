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
					<h4>Cadastro de Usuários</h4>
				</div>
				<div class="col-md-3 h4">
					<a class="btn btn-primary" href="${s:mvcUrl('novoUsuarioUrl').build()}" >Novo</a>
				</div>
			</div>
			
			<div class="row">
				<div class="table-responsive col-md-12">
					<table id="tabProdutos" class="table table-striped">
						<thead>
							<tr>
								<th>Login</th>
								<th>Nome</th>
								<th>Perfis</th>
								<th>Ações</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listaDeUsuarios}" var="registro" >
								<tr>
									<td>${registro.username}</td>
									<td>${registro.name}</td>
									<td></td>
									<td>
										<a class="btn btn-warning btn-xs" href="${s:mvcUrl('alterarUsuarioUrl').arg(0, registro.username).build()}">editar</a>
										<a class="btn btn-success btn-xs" href="${s:mvcUrl('detalharUsuarioUrl').arg(0, registro.username).build()}">detalhes</a>
										<button class="btn btn-danger btn-xs" type="button" data-toggle="modal" data-target="#modalExcluir" data-descr="${registro.name}"  >
											Excluir
											<f:form action="${s:mvcUrl('excluirUsuarioUrl').arg(0, registro.username).build()}" method="post">
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