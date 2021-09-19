<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Date</title>
<link rel="stylesheet" href="css/style.css">
<script src="js/main.js"></script>
</head>
<body>
<script>dateAlert()</script>
<p class="date"><fmt:formatDate pattern="EEEE, 'the' dd 'of' MMMM, YYYY" value="${datetime}"/>
</body>
</html>