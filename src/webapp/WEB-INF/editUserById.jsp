<%--
  Created by IntelliJ IDEA.
  User: Dron
  Date: 08.07.2018
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>Введите новые данные, после ввода ID, который необходимо изменить</h2>
<form action="/editUserById" method="get">
    ID <input type="text" name="id" >
    <br>
    <br>
    New name: <input type="text" name="name" >
    <br>
    New sec_name: <input type="text" name="secName" >
    <br>
    New phone:<input type="text" name="phonex">
    <br>
    <br>
    <input type="submit" value="editUser" name="buttonEditById">
</form>

</body>
</html>
