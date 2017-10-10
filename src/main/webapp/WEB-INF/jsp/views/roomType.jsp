<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
    <jsp:include page="../partials/_header.jsp"/>
    <jsp:include page="../partials/_menu.jsp"/>

    <h1>Manage Room type</h1>

    <form action="/add-room-type" method="post">
        <table>
            <tr>
                <td>Add new type</td>
                <td><input type="text" name="description"/></td>
                <td><input type="submit" value="Add"/></td>
            </tr>
        </table>
    </form>

    <table>
        <tr>
            <th>ID</th>
            <th>Description</th>
            <th colspan="2">#</th>
        </tr>
        <c:forEach items="${roomTypeList}" var="roomType">
            <tr>
                <td>${roomType.id}</td>
                <td>${roomType.description}</td>
                <td><a href="#">Edit</a></td>
                <td><a href="#">Delete</a></td>
            </tr>
        </c:forEach>
    </table>

    <jsp:include page="../partials/_footer.jsp"/>
</body>
</html>