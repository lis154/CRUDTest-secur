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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <c:if test="${empty user.name}">
        <title>Add</title>
    </c:if>
    <c:if test="${!empty user.name}">
        <title>Edit</title>
    </c:if>
</head>
<body>
<c:if test="${empty user.name}">
    <c:url value="/add" var="var"/>
</c:if>
<c:if test="${!empty user.name}">
    <c:url value="/edit" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${!empty user.name}">
    <input type="hidden" name="id" value="${user.id}">
    </c:if>
    <label for="name">Name</label>
    <input type="text" name="name" id="name" value="${user.name}">
    <label for="position">Position</label>
    <input type="text" name="position" id="position" value="${user.position}">
    <label for="age">Age</label>
    <input type="text" name="age" id="age" value="${user.age}">
    <c:if test="${!empty user.name}">
    <input type="submit" value="Edit user">
    </c:if>
    <c:if test="${empty user.name}">
        <input type="submit" value="Add new user">
    </c:if>

</form>
</body>
</html>
