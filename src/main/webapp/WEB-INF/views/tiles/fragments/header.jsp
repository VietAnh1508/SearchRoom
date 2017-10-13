<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div style="background: #E0E0E0; height: 55px; padding: 5px;">
    <div style="float: left">
        <h3>Search Room</h3>
    </div>

    <div style="float: right; padding: 10px; text-align: right;">
        <c:choose>
            <c:when test="${LOGGED_IN_USER.username == null}">
                <a href="/post">Add news</a> |
                <a href="/login">Login</a> |
                <a href="/register">Register</a>
            </c:when>
            <c:when test="${LOGGED_IN_USER.username != null}">
                <c:choose>
                    <c:when test="${LOGGED_IN_USER.role == \"ADMIN\"}">
                        <a href="/admin">Web Manager</a> |
                    </c:when>
                    <c:when test="${LOGGED_IN_USER.role == \"CUSTOMER\"}">
                        <a href="/post">Add news</a> |
                        <a href="/customerInfo">Account's info</a> |
                    </c:when>
                </c:choose>
                <a href="/logout">Log out</a>
            </c:when>
        </c:choose>
    </div>
</div>