<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Games Shop</title>
    <spring:url var="bootstrapCss" value="/webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${bootstrapCss}">
    <link rel="stylesheet" href="resources/theme1/css/style.css" type="text/css">
</head>

<body>
<div class="container">
    <spring:url var="logoutUrl" value="/perform_logout"/>

    <form:form method="post" action="${logoutUrl}" class="form-horizontal">
        <button class="buttonLogout" type="submit">
            Wyloguj
        </button>
    </form:form>
        <div class="center">
            <form:form id="contact">
                <h3>Panel Administratora</h3>
                <button class="btn btn-primary" onclick="location.href='/addCustomer'">
                    Dodaj użytkownika
                </button>
                <button class="btn btn-primary" onclick="location.href='/product'">
                    Dodaj towar
                </button>
                <button class="btn btn-primary" onclick="location.href='/#'">
                    Pokaż statystyki
                </button>
            </form:form>
        </div>
    </div>
</div>
</body>

</html>