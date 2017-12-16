<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach var="entry" items="${list}">
            <div <c:if test="${entry.gender.toString() == 'MAN'}"> style="color: blue;" </c:if> >
        <p>
            <b>ID:</b> <c:out value="${entry.id}" /><br />
            <b>Name:</b> <c:out value="${entry.name}" /><br/>
            <b>Surname:</b> <c:out value="${entry.surname}"/><br/>
            <b>Login:</b> <c:out value="${entry.login}" /><br/>
            <b>Age:</b> <c:out value="${entry.age}" /><br/>
            <b>GENDER:</b> <c:out value="${entry.gender}"/>
        </p>
    </div>
    </c:forEach>

</body>
</html>
