<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Dodawanie nowego produktu</title>
    <spring:url var="bootstrapCss" value="/webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${bootstrapCss}">
    <link rel="stylesheet" href="resources/theme1/css/style.css" type="text/css">
</head>


<c:url var="saveProduct" value="/saveProduct"/>
<div class="container">
    <form:form id="contact" method="post" modelAttribute="product" action="${saveProduct}">

        <h3>Dodawanie produktu</h3>
        <form:hidden path="id"/>
        <fieldset>
            <form:input placeholder="Nazwa" path="name" required="true"/>
        </fieldset>
        <fieldset>
            <form:input placeholder="Opis" path="description" required="true"/>
        </fieldset>
        <fieldset>
            <form:input placeholder="Kategoria" path="category" required="true" />
        </fieldset>
        <fieldset>
            <form:input placeholder="Cena" path="price" required="true" />
        </fieldset>
        <fieldset>
            <form:input placeholder="Dostępna ilość" path="unitsInStock" required="true" />
        </fieldset>
        <fieldset>
            <input value="Dodaj" type="submit" name="submit">
        </fieldset>
    </form:form>
</div>
<body>

</body>
</html>
