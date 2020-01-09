<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="POST" modelAttribute="employee">
<%@ page isELIgnored="false" %>
<h2>In Display</h2>
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
<tr>
<th>${employee.employeeid}</th>
<th>${employee.name}</th>
<th>${employee.desg}</th>
<th>${employee.deptId}</th>
<th>${employee.email}</th>
</tr>
</tbody>
</table>
</form>
<a href="menu">Menu</a>
</body>
</html>