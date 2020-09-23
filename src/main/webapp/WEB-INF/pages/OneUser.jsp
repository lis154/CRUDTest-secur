<%--
  Created by IntelliJ IDEA.
  User: ilya
  Date: 20.09.2020
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
    <title>USERS</title>

    <style>
        body {
            background-image: url("/res/image.jpg"); /* Путь к фоновому изображению */
            background-color: #c7b39b; /* Цвет фона */
        }
    </style>
</head>
<body>
<h2 align="center"><font color="red">USERS</font></h2>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>password</th>
        <th>age</th>
    </tr>

        <tr>
            <td>${user1.id}</td>
            <td>${user1.name}</td>
            <td>${user1.password}</td>
            <td>${user1.age}</td>
        </tr>
    <tr>
        <td>
            <form>
                <input type="button" value="LogOut" onClick='location.href="/logout"'>
            </form>
        </td>
        <td>
            <c:if test = "${ user1.isAdmin()}">
                <form>
                    <input type="button" value="ADMIN" onClick='location.href="/admin"'>
                </form>
            </c:if>
        </td>
    </tr>

</table>



</body>
</html>