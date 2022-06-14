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
					<h2>Dados do Produto</h2>
				</div>
			</div>
			
			<f:form action="${s:mvcUrl('salvarProdutoUrl').build()}" method="post" modelAttribute="produto" enctype="multipart/form-data">
				<f:hidden path="id"/>
				
				<div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<label for="fornecedor">Fornecedor</label>
							<f:select path="fornecedor" cssClass="form-control"> 
								<f:option value="0">Selecione um Fornecedor</f:option>
								<f:options items="${fornecedores}" itemLabel="razaoSocial" itemValue="id" />
							</f:select>
							<f:errors path="fornecedor" />						
						</div>
					</div>				
				</div>
				
				<div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<label for="descricao">Descrição</label>
							<f:input path="descricao" cssClass="form-control" />
							<f:errors path="descricao" />
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="col-sm-3">
						<div class="form-group">
							<label for="quantidade">Quantidade</label>
							<f:input type="number" path="quantidade" cssClass="form-control"/>
							<f:errors path="quantidade" />
						</div>
					</div>
					<div class="col-md-9">
						<div class="form-group">
							<label for="localizacao">Localização</label>
							<f:input path="localizacao" cssClass="form-control" />
							<f:errors path="localizacao"  />
						</div>	
					</div>	
				</div>
				
				<div class="row">
					<div class="col-md-12" >
						<div class="form-group" >
							<label for="categoria">Categoria</label>
							<f:input path="categoria" cssClass="form-control" />
							<f:errors path="categoria"  />
						</div>		
					</div>
				</div>				
				
				<div class="row">
					<div class="col-md-6">
						<div class="form-group" > 
							<label for="estoqueMinimo">Estoque Minimo</label>
							<f:input type="number" path="estoqueMinimo" cssClass="form-control" />
							<f:errors path="estoqueMinimo"  />
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label for="validade">Validade</label>
							<f:input type="date" path="validade" cssClass="form-control" />
							<f:errors path="validade"  />
						</div>
					</div>
				</div>		
				
				<div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<label for="foto">Foto do Produto</label>
							<input name="foto" type="file"/>
							<f:errors path="caminhoFoto" />
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