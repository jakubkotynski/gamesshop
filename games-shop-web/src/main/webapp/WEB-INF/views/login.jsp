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
<div class="center">
    <spring:url var="login" value="perform_login"/>
    <form:form id="contact" method="post" modelAttribute="login" action="${login}">

        <h3>Logowanie</h3>
        <fieldset>
            <form:input placeholder="username" path="username"/>
        </fieldset>
        <fieldset>
            <form:input placeholder="hasło" path="password" type="password"/>
        </fieldset>
        <br>
        <form:button type="submit" name="submit" class="btn btn-primary submitButton">Zaloguj</form:button>
    </form:form>
</div>
</body>
</html>