<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Livro</title>
</head>
<body>
	<a href="/controlebiblioteca/"> Home </a>
	<a href="/controlebiblioteca/livros/form"> Incluir livro </a>

	<table>
		<tr>
			<td></td>
			<td>Titulo</td>
			<td>Autor</td>
			<td>Data Lançamento</td>
			<td></td>
			<td></td>
		</tr>
		<c:forEach items="${livros}" var="livro">
			<tr>
				<td><img src="uploads/${livro.capa}" width="100px"/></td>
				<td>${livro.titulo}</td>
				<td>${livro.autor.nome}</td>
				<td><fmt:formatDate pattern="dd/MM/yyyy" value="${livro.dataLancamento}" /></td>
				<td><a href="/controlebiblioteca/livros/${livro.id}">Atualizar</a></td>
				<td><a href="">Excluir</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>