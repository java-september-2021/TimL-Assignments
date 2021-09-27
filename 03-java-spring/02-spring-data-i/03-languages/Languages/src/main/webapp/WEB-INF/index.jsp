<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Languages</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body class="container">

<table class="table table-striped">
<thead>
<tr>
<td>Name</td>
<td>Creator</td>
<td>Version</td>
<td>action</td>
</tr>
</thead>
<tbody>
<c:forEach items="${allLanguages}" var="lang">
<tr>
<td><a href="/language/${lang.id}">${lang.name}</a></td>
<td>${lang.creator}</td>
<td>${lang.version}</td>
<td><form action="/delete/${lang.id}" method="POST">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form> <a href="edit/${lang.id}">edit</a></td>
</tr>
</c:forEach>
</tbody>
</table>

<form:form action="/" method="POST" modelAttribute="language">
<p>
<form:label path="name">Name</form:label>
<form:errors path="name"/>
<form:input path="name"/>
</p>
<p>
<form:label path="creator">Creator</form:label>
<form:errors path="creator"/>
<form:input path="creator"/>
</p>
<p>
<form:label path="version">Version</form:label>
<form:errors path="version"/>
<form:input path="version"/>
</p>
<button>Submit</button>
</form:form>

</body>
</html>