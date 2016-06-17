<%@ page import="entity.Order" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="jspf/left_profile.jspf"%>



<div id="indexRightColumn">

    <div id="OrdersHistory">
        <span class="idOrder">id </span>
        <span class="dateOrder">Date</span>
        <span class="costOrder">Cost</span>
        <span class="paymentOrder">Payment</span>
        <span class="deliveryOrder">Delivery</span>
        <span class="paymentStatusOrder">Payment status</span>
        <span class="deliveryStatusOrder">Delivery status</span>
    </div>
    <%

        List<Order> orders = (List<Order>) request.getAttribute("ordersList");
        if ( orders.isEmpty())
        {
    %>
    <div class="info">
        You have not placed any orders.
    </div>
    <%
        }
        else{
        for (Order order: orders)
        {
    %>

    <div class="order_info">
        <span class="idOrder">Order №<%=order.getId()%></span>
        <span class="dateOrder"><%=order.getDate()%></span>
        <span class="costOrder"><%=order.getCost()%></span>
        <span class="paymentOrder"><%=order.getPayment()%></span>
        <span class="deliveryOrder"><%=order.getDelivery()%></span>
        <span class="paymentStatusOrder"><%=order.getStatusPayment()%></span>
        <span class="deliveryStatusOrder"><%=order.getStatusDelivery()%></span>
    </div>

    <%
        }}
    %>

</div>

</div>
</body>
</html>
