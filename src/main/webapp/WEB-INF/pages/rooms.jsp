<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="main">
    <div class="shop_top">
        <div class="container">
            <h3 class="m_3">Room List</h3>
            <div class="close_but"><i class="close1"> </i></div>
            <div class="row shop_box-top">
                <c:forEach items="${postList}" var="post">
                    <div class="col-md-3 shop_box">
                        <a href="<c:url value="/detail?post-id=${post.postId}"/>">
                            <img src="/image/${post.image}" class="img-responsive" style="height: 196px;"/>
                        </a>
                        <span class="new-box">
                            <span class="new-label">Approved</span>
                        </span>
                        <div class="shop_desc">
                            <h3><a href="<c:url value="/detail?post-id=${post.postId}"/>">${post.title}</a></h3>
                            <p>${post.address}</p>
                            <span class="actual">${post.price} VND</span><br>
                            <ul class="buttons">
                                <li class="cart"><a href="<c:url value="/save?post-id=${post.postId}"/>">Save</a></li>
                                <li class="shop_btn"><a href="<c:url value="/detail?post-id=${post.postId}"/>">Read
                                    More</a></li>
                                <div class="clear"></div>
                            </ul>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>