<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Dodawanie konta klienta</title>
    <spring:url var="bootstrapCss" value="/webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${bootstrapCss}">
    <link rel="stylesheet" href="resources/theme1/css/style.css" type="text/css">
</head>


<c:url var="saveCustomer" value="/addCustomer"/>
<div class="container">
    <form:form id="contact" method="get" modelAttribute="customer" action="${saveCustomer}">

        <h3>Utwórz konto</h3>
        <form:hidden path="id"/>
        <fieldset>
            <form:input placeholder="imię" path="firstName" required="true"/>
        </fieldset>
        <fieldset>
            <form:input placeholder="nazwisko" path="lastName" required="true"/>
        </fieldset>
        <fieldset>
            <form:input placeholder="adres" path="address" required="true" />
        </fieldset>
        <fieldset>
            <form:input placeholder="e-mail" path="email" type="email" required="true" />
        </fieldset>
        <fieldset>
            <input value="Dodaj" type="submit" name="submit">
        </fieldset>
    </form:form>
</div>
<body>

</body>
</html>
