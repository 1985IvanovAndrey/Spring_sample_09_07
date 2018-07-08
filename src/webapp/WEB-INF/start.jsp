<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>${errorPhone}</h3>
<h2>Все записи в записной книжке</h2>
<table border="4" cellpadding="5" cellspacing="4">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>sec_name</td>
        <td>phone</td>
    </tr>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.secName}</td>
            <td>${user.phone}</td>
        </tr>
    </c:forEach>
</table>
<br>
<br>
<form action="/edit" method="get">
    <input type="submit" value="edit" name="buttonAdd">
</form>

<br/>

</body>
</html>
