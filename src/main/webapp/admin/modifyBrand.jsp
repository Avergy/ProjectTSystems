<%@ page import="entity.Brand" %>
<%@ page import="Util.ServicesUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="/WEB-INF/jspf/left_profile.jspf"%>

<div id ="indexRightColumn">

        <form action="/modifyBrand" method="post">
            <div class="modify_info">
                <div>
                    <div class="field">
                        <label for="select_brand">Select or add a new brand.</label>
                        <select name="select_brand" id="select_brand">
                            <option>add new brand</option>
                        <%
                            for (Brand brand: ServicesUtil.getBrandService().loadAllBrands()) {
                        %>
                        <option><%=brand.getBrand()%></option>
                        <% } %>
                    </select>
                    </div>
                    <div class="field">
                        <label for="new_brand_name">Enter a new brand name:</label>
                        <input name="new_brand_name" type="text" id="new_brand_name">
                    </div>
                    <input type="hidden" name="type" value="modifyBrand"></p>
                    <p><input type="submit" name = "edit" value="Edit"></p>
                    <p><input type="submit" name="delete" value="Delete"></p>
                </div>
            </div>
        </form>

    </div>


</body>
</html>
