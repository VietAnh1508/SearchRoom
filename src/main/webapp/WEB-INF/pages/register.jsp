<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="main">
    <div class="shop_top">
        <div class="container">
            <div class="col-md-6">
                <div class="login-page">
                    <h4 class="title">Registered Customers</h4>
                    <p>Already has an account? Login now</p>
                    <div class="button1">
                        <a href="<c:url value="/login"/>">
                            <input type="submit" name="Submit" value="Login">
                        </a>
                    </div>
                    <div class="clear"></div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="login-title">
                    <h4 class="title">New Customers</h4>
                    <p style="color: #37ff1a">${notification}</p>
                    <p style="color: red;">${message}</p>
                    <div id="loginbox" class="loginbox">
                        <form:form commandName="account" name="register" id="login-form">
                            <fieldset class="input">
                                <p id="register-form-username">
                                    <form:label path="username" for="modlgn_username">Username*</form:label>
                                    <form:input path="username" id="modlgn_username" class="inputbox" size="18"
                                                autocomplete="off"/>
                                    <form:errors path="username" cssClass="error"/>
                                </p>
                                <p id="register-form-password">
                                    <form:label path="password" for="modlgn_passwd">Password*</form:label>
                                    <form:input path="password" id="modlgn_passwd" type="password" class="inputbox" size="18"
                                                autocomplete="off"/>
                                    <form:errors path="password" cssClass="error"/>
                                </p>
                                <p id="register-form-re-password">
                                    <form:label path="confirmPassword" for="modlgn_passwd">Confirm Password*</form:label>
                                    <form:input path="confirmPassword" id="modlgn_passwd" type="password"
                                                class="inputbox" size="18" autocomplete="off" />
                                    <form:errors path="confirmPassword" cssClass="error"/>
                                </p>
                                <div class="remember">
                                        <input type="submit" name="Submit" class="button" value="Register" style="margin-right: 2px;"/>
                                    <div class="clear"></div>
                                </div>
                            </fieldset>
                        </form:form>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
        </div>
    </div>
</div>