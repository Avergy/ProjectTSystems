<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="jspf/left_menu.jspf"%>


<div id="indexRightColumn">
<form class="login_form"  name="user" action="j_security_check" method="POST" id="login_form">
    <div class="form_box" >

        <label for="login">Login:</label>
        <input type="text" name="j_username" id="login" />
        <label for="password">Password:</label>
        <input type="password" name="j_password" id="password" />

        <input type="submit" name="log_in" value="Log in" class="btn" />

    </div>
</form>
</div>

</div>

</body>
</html>