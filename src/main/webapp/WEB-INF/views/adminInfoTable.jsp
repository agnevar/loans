<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<style><%@include file="/WEB-INF/css/normalize.css"%></style>
<style><%@include file="/WEB-INF/css/style.css"%></style>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700&display=swap" rel="stylesheet">
<title>User Loan Tables</title>
</head>
<body>

  <header>
        <div class="menu">
            <a href="<c:url value="/user" />" id = "home">Loan Counter</a>
            <nav>
                <a href="login">Login</a>
                <a href="<c:url value="/logout" />">Logout</a>
            </nav>
       </div>
    </header>

    <main>
        <table>
        <tr>
            <td>Month nr.</td>
            <td>Returnable</td>
            <td>Remainder</td>
            <td>Added interest</td>
            <td>Sum to pay</td>
        </tr>

        <form items

        <c:forEach items="${loanTableRecords}" var = "loanTableRecord">
        <tr>
        <td>${loanTableRecord.monthNr}</td>
        <td><fmt:formatNumber type = "number" maxFractionDigits = "2" value = "${loanTableRecord.returnable}" /></td>
        <td><fmt:formatNumber type = "number" maxFractionDigits = "2" value = "${loanTableRecord.remainder}" /></td>
        <td><fmt:formatNumber type = "number" maxFractionDigits = "2" value = "${loanTableRecord.addedInterest}" /></td>
        <td><fmt:formatNumber type = "number" maxFractionDigits = "2" value = "${loanTableRecord.finalSum}" /></td>
        </tr>
        </c:forEach>
        </table>


    </main>

<footer>
    <a href="<c:url value="/admin/admin-site" />">Admin site</a>
    </footer>
</body>
</html>