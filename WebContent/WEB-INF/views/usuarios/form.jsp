<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
	<%@ include file="../base/header.jsp" %>
	<body>
		<%@ include file="../base/navbar.jsp" %>
	
		<div class="container">
			<f:form action="${s:mvcUrl('salvarUsuarioUrl').build()}" method="post" modelAttribute="usuario">
			
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">Dados do Usuário</h3>
					</div>
					
					<div class="panel-body">
					
						<!-- Nav tabs -->
						<ul class="nav nav-tabs" role="tablist">
							<li role="presentation" class="active"><a href="#detalhesU" aria-controls="home" role="tab" data-toggle="tab">Detalhes</a></li>
							<li role="presentation"><a href="#perfilU" aria-controls="profile" role="tab" data-toggle="tab">Perfis</a></li>
						</ul>
						
						<!-- Tab panes -->						
						<div class="tab-content">
							<div role="tabpanel" class="tab-pane active" id="detalhesU">
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label for="username">Login</label>
											<f:input path="username" cssClass="form-control" />
											<f:errors path="username" />
										</div>
									</div>
								</div>
								
								<div class="row">
									<div class="col-md-12" >
										<div class="form-group" >
											<label for="name">Nome</label>
											<f:input path="name" cssClass="form-control" />
											<f:errors path="name"  />
										</div>		
									</div>
								</div>		
								
								<c:if test="${!alteracao}">
									<div class="row">
										<div class="col-md-6" >
											<div class="form-group" >
												<label for="password">Senha</label>
												<f:input path="password" cssClass="form-control" type="password" />
												<f:errors path="password"  />
											</div>		
										</div>
									</div>
								</c:if>
							</div>
							
							<div role="tabpanel" class="tab-pane" id="perfilU">
								<div class="row">
									<div class="col-md-12 text-right">
										<button id="btnNovaLinha" class="btn btn-primary btn-sm" type="button" data-toggle="modal" data-target="#modalPefil"><i class="glyphicon glyphicon-plus"></i></button>
									</div>
								</div>
								<table class="table table-condensed" id="tablePerfis">
									<thead>
										<tr>
											<th>Nome</th>
											<th>Descrição</th>
										</tr>
									</thead>
										<c:forEach items="${usuario.authorities}" var="perfil" varStatus="status">
											<tr>
												<f:hidden path="authorities[${status.index}].authority"/>
												<f:hidden path="authorities[${status.index}].descricao"/>
												<td>${perfil.authority}</td>
												<td>${perfil.descricao}</td>												
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
			
			<div class="modal fade" tabindex="-1" role="dialog" id="modalPefil">
			    <div class="modal-dialog" role="document">
			        <div class="modal-content">
			            <div class="modal-header">
			                <h5 class="modal-title">Dados do Perfil</h5>
			                <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
			                    <span aria-hidden="true">&times;</span>
			                </button>
			            </div>
			            <div class="modal-body">
			            	<div class="row">
			            		<div class="col-md-12">
			            			<div class="form-group">
			            				<label for="perfil">Perfil</label>
			            				<select id="perfil" class="form-control">
			            					<option value="">Selecione</option>
			            					<c:forEach items="${perfis}" var="regPerfil" >
			            						<option value="${regPerfil.authority}">${regPerfil.descricao}</option>			            					
			            					</c:forEach>			            				
			            				</select>			            			
			            			</div>			            		
			            		</div> 
			            	</div>
			            
			            </div>
			            <div class="modal-footer">
			                <button id="btnModalSim" type="button" class="btn btn-success">Salvar</button>
			                <button id="btnModalNao" type="button" class="btn btn-danger" data-dismiss="modal">Sair</button>
			            </div>
			        </div>
			    </div>
			</div>			
			
		</div>
	</body>
	
	<%@ include file="../base/scripts.jsp" %>
	
	<script type="text/javascript">
		$(document).ready(function() {	
			$("#btnModalSim").click(function() {
				var count = $("#tablePerfis tbody tr").length;
				
				$("#tablePerfis tbody").append("<tr>");
				$("#tablePerfis tbody").append("	<input type='hidden' id='authorities[" + count + "].authority' name='authorities[" + count + "].authority' value='" + $("#perfil").val() + " ' />"); 
				$("#tablePerfis tbody").append("	<input type='hidden' id='authorities[" + count + "].descricao' name='authorities[" + count + "].descricao' value='" + $("#perfil option:selected").text() + " ' />"); 
				$("#tablePerfis tbody").append("	<td>" + $("#perfil").val() + "</td>");
				$("#tablePerfis tbody").append("	<td>" + $("#perfil option:selected").text() + "</td>");
				$("#tablePerfis tbody").append("</tr>");
				
				$("#modalPefil").modal("hide");
			});
		});	
	</script>		
</html>