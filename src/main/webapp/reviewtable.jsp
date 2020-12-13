<%--
  Created by IntelliJ IDEA.
  User: caroline
  Date: 12/9/20
  Time: 11:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@include file="head.jsp"%>
<body>
<%@include file="top-buttons-authenticated.jsp"%>
Display all the site park data in a nice lil table
<p>Below is a table with all the campsite data we have for the park you specified.</p>
<p>Review the campsite data shown. Update the capacity value and mark the "Dispute" column to indicate the information we had wasn't correct.</p>
<p>If you see a row where the data provided is correct, mark the Affirm column so we know more than one person agrees with this information.</p>
    <form action="processReview" method="POST">
    <!--select search type-->
        <table>
        <tr><td>Site number</td><td>Capacity</td><td>Affirm?</td><td>Dispute?</td></tr>
            <c:forEach var="site" items="${siteList}">
            <tr>
            <td>${site.siteno}</td>
            <td><input type="text" name="hamcap${site.siteno}" value="${site.capacity}"/></td>
            <td><input type="radio" name="dispute${site.siteno}"/></td>
            <td><input type="radio" name="affirm${site.siteno}"/></td>
            </tr>
            </c:forEach>
        </table>
        <!--submit button-->
        <input type="submit" name="" value="Submit" />
    </form>
</body>
</html>
