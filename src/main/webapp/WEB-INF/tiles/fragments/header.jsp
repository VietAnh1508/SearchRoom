<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="header">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="header-left">
                    <div class="logo">
                        <a href=<c:url value="/"/>><img src=<c:url value="/resources/images/logo.png"/>/></a>
                    </div>
                    <div class="menu">
                        <a class="toggleMenu" href="#"><img src=<c:url value="/resources/images/nav.png"/>/></a>
                        <ul class="icon1 sub-icon1" style="display:flex;">
                            <li><a href="<c:url value="/rooms"/>" class="header-menu">Rooms</a></li>
                            <c:if test="${empty LOGGED_IN_USER.username}">
                                <li><a href="<c:url value="/login"/>" class="header-menu">Login</a></li>
                                <li><a href="<c:url value="/register"/>" class="header-menu">Register</a></li>
                            </c:if>
                            <c:if test="${not empty LOGGED_IN_USER.username}">
                                <c:if test="${LOGGED_IN_USER.role == \"CUSTOMER\"}">
                                    <li><a href="<c:url value="/rooms/update"/>" class="header-menu">Post</a></li>
                                </c:if>
                                <li><a href="#" class="header-menu">Welcome ${LOGGED_IN_USER.username}</a>
                                    <ul class="sub-icon1 list" style="display:flex; flex-direction: column;font-size: 18px;">
                                        <c:if test="${LOGGED_IN_USER.role == \"ADMIN\"}">
                                            <li><a href="<c:url value="/admin"/>" style="color:black;">Web Manager</a></li>
                                        </c:if>
                                        <c:if test="${LOGGED_IN_USER.role == \"CUSTOMER\"}">
                                            <li><a href="<c:url value="/customer-posts?user=${LOGGED_IN_USER.username}"/>" style="color:black;">My post</a></li>
                                            <li><a href="<c:url value="/customer-info"/>" style="color:black;">Account's info</a></li>
                                        </c:if>
                                        <li><a href="<c:url value="/logout"/>" style="color:black;">Log out</a></li>
                                    </ul>
                                </li>
                            </c:if>
                        </ul>
                        <script type="text/javascript" src=<c:url value="/resources/js/responsive-nav.js"/>></script>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="header_right">
                    <!-- start search-->
                    <div class="search-box">
                        <div id="sb-search" class="sb-search">
                            <form action="/rooms/search">
                                <input class="sb-search-input" placeholder="Enter your search term..." type="search"
                                       name="search" id="search">
                                <input class="sb-search-submit" type="submit" value="">
                                <span class="sb-icon-search"> </span>
                            </form>
                        </div>
                    </div>
                    <!----search-scripts---->
                    <script src=<c:url value="/resources/js/classie.js"/>></script>
                    <script src=<c:url value="/resources/js/uisearch.js"/>></script>
                    <script>
                        new UISearch(document.getElementById('sb-search'));
                    </script>
                    <!----//search-scripts---->
                    <ul class="icon1 sub-icon1 profile_img">
                        <li><a class="active-icon c1" href="#"> </a>
                            <ul class="sub-icon1 list">
                                <div class="product_control_buttons">
                                    <a href="#"><img src=<c:url value="/resources/images/close_edit.png"/>/></a>
                                </div>
                                <div class="clear"></div>
                                <li class="list_img"><img src=<c:url value="/resources/images/1.jpg"/>/></li>
                                <li class="list_desc">
                                    <h4><a href="#">velit esse molestie</a></h4>
                                    <span class="actual">1 x $12.00</span>
                                </li>
                                <div class="clear"></div>

                                <div class="product_control_buttons">
                                    <a href="#"><img src=<c:url value="/resources/images/close_edit.png"/>/></a>
                                </div>
                                <div class="clear"></div>
                                <li class="list_img"><img src=<c:url value="/resources/images/1.jpg"/>/></li>
                                <li class="list_desc">
                                    <h4><a href="#">velit esse molestie</a></h4>
                                    <span class="actual">1 x $12.00</span>
                                </li>

                                <div class="login_buttons">
                                    <div class="check_button">
                                        <a href=<c:url value="/compare"/>>Compare</a>
                                    </div>
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