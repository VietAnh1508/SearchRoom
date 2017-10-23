<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="page login-page">
    <div class="container">
        <div class="form-outer text-center d-flex align-items-center">
            <div class="form-inner">
                <div class="logo text-uppercase">
                    <strong class="text-primary">Admin login</strong>
                </div>
                <form:form commandName="account" id="login-form">
                    <div class="form-group">
                        <form:label path="username" for="login-username" class="label-custom">User Name</form:label>
                        <form:input path="username" id="login-username" name="loginUsername" required=""/>
                    </div>
                    <div class="form-group">
                        <form:label path="password" for="login-password" class="label-custom">Password</form:label>
                        <form:password path="password" id="login-password" name="loginPassword" required=""/>
                    </div>
                    <input type="checkbox" name="remember-me" value="Y"/> Remember Me
                    <input class="btn btn-primary" type="submit" value="Login"/>
                    <%--<a id="login" href="index.html" class="btn btn-primary">Login</a>--%>
                </form:form>
            </div>
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="<c:url value="/resources/admin/js/tether.min.js"/>"></script>
<script src="<c:url value="/resources/admin/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/admin/js/jquery.cookie.js"/>"></script>
<script src="<c:url value="/resources/admin/js/grasp_mobile_progress_circle-1.0.0.min.js"/>"></script>
<script src="<c:url value="/resources/admin/js/jquery.nicescroll.min.js"/>"></script>
<script src="<c:url value="/resources/admin/js/jquery.validate.min.js"/>"></script>
<script src="<c:url value="/resources/admin/js/front.js"/>"></script>