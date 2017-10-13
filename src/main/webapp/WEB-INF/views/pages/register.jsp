<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create account</title>
    <style>
        .error {
            color: #ff0000;
        }

        .errorblock {
            color: #000;
            background-color: #ffEEEE;
            border: 3px solid #ff0000;
            padding: 8px;
            margin: 16px;
        }
    </style>
</head>
<body>
    <jsp:include page="../../partials/_header.jsp"/>
    <jsp:include page="../../partials/_menu.jsp"/>

    <h1>Create your account</h1>

    <c:if test="${notification != null}">
        <p style="color: chartreuse; font-weight: bold">${notification} You can <a href="login">login</a> now</p>
    </c:if>

    <form:form commandName="account" method="post">
        <%--<form:errors path="*" cssClass="errorblock" element="div"/>--%>
        <table align="center">
            <tr>
                <td><form:label path="username">Username</form:label></td>
                <td><form:input path="username"/></td>
                <td><form:errors path="username" cssClass="error"/></td>
            </tr>
            <tr>
                <td><form:label path="password">Password</form:label></td>
                <td><form:password path="password"/></td>
                <td><form:errors path="password" cssClass="error"/></td>
            </tr>
            <tr>
                <td>Confirm password</td>
                <td><input type="password" name="confirm-password"/></td>
                <td><p class="error">${confirmPassError}</td>
            </tr>
            <tr>
                <td colspan="3">
                    <input type="submit" value="Create my account"/>
                    <a href="/">Cancel</a>
                </td>
            </tr>
        </table>
    </form:form>
    <p>Already has an account? <a href="login">Log in</a></p>
</body>
</html>