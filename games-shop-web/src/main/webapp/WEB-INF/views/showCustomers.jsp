<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: gryzi
  Date: 20.02.2018
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Games shop</title>
</head>
<body>
<h1>Lista klientów.</h1>

<c:choose>
    <c:when test="${!empty customers}">
        <c:forEach items="${customers}" var="customer">
            <tr>
                <td>${customer.firstName}</td>
                <td>${customer.lastName}</td>
                <td>${customer.email}</td>
                <td>${customer.address}</td>
            </tr>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <tr>
            <td>Nie ma klientów</td>
        </tr>
    </c:otherwise>
</c:choose>
</body>
</html>