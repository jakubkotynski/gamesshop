<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<html>
<head>
    <title>OSK Manager</title>
</head>
<body>
<h3>Znajdż kursanta</h3>

<spring:url value="findCustomer" var="findCustomer"/>
<form:form method="post" modelAttribute="searchCustomer" action='${findCustomer}'>
    <form:label path="firstName">
        Imię
    </form:label>
    <form:input path="firstName"/>

    <form:label path="lastName">
        Nazwisko
    </form:label>
    <form:input path="lastName"/>
    <button class="btn btn-primary" type="submit">
        Znajdź
    </button>

</form:form>
<c:choose>
    <c:when test="${!empty foundCustomer}">
        <c:forEach items="${foundCustomer}" var="customer">
            <tr>
                <td>${customer.firstName}</td>
                <td>${customer.lastName}</td>
                <td>${customer.email}</td>
            </tr>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <tr>
            <td>Nie znaleziono</td>
        </tr>
    </c:otherwise>
</c:choose>
</body>
</html>