<%--
  Created by IntelliJ IDEA.
  User: annasidz
  Date: 16.12.17
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodaj użytkownika step1</title>
</head>
<body>
<h2>Dodaj użytkownika</h2>
<form method="post" action="/add-user-steps">
    ID:<input type="text" name="id" /><br />
    Login:<input type="text" name="login" /><br />
    <input type="hidden" name="step" value="1"/>
    <button type="submit">Dalej</button>
</form>
</body>
</html>
