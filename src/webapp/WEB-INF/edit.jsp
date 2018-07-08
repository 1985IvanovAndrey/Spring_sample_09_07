<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Добавление, удаление и изменение записей в записной книжке</h2>
<form action="/editUser" method="get">
    Name: <input type="text" name="name" >
    <br>
    Sec_name: <input type="text" name="secName" >
    <br>
    Phone:<input type="text" name="phone">
    <br>
    <br>
    <input type="submit" value="addUser" name="buttonAdd">
</form>
<br>
<br>
<h3>Удаление записи по ID</h3>
<br>
<form action="/delUser" method="get">
    ID<input type="text" name="id">
    <br>
    <br>
    <input type="submit" value="delUserById" name="buttonDel">
</form>
<br>
<br>
<h3>Изменение существующей записи по ID</h3>
<form action="/editById" method="get">
    <input type="submit" value="editUserById" name="buttonEdit">
</form>

</body>
</html>
