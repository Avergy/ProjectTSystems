<%@ page import="entity.Phone" %>
<%@ page import="Util.ServicesUtil" %>
<%@ page import="entity.Brand" %>
<%@ page import="entity.Color" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id ="indexRightColumn">

    <%
        Phone phone = (Phone) request.getAttribute("currentPhone");
    %>
    <form action="/editPhone" method="post" enctype="multipart/form-data">
        <div class="edit_phone_info">
            <div>

                <div class="image">
                    <label for="image">Phone image:</label><input type="file" name="image" id="image" multiple
                                                                  accept="image/jpeg">
                </div>
                <div class="id">
                    <input name="phone_id" value="<%=phone.getId()%>" type="hidden" id="phone_id">
                </div>
                <div class="field">
                    <label for="phone_name">Name:</label><input name="phone_name" value="<%=phone.getName()%> " type="text" id="phone_name" required>
                </div>
                <div class="field">
                    <%
                        Brand brandPhone = phone.getBrand();
                        Color colorPhone = phone.getColor();
                    %>

                    <label for="phone_brand">Brand:</label><select name="phone_brand" id="phone_brand">
                    <option><%=brandPhone.getBrand()%></option>
                    <%
                        for (Brand brand : ServicesUtil.getBrandService().loadAllBrands()) {
                            if (!brand.equals(brandPhone)){
                    %>
                    <option><%=brand.getBrand()%>
                    </option>
                    <% } }%>
                </select>
                </div>

                <div class="field">
                    <label for="phone_color">Color:</label><select name="phone_color" id="phone_color">
                    <option><%=colorPhone.getColor()%></option>
                    <%
                        for (Color color : ServicesUtil.getColorService().loadAllColors()) {
                            if (!color.equals(colorPhone)){
                    %>
                    <option><%=color.getColor()%>
                    </option>
                    <% }} %>
                </select>
                </div>
                <div class="field">
                    <label for="phone_weight">Weight:</label><input name="phone_weight" value="<%=phone.getWeight()%>" type="number" id="phone_weight">
                </div>
                <div class="field">
                    <label for="phone_quantity_stock">Quantity:</label><input name="phone_quantity_stock" value="<%=phone.getQuantityStock()%>" type="number"
                                                                              id="phone_quantity_stock">
                </div>

                <div class="field">
                    <label for="phone_price">Price, rub:</label><input name="phone_price" value="<%=phone.getPrice()/ 100.0%>" type="number" id="phone_price"
                                                                       pattern="[0-9]{1,5}">
                </div>
                <input type="hidden" name="type" value="edit"></p>
                <p><input type="submit" value="Edit"></p>
            </div>
        </div>

    </form>

</div>

</body>
</html>
