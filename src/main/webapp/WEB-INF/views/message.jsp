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
	</div>

	<div align='center'>
		<div style="display: inline-block; padding-right: 50px;">
			<a href="welcome">
				<button  class="btn btn-primary btn-block btn-large">Log out</button>
			</a>
		</div>
	</div>
</body>
</html>

