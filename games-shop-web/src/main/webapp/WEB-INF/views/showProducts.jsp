<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Games shop</title>
</head>
<body>
<h1>Lista dostępnych gier.</h1>

<c:choose>
    <c:when test="${!empty products}">
        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.name}</td>
                <td>${product.category}</td>
                <td>${product.description}</td>
                <td>${product.price}</td>
                <td>${product.unitsInStock}</td>

            </tr>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <tr>
            <td>Lista jest pusta</td>
        </tr>
    </c:otherwise>
</c:choose>
</body>
</html>