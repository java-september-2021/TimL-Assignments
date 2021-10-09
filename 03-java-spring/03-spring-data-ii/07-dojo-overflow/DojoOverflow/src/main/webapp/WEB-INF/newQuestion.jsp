<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Question</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body class="container">
<a href="/">Dashboard</a>
<h1>What is your question?</h1>
<form:form method="POST" action="/newQuestion" modelAttribute="question">
<p>
<form:label path="questiontext">Question</form:label>
<form:errors path="questiontext"/>
<form:textarea path="questiontext"/>
</p>
<p>
<form:label path="tagsFromFrontEnd">Tags</form:label>
<form:errors path="tagsFromFrontEnd"/>
<form:textarea path="tagsFromFrontEnd"/>
</p>
<button>Submit</button>
</form:form>
</body>
</html>