<%@ page import="java.util.List" %>
<%@ page import="entity.Order" %>
<%@ page import="Util.ServicesUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jspf/left_profile.jspf"%>
<style>
    <%@include file='../css/order_table.css'%>
</style>
<div id="INDEXRIGHTCOLUMN">
<div class="admin_penal">
    <%
        List<Order> orders = (ServicesUtil.getOrderService().getAllOrders());
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
            <td>Edit</td>
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
            <td><div class="div_edit_img">
                <a href="/admin/editOrder.jsp?order_id=<%=order.getId()%>">
                    <img src="/images/edit.png" alt="edit" name="edit" id="edit_img" /></a>
            </div>
            </td>

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
