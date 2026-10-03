<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Edit Employee - Day 12</title>
<style>
 body{font-family:Arial;display:flex;justify-content:center;margin-top:50px;background:#f4f4f4;}
 .card{background:white;padding:30px;border-radius:10px;box-shadow:0 0 15px #ccc;width:400px;}
 input{width:100%;padding:10px;margin:10px 0;border:1px solid #ccc;border-radius:5px;}
 button{background:#2196F3;color:white;padding:12px;border:none;width:100%;border-radius:5px;cursor:pointer;font-size:16px;}
 a{color:#4CAF50;text-decoration:none;}
</style>
</head>
<body>
<div class="card">
<h2>Edit Employee - Day 12 💙</h2>
<form action="edit-employee" method="post">
<input type="hidden" name="id" value="${employee.id}">
<input type="text" name="name" value="${employee.name}" required>
<input type="email" name="email" value="${employee.email}" required>
<input type="number" step="0.01" name="salary" value="${employee.salary}" required>
<button type="submit">Update Employee</button>
</form>
<br>
<a href="employees">← Back to List</a>
</div>
</body>
</html>