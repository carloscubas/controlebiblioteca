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
	<a href="<c:url value = "/livros"/>">Livros</a>
	<a href="<c:url value = "/autores"/>">Autores</a>
	<a href="<c:url value = "/alunos"/>">Alunos</a>
</body>
</html>

