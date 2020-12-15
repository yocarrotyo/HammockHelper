<%--
  Created by IntelliJ IDEA.
  User: caroline
  Date: 12/8/20
  Time: 6:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="head.jsp"%>
<%@include file="top-buttons-authenticated.jsp"%>
<body>

<div class="bgimg w3-display-container w3-text-white">
    <div class="w3-display-middle w3-large">
        <p>Thanks for contributing to Hammock Helper!</p>
        <p>Here are the details of the information you submitted: </p>
        <table class="w3-table">
            <tr><td>Park</td><td>Campsite #</td><td>Number of hammocks</td></tr>
            <c:forEach var="site" items="${addedSite}">
                <tr><td>${thePark.parkname}</td><td>${site.siteno}</td><td>${site.capacity}</td></tr>
           </c:forEach>
        </table>
    </div>

<%@include file="bottom-buttons.jsp"%>
</body>
</html>
