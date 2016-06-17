<%@ page import="entity.Phone" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="jspf/left_menu.jspf"%>

<div id="indexRightColumn">
    <%
        Phone phone = (Phone) request.getAttribute("phone");
    %>

    <div class="phone_info_item">

        <div class="phone_title_item">
            ${phone.getName()}
        </div>

        <div class="phone_image_item">
            <a href=""><img src="${request.getContextPath()}/ShowImage?index=<%=phone%>"
                            alt="PhoneImage" class="cover"/></a>
        </div>

        <div class="phone_details_item">
            <br><strong>Brand:</strong> <%=phone.getBrand().getBrand()%>
            <br><strong>Color:</strong> <%=phone.getColor().getColor()%>
            <br><strong>Weight:</strong> <%=phone.getWeight()%>
            <br><strong>Price:</strong> <%=phone.getPrice()/100.0%> <strong> rub </strong>
            <% if (session.getAttribute("role").equals("Admin")) {%>

            <div>
                <a href="editPhone.jsp?<%=phone.getId()%>">Edit</a>
            </div>

            <% } %>

            <div>
                <a href="/addToCart?<%=phone.getId()%>" methods="post">Add to cart</a></p>
            </div>

        </div>

    </div>

</div>

</div>
</body>
</html>
