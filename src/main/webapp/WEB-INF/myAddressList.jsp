<%@ page import="entity.UserAddress" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="jspf/left_profile.jspf"%>

<div id="indexRightColumn">
    <%
        List<UserAddress> addresses = (List<UserAddress>) request.getAttribute("myAddressList");
        for (UserAddress address: addresses)
        {
    %>

    <div class="address_item">
            <%=address.getAddress()%>
    </div>
    <%
        }
    %>

</div>

</div>
</body>
</html>