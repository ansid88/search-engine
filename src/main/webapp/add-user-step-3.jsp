<%--
  Created by IntelliJ IDEA.
  User: annasidz
  Date: 16.12.17
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodaj użytkownika step3</title>
</head>
<body>
<h2>Dodaj użytkownika step3</h2>
<form method="post" action="/add-user-steps">
    Płeć:<input type="text" name="gender" /><br />
    <input type="hidden" name="step" value="3"/>
    <button type="submit">Dodaj</button>
</form>
</body>
</html>
