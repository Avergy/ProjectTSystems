<%@ page import="entity.OrderItem" %>
<%@ page import="cart.ShoppingCart" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="cart_items">

    <div id="CartTitle">
        <span class="cart_title_phone_name">Phone  </span>
        <span class="cart_title_price">Price</span>
        <span class="cart_title_quantity">Quantity</span>
        <span class="cart_title_order_amount">Order amount</span>
    </div>
    <%

        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        if ( cart == null)
        {
    %>
    <div class="info">
        Your Shopping Cart is empty
    </div>
    <%
    }
    else{
        for (OrderItem orderItem: cart.getOrderItems())
        {
    %>

    <div class="order_info">
        <span class="cart_title_phone_name"><%=orderItem.getPhone().getName()%> </span>
        <span class="cart_title_price"><%=orderItem.getPhone().getPrice()%> </span>
        <span class="cart_title_quantity"><%=orderItem.getQuantity()%> </span>
        <span class="cart_title_order_amount"><%=orderItem.getQuantity()*orderItem.getPhone().getPrice()%> </span>
    </div>

    <%
            }}
    %>

</div>
<div id="cart_navigator">


</div>
</div>
</body>
</html>
