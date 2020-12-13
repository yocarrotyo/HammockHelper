<%--
  Created by IntelliJ IDEA.
  User: caroline
  Date: 12/3/20
  Time: 10:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="head.jsp"%>
<body>
<%@include file="top-buttons.jsp"%>
    <div class="bgimg w3-display-container w3-text-white">
        <div class="w3-display-middle w3-large">

            <p> The follow parks have ZIP codes within 20 miles of ${parkid} </p>
            <ul>
                <c:forEach var="park" items="${nearbyParks}">
                    <li>${park.parkname}</li>
                </c:forEach>
            </ul>


            <p> Here are all the hammock-friendly campsites at those parks that we know of:</p>
            <table class="w3-table">
                <c:forEach var="entry" items="${friendlySites}">
                    <tr><td><c:out value="${entry.key.parkname}"/></td>
                    <c:forEach var="campsite" items="${entry.value}">
                            <tr>
                                <td><c:out value="${campsite.siteno}"/></td>
                            </tr>
                    </c:forEach>
                </c:forEach>
            </table>

            <p>To reserve one of these sites, go to the
                <a href="https://wisconsin.goingtocamp.com/">Wisconsin DNR campsite reservation page</a>
            </p>
        </div>
    </div>
<%@include file="bottom-buttons.jsp"%>
</body>
</html>
