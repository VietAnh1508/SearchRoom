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

    <h1>Cities List</h1>

    <form:form commandName="city" action="/city/add">
        <table>
            <c:if test="${!empty city.name}">
                <tr>
                    <td><form:label path="id">ID</form:label></td>
                    <td><form:input path="id" readonly="true"/></td>
                </tr>
            </c:if>
            <tr>
                <td><form:label path="name">City name</form:label></td>
                <td><form:input path="name"/></td>
                <td><form:errors path="name" cssClass="error"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <c:if test="${!empty city.name}">
                        <input type="submit" value="Edit"/>
                    </c:if>
                    <c:if test="${empty city.name}">
                        <input type="submit" value="Add"/>
                    </c:if>
                    <a href="/city">Cancel</a>
                </td>
            </tr>
        </table>
    </form:form>
    <br/>
    <h1>List cities</h1>
    <c:if test="${!empty cities}">
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
                    <td><a href="<c:url value="/edit/${city.id}"/>">Edit</a></td>
                    <td><a href="<c:url value="/remove/${city.id}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <jsp:include page="../partials/_footer.jsp"/>
</body>
</html>