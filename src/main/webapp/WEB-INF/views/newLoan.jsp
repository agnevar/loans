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
<title>New Loan</title>
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
        <form:form method="POST" modelAttribute="LoanRecord" >
        <div>
            <form:label path="sum">Enter sum: </form:label>
            <form:input path="sum" type="number"  required="true"/>
        </div>
        <div>
            <form:label path="term">Enter term: </form:label>
            <form:input path="term" type="number"  required="true"/>
        </div>
        <div>
            <form:label path="loanPercent">Enter loan percentage: </form:label>
            <form:input path="loanPercent" type="number"  required="true"/>
        </div>
        <div>
            <form:label path="agreementTax">Enter agreement tax: </form:label>
            <form:input path="agreementTax" type="number"  required="true"/>
        </div>
        <div>
         <input type="submit" value="Count" />
        </div>
        </form:form>

        <h1>${message}</h1>
        <a href="<c:url value="/user/loan-table?getId=${id}" />">${table}</a>

        <div>
        <a href="<spring:url value="/user" />"> Back </a>
        </div>



    </main>

    <footer>
    <p>${hello}</p>
    </footer>

</body>
</html>