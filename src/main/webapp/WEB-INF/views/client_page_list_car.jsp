<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@page isELIgnored="false"%>
<html>
<head>
    <link href="<c:url value="/resources/style/style2.css" />" rel="stylesheet">
</head>
<body>
<div align='right'>
    <div style="display: inline-block; padding-right: 50px;">
        <a href="welcome">
            <button  class="btn btn-primary btn-block btn-large">Log out</button>
        </a>
    </div>
</div>

<div align='center' >
    <caption><h2>Cars</h2></caption>
        <div align='center'>
            <div style="display: inline-block; padding-right: 50px;">
                <a href="sortedUpPrice">
                    <button  class="btn btn-primary btn-block btn-large">Sort by price ></button>
                </a>
            </div>
            <div align='center'>
                <div style="display: inline-block; padding-right: 50px;">
                    <a href="sortedDownPrice">
                        <button  class="btn btn-primary btn-block btn-large">Sort by price <</button>
                    </a>
                </div>
            <div align='center'>
                <div style="display: inline-block; padding-right: 50px;">
                    <a href="sortedUpName">
                        <button  class="btn btn-primary btn-block btn-large">Sort by name ></button>
                    </a>
                </div>
                <div align='center'>
                    <div style="display: inline-block; padding-right: 50px;">
                        <a href="sortedDownName">
                            <button  class="btn btn-primary btn-block btn-large">Sort by name <</button>
                        </a>
                    </div>
       <table border='1'>
        <tr>
            <td>№</td>
            <td>CARS</td>
            <td>PRICE</td>
            <td>CLASS</td>
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
                    <form method="post" action="  ">
                        <input type="hidden" name="command" value="makeOrderCommand"/>
                        <button type="submit" name ="makeOrderButt" value = "${car.id}"
                                class="btn btn-primary btn-block btn-large">make an orders</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
                    <div class='mydiv'>
                        <form method='post' action="  ">
                            <input type="hidden" name="command" value="selectByClass"/>
                            Car class: <input type='text' name='selectClass'   required='required'/>
                            <button type='submit' name = 'Butt' value = '0' class='btn btn-primary btn-block btn-large'>ENTER</button>
                        </form>
                    </div>
                </div>
            </body>
</html>

