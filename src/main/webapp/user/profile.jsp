<%@ page import="entity.User" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="/WEB-INF/jspf/left_profile.jspf"%>

<div id="indexRightColumn">

<%
    user = (User) session.getAttribute("user");
    Date birthday = user.getBirthday();
    DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
%>

<div class =hint>
    <p> Enter the password to save the changes or delete profile </p>
</div>

<form action="/profile" method="post">
    <div class="form_box">

        <label for="login">Login:</label>
        <p name="login" id="login"><%=user.getLogin()%></p>
        <label for="firstName">First Name:</label>
        <input type="text" name="firstName" id="firstName" value="<%=user.getFirstName()%>"/>
        <label for="secondName">Last Name:</label>
        <input type="text" name="secondName" id="secondName" value="<%=user.getSecondName()%>"/>
        <label for="birthday">Birthday:</label>
        <input type="text" name="birthday" id="birthday" value="<%=dateFormat.format(birthday)%>"/>
        <label for="email">E-mail:</label>
        <input type="email" name="email" id="email" value="<%=user.getEmail()%>"/>
        <label for="password">Current password:</label>
        <input type="password" name="password" id="password" />
        <label for="new_password">New password:</label>
        <input type="password" name="new_password" id="new_password"/>

        <input type="submit" name="edit_profile" value="Edit profile" class="btn"/>
        <input type="submit" name="delete_profile" value="Delete profile" class="btn"/>
    </div>
</form>
</div></div>
</body>
</html>
