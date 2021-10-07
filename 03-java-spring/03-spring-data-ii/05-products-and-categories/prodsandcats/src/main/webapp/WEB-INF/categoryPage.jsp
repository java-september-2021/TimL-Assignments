<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category Page</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body class="container">
<h1><c:out value="${category.name}"/></h1>
<hr>
<h3>Products</h3>
<ul>
<c:forEach items="${category.products}" var="product">
<li>${product.name}</li>
</c:forEach>
</ul>
<h3>Add Product:</h3>
<form method="POST" action="/addProdToCat/${category.id}">
<select name="products">
<c:forEach items="${notInCat}" var="product">
<option value="${product.id}">${product.name}</option>
</c:forEach>
</select>
<button>Add</button>
</form>
</body>
</html>