<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*"%>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>Admin</title>
    <link href="<c:url value="/resources/style/style2.css" />" rel="stylesheet">
</head>
<body>
<div align='right'>
    <div style="display: inline-block; padding-right: 50px;">
        <a href="login?logout">
            <button  class="btn btn-primary btn-block btn-large">Log out</button>
        </a>
    </div>
</div>
<div class='mydiv'>
            <h1 align='center'>New cars</h1>
    <form method='post' action="addCar">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        Name: <input type='text' name='addName'   required='required'/>
        Price: <input type='text' name='addPrice'   required='required'/>
        Category: <input type='text' name='addCategory'   required='required'/>
        <button type='submit' name = 'Butt' value = '0' class='btn btn-primary btn-block btn-large'>CREATE</button>
    </form>
</div>
</body>
</html>

