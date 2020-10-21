<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="head.jsp"%>

<html><body>

<div class="container-fluid">
    <h2>Here are all the campsites we found</h2>
    <h3>The following users matched your search:</h3>
    <table>
        <tr><td>Park Name</td><td>Site no.</td><td>Capacity</td>Confidence</tr>
        <!--loop through the employees in the list-->
        <c:forEach var="site" items="${campsites}">
            <tr>
                <td>${site.parkname}</td>
                <td>${site.siteno}</td>
                <td>${site.capacity}</td>
                <td>${site.confidence}</td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
