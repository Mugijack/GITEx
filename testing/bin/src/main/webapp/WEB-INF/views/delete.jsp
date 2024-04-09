<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Employee</title>
</head>
<body>
    <h2>Delete Employee</h2>
    <p>Are you sure you want to delete this employee?</p>
    <form action="/delete/${employee.id}" method="post">
        <input type="hidden" name="_method" value="DELETE"> <!-- This line is for Spring Boot -->
        <input type="submit" value="Delete">
        <a href="/">Cancel</a>
    </form>
</body>
</html>
