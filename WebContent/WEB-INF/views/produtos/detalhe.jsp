<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta charset="UTF-8">
<title>Produtos - Novo</title>
</head>
<body>
	<div>
		<h4>Dados do Produto</h4>
	</div>
	<div>
		<ul>
			<li>Id: ${produto.id}</li>
			<li>Descrição: ${produto.descricao}</li>
			<li>Quantidade: ${produto.quantidade}</li>
			<li>Localização: ${produto.localizacao}</li>
			<li>Categoria: ${produto.categoria}</li>
			<li>Estoque Mínimo: ${produto.estoqueMinimo}</li>
		</ul>
	</div>
	<div>
		<img alt="foto do produto" src="${pageContext.request.contextPath}/${produto.caminhoFoto}">
	</div>
	
	<div>
		<a href="${s:mvcUrl('listarProdutoUrl').build()}">voltar</a>
	</div>
</body>
</html>