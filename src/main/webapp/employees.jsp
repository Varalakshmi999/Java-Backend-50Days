<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
<title>Employee List - Day 10</title>
<style>
 body{font-family:Arial;margin:30px;}
 table{border-collapse:collapse;width:80%;}
 th,td{border:1px solid #333;padding:10px;}
 th{background:#4CAF50;color:white;}
 a{background:#4CAF50;color:white;padding:8px 15px;text-decoration:none;border-radius:5px;}
</style>
</head>
<body>
<h2>Employee List - Day 10 JSP 💚</h2>
<a href="add-employee.html">Add New Employee</a>
<br><br>
<table>
<tr><th>ID</th><th>Name</th><th>Email</th><th>Salary</th></tr>
<c:forEach var="emp" items="${empList}">
<tr>
<td>${emp.id}</td>
<td>${emp.name}</td>
<td>${emp.email}</td>
<td>${emp.salary}</td>
</tr>
</c:forEach>
</table>
</body>
</html>