<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="main">
    <div class="shop_top">
        <div class="container">
            <form action="addRoom" method="post" enctype="multipart/form-data">
                <div class="register-top-grid">
                    <h3>ROOM INFORMATION</h3>
                    <p style="font-weight: bold; color: #de6507">${message}</p>
                    <div>
                        <span>Title<label>*</label></span>
                        <input type="text" name="title"/>
                    </div>
                    <div>
                        <span>Address<label>*</label></span>
                        <input type="text" name="address"/>
                    </div>
                    <div>
                        <span>Area<label>*</label> (m<sup>2</sup>)</span>
                        <input type="text" name="area"/>
                    </div>
                    <div>
                        <span>Price<label>*</label></span>
                        <input type="text" name="price"/>
                    </div>
                    <div>
                        <span>Room Type<label>*</label></span>
                        <select name="type">
                            <c:forEach items="${roomTypeList}" var="roomType">
                                <option value="${roomType.id}">${roomType.description}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div>
                        <span>Description<label>*</label></span>
                        <textarea name="description" style="width: 96%"></textarea>
                    </div>
                    <div>
                        <span>Images</span>
                        <input type="file" name="files" multiple/>
                    </div>
                    <div class="clear"> </div>
                </div>
                <div class="clear"> </div>
                <input type="submit" value="submit">
            </form>
        </div>
    </div>
</div>