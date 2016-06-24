<%@ page import="entity.OrderItem" %>
<%@ page import="cart.ShoppingCart" %>
<%@ page import="Util.SetUtil" %>
<%@ page import="java.util.List" %>
<%@ page import="enums.Delivery" %>
<%@ page import="enums.Payment" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file="css/cart.css"%>
    <%@include file='css/status.css'%>
</style>

<%
    user = (User) session.getAttribute("user");
    if (user == null) {
        userName = "Guest";
        SetUtil.setUserByLogin(userName, request);
    }

    List<OrderItem> orderItems = null;

    if (request.getSession().getAttribute("cart") == null) {
        SetUtil.setCartOutCookie(request, user, shoppingCartManager);
    } else {
        shoppingCartManager.setShoppingCart((ShoppingCart) session.getAttribute("cart"));
    }

    orderItems = shoppingCartManager.getShoppingCart().getOrderItems();
    session.setAttribute("cartManager", shoppingCartManager);

%>

<div class="cart_penal">


    <%
        if (!orderItems.isEmpty()) {
    %>

    <br><strong>Cart</strong>

    <br><a href="/clearCart">Clear cart</a></br></p>

    <form name="order_form" action="/createOrder" method="post">


        <table border="1">
            <tr>
                <td>id</td>
                <td>Name</td>
                <td>Quantity</td>
                <td></td>
            </tr>
            <%
                for (OrderItem item: orderItems) {
            %>
            <tr>
                <td><%=item.getPhone().getId()%>
                </td>
                <td><%=item.getPhone().getName()%>
                </td>
                <td><input type="number" name="quantity<%=item.getPhone().getId()%>" min="1" value="<%=item.getQuantity()%>"
                           onchange=""
                           style="width:45px"></td>
                <td><a href="/removeOrderItem?id=<%=item.getPhone().getId()%>">
                    Delete</a>
                </td>
            </tr>
            <%
                }
                request.getSession().setAttribute("orderItems", orderItems);

            %>
        </table>

        <br>Shipping type:<select name="shipping_type">
        <%
            for (Delivery value : Delivery.values()) {
        %>
        <option><%=value.toString()%>
        </option>
        <% } %>
    </select>


        <br>Payment type:<select name="payment_type">
        <%
            for (Payment value : Payment.values()) {
        %>
        <option><%=value.toString()%>
        </option>
        <% } %>
    </select>

        <% if (request.getUserPrincipal() != null) {%>
        <p></p>
        <div id="user_addresses">
            <div class="field">
                <label for="new_address_name">Enter a shipping address:</label>
                <input name="new_address_name" type="text" id="new_address_name">
            </div>
            <%

            %>
        </div>
        <p><input type="submit" value="Proceed to checkout"></p>
        <%} else { %>
        <br><a href="/user/profile.jsp">Sign in</a></br></p>
        <% } %>



    </form>
    <%
        } else {
    %>
    <br><strong>Your Shopping Cart is empty</strong>
    <%
        }
    %>

</div>


<div id="order_popup_ok" class="overlay">
    <div class="popup">
        <h2>Order</h2>
        <a class="close" href="">×</a>

        <div>
            Ok
        </div>
    </div>
</div>

<div id="order_popup_not_ok" class="overlay">
    <div class="popup">
        <h2>Order</h2>
        <a class="close" href="">×</a>

        <div>
            Not ok!
        </div>
    </div>
</div>

</body>
</html>