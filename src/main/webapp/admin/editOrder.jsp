<%@ page import="enums.StatusOrder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jspf/left_profile.jspf"%>
<style>
    <%@include file='../css/form.css'%>
</style>
<div id="indexRightColumn">
<div class="edit_penal">
    <br><strong>Update order status</strong>

    <form name="order_set_status_form" action="/setOrderStatus" method="get">
        <div class="edit_phone_info">
            <div>
                <div class="field">
                    <label for="order_id">ID:</label> <%=request.getParameter("order_id")%>
                    <input type="text" value="<%=request.getParameter("order_id")%>"
                           name="order_id" id="order_id" hidden>
                </div>

                <div class="field">
                    <label for="order_status">Order status:</label>
                    <select name="order_status" id="order_status">
                        <%
                            for (StatusOrder statusOrder: StatusOrder.values()) {
                        %>
                        <option><%=statusOrder.toString()%>
                        </option>
                        <% } %>
                    </select>
                </div>
                <input type="hidden" name="action" value="set"></p>
                <p><input type="submit" value="update"></p>
            </div>
        </div>
    </form>
</div>
</div>
</body>
</html>