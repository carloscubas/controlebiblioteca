<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Autor</title>
</head>
<body>	
	<div>
		<a href="/controlebiblioteca/autores">Autor</a>
	</div>
	<form:form action="/controlebiblioteca/autores" method="post" commandName="autor">
		<form:input path="id" type="hidden" id="id" />
		<div>
      		<label for="name">Nome</label>
       		<form:input path="nome" type="text" id="nome" />
       		<form:errors path="nome" />
     	</div>
     	<div>
      		<input type="submit" value="Enviar">
    	</div>
	</form:form>
</body>
</html>