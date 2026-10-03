<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head><title>Employee List - Day 11</title>
<style>
 body{font-family:Arial;margin:30px;}
 table{border-collapse:collapse;width:90%;}
 th,td{border:1px solid #333;padding:10px;}
 th{background:#4CAF50;color:white;}
 a.btn{background:#4CAF50;color:white;padding:8px 15px;text-decoration:none;border-radius:5px;}
 a.del{background:#f44336;color:white;padding:6px 12px;text-decoration:none;border-radius:5px;}
</style>
</head>
<body>
<h2>Employee List - Day 11 💚</h2>
<a class="btn" href="add-employee.jsp">Add New Employee</a>
<br><br>
<table>
<tr><th>ID</th><th>Name</th><th>Email</th><th>Salary</th><th>Action</th></tr>
<c:forEach var="emp" items="${empList}">
<tr>
<td>${emp.id}</td>
<td>${emp.name}</td>
<td>${emp.email}</td>
<td>${emp.salary}</td>
<td><a class="del" href="delete-employee?id=${emp.id}">Delete</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>