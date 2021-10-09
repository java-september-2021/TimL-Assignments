<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Question Profile</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body class="container">
<h1>${question.questiontext}</h1>
<p>
<c:forEach items="${question.questionstags}" var="tag">
${tag.subject},
</c:forEach>
</p>
<hr>
<h3>Answers</h3>
<ul>
<c:forEach items="${question.answers}" var="answer">
<li>${answer.answertext}</li>
</c:forEach>
</ul>
<hr>
<h2>Add your answer</h2>
<form:form method="POST" action="/addAnswer" modelAttribute="answer">
<p>
<form:label path="answertext">Answer</form:label>
<form:errors path="answertext"/>
<form:input path="answertext"/>
<form:hidden path="quest" value="${question.id}"/>
</p>
<button>Answer it!</button>
</form:form>
</body>
</html>