<%@ page import="java.util.Map" %>
<%@ page import="Util.ServicesUtil" %>
<%@ page import="entity.Phone" %>
<%@ page import="entity.Order" %>
<%@ page import="java.util.List" %>
<%@include file="/WEB-INF/jspf/left_profile.jspf"%>
<style>
    <%@include file='/css/order_table.css'%>
    <%@include file='/css/form.css'%>
    <%@include file="/css/Top-10.css"%>
</style>
<div id ="indexRightColumn">

<div>

    <div class="top10_penal">

        <div class="admin_penal">
            <%
                Map<User, Long> topTenUsers = ServicesUtil.getUserService().getTopTenUsers();
                if (!topTenUsers.isEmpty()) {
            %>

            <br><strong>Top-10 users</strong>

            <table border="1">
                <tr>
                    <td>Login</td>
                    <td>First Name</td>
                    <td>Last Name</td>
                    <td>E-mail</td>
                    <td>Proceeds</td>
                </tr>
                <%
                    for (Map.Entry<User, Long> pair: topTenUsers.entrySet())
                    {
                        User user1 = pair.getKey();
                %>
                <tr>
                    <td><%=user1.getLogin()%>
                    </td>
                    <td><%=user1.getFirstName()%>
                    </td>
                    <td><%=user1.getSecondName()%>
                    </td>
                    <td><%=user1.getEmail()%>
                    </td>
                    <td><%=pair.getValue() / 100.0%> rub
                    </td>

                </tr>
                <%
                    }
                %>
            </table>

            <%
            } else {
            %>
            <br><strong> 0 orders found</strong>
            <%
                }
            %>


        </div>
    </div>

    <div class="top10_penal">

        <div class="admin_penal">
            <%
                Map<Phone, Integer> topTenPhones = ServicesUtil.getUserService().getTopTenPhones();
                if (!topTenPhones.isEmpty()) {
            %>

            <br><strong>Top-10 phones</strong>


            <table border="1">
                <tr>
                    <td>Phone</td>
                    <td>Brand</td>
                    <td>Color</td>
                    <td>Price</td>
                    <td>Out of stock</td>
                    <td>sales</td>

                </tr>
                <%
                    for (Map.Entry<Phone, Integer> pair: topTenPhones.entrySet())
                    { Phone phone = pair.getKey();
                %>
                <tr>
                    <td><%=phone.getName()%>
                    </td>
                    <td><%=phone.getBrand().getBrand()%>
                    </td>
                    <td><%=phone.getColor().getColor()%>
                    </td>
                    <td><%=phone.getPrice() /100%> rub.
                    </td>
                    <td><%=phone.getQuantityStock()%>
                    </td>
                    <td><%=pair.getValue()%>
                    </td>


                </tr>
                <%
                    }
                %>
            </table>

            <%
            } else {
            %>
            <br><strong>0 orders found</strong>
            <%
                }
            %>


        </div>
    </div>
</div>

    <div class="edit_penal">

        <br><strong>Proceeds:</strong>

        <form name="proceed_form" action="/getProceedsPerPeriod" method="post">

            <div class="edit_phone_info">
                <div>

                    <div class="date">

                        <label for="start_date">From:</label>
                        <input name="start_date" id="start_date" type="date" required>
                    </div>

                    <div class="date">


                        <label for="end_date">To:</label>
                        <input name="end_date" id="end_date" type="date" required>
                    </div>

                    <input type="hidden" name="action" value="show"></p>
                    <p><input type="submit" value="Show"></p>

                </div>
            </div>
        </form>


        <div class="admin_penal">
            <%
                List<Order> ordersPerPeriod = (List<Order>) session.getAttribute("ordersPerPeriod");
                int totalSum = 0;
                if (ordersPerPeriod != null && !ordersPerPeriod.isEmpty()) {
            %>

            <br><strong>Orders</strong>


            <table border="1">
                <tr>
                    <td>id</td>
                    <td>Date</td>
                    <td>User login</td>
                    <td>Status order</td>
                    <td>Shipping type</td>
                    <td>Status payment</td>
                    <td>Payment type</td>
                    <td>Total</td>
                    <td>Edit</td>
                </tr>
                <%
                    for (Order order : ordersPerPeriod) {
                        totalSum += order.getCost();
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
                    <td><%=order.getStatusPayment()%>
                    </td>
                    <td><%=order.getPayment()%>
                    </td>
                    <td><%=order.getCost()/ 100.0%> rub</td>
                    <td>
                        <a href="edit_order.jsp?order_id=<%=order.getId()%>">
                            <img src="../images/edit.png" alt="Edit" id="edit_img" name="edit"/></a>
                    </td>

                </tr>
                <%
                    }
                %>
            </table>

            <%
            } else {
            %>
            <br><strong>0 orders found</strong>
            <%
                }
            %>

            <br><strong>Proceeds: <%=totalSum / 100.0 %> rub.
        </strong>


        </div>

    </div>
    </div>
</body>
</html>
