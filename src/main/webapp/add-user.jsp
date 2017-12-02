<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Dodaj użytkownika</h2>
<form method="post" action="/add-user">
    ID:<input type="text" name="id" /><br />
    Imię:<input type="text" name="name" /><br />
    Nazwisko:<input type="text" name="surname" /><br />
    Wiek:<input type="text" name="age" /><br />
    Login:<input type="text" name="login" /><br />
    Płeć:<input type="text" name="gender" /><br />
    <button type="submit">Dodaj</button>

</form>
</body>
</html>
