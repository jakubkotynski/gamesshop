<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
                <spring:url value="/customer/edit/${customer.id}" var="customerEditUrl"/>
                <spring:url value="/customer/delete/${customer.id}" var="customerDeleteUrl"/>

                <button class="btn btn-info" onclick="location.href='${customerEditUrl}'">
                    Edytuj
                </button>
                <button class="btn btn-info" onclick="location.href='${customerDeleteUrl}'">
                    Usuń
                </button>
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