<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
    <jsp:include page="../partials/_header.jsp"/>
    <jsp:include page="../partials/_menu.jsp"/>

    <h1>Admin page</h1>
    <a href="/roomType">Manage room type</a>
    <a href="/cities">Manage cities</a>
    <a href="/districts">Manage districts</a>
    <a href="/approve">Approve rooms</a>
    <a href="/accounts">Manage accounts</a>

    <jsp:include page="../partials/_footer.jsp"/>
</body>
</html>