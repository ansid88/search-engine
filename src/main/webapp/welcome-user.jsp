<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Welcome user</title>
</head>
<body>
<c:set var="bonus" scope="request" value="${0.2*salary+salary}"/>
welcome ${sessionScope.session}<br />
salary ${salary}<br />
bonus: <c:out value="${bonus}" />
</body>
</html>
