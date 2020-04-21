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
<title>Create User</title>
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
        <form:form method="POST" modelAttribute="User" >
            <form:input path="username" type="text" required="true"/>
            <form:input path="password" type="password" required="true"/>
            <input type="submit" value="Sign up" />
        </form:form>
    </main>



</body>
</html>