<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="jspf/left_menu.jspf"%>


<div id="indexRightColumn">
<form action="/registration" method="post">
    <div class="ащкь_box">

            <label for="login">Login:</label>
            <input type="text" name="login" id="login" />
            <label for="password">Password:</label>
            <input type="password" name="password" id="password" />
            <label for="email">E-mail:</label>
            <input type="email" name="email" id="email" />
            <label for="firstName">First Name:</label>
            <input type="text" name="firstName" id="firstName" />
            <label for="secondName">Last Name:</label>
            <input type="text" name="secondName" id="secondName" />
            <label for="birthday">Birthday:</label>
            <input type="date" name="birthday" id="birthday" />

            <input type="submit" name="register" value="Register" class="btn"/>
            <input type="submit" name="log_in" value="Log in" class="btn"/>

        </div>
    </form>
</div>
</div>
</body>
</html>