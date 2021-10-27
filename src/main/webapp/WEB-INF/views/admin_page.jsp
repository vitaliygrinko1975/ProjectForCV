<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<div align='center'>
    <div style="display: inline-block; padding-right: 50px;">
        <a href="adminPageUsers">
            <button  class="btn btn-primary btn-block btn-large">PAGE USER</button>
        </a>
    </div>
</div>

<h1 align='center'>Admin page</h1>

<div align='center' >

    <table border='1'>
        <caption><h2>Cars</h2></caption>

        <tr>
            <td>№</td>
            <td>Name</td>
            <td>Price</td>
            <td>Class</td>
        </tr>
        <c:set var="k" value="0"/>
        <c:forEach var="car" items="${carsItems}">
           <c:set var="k" value="${k+1}"/>
            <tr>
                <td><c:out value="${k}"/></td>
                <td>${car.name}</td>
                <td>${car.price}</td>
                <td>${car.category}</td>
                <td>
            <form method="post" action="removeCar">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                 <button type="submit" name = "removeButt" value = "${car.id}"
                        class="btn btn-primary btn-block btn-large">Remove</button>
            </form>
                </td>
                 <td>
                    <form method="post" action="controller">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <input type="hidden" name="command" value="adminPageUpdateCommand"/>
                        <button type="submit" name = "carForUpdateButt" value = "${car.id}"
                                class="btn btn-primary btn-block btn-large">Update</button>
                    </form>

                 </td>
            </tr>
        </c:forEach>
    </table>

    <div align='center'  style="display: inline-block;">
        <a href="controller?command=addPage">
            <button  class="btn btn-primary btn-block btn-large">Add new car</button>
        </a>
    </div>
</div>
</body>
</html>