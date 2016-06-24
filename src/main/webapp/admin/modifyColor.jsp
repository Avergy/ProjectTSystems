<%@ page import="entity.Color" %>
<%@ page import="Util.ServicesUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="/WEB-INF/jspf/left_profile.jspf"%>

<div id ="indexRightColumn">

    <form action="/modifyColor" method="post">
        <div class="modify_info">
            <div>
                <div class="field">
                    <label for="select_color">Select or add a new color.</label>
                    <select name="select_color" id="select_color">
                        <option>add new color</option>
                        <%
                            for (Color color: ServicesUtil.getColorService().loadAllColors()) {
                        %>
                        <option><%=color.getColor()%></option>
                        <% } %>
                    </select>
                </div>
                <div class="field">
                    <label for="new_color_name">Enter a new color name:</label>
                    <input name="new_color_name" type="text" id="new_color_name">
                </div>
                <input type="hidden" name="type" value="modifyColor"></p>
                <p><input type="submit" name = "edit" value="Edit"></p>
                <p><input type="submit" name="delete" value="Delete"></p>
            </div>
        </div>
    </form>

</div>


</body>
</html>
