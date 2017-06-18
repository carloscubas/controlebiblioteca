<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Livro</title>
</head>
<body>
	<div>
		<a href="/controlebiblioteca/livros">Livros</a>
	</div>
	
	<form:form action="/controlebiblioteca/livros" method="post" commandName="livro" enctype="multipart/form-data" >
		<form:input path="id" type="hidden" id="id" />

		<div>
			<label for="pathCapa">Capa do livro</label> 
			<input type="file" name="capaurl" />
			<span style="color: red;"><form:errors path="capa" /></span>
		</div>

		<div>
			<label for="name"><strong>Nome: </strong> </label> 
			<form:input path="titulo" size="100" type="text"/>
			<span style="color: red;"><form:errors path="titulo"/></span>
		</div>

		<div>
			<label for="autor"><strong>Autores: </strong></label>
			<form:select path="autor">
				<form:option value="" label="Selecione o Autor" /> 
				<form:options items="${listaautores}" itemValue="id" itemLabel="nome"/>
			</form:select>
			<span style="color: red;"><form:errors path="autor"/></span>
		</div>
		
		<div>
			<label for="releaseDate">Data de Lançamento</label> <form:input type="date" path="dataLancamento" />
			<span style="color: red;"><form:errors path="dataLancamento" /></span>
		</div>

		<div>
			<label for="descricao"><strong>Descrição: </strong></label><span style="color: red;"><form:errors path="descricao"/></span><br/>
			<form:textarea path="descricao" rows="10" cols="40" maxlength="500" /> 
		</div>

		<div>
			<input type="submit" value="Enviar">
		</div>
	</form:form>
	
</body>
</html>