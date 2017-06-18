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
	<a href="<c:url value = "/"/>"> Home </a>
	<a href="<c:url value = "/alunos/form"/>"> Incluir Aluno </a>

	<table>
		<tr>
			<td>Alunos</td>
			<td>RA</td>
			<td></td>
			<td></td>
		</tr>
		<c:forEach items="${alunos}" var="aluno">
			<tr>
				<td>${aluno.nome}</td>
				<td>${aluno.registroAcademico}</td>
				<td><a href="<c:url value="/alunos/"/>${aluno.id}">Atualizar</a></td>
				<td><a href="">Excluir</a></td>
				
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>