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
<title>Loan Counter</title>
</head>
<body>

  <header>
        <div class="menu">

            <a href="<c:url value="/" />" id = "home">Loan Counter</a>

            <nav>
                <a href="login">Login</a>
                <a href="<c:url value="/create-user" />">Sign up</a>
                <a href="<c:url value="/logout" />">Logout</a>
            </nav>

        </div>

    </header>

    <main>

        <h1>There are various types of loans<h1>
    <div class="loan-types">
	    <div class="box">
	    <h2>Consumer loan</h2>
	    <p>A small loan is a great solution if you need to renovate your home, buy new furniture for the terrace, repair your car or to finance your next big thing.</p>
	    </div>
	    <div class="box">
        	    <h2>Home small loan</h2>
        	    <p>A new home or refurbishment – now it’s a breeze!
                   A simple solution if you’re looking to buy a property or undertake your home renovation.</p>
        </div>
        <div class="box">
               <h2>Credit line</h2>
                <p>We recommend if you plan to use the money in instalments or do not know the exact amount of the final cost (e. g., for home repair);</p>
        </div>
    </div>

    <div>

    <p>Here you can calculate all types of loans and what will you will finaly pay</p>

    <h1>Ready to join?</h1>
    <a href="<c:url value="/create-user" />">Sign up</a>
    </div>

    </main>

    <footer>
    <a href="<c:url value="/admin/admin-site" />">Admin site</a>
    </footer>


</body>
</html>