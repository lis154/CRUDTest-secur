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
        <th>roles</th>
    </tr>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.password}</td>
            <td>${user.age}</td>
            <td>${user.getListRoles()}</td>

            <td>
                <form>
                <%--    <input type="button" value="edit" onClick='location.href="/admin/edit/${user.id}"'> --%>
                    <a class="button24" href="/admin/edit/${user.id}" >edit</a>
                    <a class="button25" href="/admin/delete/${user.id}" >delete</a>
        <%--    <input type="button" value="delete" onClick='location.href="/admin/delete/${user.id}"'>--%>

        </form>
    </td>
</tr>
</c:forEach>

    <tr><td>USer count </td><td>${usersCount}</td></tr>
<tr><td>page</td>
<td> <c:forEach begin="1" end="${pagesCount}" step="1" varStatus="i">
    <c:url value="/admin" var="url">
        <c:param name="page" value="${i.index}"/>
    </c:url>
    <a href="${url}">${i.index}</a>
</c:forEach></td>


    <%--<td><c:url value="/admin/add" var="add"/>
    <form>
        <a class="button7" href="/admin/add" >Add new user</a>
        <input type="button" value="Add new user" onClick='location.href="${add}"'>
</form>--%>
    <td><a class="button7" href="/admin/add" >Add new user</a></td>
<td>
 <a class="button7" href="/logout" >LOGOUT</a>
</td>
<td>
<a class="button7" href="/user?username=${username}" >User</a>
</td>
</tr>
</table>
</body>
</html>
