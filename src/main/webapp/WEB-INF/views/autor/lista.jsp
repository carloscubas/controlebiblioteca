<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Livro</title>
</head>
<body>
	<a href="/controlebiblioteca/"> Home </a>
	<a href="/controlebiblioteca/autores/form"> Incluir Autor </a>

	<table>
		<tr>
			<td>Autor</td>
			<td></td>
			<td></td>
		</tr>
		<c:forEach items="${autores}" var="autor">
			<tr>
				<td>${autor.nome}</td>
				<td><a href="/controlebiblioteca/autores/${autor.id}">Atualizar</a></td>
				<td><a href="">Excluir</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>