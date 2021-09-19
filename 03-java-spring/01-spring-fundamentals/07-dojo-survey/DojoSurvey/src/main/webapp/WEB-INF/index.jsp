<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Survey Index</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body class="body">
<form method="POST" action="/result">
<p>
<label>Your Name:</label>
<input type=text name="name">
</p>
<p>
<label>Dojo Location:</label>
<select name="location">
<option value="San Francisco">San Francisco</option>
<option value="New York">New York</option>
<option value="Seattle">Seattle</option>
<option value="Dallas">Dallas</option>
<option value="Online">Online</option>
</select>
</p>
<p>
<label>Favorite Language:</label>
<select name="language">
<option value="Java">Java</option>
<option value="Python">Python</option>
<option value="C#">C#</option>
<option value="Ruby">Ruby</option>
<option value="JavaScript">JavaScript</option>
</select>
</p>
<p>
<label>Comment (Optional):</label>
<textarea name="comment"></textarea>
</p>
<button>Button</button>
</form>
</body>
</html>