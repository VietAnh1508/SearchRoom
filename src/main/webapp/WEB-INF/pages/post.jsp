<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="main">
    <div class="shop_top">
        <div class="container">
            <form:form commandName="newPost" enctype="multipart/form-data">
                <div class="register-top-grid">
                    <h3>ROOM INFORMATION</h3>
                    <p style="font-weight: bold; color: #de6507">${message}</p>
                    <div>
                        <span>Title<label>*</label></span>
                        <form:input path="title"/>
                    </div>
                    <div>
                        <span>Address<label>*</label></span>
                        <form:input path="address"/>
                    </div>
                    <div>
                        <span>Area<label>*</label> (m<sup>2</sup>)</span>
                        <form:input path="area"/>
                    </div>
                    <div>
                        <span>Price<label>*</label></span>
                        <form:input path="price"/>
                    </div>
                    <div>
                        <span>Room Type<label>*</label></span>
                        <form:select path="typeId">
                            <c:forEach items="${roomTypeList}" var="roomType">
                                <form:option value="${roomType.id}">${roomType.description}</form:option>
                            </c:forEach>
                        </form:select>
                    </div>
                    <div>
                        <span>Description<label>*</label></span>
                        <form:textarea path="description" style="width: 96%; resize: none"/>
                    </div>
                    <div>
                        <span>Images</span>
                        <input type="file" name="files"/>
                    </div>
                    <div class="clear"> </div>
                </div>
                <div class="clear"> </div>
                <input type="submit" value="submit">
            </form:form>
        </div>
    </div>
</div>