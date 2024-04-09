<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Employee</title>
</head>
<body>
    <h2>Add Employee</h2>
    <form action="/add" method="post">
        <label>First Name:</label><br>
        <input type="text" name="firstName"><br>
        <label>Last Name:</label><br>
        <input type="text" name="lastName"><br>
        <label>Age:</label><br>
        <input type="text" name="age"><br>
        <label>Salary:</label><br>
        <input type="text" name="salary"><br><br>
        <button onclick="alert('Hello, World!')">
        <input type="submit" value="Add Employee"></button>
    </form>
</body>
</html>
