<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%--<c:choose>--%>
            <%--<c:when test="${LOGGED_IN_USER.username == null}">--%>
                <%--<a href="/post">Add news</a> |--%>
                <%--<a href="/login">Login</a> |--%>
                <%--<a href="/register">Register</a>--%>
            <%--</c:when>--%>
            <%--<c:when test="${LOGGED_IN_USER.username != null}">--%>
                <%--<c:choose>--%>
                    <%--<c:when test="${LOGGED_IN_USER.role == \"ADMIN\"}">--%>
                        <%--<a href="/admin">Web Manager</a> |--%>
                    <%--</c:when>--%>
                    <%--<c:when test="${LOGGED_IN_USER.role == \"CUSTOMER\"}">--%>
                        <%--<a href="/post">Add news</a> |--%>
                        <%--<a href="/customerInfo">Account's info</a> |--%>
                    <%--</c:when>--%>
                <%--</c:choose>--%>
                <%--<a href="/logout">Log out</a>--%>
            <%--</c:when>--%>
        <%--</c:choose>--%>
    <%--</div>--%>
<%--</div>--%>
<div class="header">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="header-left">
                    <div class="logo">
                        <a href="/"><img src="/resources/images/logo.png" alt=""/></a>
                    </div>
                    <div class="menu">
                        <a class="toggleMenu" href="#"><img src="/resources/images/nav.png" alt=""/></a>
                        <ul class="nav" id="nav">
                            <li><a href="/rooms">Rooms</a></li>
                            <li><a href="/post">Post</a></li>
                            <c:if test="${empty LOGGED_IN_USER.username}">
                                <li><a href="/login">Login</a></li>
                                <li><a href="/register">Register</a></li>
                            </c:if>
                            <c:if test="${!empty LOGGED_IN_USER.username}">
                                <c:if test="${LOGGED_IN_USER.role == \"ADMIN\"}">
                                    <li><a href="/admin">Web Mamanger</a></li>
                                </c:if>
                                <c:if test="${LOGGED_IN_USER.role == \"CUSTOMER\"}">
                                    <li><a href="/post">Add news</a></li>
                                    <li><a href="/customerInfo">Account's info</a></li>
                                </c:if>
                                <li><a href="#">Welcome ${LOGGED_IN_USER.username}</a></li>
                                <li><a href="/logout">Log out</a></li>
                            </c:if>
                            <div class="clear"></div>
                        </ul>
                        <script type="text/javascript" src="/resources/js/responsive-nav.js"></script>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="header_right">
                    <!-- start search-->
                    <div class="search-box">
                        <div id="sb-search" class="sb-search">
                            <form>
                                <input class="sb-search-input" placeholder="Enter your search term..." type="search"
                                       name="search" id="search">
                                <input class="sb-search-submit" type="submit" value="">
                                <span class="sb-icon-search"> </span>
                            </form>
                        </div>
                    </div>
                    <!----search-scripts---->
                    <script src="/resources/js/classie.js"></script>
                    <script src="/resources/js/uisearch.js"></script>
                    <script>
                        new UISearch(document.getElementById('sb-search'));
                    </script>
                    <!----//search-scripts---->
                    <ul class="icon1 sub-icon1 profile_img">
                        <li><a class="active-icon c1" href="#"> </a>
                            <ul class="sub-icon1 list">
                                <div class="product_control_buttons">
                                    <a href="#"><img src="/resources/images/edit.png" alt=""/></a>
                                    <a href="#"><img src="/resources/images/close_edit.png" alt=""/></a>
                                </div>
                                <div class="clear"></div>
                                <li class="list_img"><img src="/resources/images/1.jpg" alt=""/></li>
                                <li class="list_desc">
                                    <h4><a href="#">velit esse molestie</a></h4>
                                    <span class="actual">1 x $12.00</span>
                                </li>
                                <div class="login_buttons">
                                    <div class="check_button"><a href="checkout.html">Check out</a></div>
                                    <div class="login_button"><a href="login.html">Login</a></div>
                                    <div class="clear"></div>
                                </div>
                                <div class="clear"></div>
                            </ul>
                        </li>
                    </ul>
                    <div class="clear"></div>
                </div>
            </div>
        </div>
    </div>
</div>