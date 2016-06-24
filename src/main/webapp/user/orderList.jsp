<%@ page import="entity.Order" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="/WEB-INF/jspf/left_profile.jspf"%>

<div id="INDEXRIGHTCOLUMN">
    <div class="admin_penal">
        <%
            List<Order> orders = (List<Order>) request.getAttribute("keyOrdersList");
            if (!orders.isEmpty()) {
        %>

        <br><strong>Orders</strong>


        <table border="1">
            <tr>
                <td>id</td>
                <td>Date</td>
                <td>user login </td>
                <td>order status</td>
                <td>shipping type</td>
                <td>payment type</td>
                <td>payment status</td>
                <td>Total</td>
            </tr>
            <%
                for (Order order : orders) {
            %>
            <tr>
                <td><%=order.getId()%>
                </td>
                <td><%=order.getDate()%>
                </td>
                <td><%=order.getUser().getLogin()%>
                </td>
                <td><%=order.getStatusOrder()%>
                </td>
                <td><%=order.getDelivery()%>
                </td>
                <td><%=order.getPayment()%>
                </td>
                <td><%=order.getStatusPayment()%>
                </td>
                <td><%=order.getCost() / 100.0%> rub </td>

            </tr>
            <%
                }
            %>
        </table>

        <%
        } else {
        %>
        <br><strong> 0 orders found.</strong>
        <%
            }
        %>

    </div>
</div>
</body>
</html>
