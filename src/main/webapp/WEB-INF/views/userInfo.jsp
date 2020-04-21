<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<style><%@include file="/WEB-INF/css/normalize.css"%></style>
<style><%@include file="/WEB-INF/css/style.css"%></style>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700&display=swap" rel="stylesheet">
<title>User Info</title>
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
            <td>Sum</td>
            <td>Term</td>
            <td>Loan Percent</td>
            <td>Agreement Tax</td>
            <td>Link</td>
        </tr>

        <c:forEach items="${loanRecords}" var = "loanRecord">
        <tr>
        <td>${loanRecord.sum}</td>
        <td>${loanRecord.term}</td>
        <td>${loanRecord.loanPercent}</td>
        <td>${loanRecord.agreementTax}</td>
        <td><a href="<c:url value="/user/loan-table?getId=${loanRecord.id}" />">See Table</a></td>

        </tr>
        </c:forEach>
        </table>


    </main>

    <footer>
        <p>${hello}</p>
        </footer>

</body>
</html>