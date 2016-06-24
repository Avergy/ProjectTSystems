<%@ page import="entity.Brand" %>
<%@ page import="Util.ServicesUtil" %>
<%@ page import="entity.Color" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%@include file="/WEB-INF/jspf/left_profile.jspf"%>

<div id ="indexRightColumn">

    <br><strong>Add new phone</strong>

    <p>&nbsp;</p>

    <form action="/newPhone" method="post" enctype="multipart/form-data" >
        <div class="new_phone_info">
            <div>

                <div class="image">
                    <label for="image">Phone image:</label><input type="file" name="image" id="image" multiple
                                                              accept="image/jpeg">
                </div>
                <div class="field">
                    <label for="phone_name">Name:</label><input name="phone_name" type="text" id="phone_name" required>
                </div>

                <div class="field">

                    <label for="phone_brand">Brand:</label><select name="phone_brand" id="phone_brand">
                    <%
                        for (Brand brand : ServicesUtil.getBrandService().loadAllBrands()) {
                    %>
                    <option><%=brand.getBrand()%>
                    </option>
                    <% } %>
                </select>
                </div>

                <div class="field">
                    <label for="phone_color">Color:</label><select name="phone_color" id="phone_color">
                    <%
                        for (Color color : ServicesUtil.getColorService().loadAllColors()) {
                    %>
                    <option><%=color.getColor()%>
                    </option>
                    <% } %>
                </select>
                </div>
                <div class="field">
                    <label for="phone_weight">Weight:</label><input name="phone_weight" type="number" id="phone_weight">
                </div>
                <div class="field">
                    <label for="phone_quantity_stock">Quantity:</label><input name="phone_quantity_stock" type="number"
                                                                              id="phone_quantity_stock">
                </div>

                <div class="field">
                    <label for="phone_price">Price, rub:</label><input name="phone_price" type="number" id="phone_price"
                                                                     pattern="[0-9]{1,5}">
                </div>
                <input type="hidden" name="type" value="add">
                </p>
                <p><input type="submit" value="Add phone"></p>
            </div>
        </div>

    </form>

</div>

</body>
</html>
