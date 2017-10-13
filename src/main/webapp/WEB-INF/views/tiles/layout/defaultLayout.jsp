<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <title><tiles:getAsString name="title"/></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

</head>
<body>
    <header id="header">
        <tiles:insertAttribute name="header"/>
    </header>
    <section id="content">
        <tiles:insertAttribute name="body"/>
    </section>
    <footer id="footer">
        <tiles:insertAttribute name="footer"/>
    </footer>
</body>
</html>