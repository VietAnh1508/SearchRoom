<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="banner">
    <!-- start slider -->
    <div id="fwslider">
        <div class="slider_container">
            <div class="slide">
                <!-- Slide image -->
                <img src="<c:url value="/resources/images/slider1.jpg"/>" class="img-responsive"/>
                <!-- /Slide image -->
                <!-- Texts container -->
                <div class="slide_content">
                    <div class="slide_content_wrap">
                        <!-- Text title -->
                        <h1 class="title">Run Over<br>Everything</h1>
                        <!-- /Text title -->
                        <div class="button"><a href="#">See Details</a></div>
                    </div>
                </div>
                <!-- /Texts container -->
            </div>
            <!-- /Duplicate to create more slides -->
            <div class="slide">
                <img src="<c:url value="/resources/images/slider2.jpg"/>" class="img-responsive"/>
                <div class="slide_content">
                    <div class="slide_content_wrap">
                        <h1 class="title">Run Over<br>Everything</h1>
                        <div class="button"><a href="#">See Details</a></div>
                    </div>
                </div>
            </div>
            <!--/slide -->
        </div>
        <div class="timers"></div>
        <div class="slidePrev"><span></span></div>
        <div class="slideNext"><span></span></div>
    </div>
    <!--/slider -->
</div>
<div class="features">
    <div class="container">
        <h3 class="m_3">Newest</h3>
        <div class="close_but"><i class="close1"> </i></div>
        <div class="row">
            <c:forEach items="${postNewsList}" var="postNews">
                <div class="col-md-3 top_box">
                    <div class="view view-ninth"><a href="/detail/${postNews.postId}">
                        <img src="/image/${postNews.image}" class="img-responsive" style="height: 196px;"/>
                        <div class="mask mask-1"></div>
                        <div class="mask mask-2"></div>
                        <div class="content">
                            <h2>${postNews.price}</h2>
                            <p>${postNews.address}</p>
                        </div>
                    </a></div>
                    <h4 class="m_4"><a href="/detail/${postNews.postId}">${postNews.title}</a></h4>
                    <p class="m_5">${postNews.roomType}</p>
                </div>
            </c:forEach>
        </div>
    </div>
</div>