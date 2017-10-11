<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Admin</title>
    <style>
        .error { color: red; }
    </style>
</head>
<body>
    <jsp:include page="../partials/_header.jsp"/>
    <jsp:include page="../partials/_menu.jsp"/>

    <h1>Manage Room type</h1>

    <form:form commandName="roomType" action="/roomType/add">
        <table>
            <c:if test="${!empty roomType.description}">
                <tr>
                    <td><form:label path="id">ID</form:label></td>
                    <td><form:input path="id" readonly="true"/></td>
                </tr>
            </c:if>
            <tr>
                <td><form:label path="description">Description</form:label></td>
                <td><form:input path="description"/></td>
                <td><form:errors path="description" cssClass="error"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <c:if test="${!empty roomType.description}">
                        <input type="submit" value="Edit"/>
                    </c:if>
                    <c:if test="${empty roomType.description}">
                        <input type="submit" value="Add"/>
                    </c:if>
                    <a href="/roomType">Cancel</a>
                </td>
            </tr>
        </table>
    </form:form>
    <br/>
    <h1>List room type</h1>
    <c:if test="${!empty roomTypeList}">
        <table>
            <tr>
                <th>ID</th>
                <th>Description</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach items="${roomTypeList}" var="roomType">
                <tr>
                    <td>${roomType.id}</td>
                    <td>${roomType.description}</td>
                    <td><a href="<c:url value="/edit/${roomType.id}"/>">Edit</a></td>
                    <td><a href="<c:url value="/remove/${roomType.id}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <jsp:include page="../partials/_footer.jsp"/>
</body>
</html>