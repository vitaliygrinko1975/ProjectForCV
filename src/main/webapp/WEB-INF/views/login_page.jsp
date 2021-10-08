<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>

<c:set var="title" value="Login"/>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login page</title>
    <link href="<c:url value="/resources/style/st4.css" />" rel="stylesheet">


</head>

<div align='right'>
    <div style="display: inline-block; padding-right: 50px;">
        <a href="welcome">
            <button class="btn btn-primary btn-block btn-large">Log out</button>
        </a>
    </div>
</div>

<%--<div class="login">--%>
<%--    <c:url var="loginUrl" value="/login" />--%>
<%--    <form action="${loginUrl}" method="post" class="form-horizontal">--%>
<%--        <c:if test="${param.logout != null}">--%>
<%--            <div>--%>
<%--                <p>You have been logged out successfully.</p>--%>
<%--            </div>--%>
<%--        </c:if>--%>
<%--        <c:if test="${param.error != null}">--%>
<%--            <div>--%>
<%--                <p>Invalid username and password.</p>--%>
<%--            </div>--%>
<%--        </c:if>--%>
<%--        <input type="text" name="username" placeholder="Username" required="required" />--%>
<%--        <input type="password" name="password" placeholder="Password" required="required" />--%>
<%--        <button type="submit" class="btn btn-primary btn-block btn-large">Log in</button>--%>
<%--        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
<%--    </form>--%>
<%--</div>--%>


<table id="main-container">

    <tr>
        <td class="content center">

            <form id="login_form" action="forRegistered" method="post">
                <fieldset>
                    <legend>Login</legend>
                    <input type="text" name="login"/><br/>
                </fieldset>
                <br/>
                <fieldset>
                    <legend>Password</legend>
                    <input type="password" name="password"/>
                </fieldset>
                <br/>
                <input type="submit" value="LOG IN">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>

            <div align='center'>
                <div style="display: inline-block; padding-right: 50px;">
                    <a href="welcome">
                        <button  class="btn btn-primary btn-block btn-large">Log out</button>
                    </a>
                </div>
            </div>

        </td>
    </tr>


</table>
</body>
</html>

