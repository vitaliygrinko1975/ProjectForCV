<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
	<title>Message</title>
	<link href="<c:url value="/resources/style/style2.css" />" rel="stylesheet">
</head>
<body>
<div class='mydiv'>
	<h1 align='center'>${message}</h1>
	<form method='get' action='forRegistered'>
		<button type='submit' class='btn btn-primary btn-block btn-large'>Return</button>
<%--		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
	</form>

</div>
</body>
</html>
</html>

