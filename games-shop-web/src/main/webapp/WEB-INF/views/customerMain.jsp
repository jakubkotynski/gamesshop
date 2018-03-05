<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pl">
<html>
<head>
    <title>Panel Klienta</title>
</head>
<body>
<div class="middle">
    <div class="center">
        <form:form id="contact">
            <h3>Panel Klienta</h3>
            <button class="btn btn-primary" onclick="location.href='/#'">
                Przeglądaj dostępne gry
            </button>
            <button class="btn btn-primary" onclick="location.href='/#'">
                Wyświetl mój koszyk
            </button>
        </form:form>
    </div>
</body>
</html>
