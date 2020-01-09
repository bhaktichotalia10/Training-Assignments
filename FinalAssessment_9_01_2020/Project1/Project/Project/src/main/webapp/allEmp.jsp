<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Insert title here</title>
</head>
<body>
<%@ page isELIgnored="false" %>
<h2>In Display All Employees</h2>
<table border=2>
<thead>
<tr>
<th>Employee Id</th>
<th>Employee Name</th>
<th>Designation</th>
<th>Department Id</th>
<th>Email</th>
</tr>
</thead>
<tbody>
<c:forEach var="employee" items="${emps}">
<tr>
<th>${employee.employeeid}</th>
<th>${employee.name}</th>
<th>${employee.desg}</th>
<th>${employee.deptId}</th>
<th>${employee.email}</th>
</tr>
</c:forEach>
</tbody>
</table>
<form action="menu">
<input type=submit value="Menu"></form>
</body>
</html>