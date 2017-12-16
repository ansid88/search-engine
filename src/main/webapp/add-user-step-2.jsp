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
    <title>Dodaj użytkownika step2</title>
</head>
<body>
<h2>Dodaj użytkownika step2</h2>
<form method="post" action="/add-user-steps">
    Imię:<input type="text" name="name" /><br />
    Nazwisko:<input type="text" name="surname" /><br />
    Wiek:<input type="text" name="age" /><br />
    <input type="hidden" name="step" value="2"/>
    <button type="submit">Dalej</button>
</form>
</body>
</html>
