<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
	<%@ include file="../base/header.jsp" %>
	<body>
		<%@ include file="../base/navbar.jsp" %>
	
		<div class="container">
			<f:form action="${s:mvcUrl('salvarFornecedorJsUrl').build()}" method="post" modelAttribute="fornecedor">
				<f:hidden path="id"/>			
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">Dados do Fornecedor</h3>
					</div>
					
					<div class="panel-body">
						<!-- Nav tabs -->
						<ul class="nav nav-tabs" role="tablist">
							<li role="presentation" class="active"><a href="#detalhesF" aria-controls="home" role="tab" data-toggle="tab">Detalhes</a></li>
							<li role="presentation"><a href="#prodF" aria-controls="profile" role="tab" data-toggle="tab">Produtos</a></li>
						</ul>		
						
						<!-- Tab panes -->
						<div class="tab-content">
							<div role="tabpanel" class="tab-pane active" id="detalhesF">
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label for="razaoSocial">Razão Social</label>
											<f:input path="razaoSocial" cssClass="form-control" />
											<f:errors path="razaoSocial" />
										</div>
									</div>
									<div class="col-md-6" >
										<div class="form-group" >
											<label for="nomeFantasia">Nome Fantasia</label>
											<f:input path="nomeFantasia" cssClass="form-control" />
											<f:errors path="nomeFantasia"  />
										</div>		
									</div>
								</div>
								
								<div class="row">
									<div class="col-md-6" >
										<div class="form-group" >
											<label for="cnpj">CNPJ</label>
											<f:input path="cnpj" cssClass="form-control" maxlength="14" />
											<f:errors path="cnpj"  />
										</div>		
									</div>
									<div class="col-md-6" >
										<div class="form-group" >
											<label for="email">Email</label>
											<f:input path="email" cssClass="form-control" />
											<f:errors path="email"  />
										</div>		
									</div>
								</div>		
				
								<div class="row">
									<div class="col-md-6" >
										<div class="form-group" >
											<label for="telefone">Telefone</label>
											<f:input path="telefone" cssClass="form-control" />
											<f:errors path="telefone"  />
										</div>		
									</div>
								</div>							
							</div>
							
							<div role="tabpanel" class="tab-pane" id="prodF">
								<div class="row">
									<div class="col-md-12 text-right">
										<button id="btnNovaLinha" class="btn btn-primary btn-sm" type="button"><i class="glyphicon glyphicon-plus"></i></button>
									</div>
								</div>
								<table class="table table-condensed" id="tableProdutos">
									<thead>
										<tr>
											<th>Descrição</th>
											<th>Qtde</th>
											<th>Localização</th>
											<th>Categoria</th>
											<th>Validade</th>
										</tr>
									</thead>
										<c:forEach items="${produtos}" varStatus="index" var="prod">
											<p>t</p>
											<tr>
												<td><f:input path="produtos[${index}].descricao" cssClass="form-control"/></td>
												<td><f:input path="produtos[${index}].quantidade" cssClass="form-control" type="number"/></td>
												<td><f:input path="produtos[${index}].localizacao" cssClass="form-control"/></td>
												<td><f:input path="produtos[${index}].categoria" cssClass="form-control"/></td>
												<td><f:input path="produtos[${index}].validade" cssClass="form-control" type="date" /></td>
											</tr>										
										</c:forEach>
									<tbody>		
									</tbody>								
								</table>							
							</div>
						</div>								
						
					</div>
					
					<div class="panel-footer">
						<div class="row">
							<div class="col-md-12">
								<input class="btn btn-success" type="submit" value="Salvar">
							</div>
						</div>
					</div>
					
				</div>
			</f:form>
	</div>
	</body>
	
	<%@ include file="../base/scripts.jsp" %>
	
	<script type="text/javascript">
		$(document).ready(function() {	
			$("#btnNovaLinha").click(function() {
				var count = $("#tableProdutos tbody tr").length;
			
				$("#tableProdutos tbody").append('<tr id="produtoLinha' + count + '">');
				$("#tableProdutos tbody").append('	<td><input id="produtos' + count + '.descricao" name="produtos[' + count +'].descricao" class="form-control" value="" type="text"></td>');
				$("#tableProdutos tbody").append('	<td><input id="produtos' + count + '.quantidade" name="produtos[' + count + '].quantidade" class="form-control" value="0" type="number"></td>');
				$("#tableProdutos tbody").append('	<td><input id="produtos' + count + '.localizacao" name="produtos[' + count + '].localizacao" class="form-control" value="" type="text"></td>');
				$("#tableProdutos tbody").append('	<td><input id="produtos' + count + '.categoria" name="produtos[' + count + '].categoria" class="form-control" value="" type="text"></td>');
				$("#tableProdutos tbody").append('	<td><input id="produtos' + count + '.validade" name="produtos[' + count + '].validade" class="form-control" value="" type="date"></td>');
				$("#tableProdutos tbody").append('</tr>');	
			});
		});
	</script>
	
</html>