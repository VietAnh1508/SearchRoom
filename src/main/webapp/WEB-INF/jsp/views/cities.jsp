<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Cities List</title>
</head>
<body>
    <h1>Cities List</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${cities}" var="city">
            <tr>
                <td>${city.id}</td>
                <td>${city.name}</td>
                <td><a href="cities/edit/${city.id}">Edit</a></td>
                <td><a href="cities/delete/${city.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>