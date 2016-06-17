<%@ page import="entity.Phone" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="jspf/left_menu.jspf"%>

<div id="indexRightColumn">
    <%
        List<Phone> phones = (List<Phone>) request.getAttribute("phonesList");
        for (Phone phone: phones)
        {
    %>

        <div class="phone_info">

            <div class="phone_title">
                <a href="/phone?<%=phone.getId()%>"><%=phone.getName()%></a>
            </div>

            <div class="phone_image">
                <a href=""><img src="${request.getContextPath()}/ShowImage?index=<%=phones.indexOf(phone)%>"
                                alt="PhoneImage" class="cover"/></a>
            </div>

            <div class="phone_details">
                <br><strong>Brand:</strong> <%=phone.getBrand().getBrand()%>
                <br><strong>Price:</strong> <%=phone.getPrice()/100.0%> <strong> rub </strong>
                <% if (session.getAttribute("role").equals("Admin")) {%>

                <div>
                    <a href="editPhone.jsp?<%=phone.getId()%>">Edit</a>
                </div>

                <% } %>

                <div>
                    <a href="/addToCart?<%=phone.getId()%>">Add to cart</a></p>
                </div>

            </div>

        </div>
    <%
        }
    %>

</div>

</div>
</body>
</html>