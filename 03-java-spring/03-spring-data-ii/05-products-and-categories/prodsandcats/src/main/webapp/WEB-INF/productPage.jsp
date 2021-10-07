<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Page</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body class="container">
<h1><c:out value="${product.name}"/></h1>
<c:out value="${product.description}"/>
<c:out value="${product.price}"/>
<hr>
<h3>Categories:</h3>
<ul>
<c:forEach items="${product.categories}" var="category">
<li>${category.name}</li>
</c:forEach>
</ul>
<h3>Add Category:</h3>
<form method="POST" action="/addCatToProd/${product.id}">
<select name="categories">
<c:forEach items="${notInProd}" var="category">
<option value="${category.id}">${category.name}</option>
</c:forEach>
</select>
<button>Add</button>
</form>
</body>
</html>