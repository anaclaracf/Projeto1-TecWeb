<%@ page language="java" contentType="text/html"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.*, br.edu.insper.*" %>
<html>
<head>
<meta charset="UTF-8">
<title>Atividades</title>
</head>
<body>

<form action="adiciona" method="post">
<b>Responda as seguintes perguntas para adicionar uma atividade: </b><br><br>
Nome da atividade: <input type='text' name='tarefa'>
Tipo de atividade: <input type='text' name='tipo'><br><br>
Data: <input type='text' name='tempo'>
Dificuldade: <input type='number' name='dificuldade' step='0.1'>
<input type="submit" value="submit">
</form>


<table border="1">
<tr><td><b>#</b></td>
<td><b>Atividades</b></td>
<td><b>Tipo de Atividade</b></td>
<td><b>Data</b></td>
<td><b>Dificuldade</b></td>
</tr>

<b>Como deseja ordenar suas atividades: </b>
<form action="order" method="post">
<select name="filter" required>
<option value="1">Ordem alfabética</option>
<option value="2">Data</option>
<option value="3">Tipo de atividade</option>
<option value="4">Dificuldade</option>
</select>
<input type="submit" value="ordenar"><br>
</form><br><br>
<c:forEach var="atividade" items="${atividades}" varStatus="id">

<td>${id.count}</td>
<td>${atividade.tarefa}</td>
<td>${atividade.tipo}</td>
<td><fmt:formatDate     
value="${atividade.tempo.time}"                
pattern="dd/MM/yyyy"/></td>
<td>${atividade.dificuldade}</td>

<td>
<form action="remove" method="post">
<input type="hidden" name="id" value="${atividade.id}">
<input type="submit" value="remover">
</form>
</td>

<td>
<form action="atualiza" method="get">
<input type="hidden" name="id" value="${atividade.id}">
<input type="hidden" name="tarefa" value="${atividade.tarefa}">
<input type="hidden" name="tipo" value="${atividade.tipo}">
<input type="submit" value="atualizar">
</form>
</td>

</tr>
</c:forEach>
</table>
</body>
</html>