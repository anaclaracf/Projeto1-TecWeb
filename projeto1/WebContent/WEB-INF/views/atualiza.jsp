<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Atualiza</title>
</head>
<body>
<form action="atualiza" method="post">
Atividade: <input type="text" name="tarefa" value="${param.tarefa}"><br/>
Tipo: <input type="text" name="tipo" value="${param.tipo}"><br/>
<input type="hidden" name="id" value="${param.id}"><br/>
<input type="submit" value="atualizar">
</form>

</body>
</html>