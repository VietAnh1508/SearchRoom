<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>Login to your account</h1>
<p class="error">${message}</p>

<form:form commandName="account">
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
            <td>Remember Me</td>
            <td><input type="checkbox" name="remember-me" value="Y"/></td>
        </tr>
        <tr>
            <td colspan="3">
                <input type="submit" value="Log in"/>
            </td>
        </tr>
    </table>
</form:form>