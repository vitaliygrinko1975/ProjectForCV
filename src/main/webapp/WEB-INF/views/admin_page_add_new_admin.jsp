<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*"%>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>Admin</title>
    <link href='./style/style2.css' rel='stylesheet' type='text/css'>
</head>
<body>
<div align='right'>
    <div style="display: inline-block; padding-right: 50px;">
        <a href="controller?command=logout">
            <button  class="btn btn-primary btn-block btn-large">Log out</button>
        </a>
    </div>
</div>
<div class='mydiv'>
    <h1 align='center'>New Admin</h1>
    <form method='post' action="controller">
        <input type="hidden" name="command" value="addNewAdmin"/>
        Login: <input type='text' name='addLoginPageAdmin'   required='required'/>
        Password: <input type='text' name='addPasswordPageAdmin'   required='required'/>
        Name: <input type='text' name='addNamePageAdmin'   required='required'/>
        Lastname: <input type='text' name='addLastNamePageAdmin'   required='required'/>
        <button type='submit' name = 'Butt' value = '0' class='btn btn-primary btn-block btn-large'>ENTER</button>
    </form>
</div>
</body>
</html>