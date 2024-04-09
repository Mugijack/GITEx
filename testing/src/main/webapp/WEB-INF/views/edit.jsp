<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Employee</title>
</head>
<body>
    <h2>Edit Employee</h2>
    <form action="/edit/${employee.id}" method="post">
        <input type="hidden" name="id" value="${employee.id}">
        <label>First Name:</label><br>
        <input type="text" name="firstName" value="${employee.firstName}"><br>
        <label>Last Name:</label><br>
        <input type="text" name="lastName" value="${employee.lastName}"><br>
        <label>Age:</label><br>
        <input type="text" name="age" value="${employee.age}"><br>
        <label>Salary:</label><br>
        <input type="text" name="salary" value="${employee.salary}"><br><br>
        <input type="submit" value="Update Employee">
    </form>
</body>
</html>
