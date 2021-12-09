<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <link href="<c:url value="/resources/style/style2.css" />" rel="stylesheet">
</head>
<body>
<div align='right'>
    <div style="display: inline-block; padding-right: 50px;">
        <a href="welcome">
            <button class="btn btn-primary btn-block btn-large">Log out</button>
        </a>
    </div>
</div>
<div class='mydiv'>
    <h1 align='center'>Sign up</h1>
    <form method='post' action="registrationUser">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        Login: <input type='text' name='login' required='required'/>
        Password: <input type='text' name='password' required='required'/>
        Name: <input type='text' name='firstName' required='required'/>
        Surname: <input type='text' name='lastName' required='required'/>
        <button  class='btn btn-primary btn-block btn-large'>CREATE</button>
    </form>


</div>
</body>
</html>

