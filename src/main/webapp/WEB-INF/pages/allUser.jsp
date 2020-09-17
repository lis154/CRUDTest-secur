<%--
  Created by IntelliJ IDEA.
  User: ilya
  Date: 12.08.2020
  Time: 19:55
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
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.password}</td>
            <td>${user.age}</td>
            <td>
                <a href="/edit/${user.id}">edit</a>
                <a href="/delete/${user.id}">delete</a>
            </td>
        </tr>
    </c:forEach>

    <tr><td>USer count ${usersCount}</td>><td>
    <tr><td>page</td>
       <td> <c:forEach begin="1" end="${pagesCount}" step="1" varStatus="i">
            <c:url value="/" var="url">
                <c:param name="page" value="${i.index}"/>
            </c:url>
            <a href="${url}">${i.index}</a>
        </c:forEach></td></tr>

    <td><c:url value="/add" var="add"/>
        <a href="${add}">Add new user</a></td>
</table>

</body>
</html>
