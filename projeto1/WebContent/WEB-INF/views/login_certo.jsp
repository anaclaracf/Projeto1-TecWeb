<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.*, br.edu.insper.mvc.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="add" method="post">
<b>Ainda não possui cadastro? Crie seu login e senha abaixo:</b><br>
usuario <input type="text" name="usuario"><br>
senha <input type="text" name="senha"><br><br>
<input type="submit" value="cadastrar"><br><br><br>
</form>

</body>
</html>