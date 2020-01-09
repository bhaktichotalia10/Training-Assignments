<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<title>Insert title here</title>
</head>
<body>
<h2>In Remove</h2>
<form:form action="/remove" method="POST" modelAttribute="emp">
Enter Employee Id : <form:input path="employeeid" />
<input type=submit value="Remove" /></form:form>
<a href="menu">Menu</a>
</body>
</html>