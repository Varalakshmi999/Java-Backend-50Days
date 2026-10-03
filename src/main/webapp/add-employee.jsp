<%@ page contentType="text/html;charset=UTF-8" %>
<html><head><title>Add Employee</title>
<style>
 body{font-family:Arial;display:flex;justify-content:center;margin-top:50px;background:#f4f4f4;}
 .card{background:white;padding:30px;border-radius:10px;box-shadow:0 0 15px #ccc;width:400px;}
 input{width:100%;padding:10px;margin:10px 0;border:1px solid #ccc;border-radius:5px;}
 button{background:#4CAF50;color:white;padding:12px;border:none;width:100%;border-radius:5px;cursor:pointer;font-size:16px;}
</style></head>
<body>
<div class="card">
<h2>Add Employee - Day 11 💚</h2>
<form action="employees" method="post">
<input type="text" name="name" placeholder="Enter Name" required>
<input type="email" name="email" placeholder="Enter Email" required>
<input type="number" step="0.01" name="salary" placeholder="Enter Salary" required>
<button type="submit">Save Employee</button>
</form><br><a href="employees">← Back to List</a>
</div></body></html>