<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" type="text/css" href="/resources/css/admin-style.css"/>
<div id="wrapper">
    <jsp:include page="_admin_menu.jsp"/>
    <div id="rightContent">
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
            <table class="data">
                <tr class="data">
                    <th class="data">ID</th>
                    <th class="data">Description</th>
                    <th class="data">Edit</th>
                    <th class="data">Delete</th>
                </tr>
                <c:forEach items="${roomTypeList}" var="roomType">
                    <tr class="data">
                        <td class="data">${roomType.id}</td>
                        <td class="data">${roomType.description}</td>
                        <td class="data"><a href="<c:url value="/roomType/edit/${roomType.id}"/>">Edit</a></td>
                        <td class="data"><a href="<c:url value="/roomType/remove/${roomType.id}"/>">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
</div>
<div class="clear"></div>