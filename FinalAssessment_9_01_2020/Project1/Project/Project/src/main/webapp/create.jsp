<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<title>Insert title here</title>
</head>
<body>
<h2>In Create</h2>
<form:form action="/display" method="POST" modelAttribute="emp">
Enter ID : <form:input path="employeeid" /><br>
Enter Name : <form:input path="name" /><br>
Enter Designation : <form:input path="desg" /><br>
Enter Department Id : <form:input path="deptId" /><br>
Enter Email : <form:input path="email" /><br>
<input type="submit" value="Add Employee" />
</form:form>
</body>
</html>