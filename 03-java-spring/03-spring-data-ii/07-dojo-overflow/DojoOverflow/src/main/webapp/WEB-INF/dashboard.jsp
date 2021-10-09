<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Questions Dashboard</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body class="container">
<h1>Questions Dashboard</h1>
<table>
<tr>
<th>Question</th>
<th>Tags</th>
</tr>
<c:forEach items="${allquestions}" var="question">
<tr>
<td><a href="/questionProfile/${question.id}">${question.questiontext}</a></td>
<td>
<p>
<c:forEach items="${question.questionstags}" var="tagword">
${tagword.subject},
</c:forEach>
</p>
</td>
</tr>
</c:forEach>
</table>
<hr>
<a href="/new">New Question</a>
</body>
</html>