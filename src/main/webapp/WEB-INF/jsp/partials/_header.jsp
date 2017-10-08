<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div style="background: #E0E0E0; height: 55px; padding: 5px;">
    <div style="float: left">
        <h3>Search Room</h3>
    </div>

    <div style="float: right; padding: 10px; text-align: right;">
        <a href="/addNews">Add news</a> |
        <c:choose>
            <c:when test="${loginedAccount.username == null}">
                <a href="/login">Login</a> |
                <a href="/register">Register</a>
            </c:when>
            <c:when test="${loginedAccount.username != null}">
                <a href="/logout">Log out</a>
            </c:when>
        </c:choose>
    </div>
</div>