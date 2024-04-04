<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="models.Employee" %>
<html>
<head>
    <title>Employee Management</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
    <h1>Employee Management</h1>
    
    <!-- Search Employees Form -->
    <h2>Search Employees</h2>
    <form action="${pageContext.request.contextPath}/employees/search" method="get">
        <label for="keyword">Search Keyword:</label>
        <input type="text" id="keyword" name="keyword" required>
        <input type="submit" value="Search">
    </form>
    
    <hr>
    
    <!-- Filter Employees Form -->
    <h2>Filter Employees</h2>
    <form action="${pageContext.request.contextPath}/employees/filter" method="get">
        <label for="department">Department:</label>
        <input type="text" id="department" name="department">
        
        <label for="position">Position:</label>
        <input type="text" id="position" name="position">
        
        <input type="submit" value="Filter">
    </form>
    
    <hr>
    
    <!-- Add Employee Form -->
    <h2>Add Employee</h2>
    <form action="${pageContext.request.contextPath}/employees/add" method="post">
        <label for="id">ID:</label>
        <input type="text" id="id" name="id">
        
        <label for="name">Name:</label>
        <input type="text" id="name" name="name">
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email">
        
        <label for="phone">Phone:</label>
        <input type="text" id="phone" name="phone">
        
        <label for="department">Department:</label>
        <input type="text" id="department" name="department">
        
        <label for="position">Position:</label>
        <input type="text" id="position" name="position">
        
        <input type="submit" value="Add Employee">
    </form>
    
    <hr>
    
    <!-- Display Employees Table -->
    <h2>Employee List</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Department</th>
            <th>Position</th>
            <th>Action</th>
        </tr>
        <c:forEach var="employee" items="${employees}">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.name}</td>
                <td>${employee.email}</td>
                <td>${employee.phone}</td>
                <td>${employee.department}</td>
                <td>${employee.position}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/employees/edit?id=${employee.id}">Edit</a>
                    <a href="${pageContext.request.contextPath}/employees/delete?id=${employee.id}" onclick="return confirm('Are you sure you want to delete this employee?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    
</body>
</html>
