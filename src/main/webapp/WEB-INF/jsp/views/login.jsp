<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Login</title>
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
    <h1>Login to your account</h1>
    <p class="error">${message}</p>

    <form:form commandName="account">
        <form:errors path="*" cssClass="errorblock" element="div"/>
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
                <td colspan="3">
                    <input type="submit" value="Log in"/>
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>