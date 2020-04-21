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
<title>User List</title>
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
            <td>ID</td>
            <td>Username</td>
            <td>Loans</td>

        </tr>

        <c:forEach items="${userList}" var = "user">
        <tr>
        <td>${user.id}</td>
        <td>${user.username}</td>
        <td><a href="<c:url value="/admin/user-info?getUsername=${user.username}" />">See User Loans</a></td>
        <td><a href="<c:url value="/admin/user-disable?getUsername=${user.username}" />"  onclick="return confirm('Are you sure?')">Disable user</a></td>
        <td><a href="<c:url value="/admin/remove-user?getUsername=${user.username}" />"  onclick="return confirm('Are you sure?')">Remove user</a></td>
        </tr>
        </c:forEach>
        </table>

        <h2>${disabled}</h2>
        <h2>${removed}</h2>

    </main>

    <footer>
        <a href="<c:url value="/admin/admin-site" />">Admin site</a>
        </footer>


</body>
</html>