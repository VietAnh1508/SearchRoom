<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Account Info</title>
    <style>
        .error {
            color: #ff0000;
        }
    </style>
</head>
<body>

    <h1>Account's information</h1>

    <c:if test="${notification != null}">
        <p style="font-weight: bold; color: red">${notification}</p>
    </c:if>

    <form:form commandName="customer">
        <table>
            <tr>
                <td><form:label path="username">Username:</form:label></td>
                <td><form:input path="username" readonly="true" /></td>
            </tr>
            <tr>
                <td><form:label path="fullName">Full name:</form:label></td>
                <td><form:input path="fullName"/></td>
                <td><form:errors path="fullName" cssClass="error"/></td>
            </tr>
            <tr>
                <td><form:label path="phoneNumber">Phone number:</form:label></td>
                <td><form:input path="phoneNumber"/></td>
                <td><form:errors path="phoneNumber" cssClass="error"/></td>
            </tr>
            <tr>
                <td><form:label path="email">Email:</form:label></td>
                <td><form:input path="email"/></td>
                <td><form:errors path="email" cssClass="error"/></td>
            </tr>
            <tr>
                <td colspan="3">
                    <input type="submit" value="Update"/>
                    <a href="/">Cancel</a>
                </td>
            </tr>
        </table>
    </form:form>

</body>
</html>