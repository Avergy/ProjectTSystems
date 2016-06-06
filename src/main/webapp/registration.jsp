<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registration</title>
</head>
<body>
<h1>Registration</h1>
<form action="/registration" method="post">
    <table>
        <tr>
            <th><small>
            <td>Login:</td>
            </small>
            <th><small>
            <td><input type="text" name="login" size="10"></td>
        </tr>
        <tr>
            <th><small>
            <td>First name:</td>
            </small>
            <th><small>
            <td><input type="text" name="firstName" size="10"></td>
        </tr>
        <tr>
            <th><small>
            <td>Second name:</td>
            </small>
            <th><small>
            <td><input type="text" name="secondName" size="10"></td>
        </tr>
        <tr>
            <th><small>
            <td>Birthday:</td>
            </small>
            <th><small>
            <td><input type="date" name="birthday" size="10"></td>
        </tr>
        <tr>
            <th><small>
            <td>e-mail:</td>
            </small>
            <th><small>
            <td><input type="email" name="email" size="10"></td>
        </tr>
        <tr>
            <th><small>
            <td>password:</td>
            </small>
            <th><small>
            <td><input type="password" name="password" size="10"></td>
        </tr>
    </table>
    <p>
    <table>
        <tr>
            <th><small>
                <input type="submit" name="register" value="Register">
            </small>
            <th><small>
                <input type="submit" name="log_in" value="Log in">
            </small>
    </table>
</form>
</body>
</html>